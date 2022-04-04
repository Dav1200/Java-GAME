package game;

import org.jbox2d.common.Vec2;

import java.io.*;

public class gamesaverloader {

    public gamesaverloader(){

    }

    public static void save(Gamelevel gameworld, String filename) throws IOException {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, append);
            writer.write(gameworld.level());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static Gamelevel load(String filename,Game game) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        String name = "";
        try {
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                // String[] tokens = line.split(",");
                name = line;
                //int score = Integer.parseInt(tokens[1]);
                System.out.println("Name: " + name);
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

        if(name.equals("level1")){
            return new level1(game);

        }

        if(name.equals("level2")){
            return new level2(game,game.getView());

        }

        if(name.equals("level3")){
            return new level3(game);

        }

        else
            return null;


    }

}