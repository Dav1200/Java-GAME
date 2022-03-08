package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionListener;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Gameworld extends World {

    private Player player;
    private platforms plat;
    private enemy e;
    //protected enemy ee;
    private track t;
    private PlatformCollision platcollision;


    public Gameworld() {
        plat = new platforms(this);


        e = new enemy(this,plat);
        player = new Player(this,e);
        e.setPosition(new Vec2(18.5f,0));
        player.setPosition(new Vec2(-17,2));

        PickupItems p = new PickupItems(this);
        p.setPosition(new Vec2(0,2));
        PickupItems p2 = new PickupItems(this);
        p2.setPosition(new Vec2(-5,0));

    }

    public Player getPlayer() {
        return player;
    }

    public platforms getPlat(){return plat;};

    public enemy getE() {
        return e;

    }

    public void setE(enemy e) {
        this.e = e;
    }
}
