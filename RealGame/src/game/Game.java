package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.util.Set;


public class Game implements StepListener {
    public Gamelevel getWorld() {
        return world;
    }

    public void setWorld(Gamelevel world) {
        this.world = world;
    }

    private Gamelevel world;

    public Gameview getView() {
        return view;
    }

    public void setView(Gameview view) {
        this.view = view;
    }

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private Gameview view;

    private control move;
    private Mousecontroller dav;

    private EnemySteplistener t;
    protected Container pane;
    protected Container thispane;
    protected final JFrame frame;
    protected final JFrame framee;
    private Menu menu;
    private JLabel jlabel;
    private ImageIcon Image;
    private Image background;
    protected int volume;


    public Settings getSettings() {
        return settings;
    }

    private Settings settings;

    public Game()  {

        world = new level1(this);
        volume =1 ;
        menu = new Menu(this);
        settings = new Settings(this,world);

        background = new ImageIcon("Platformimg/Pauseback.png").getImage();
        if (world.getPlayer().getLives() == 9) {

        }


        //make game world


        //2. view
        view = new Gameview(world, 800, 600, world.getPlayer(), world.getE(), world);

        t = new EnemySteplistener(view, world.getPlayer(), world.getE());

        Image = new ImageIcon("Platformimg/Pauseback.png");

        JButton play = new JButton("play");


        jlabel = new JLabel(Image);
        jlabel.setSize(800, 600);
        jlabel.add(menu.getButton1());
        jlabel.add(menu.getQuitButton());
        jlabel.add(menu.getSettingsButton());
        //RegeneratePlayercollision c = new RegeneratePlayercollision(world.getPlayer());

        dav = new Mousecontroller(view, world.getPlayer());
        view.addMouseListener(dav);
        move = new control(world.getPlayer(), t, world.getE(), this,world);
        view.addKeyListener(move);



        //
        //world.getPlayer().addCollisionListener(dav);

        world.addStepListener(t);
        world.addStepListener(view);
        world.addStepListener(world.getE());
        world.addStepListener(world.getPlayer());
        world.addStepListener(move);
        world.addStepListener(world);
        world.addStepListener(this);

        frame = new JFrame("Dav Game");


        framee = new JFrame("Dav Game");

        //frame.setSize(800,600)
        //  view.setGridResolution(1);


        thispane = frame.getContentPane();
        pane = framee.getContentPane();


        view.setLayout(null);
        frame.setSize(800, 600);

        frame.getContentPane().add(view);


        // frame.setContentPane(pane);

        //frame.add(menu.getButton1());


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);

        frame.pack();

        frame.setVisible(true);

