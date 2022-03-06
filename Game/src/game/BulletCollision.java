package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class BulletCollision implements CollisionListener {
    private Player player;
    private enemy en;
    private platforms plat;


    //private Game game;

    public BulletCollision(Player player) {
        this.player = player;




    }

    public BulletCollision(enemy en) {
        this.en = en;




    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof enemy){

            ((enemy) collisionEvent.getOtherBody()).setSmallenemylives(((enemy) collisionEvent.getOtherBody()).getSmallenemylives()-1);
            collisionEvent.getReportingBody().setPosition(new Vec2(-1000,-1000));
            if(((enemy) collisionEvent.getOtherBody()).Smallenemylives == 0){

                collisionEvent.getOtherBody().setPosition(new Vec2(16.5f,5));
                ((enemy) collisionEvent.getOtherBody()).setSmallenemylives(5);
                ((enemy) collisionEvent.getOtherBody()).setRespawn(((enemy) collisionEvent.getOtherBody()).getRespawn()-1);

            }
            if(((enemy) collisionEvent.getOtherBody()).getRespawn() == 0){
                collisionEvent.getOtherBody().destroy();
            }



        }




        }



    ;
}



