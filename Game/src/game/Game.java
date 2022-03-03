package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Game {


    public Game() {

        //make game world
        Gameworld world = new Gameworld();


        //2. view
        Gameview view = new Gameview(world, 800, 600, world.getPlayer());


        view.addMouseListener(new Mousecontroller(view));
        view.addKeyListener(new control(world.getPlayer()));
        Collision pickup = new Collision(world.getPlayer(), world.getPlat(), this);
        world.getPlayer().addCollisionListener(pickup);


        final JFrame frame = new JFrame("Dav Game");
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

        new Game();
    }
}
