package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GrenadeCollision implements CollisionListener, StepListener {
    private GrenadeProjectile   g;
    private boolean incollision;
    public GrenadeCollision(GrenadeProjectile g){
        this.g = g;
        incollision = false;
    }
//-2.26f,0.44f, -1.57f,-1.86f, -0.09f,-1.88f, 1.22f,-0.12f, -0.85f,1.74f
    @Override
    public void collide(CollisionEvent collisionEvent) {


        //the bomob will destroy anything it touches unless i add a sepearte collision listener for the explosion.
        if(collisionEvent.getOtherBody() instanceof  StaticBody){

            incollision = true;
           // g.setLinearVelocity(new Vec2(0,0));
           // g.setangle(0.1f);




        }

        if(collisionEvent.getOtherBody() instanceof ShieldBody){
            collisionEvent.getReportingBody().destroy();
        }


//add a timer which reduces the velocity of the bomb by 1 every 10ms

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(incollision){
            if(g.getlinearvelocity().x > 0 )
            g.setLinearVelocity(g.getlinearvelocity().sub(new Vec2(0.2f,0)));
        }

        if(incollision){
            if(g.getlinearvelocity().x < 0 )
                g.setLinearVelocity(g.getlinearvelocity().add(new Vec2(0.2f,0)));
        }


    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
