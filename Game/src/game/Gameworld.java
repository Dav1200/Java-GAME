package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Gameworld extends World {

    private Player player;
    private platforms plat;
    private enemy e;


    private Spikeplat Lava;
    private RegeneratePlat a;
    private RegeneratePlayercollision regenCollision;
    private jumppad jumppad;
    private static final BodyImage grounds = new BodyImage("Platformimg/regen.png", 2);

    public Gameworld() {
        plat = new platforms(this);

        e = new enemy(this,plat);
        player = new Player(this,e,plat);
        e.setPosition(new Vec2(18.5f,0));
        player.setPosition(new Vec2(-17,2));
        a = new RegeneratePlat(this,3.5f,47f,10f,player);
        Lava = new Spikeplat(this,10,60,0,player);
        jumppad = new jumppad(this);

        a.setName("Regen");

        PickupItems p = new PickupItems(this);
        p.setPosition(new Vec2(0,2));
       // PickupItems p2 = new PickupItems(this);
        //p2.setPosition(new Vec2(-5,0));


        player.getBackpack().additem(new Doublegun(getPlayer()));
        player.getBackpack().additem(new Doublejump(getPlayer()));

    }

    public Player getPlayer() {
        return player;
    }

    public platforms getPlat(){return plat;};

    public enemy getE() {
        return e;

    }

    public RegeneratePlat getA() {
        return a;
    }

    public void setE(enemy e) {
        this.e = e;
    }
}
