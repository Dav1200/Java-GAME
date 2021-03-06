package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;

public class Gameview extends UserView implements StepListener {
    private static SoundClip stage1, intro;

    static {
        try {
            stage1 = new SoundClip("Sound/stage1.wav");
            intro = new SoundClip("Sound/intro.wav");
            stage1.setVolume(0.2);
            intro.setVolume(0.2);
            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    private Image background;
    private Image backgroundt;
    private Image level2background;
    private Image Hearts;
    protected Player player;
    private Image fullh;
    private Image emptyh;
    private enemy e;
    protected Point2D.Float pxcoverted;
    protected Point2D.Float Enemypos;
    protected int pycoverted;
    protected int px;
    protected int sec = 0;
    private boolean setstage0;
    private boolean setstage1;
    protected boolean set;
    protected int ex;
    protected int ey;
    private int tick;
    private Point2D.Float points;
    private String face;
    private boolean setStage3;

    public Gamelevel getGamelevel() {
        return gamelevel;
    }

    private Gamelevel gamelevel;
    private boolean level2;


    public Gameview(World w, int width, int height, Player player, enemy e, Gamelevel gamelevel) {
        super(w, width, height);
        this.player = player;
        this.e = e;
        this.gamelevel = gamelevel;
        setstage0 = false;
        set = false;
        setstage1 = false;
        setStage3 = false;
        background = new ImageIcon("Platformimg/stage1r.png").getImage();
        backgroundt = new ImageIcon("Platformimg/background0.png").getImage();
        Hearts = new ImageIcon("enemy/maxh.png").getImage();
        fullh = new ImageIcon("playerimages/fullh.png").getImage();
        emptyh = new ImageIcon("playerimages/emptyhh.png").getImage();

        level2 = false;


    }


    @Override
    protected void paintBackground(Graphics2D g) {


        g.drawImage(gamelevel.background(), 0, 0, this);
/*}
        if(gamelevel instanceof  level2)
        {
            g.drawImage(backgroundt,0,0,this);
           // g.scale(0.5,0.5);
        }

        if (e.stage == 0) {
            g.drawImage(backgroundt,0,0,this);
        } else if(e.stage == 1 || e.stage ==2){
            g.drawImage(background, 0, 0, this);


       }

               else if(e.stage == 3){
            g.drawImage(backgroundt,0,0,this);


        }

*/
        //g.scale(0.5f,0.5f);


    }

    @Override
    protected void paintForeground(Graphics2D g) {


        // tick = e.getSmallenemylives() + 7;
/*
        if (e.stage == 0) {
            g.scale(1.5f, 1.5f);
            g.drawString("Tap W = Jump", 10, 20);
            g.drawString("A = MoveLeft", 10, 40);
            g.drawString("D = MoveRight", 10, 60);
            g.drawString("Space = Shoot", 10, 80);
            g.drawString("Q = Switch Item", 10, 100);
            g.drawString("R = Use Item", 10, 120);
            g.drawString("Shift + A or D = Sprint", 200, 20);
            g.drawString("Hold W = Double Jump", 200, 40);
            g.drawString("G = Start Game", 400, 20);
            g.drawString("Toy Enemy is provided To Test your Skills", 200, 60);

        }
*/
        //g.drawRect(165,75,60,60);
        g.drawImage(player.getBackpack().getitem().image, 185, 85, 30, 30, this);
        g.drawImage(emptyh, px - 70, pycoverted - 50, 100, 20, this);
        g.drawImage(fullh, px - 69, pycoverted - 50, player.getLivess(), 20, this);


        if (gamelevel instanceof level1 && e.stage ==1) {
            g.setColor(Color.red);
            g.fillRect(ex, ey - 50, 50, 10);
            g.setColor(Color.green);
            g.fillRect(ex, ey - 50, e.getSmallenemylivess(), 10);
        }
        // if (e.stage > 0&& e.stage < 3) {

        // g.scale(0.2f,0.2f);
        //g.drawImage(Hearts,0,10,this);
        // g.scale(2,2);
        g.scale(1.5f, 1.5f);
        g.setColor(Color.white);
        if (gamelevel instanceof game.level2 || gamelevel instanceof level3) {
            g.setColor(Color.black);

        }
        g.drawString("Lives:" + player.getLives(), 10, 30);
        g.drawString("Score:" + player.getScore(), 10, 50);
        g.drawString("Current Weapons:", 10, 70);

        // System.out.println(this.EnemySteplistener.getSeconds());
        // g.drawString("enemy" + e.getRespawn(), 10, 90);

        // g.drawString("Time:" + sec, 10, 70);
        // }
        // if (e.stage > 0 && e.stage < 3) {

        if (gamelevel instanceof level1) {

        }
         /*
        if(e.stage  ==3){
            g.scale(3,3);
            g.drawString("Game over",100,100);
            g.drawString("Thanks For playing",86,110);

        }
        */

        //System.out.println(ex);


        //
    }


    @Override
    public void preStep(StepEvent stepEvent) {


        //setCentre(new Vec2(player.getPosition().x,player.getPosition().y));
        pxcoverted = worldToView(new Vec2(player.getPosition()));
        pycoverted = Math.round(pxcoverted.y);
        px = Math.round(pxcoverted.x);
        face = player.getFacing();

        //follow Enemy Healthbar


        Enemypos = worldToView(new Vec2(e.getPosition()));
        ex = Math.round(Enemypos.x);
        ey = Math.round(Enemypos.y);


        //System.out.println(Math.round(pxcoverted.x));
        //System.out.println(pxcoverted);
        if (face.equals("left")) {
            //px += 35;
            if (gamelevel instanceof level2 || gamelevel instanceof level3) {
                px += 10;
            }
        }

        if (face.equals(("right"))) {
            if (gamelevel instanceof level2 || gamelevel instanceof level3) {
                px += 10;
            }
        }
        if(e.stage == 1) {
            if (e.getFacing().equals("right")) {
                ex -= 40;
            }
        }
        if (gamelevel instanceof level2) {

            level2 = true;
        }
        if (e.stage == 2) {
            ex += 10;

        }


    }


    @Override
    public void postStep(StepEvent stepEvent) {
        // System.out.println(e.stage);
        // System.out.println(set);
      /*  if (e.stage == 0 && !setstage0) {
            setView(new Vec2(-60, 0), this.getZoom());
            player.setPosition(new Vec2(-70, -13));
            setstage0 = true;
            intro.play();
            intro.loop();
            player.setLives(999);
        }*/
        if (gamelevel instanceof level1) {
            if (e.stage == 1 && !setstage1) {
                intro.stop();
                setView(new Vec2(0, 0), this.getZoom());
                player.setPosition(new Vec2(-17, -14));

                setstage1 = true;
                // stage1.play();
                // stage1.loop();
                player.setLives(10);
            }


            if (e.stage == 2 && !set && player.getScore() == 1) {
                setView(new Vec2(60, 0), this.getZoom());
                e.setRespawn(1);

                player.setPosition(new Vec2(48, 13));
                set = true;


            }


            if (e.stage == 2 && e.getRespawn() == 0 && player.getScore() == 2) {

            }
        }

        //if(e.stage == 3 && !setStage3  && player.getScore() == 2){
        // setView(new Vec2(120, 0), this.getZoom());

        // setStage3 = true;
        //   }


        //this.points = worldToView(new Vec2((e.getPosition().x),(e.getPosition().y-50)));
        //this.ex = (int)points.x;
        // this.ey = (int)points.y;

        // System.out.println(ex);


    }

    public void updateStudent(Player player) {
        this.player = player;
    }

    public void enemy(enemy e) {
        this.e = e;
    }

    public void updategamelevel(Gamelevel gamelevel) {
        this.gamelevel = gamelevel;
    }
}