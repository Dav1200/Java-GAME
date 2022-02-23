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

    private static final BodyImage Playerimg = new BodyImage("PlayerImages/Stable.png",4f);
    private int Lives = 3;
    //constructor
    public Player(World world) {
        super(world,player);
        addImage(Playerimg);


    }

    public int getLives() {
        return Lives;
    }
    public void setLives(int Lives){
        this.Lives = Lives;
    }


    public void walk(float speed){
        if(speed<0){
            this.startWalking(speed);

        }
        else
            this.startWalking(speed);

    }
}
