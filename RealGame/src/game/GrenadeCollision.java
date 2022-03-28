package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class GrenadeCollision implements CollisionListener {
    private GrenadeProjectile   g;
    public GrenadeCollision(GrenadeProjectile g){
        this.g = g;
    }
//-2.26f,0.44f, -1.57f,-1.86f, -0.09f,-1.88f, 1.22f,-0.12f, -0.85f,1.74f
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Destroy){
            collisionEvent.getOtherBody().destroy();
        }

        //the bomob will destroy anything it touches unless i add a sepearte collision listener for the explosion.
        if(collisionEvent.getOtherBody() instanceof  StaticBody){
            g.setLinearVelocity(new Vec2(0,0));
            g.setangle(0.1f);


        }
//add a timer which reduces the velocity of the bomb by 1 every 10ms

    }
}
