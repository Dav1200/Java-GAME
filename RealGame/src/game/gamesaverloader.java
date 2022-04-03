package game;

import java.io.*;

public class gamesaverloader {

    public gamesaverloader(){

    }

    public static void save(Gamelevel gameworld, String filename) throws IOException {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, append);
            writer.write(String.valueOf(gameworld.getPlayer().getLives()));
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static int load(String filename) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        int name = 0;
        try {
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                // String[] tokens = line.split(",");
                name = Integer.parseInt(line);
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


        return name;


    }

}