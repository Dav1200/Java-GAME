package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.Timer;

public class Player extends Walker implements StepListener {

    private static final Shape player = new PolygonShape(
            -2.21f,0.59f, -1.48f,-2.05f, 0.07f,-2.08f, 1.17f,-0.32f, -0.11f,1.45f);

    private static final BodyImage Playerimg = new BodyImage("PlayerImages/gif.gif", 5f);
    private static final BodyImage bulletimgl = new BodyImage("PlayerImages/shotl.png", 0.5f);
    private static final BodyImage bulletimgr = new BodyImage("PlayerImages/shot.png", 0.5f);
    private static final BodyImage Playerimgl = new BodyImage("PlayerImages/stablel.png", 4f);

    private float Lives;
    private int Score;

    public String getFacing() {
        return facing;
    }

    private String facing;
    protected boolean doublegun;
    private AttachedImage playerimg;
    private AttachedImage bulletimgrr;
    protected enemy en;
    private Backpack backpack;
    protected int timer;
    protected int bulletcount;
    private int delay;
    private World world;



    //constructor
    public Player(World world,enemy en) {
        super(world, player);
        this.world = world;
        this.en = en;
         playerimg = addImage(Playerimg);

        Lives = 3;
         setGravityScale(5);
        Score = 0;
        facing = "right";
        this.setGravityScale(2);
        backpack = new Backpack();
        timer = 0;
        bulletcount = 2;
        delay =0;
        doublegun =false;

    }

    public float getLives() {
        return Lives;
    }

    public void setLives(float Lives) {
        this.Lives = Lives;
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
        //PlatformCollision platcollision = new PlatformCollision(en.plat);

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
            this.setLives(this.getLives()-0.5f);
        this.setPosition(new Vec2(-17, -6));
    }
        if(en.stage == 2){
            this.setPosition(new Vec2(47,10));
            this.setLives(this.getLives()-0.5f);
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
        timer++;


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

        if(getLives() < 0){
            world.stop();
        }



        //System.out.println(timer);
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
