package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Player extends Walker {

    private static final Shape player = new PolygonShape(
            -0.57f, 0.63f,
            -0.14f, -1.52f,
            1.16f, -1.51f,
            1.37f, 0.62f,
            0.75f, 1.69f);

    private static final BodyImage Playerimg = new BodyImage("PlayerImages/stable.png", 4f);
    private int Lives;
    private int Score;
    private String facing;

    //constructor
    public Player(World world) {
        super(world, player);
        addImage(Playerimg);
        Lives = 3;
        Score = 0;

    }

    public int getLives() {
        return Lives;
    }

    public void setLives(int Lives) {
        this.Lives = Lives;
    }

    public void walk(float speed) {
        if (speed < 0) {
            facing = "left";
            this.startWalking(speed);

        } else
            facing = "right";
            this.startWalking(speed);


    }

    public void shoot() {

        DynamicBody bullet = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        if (this.facing.equals("left")) {
            bullet.setPosition(new Vec2(this.getPosition().x - 0.5f, this.getPosition().y));
            bullet.setLinearVelocity(new Vec2(-20, 2));
        } else{
            bullet.setPosition(new Vec2(this.getPosition().x + 0.5f, this.getPosition().y));
            bullet.setLinearVelocity(new Vec2(20, 2));

        }


    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
