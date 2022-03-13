package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Spikeplat extends platforms {

    private static final BodyImage grounds = new BodyImage("Platformimg/Spikes.png", 2.5f);
    private static final BodyImage hp = new BodyImage("Platformimg/hp.png", 2.5f);
    protected StaticBody spikeplat;
    protected Gameworld w;

    public int getPlayer() {
        return player.getLives();
    }

    protected Player player;


    public Spikeplat(Gameworld w, float width, float x, float y, Player player) {
        super(w);
        this.w = w;
        this.player = player;
        //addImage(hp).setOffset(new Vec2(49.5f,12));
        spikeplat = new StaticBody(this.getWorld(),new BoxShape(width,0.3f));
        spikeplat.setPosition(new Vec2(x,y));
        spikeplat.addImage(grounds);
        spikeplat.addImage(grounds).setOffset(new Vec2(-7,0));
        spikeplat.addImage(grounds).setOffset(new Vec2(7,0));
        spikeplat.setAlwaysOutline(true);
        //setName("hiii");



        SpikeplatCollision dav = new SpikeplatCollision(player,this);
        spikeplat.addCollisionListener(dav);
        getWorld().addStepListener(dav);

    }





}



