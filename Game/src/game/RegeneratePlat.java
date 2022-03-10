package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class RegeneratePlat extends StaticBody {

    private static final BodyImage grounds = new BodyImage("Platformimg/ground.png", 1);
    private StaticBody Dav;


    public RegeneratePlat(World w, float width, float x, float y) {
        super(w);
        Dav = new StaticBody(this.getWorld(),new BoxShape(width,0.3f));
        Dav.setPosition(new Vec2(x,y));
        setName("hi");
        RegeneratePlayercollision dav = new RegeneratePlayercollision();
        Dav.addCollisionListener(dav);

    }




}



