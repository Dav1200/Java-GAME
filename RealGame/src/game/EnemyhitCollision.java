
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class EnemyhitCollision implements CollisionListener {
    private Player player;
    private enemy en;
    private platforms plat;


    //private Game game;


    public EnemyhitCollision(enemy en) {
        this.en = en;


    }



    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Player) {
            ((Player) collisionEvent.getOtherBody()).setLives(((Player) collisionEvent.getOtherBody()).getLives()-1);
            //collisionEvent.getReportingBody().setPosition(new Vec2(1000,1000));

        }




    }





    ;
}



