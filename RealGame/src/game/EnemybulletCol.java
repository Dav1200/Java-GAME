

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class EnemybulletCol implements CollisionListener {
    private Player player;
    private enemy en;
    private platforms plat;


    //private Game game;


    public EnemybulletCol(platforms plat, enemy en) {
        this.en = en;
        this.plat = plat;


    }

    public EnemybulletCol() {

    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() != en){


            collisionEvent.getReportingBody().destroy();
        }
        if (collisionEvent.getOtherBody() instanceof  Player){
            ((Player) collisionEvent.getOtherBody()).setLives(((Player) collisionEvent.getOtherBody()).getLives()-1);
        }




   //

    }





    }

