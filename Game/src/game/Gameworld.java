package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Gameworld extends World {

    private Player player;
    private platforms plat;
    private enemy e;



    private RegeneratePlat a;
    private RegeneratePlayercollision regenCollision;

    public Gameworld() {
        plat = new platforms(this);
        a = new RegeneratePlat(this,2,47f,10f);
        a.setName("Regen");



        e = new enemy(this,plat);
        player = new Player(this,e);
        e.setPosition(new Vec2(18.5f,0));
        player.setPosition(new Vec2(-17,2));


        PickupItems p = new PickupItems(this);
        p.setPosition(new Vec2(0,2));
       // PickupItems p2 = new PickupItems(this);
        //p2.setPosition(new Vec2(-5,0));


        player.getBackpack().additem(new Doublegun(getPlayer()));
       // player.getBackpack().additem(new Doublegun());

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
