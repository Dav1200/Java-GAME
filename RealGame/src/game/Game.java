package game;

import javax.swing.JFrame;


public class Game {
    private Gamelevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private Gameview view;

    private control move;

    private  EnemySteplistener t;
    public Game() {
        world = new level1(this);

        if (world.getPlayer().getLives() == 9) {

        }


        //make game world


        //2. view
         view = new Gameview(world, 800, 600, world.getPlayer(), world.getE());

        t = new EnemySteplistener(view, world.getPlayer(), world.getE());

        //RegeneratePlayercollision c = new RegeneratePlayercollision(world.getPlayer());

        Mousecontroller dav = new Mousecontroller(view, world.getPlayer());
        view.addMouseListener(dav);
        move = new control(world.getPlayer(), t, world.getE());
        view.addKeyListener(move);

        Collision pickup = new Collision(world.getPlayer(), world.getPlat(), world.getE(),this,world);
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

    public void goToNextLevel() {
        if (world instanceof level1) {
            world.stop();
            //create the new (appropriate) level
            Player preplayer = world.getPlayer();
            //level now refers to new level
            world = new level2(this,view);
            world.getPlayer().setLives(preplayer.getLives());
            world.getPlayer().setScore(preplayer.getScore());
            world.getPlayer().setDoublegun(preplayer.doublegun);

            //change the view to look into new level
            view.setWorld(world);
            //change the controller to control the
            //student in the new world
            view.updateStudent(world.getPlayer());
            move.updateStudent(world.getPlayer());
            view.enemy(world.getE());


            world.addStepListener(t);
            world.addStepListener(view);
            world.addStepListener(world.getE());
            world.addStepListener(world.getPlayer());
            world.addStepListener(move);
            world.addStepListener(world);


            //start the simulation in the new level
            world.start();
        }
             else if (world instanceof level2){
                System.out.println("Well done! Game complete.");
                System.exit(0);



    }



    }

    public static void main(String[] args) {

        //menushow dav = new menushow();

        new Game();


        // new Game().menu();


    }
}
