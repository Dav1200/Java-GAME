package game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class bullet {
    private DynamicBody bullet;
    private World w;
    private Player p;
    public bullet(World w,Player p){
        this.w = w;
        this.p = p;

        bullet = new DynamicBody(w, new CircleShape(0.2f));
        bullet.setPosition(new Vec2(p.getPosition().x - 1f, p.getPosition().y));
        bullet.setLinearVelocity(new Vec2(-20, 2));

    }
}



