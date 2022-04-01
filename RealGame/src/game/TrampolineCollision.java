package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class TrampolineCollision implements CollisionListener {
private jumppad j;
    public TrampolineCollision(jumppad j){
this.j = j;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof  Player){
            j.play();
            ((Player) collisionEvent.getOtherBody()).setLinearVelocity(new Vec2(0,50));
        }



    }
}
