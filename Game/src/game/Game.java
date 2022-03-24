package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;


public class Game {

    public Game() {
        Gameworld world = new Gameworld();

        if (world.getPlayer().getLives() == 9) {

        }



        //make game world


        //2. view
        Gameview view = new Gameview(world, 800, 600, world.getPlayer(), world.getE());

        EnemySteplistener t = new EnemySteplistener(view, world.getPlayer(), world.getE());

        //RegeneratePlayercollision c = new RegeneratePlayercollision(world.getPlayer());

        Mousecontroller dav = new Mousecontroller(view, world.getPlayer());
        view.addMouseListener(dav);
        control move = new control(world.getPlayer(), t, world.getE());
        view.addKeyListener(move);

        Collision pickup = new Collision(world.getPlayer(), world.getPlat(),world.getE());
        world.getPlayer().addCollisionListener(pickup);


        //
        //world.getPlayer().addCollisionListener(dav);

        world.addStepListener(t);
        world.addStepListener(view);
        world.addStepListener(world.getE());
        world.addStepListener(world.getPlayer());
        world.addStepListener(move);
        world.addStepListener(world);


        final JFrame frame = new JFrame("Dav Game");
      //  view.setGridResolution(1);
        frame.add(view);


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);

        frame.pack();

        frame.setVisible(true);


        world.start();


    }


    public static void main(String[] args) {

        //menushow dav = new menushow();

        new Game();


        // new Game().menu();


    }
}
