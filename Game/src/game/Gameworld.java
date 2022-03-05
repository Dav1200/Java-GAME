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



    public Gameworld() {
        plat = new platforms(this);
        player = new Player(this);
        e = new enemy(this);
        e.setPosition(new Vec2(18.5f,0));
        player.setPosition(new Vec2(-17,2));
        PickupItems p = new PickupItems(this);
        p.setPosition(new Vec2(0,0));
        PickupItems p2 = new PickupItems(this);
        p2.setPosition(new Vec2(5,5));

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
