package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Player extends Walker implements StepListener {

    private static final Shape player = new PolygonShape(
            -2.21f,0.59f, -1.48f,-2.05f, 0.07f,-2.08f, 1.17f,-0.32f, -0.11f,1.45f);

    private static final BodyImage Playerimg = new BodyImage("PlayerImages/gif2.gif", 5f);
    protected static final BodyImage Playerimgj = new BodyImage("PlayerImages/jump.gif", 5f);
    private static final BodyImage bulletimgl = new BodyImage("PlayerImages/shotl.png", 0.5f);
    private static final BodyImage bulletimgr = new BodyImage("PlayerImages/shot.png", 0.5f);
    private static final BodyImage Playerimgl = new BodyImage("PlayerImages/stablel.png", 4f);



    private static SoundClip shot;
    static{
        try {
            shot = new SoundClip("Sound/shot.wav");

            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    private int Lives;

    public int getLivess() {
        return Lives*10;
    }

    private int Livess;
    private int Score;
    private platforms plat;

    public String getFacing() {
        return facing;
    }
    protected boolean coinpick;
    private String facing;

    public boolean isDoublegun() {
        return doublegun;
    }

    public void setDoublegun(boolean doublegun) {
        this.doublegun = doublegun;
    }

    protected boolean doublegun;
    private AttachedImage playerimg;
    protected AttachedImage jump;
    protected enemy en;
    private Backpack backpack;
    protected int timer;
    protected int bulletcount;
    private int delay;
    private World world;
    protected int jumpcount;
    private int Lives2;
    protected boolean moves;
    protected  boolean tutorial;



    //constructor
    public Player(World world,enemy en,platforms plat) {
        super(world, player);
        this.world = world;
        this.en = en;
        this.plat = plat;
         playerimg = addImage(Playerimg);
        tutorial = true;
        moves = true;
        Lives = 10;
         setGravityScale(5);
        Score = 0;
        facing = "right";
        this.setGravityScale(2);
        backpack = new Backpack();
        timer = 0;
        bulletcount = 2;
        delay =0;
        doublegun =false;
        jumpcount =0;
        coinpick = false;

    }

    public int getLives() {
        return Lives;
    }

    public void setLives(int Lives) {
        this.Lives = Lives;
    }
public void play(){
        shot.play();
}
    public void walk(float speed) {
        super.startWalking(speed);
        if (speed < 0 && facing.equals("right")) {
            playerimg.flipHorizontal();

           // this.removeAllImages();
           // this.addImage(Playerimgl);
            facing = "left";

            //this.startWalking(speed);

        } else if (speed > 0 && facing.equals("left")) {
            playerimg.flipHorizontal();
            // this.removeAllImages();
            // this.addImage(Playerimgl);
            facing = "right";
           // this.startWalking(speed);
        }

    }
    public void shoot() {

        //bullet b = new bullet(this.getWorld(),this);

        shot.play();
        DynamicBody bullet = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
       // bulletimgrr = bullet.addImage(bulletimgr);
        BulletCollision pickups = new BulletCollision(this);

        bullet.addCollisionListener(pickups);



       // bullet.setGravityScale(0);
        //bullet.addImage(bulletimg);
        if (this.facing.equals("left")) {
            bullet.removeAllImages();
            bullet.addImage(bulletimgl);
           // bulletimgrr.flipHorizontal();


            bullet.setPosition(new Vec2(this.getPosition().x - 1f, this.getPosition().y));
            bullet.setLinearVelocity(new Vec2(-20, 2));
        } else {
            bullet.removeAllImages();
            bullet.addImage(bulletimgr);

            //bulletimgrr.flipHorizontal();
            bullet.setPosition(new Vec2(this.getPosition().x + 0.5f, this.getPosition().y));

            bullet.setLinearVelocity(new Vec2(20, 2));

        }
    }

    public void doubleshoot() {


    if(bulletcount >0){
        ActionListener actionListener = new actionlistener(this);

        shot.play();

        Timer t = new Timer(190,actionListener);
        t.setRepeats(false);
        t.start();

        //EnemybulletCol platcollision = new EnemybulletCol(en.plat);

        DynamicBody bullet1 = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        DynamicBody bullet2 = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        bulletcount -=2;
        BulletCollision pickups = new BulletCollision(this);
        bullet1.addCollisionListener(pickups);
        bullet2.addCollisionListener(pickups);

        // bullet.setGravityScale(0);


        //bullet.addImage(bulletimg);
        if (this.facing.equals("left")) {
            bullet1.removeAllImages();
            bullet1.addImage(bulletimgl);
            bullet1.setPosition(new Vec2(this.getPosition().x - 1f, this.getPosition().y));
            bullet1.setLinearVelocity(new Vec2(-20, 2));

            bullet2.removeAllImages();
            bullet2.addImage(bulletimgl);
            bullet2.setPosition(new Vec2(this.getPosition().x - 2.9f, this.getPosition().y));
            bullet2.setLinearVelocity(new Vec2(-20, 2));
        } else {
            bullet1.removeAllImages();
            bullet1.addImage(bulletimgr);
            bullet1.setPosition(new Vec2(this.getPosition().x + 0.5f, this.getPosition().y));
            bullet1.setLinearVelocity(new Vec2(20, 2));

            bullet2.removeAllImages();
            bullet2.addImage(bulletimgr);
            bullet2.setPosition(new Vec2(this.getPosition().x + 2.2f, this.getPosition().y));
            bullet2.setLinearVelocity(new Vec2(20, 2));

        }

        if(timer == 120){

            timer =0;
        }

    }}

    public void reset() {
        if(en.stage == 1){
            this.setLives(this.getLives()-1);
        this.setPosition(new Vec2(-17, -6));
    }
        if(en.stage == 2){
            this.setPosition(new Vec2(47,-11));
            this.setLives(this.getLives()-1);
        }
    }


    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(en.stage == 1){
            tutorial =false;
        }
        timer++;
        jumpcount ++;
        if(getLives() < 0){
            setLives(0);

        }


    }

    @Override
    public void postStep(StepEvent stepEvent) {
       // System.out.println(en.stage);
        if (this.getPosition().y < -15) {
            this.reset();
        }

        if ( timer >= 120) {

            timer = 120;
        }
       // System.out.println(world.isRunning());

        if(getLives() == 0){
            world.stop();
        }

        //System.out.println(timer);
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
