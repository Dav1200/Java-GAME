package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.Timer;

public class Player extends Walker implements StepListener {

    private static final Shape player = new PolygonShape(
            -0.57f, 0.63f,
            -0.14f, -1.52f,
            1.16f, -1.51f,
            1.37f, 0.62f,
            0.75f, 1.69f);

    private static final BodyImage Playerimg = new BodyImage("PlayerImages/stable.png", 4f);
    private static final BodyImage bulletimgl = new BodyImage("PlayerImages/bulletl.png", 1f);
    private static final BodyImage bulletimgr = new BodyImage("PlayerImages/bullets.png", 1f);
    private static final BodyImage Playerimgl = new BodyImage("PlayerImages/stablel.png", 4f);

    private float Lives;
    private int Score;
    private String facing;
    private AttachedImage playerimg;
    protected enemy en;





    //constructor
    public Player(World world,enemy en) {
        super(world, player);
        this.en = en;
         playerimg = addImage(Playerimg);
        Lives = 3;
    setGravityScale(5);
        Score = 0;
        facing = "right";
        this.setGravityScale(2);



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
        BulletCollision pickups = new BulletCollision(this);
        bullet.addCollisionListener(pickups);
       // bullet.setGravityScale(0);



        //bullet.addImage(bulletimg);
        if (this.facing.equals("left")) {
            bullet.removeAllImages();
            bullet.addImage(bulletimgl);
            bullet.setPosition(new Vec2(this.getPosition().x - 0.5f, this.getPosition().y));
            bullet.setLinearVelocity(new Vec2(-20, 2));
        } else {
            bullet.removeAllImages();
            bullet.addImage(bulletimgr);
            bullet.setPosition(new Vec2(this.getPosition().x + 0.5f, this.getPosition().y));

            bullet.setLinearVelocity(new Vec2(20, 2));



        }
    }

    public void reset() {
        if(en.stage == 1){
        this.setPosition(new Vec2(-17, -6));
    }
        if(en.stage == 2){
            this.setPosition(new Vec2(47,10));
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


    }

    @Override
    public void postStep(StepEvent stepEvent) {
       // System.out.println(en.stage);
        if (this.getPosition().y < -15) {
            this.reset();
        }

    }
}
