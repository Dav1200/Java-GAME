package game;

import city.cs.engine.*;
import com.sun.jdi.event.VMDeathEvent;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyClass extends Walker implements StepListener,Destroy {
    private static final BodyImage enemyimg = new BodyImage("enemy/enemy3.png", 5f);
    private static final BodyImage bullets = new BodyImage("enemy/Bullet.png", 1f);
    private int Health;
    private Player player;
    private float x;
    private boolean loop;
    private int active;
    private AttachedImage aimagel;
    private String facing;
    private boolean l;
    private boolean r;


    public EnemyClass(World world, Shape shape, Player player, int Health) {
        super(world, shape);
        // addImage(enemyimg);
        this.Health = Health;
        this.player = player;
        loop = true;
        aimagel = addImage(enemyimg);
        active = Health-1;
        facing= "left";
        r = true;
        l = true;



    }
public void timeshooting(){
    if (getHealth() <= active) {
        ActionListener bulletTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shootplayer(new Vec2(player.getPosition()));
            }
        };
        Timer BulletTimer = new Timer(2000, bulletTimer);
        BulletTimer.start();


    }
}

    public void shootplayer(Vec2 t) {
        //when bullet hits player.

        DynamicBody bullet = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        bullet.addImage(bullets);
        EnemyhitCollision pickups = new EnemyhitCollision(this);


        //when the bullet hits platform

        EnemybulletCol platcollision = new EnemybulletCol();
        bullet.addCollisionListener(platcollision);


        bullet.addCollisionListener(pickups);
        //listenbullet.addCollisionListener(bullet);

        Vec2 dir = t.sub(this.getPosition());
        dir.normalize();

        bullet.setPosition(this.getPosition().add(dir.mul(3f)));

        bullet.setLinearVelocity(dir.mul(30));
        if (getHealth() == 0) {
            bullet.destroy();

        }


    }


    @Override
    public void preStep(StepEvent stepEvent) {
        x = this.getPosition().x;


        if (getHealth() <= active) {
            if (player.getPosition().x < this.getPosition().x) {
                startWalking(-6);
                facing = "left";

            } else if (player.getPosition().x > this.getPosition().x) {
                startWalking(6);
                facing ="right";
            }
            if (getHealth() == 0) {
                this.destroy();

            }
            if(getHealth() == active && loop){
                timeshooting();
                loop =false;

            }
        }

        if(facing.equals("left") && l ){
            aimagel.flipHorizontal();
            l = false;
            r =true;
        }
        if(facing.equals("right") && r){
            aimagel.flipHorizontal();
            r = false;
            l = true;
        }

    }


    @Override
    public void postStep(StepEvent stepEvent) {
        float b = this.getPosition().x;

        //weSystem.out.println(stepEvent.getStep());
        if (getHealth() <= active) {
            if (x == b) {
                //this.stopWalking();
                this.jump(10);
            }
        }




    }


    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }
}
