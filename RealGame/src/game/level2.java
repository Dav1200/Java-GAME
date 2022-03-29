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
    private level2platforms level2p;

    public level2(Game game,Gameview v) {

        super(game);

        level2p = new level2platforms(this.getWorld());
        this.getPlayer().setPosition(new Vec2(-26,-25));


        coin = new Coin(this);

        coin.setPosition(new Vec2(-5, -5));
        //
        //
        /*
        getE().setPosition(new Vec2(17.5f, 0));
        EnemySteplistener t = new EnemySteplistener(v, getPlayer(), getE());
        this.getWorld().addStepListener(t);
        getE().enemywalk(t.enemyX,t.enemyY);
        t.updateStudent(getE());
*/
        //might use or might make new enemy

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
        if(getPlayer().getScore() == 5){
            return true;
        }
        else
            return false;
    }


}
