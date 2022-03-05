package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

import javax.swing.JFrame;
import java.awt.*;


public class Game {


    public Game() {
        Gameworld world = new Gameworld();
        //make game world


        //2. view
        Gameview view = new Gameview(world, 800, 600, world.getPlayer(),world.getE());
        track t = new track(view,world.getPlayer(),world.getE());


        view.addMouseListener(new Mousecontroller(view));
        view.addKeyListener(new control(world.getPlayer(),t));
        Collision pickup = new Collision(world.getPlayer(), world.getPlat());
        world.getPlayer().addCollisionListener(pickup);

        world.addStepListener(t);

        final JFrame frame = new JFrame("Dav Game");
        frame.add(view);



        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);

        frame.pack();
        frame.setVisible(true);

        System.out.println(world.getPlayer().getLives());
        world.start();


    }


    public static void main(String[] args) {

        //menushow dav = new menushow();

        new Game();
       // new Game().menu();



    }
}
