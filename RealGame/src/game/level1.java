package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class level1 extends Gamelevel implements StepListener {
    private Player player;
    private platforms plat;
    private enemy e;
    private Spikeplat Lava;
    private RegeneratePlat a;
    private RegeneratePlayercollision regenCollision;
    private jumppad jumppad;
    private static final BodyImage grounds = new BodyImage("Platformimg/regen.png", 2);
    private PickupItems p;
    private Coin coin;
    private Coin coin2;

    public level1(Game game) {
        super(game);



        plat = new platforms(this);
        getE().setPosition(new Vec2(17.5f, 0));
        getPlayer().setPosition(new Vec2(-17, 2));
        a = new RegeneratePlat(this, 4f, 47f, 10f, getPlayer());
        Lava = new Spikeplat(this, 10, 60, 0, getPlayer(), getE());
        jumppad = new jumppad(this);

        a.setName("Regen");
        Border border = new Border(this);
        p = new PickupItems(this);
        p.setPosition(new Vec2(-5, 0));

        coin = new Coin(this);

        coin.setPosition(new Vec2(17, 6.5f));
        coin2 = new Coin(this);
        coin2.setPosition(new Vec2(77, -8.5f));

    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPlayer().coinpick && getE().enemydef) {
            getPlayer().coinpick = false;
            getE().enemydef = false;
            getE().stage++;
        }


    }

    @Override
    public void postStep(StepEvent stepEvent) {



    }


    ;


    public RegeneratePlat getA() {
        return a;
    }


    public PickupItems getP() {
        return p;
    }

    @Override
    public boolean isComplete() {

        if(getPlayer().getScore() == 2){
            return true;
        }
        else
            return false;
    }


}
