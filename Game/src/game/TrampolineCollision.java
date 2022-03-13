package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class TrampolineCollision implements CollisionListener {

    public TrampolineCollision(){

    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof  Player){
            ((Player) collisionEvent.getOtherBody()).setLinearVelocity(new Vec2(0,40));
        }


    }
}
