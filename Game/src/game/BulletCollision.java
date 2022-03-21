package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
// make two boolean variable which are set to false in the begining of the stage and when coin is collected and the enemy is defeted the varibles are set to true and if the variables are
//set to true then stage can be changed when stage is changed these boolean variable are set to false again. 
public class BulletCollision implements CollisionListener{
    private Player player;
    private enemy en;
    private platforms plat;
    protected int count;
    private boolean coincollected;
    private boolean enemydefl;


    //private Game game;

    public BulletCollision(Player player) {
        this.player = player;
        count =0;
        coincollected = false;
        enemydefl = false;

    }

    public BulletCollision(platforms plat) {
        this.plat = plat;
        count =0;

    }



    @Override
    public void collide(CollisionEvent collisionEvent) {
        //collisionEvent.getReportingBody().setPosition(new Vec2(1000,1000));
        if (collisionEvent.getOtherBody() instanceof enemy) {

            ((enemy) collisionEvent.getOtherBody()).setSmallenemylives(((enemy) collisionEvent.getOtherBody()).getSmallenemylives() - 1);

           // collisionEvent.getReportingBody().setPosition(new Vec2(-1000, -1000));
            collisionEvent.getReportingBody().destroy();
            if (((enemy) collisionEvent.getOtherBody()).Smallenemylives == 0) {
                if (((enemy) collisionEvent.getOtherBody()).stage == 1)
                    collisionEvent.getOtherBody().setPosition(new Vec2(16.5f, 5));
                if (((enemy) collisionEvent.getOtherBody()).stage == 2)
                    collisionEvent.getOtherBody().setPosition(new Vec2(60,5));


                ((enemy) collisionEvent.getOtherBody()).setSmallenemylives(5);
                ((enemy) collisionEvent.getOtherBody()).setRespawn(((enemy) collisionEvent.getOtherBody()).getRespawn() - 1);

            }
            if (((enemy) collisionEvent.getOtherBody()).getRespawn() == 0) {

                if (((enemy) collisionEvent.getOtherBody()).stage == 1) {


                    collisionEvent.getOtherBody().setPosition(new Vec2(1000,1000));
                }
                if (((enemy) collisionEvent.getOtherBody()).stage == 2) {
                    collisionEvent.getOtherBody().destroy();
                }


            }


        }


        if(collisionEvent.getOtherBody() != player){
            collisionEvent.getReportingBody().destroy();
        }



        if (collisionEvent.getOtherBody() instanceof enemy) {

        }




    }



}



;




