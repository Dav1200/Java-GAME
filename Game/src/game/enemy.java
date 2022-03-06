package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class enemy extends Walker {

    private final static Shape enemy = new BoxShape(1, 2);
    //private final static Shape enemyy = new BoxShape(1,2);
    // private final static Shape enemyy = new BoxShape(1,2);
    protected float Smallenemylives = 5;
    protected float x;
    protected float y;
    private int counter;
    //protected DynamicBody bullet;
    private platforms plat;


    public int getRespawn() {
        return respawn;
    }

    public void setRespawn(int respawn) {
        this.respawn = respawn;
    }

    private int respawn;


    public enemy(World world,platforms plat) {
        super(world, enemy);

        this.plat = plat;
        respawn = 2;
    }


    public void enemywalk(float x, float y) {
        if (x < 10) {
            this.startWalking(3);
        } else if (x > 18) {
            this.startWalking(-3);
        }

    }


    public float getSmallenemylives() {
        return Smallenemylives;
    }

    public void setSmallenemylives(float smallenemylives) {
        this.Smallenemylives = smallenemylives;
    }

    public void shootplayer(Vec2 t) {
        //when bullet hits player.
        DynamicBody bullet = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        EnemyhitCollision pickups = new EnemyhitCollision(this);


        //when the bullet hits platform

        PlatformCollision platcollision = new PlatformCollision(plat);
        bullet.addCollisionListener(platcollision);



        bullet.addCollisionListener(pickups);
        //listenbullet.addCollisionListener(bullet);

        Vec2 dir = t.sub(this.getPosition());
        dir.normalize();

        bullet.setPosition(this.getPosition().add(dir.mul(3f)));

        bullet.setLinearVelocity(dir.mul(30));
        if (getRespawn() == 0) {
            bullet.destroy();

        }


    }


}
