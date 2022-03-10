package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class RegeneratePlat extends StaticBody {

    private static final BodyImage grounds = new BodyImage("Platformimg/ground.png", 1);
    private StaticBody Dav;
    protected Gameworld w;

    public int getPlayer() {
        return player.getLives();
    }

    protected Player player;


    public RegeneratePlat(Gameworld w, float width, float x, float y,Player player) {
        super(w);
        this.w = w;
        this.player = player;
        Dav = new StaticBody(this.getWorld(),new BoxShape(width,0.3f));
        Dav.setPosition(new Vec2(x,y));
        setName("hi");
        RegeneratePlayercollision dav = new RegeneratePlayercollision(player,this);
        Dav.addCollisionListener(dav);
        getWorld().addStepListener(dav);

    }





}



