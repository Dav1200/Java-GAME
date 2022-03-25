package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class level2 extends Gamelevel implements StepListener {
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

    public level2(Game game,Gameview v) {

        super(game);

        plat = new platforms(this);

        getE().setPosition(new Vec2(17.5f, 1));
        EnemySteplistener t = new EnemySteplistener(v, getPlayer(), getE());

        this.getWorld().addStepListener(t);

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
        if(getPlayer().getScore() == 3){
            return true;
        }
        else
            return false;
    }


}
