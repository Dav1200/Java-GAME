

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class PlatformCollision implements CollisionListener {
    private Player player;
    private enemy en;
    private platforms plat;


    //private Game game;


    public PlatformCollision(platforms plat) {
        this.plat = plat;


    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        //System.out.println("hi");
        collisionEvent.getReportingBody().setPosition(new Vec2(1000,1000));



    }
}
