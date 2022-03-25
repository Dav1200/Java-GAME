package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class Gamelevel extends World implements StepListener {

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
    private Game game;



    public void setPlayer(Player player) {
        this.player = player;
    }

    public Gamelevel(Game game) {
        this.game = game;



        e = new enemy(this, plat);
        player = new Player(this, e, plat);
        player.getBackpack().additem(new Doublegun(getPlayer()));
        player.getBackpack().additem(new item(getPlayer()));
        Collision pickup = new Collision(player, plat, e,game,this);
        player.addCollisionListener(pickup);



    }

    public Player getPlayer() {
        return player;
    }

    public platforms getPlat() {
        return plat;
    }

    ;

    public enemy getE() {
        return e;

    }

    public RegeneratePlat getA() {
        return a;
    }

    public void setE(enemy e) {
        this.e = e;
    }

    public PickupItems getP() {
        return p;
    }

    public Gamelevel getWorld(){
        return this;
    }
    public abstract boolean isComplete();

    @Override
    public void preStep(StepEvent stepEvent) {




    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
