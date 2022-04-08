package game;

import city.cs.engine.*;

import java.awt.*;

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
    protected int volume;


    public void setPlayer(Player player) {
        this.player = player;
    }

    public Gamelevel(Game game) {
        this.game = game;


        getSimulationSettings().setTargetFrameRate(60);


        e = new enemy(this, plat);

        if(this instanceof level2 || this instanceof level3){
            e.destroy();
        }





        player = new Player(this.getWorld(), e, plat, this);
        player.getBackpack().additem(new Doublegun(getPlayer()));
        getPlayer().getBackpack().additem(new Shield(getPlayer()));
        player.getBackpack().additem(new Grenade(getPlayer()));


        Collision pickup = new Collision(player, this.plat, e, game, this);
        player.addCollisionListener(pickup);

        this.setGravity(15);

        this.sound().setVolume(0.2);
        this.sound().play();
        this.sound().loop();
        //this.sound().setVolume();
        //this.sound().loop();


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

    public Gamelevel getGamelevel() {
        return this;
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

    public Gamelevel getWorld() {
        return this;
    }

    public abstract boolean isComplete();

    public abstract Image background();

    public abstract SoundClip sound();

    public abstract String level();


    public void play() {
        this.sound().play();


    }


    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
