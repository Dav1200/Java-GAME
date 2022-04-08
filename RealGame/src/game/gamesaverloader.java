package game;

import org.jbox2d.common.Vec2;

import java.io.*;

public class gamesaverloader {

    public gamesaverloader() {

    }

    public static void save(Gamelevel gameworld, String filename) throws IOException {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, append);
            writer.write(gameworld.level()  + "\n");

            for (int i = 0; i < gameworld.getDynamicBodies().size(); i++) {
                if (gameworld.getDynamicBodies().get(i) instanceof Player) {
                    writer.write(gameworld.getDynamicBodies().get(i) + "," + gameworld.getDynamicBodies().get(i).getPosition().x + "," + gameworld.getDynamicBodies().get(i).getPosition().y + "\n");

                }

                if (gameworld.getDynamicBodies().get(i) instanceof enemy) {
                    writer.write(gameworld.getDynamicBodies().get(i) + "," + gameworld.getDynamicBodies().get(i).getPosition().x + "," + gameworld.getDynamicBodies().get(i).getPosition().y + "\n");

                }
            }

            for (int i = 0; i < gameworld.getStaticBodies().size(); i++) {
                if (gameworld.getStaticBodies().get(i) instanceof Coin) {
                    writer.write(gameworld.getStaticBodies().get(i) + "," + gameworld.getStaticBodies().get(i).getPosition().x + "," + gameworld.getStaticBodies().get(i).getPosition().y + "\n");

                }

                if (gameworld.getStaticBodies().get(i) instanceof PickupItems) {
                    writer.write(gameworld.getStaticBodies().get(i) + "," + gameworld.getStaticBodies().get(i).getPosition().x + "," + gameworld.getStaticBodies().get(i).getPosition().y + "\n");
                }
                if (gameworld.getStaticBodies().get(i) instanceof grenadepickup) {
                    writer.write(gameworld.getStaticBodies().get(i) + "," + gameworld.getStaticBodies().get(i).getPosition().x + "," + gameworld.getStaticBodies().get(i).getPosition().y + "\n");
                }
                if (gameworld.getStaticBodies().get(i) instanceof ShieldPickup) {
                    writer.write(gameworld.getStaticBodies().get(i) + "," + gameworld.getStaticBodies().get(i).getPosition().x + "," + gameworld.getStaticBodies().get(i).getPosition().y + "\n");
                }


            }
            // writer.write(String.valueOf(gameworld.getDynamicBodies()) +"\n");
            //writer.write(String.valueOf(gameworld.getStaticBodies()));
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static Gamelevel load(String filename, Game game,Gamelevel gameworld) throws IOException {
        FileReader fr = null;

        BufferedReader reader = null;
        String name = "";
        String level = "";
        float x = 0;
        float y = 0;
        int count = 0;
        String position = String.valueOf(new Vec2(0, 0));
        try {
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);
            String line = reader.readLine();


            while (line != null) {
                if (count == 0) {

                    level = line;
                    count++;

                    line = reader.readLine();
                }

                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");
                name = tokens[0];
                x = Float.parseFloat(tokens[1]);
                y = Float.parseFloat(tokens[2]);
                //int score = Integer.parseInt(tokens[1]);
                //  System.out.println(level);
                //System.out.println(position);
                System.out.print(name);
                System.out.print(x);
                System.out.print(y);
                System.out.println();
                count++;
                line = reader.readLine();
            }
            System.out.println("...done.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

        if(level.equals("level1")){
            return new level1(game);
        }

        if(level.equals("level2")){
            return new level2(game,game.getView());
        }
        if(level.equals("level3")){
            return new level3(game);
        }


        return null;
    }
}