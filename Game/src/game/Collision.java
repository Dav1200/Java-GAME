package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Collision implements CollisionListener {
    private Player player;
    private platforms plat;

    //private Game game;

    public Collision(Player player, platforms plat) {
        this.player = player;
        this.plat = plat;
        //this.game = g;
    }

    public Collision(Player player) {
        this.player = player;

    }




    @Override
    public void collide(CollisionEvent collisionEvent) {
        /*
        if (collisionEvent.getPosition().y < -15) {
            player.setPosition(new Vec2(-17, -6));
            player.setLives(player.getLives() - 1);

        }
        */
        if (collisionEvent.getOtherBody() instanceof PickupItems) {
            collisionEvent.getOtherBody().destroy();
            player.setScore(player.getScore() + 1);

        }

        if(collisionEvent.getOtherBody() instanceof  enemy){

            player.setLives(player.getLives()-1);
            player.setPosition(new Vec2(-17, -6));
        }

    }

    ;
}