        JFrame debugView = new DebugViewer(world, 500, 500);
        debugView.setVisible(true);
        StartMenu();
        world.start();


    }

    public void goToNextLevel() {
        if (world instanceof level1) {
            world.stop();
            //world.sound().stop();
            //create the new (appropriate) level
            Player preplayer = world.getPlayer();
            // EnemySteplistener pt = t;
            //level now refers to new level
            world = new level2(this, view);

            world.getPlayer().setLives(preplayer.getLives());
            world.getPlayer().setScore(preplayer.getScore());
            world.getPlayer().setDoublegun(preplayer.doublegun);
            world.getPlayer().setGrenadepicked(preplayer.grendadeshoot);

            view.updategamelevel(world);
            //change the view to look into new level
            view.setWorld(world);
            //view.setZoom(12);
            view.setView(new Vec2(0, 9), 12);
            System.out.println(world.isComplete());

            //change the controller to control the
            //student in the new world
            view.updateStudent(world.getPlayer());
            move.updateStudent(world.getPlayer());
            move.gamelevelupdate(world);
            dav.updateStudent(world.getPlayer());
            view.enemy(world.getE());



            world.addStepListener(t);
            world.addStepListener(view);
            world.addStepListener(world.getE());
            world.addStepListener(world.getPlayer());
            world.addStepListener(move);
            world.addStepListener(world);
            world.addStepListener(this);


            //start the simulation in the new level
            world.start();

        } else if (world instanceof level2) {
            world.stop();
            Player preplayers = world.getPlayer();
            world = new level3(this);

            world.getPlayer().setLives(preplayers.getLives());
            world.getPlayer().setScore(preplayers.getScore());
            world.getPlayer().setDoublegun(preplayers.doublegun);
            world.getPlayer().setGrenadepicked(preplayers.grendadeshoot);



            view.updategamelevel(world);
            //change the view to look into new level
            view.setWorld(world);
            view.setView(new Vec2(0, 9), 12);
            move.gamelevelupdate(world);
            view.updateStudent(world.getPlayer());
            move.updateStudent(world.getPlayer());
            dav.updateStudent(world.getPlayer());
            view.enemy(world.getE());


            world.addStepListener(t);
            world.addStepListener(view);
            world.addStepListener(world.getE());
            world.addStepListener(world.getPlayer());
            world.addStepListener(move);
            world.addStepListener(world);
            world.addStepListener(this);


            //start the simulation in the new level
            world.start();


        } else if (world instanceof level3) {
            System.out.println("Well done! Game complete.");
            System.exit(0);

        }

    }

    public void setlevel(Gamelevel g){

        if(g instanceof level2){
        world.stop();
        world.sound().stop();
        //world.sound().stop();
        //create the new (appropriate) level
        Player preplayer = world.getPlayer();
        // EnemySteplistener pt = t;
        //level now refers to new level
        world = new level2(this, view);

        world.getPlayer().setLives(preplayer.getLives());
        world.getPlayer().setScore(preplayer.getScore());
        world.getPlayer().setDoublegun(preplayer.doublegun);
        world.getPlayer().setGrenadepicked(preplayer.grendadeshoot);
        world.getPlayer().setScore(2);

        view.updategamelevel(world);
        //change the view to look into new level
        view.setWorld(world);
        //view.setZoom(12);
        view.setView(new Vec2(0, 9), 12);
        System.out.println(world.isComplete());

        //change the controller to control the
        //student in the new world
        view.updateStudent(world.getPlayer());
        move.updateStudent(world.getPlayer());
        move.gamelevelupdate(world);
        dav.updateStudent(world.getPlayer());
        view.enemy(world.getE());



        world.addStepListener(t);
        world.addStepListener(view);
        world.addStepListener(world.getE());
        world.addStepListener(world.getPlayer());
        world.addStepListener(move);
        world.addStepListener(world);
        world.addStepListener(this);


        //start the simulation in the new level
        world.start();
        world.sound().play();



        }

        if(g instanceof level3){

            world.stop();

            world.sound().stop();
            Player preplayers = world.getPlayer();
            world = new level3(this);

            world.getPlayer().setLives(preplayers.getLives());
            world.getPlayer().setScore(preplayers.getScore());
            world.getPlayer().setDoublegun(preplayers.doublegun);
            world.getPlayer().setGrenadepicked(preplayers.grendadeshoot);
            world.getPlayer().setScore(3);



            view.updategamelevel(world);
            //change the view to look into new level
            view.setWorld(world);
            view.setView(new Vec2(0, 9), 12);
            move.gamelevelupdate(world);
            view.updateStudent(world.getPlayer());
            move.updateStudent(world.getPlayer());
            dav.updateStudent(world.getPlayer());
            view.enemy(world.getE());


            world.addStepListener(t);
            world.addStepListener(view);
            world.addStepListener(world.getE());
            world.addStepListener(world.getPlayer());
            world.addStepListener(move);
            world.addStepListener(world);
            world.addStepListener(this);


            //start the simulation in the new level
            world.start();
            world.sound().play();


        }
    }


    public void StartMenu() {
        world.stop();

        frame.setContentPane(pane);
        // frame.add(startMenu);
        frame.add(jlabel);

        frame.validate();

    }


    public void move() {
        world.stop();
        world.sound().pause();

        frame.setContentPane(pane);
        frame.add(jlabel);


        //jlabel.add(menu.getMainPanel());
        frame.getContentPane();
        //frame.repaint();
        frame.validate();


    }

    public void Pause() {
        world.start();
        world.sound().resume();
        frame.setContentPane(thispane);
    }


    public static void main(String[] args) {

        //menushow dav = new menushow();

        new Game();


        // new Game().menu();


    }

    @Override
    public void preStep(StepEvent stepEvent) {
        //System.out.println(volume);

        switch (volume) {

            case 1:
                //  gamelevel.sound().resume();
                world.sound().setVolume(0.05);

                break;
            case 2:
                world.sound().setVolume(0.1);
                break;
            case 3:
                world.sound().setVolume(0.15);
                break;
            case 4:
                world.sound().setVolume(0.20);
                break;
            case 5:
                world.sound().setVolume(0.3);
                break;

        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}


