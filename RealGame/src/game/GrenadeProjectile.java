package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrenadeProjectile implements ActionListener {
    private static final BodyImage grenadeimg = new BodyImage("item/icon41.png", 1.5f);
    private static final BodyImage grenadeximg = new BodyImage("item/explosion2.png", 4f);

    private DynamicBody Bomb;
    private DynamicBody explosion;
    protected boolean g;
    private int count;
    private Player p;
    public GrenadeProjectile(World w,int detonationtime,Player p){
        g = false;


        Bomb = new DynamicBody(w,new CircleShape(1.5f));

        Bomb.addImage(grenadeimg);
        Bomb.setAngularVelocity(0);
        Bomb.addCollisionListener(new GrenadeCollision(this));



       // Vec2 dir = p.mousepos.sub(p.getPosition());
      //  dir.normalize();
      //  Bomb.setPosition(p.getPosition().add(dir.mul(1f)));
      //  Bomb.setLinearVelocity(dir.mul(20));


        Timer t = new Timer(detonationtime,this);
        t.setRepeats(false);
        t.start();
        count = 0;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(count == 0){
            Bomb.destroy();
            explosion = new DynamicBody(Bomb.getWorld(),new CircleShape(3));

            explosion.addImage(grenadeximg);
            explosion.setPosition(Bomb.getPosition());
            Timer t2 = new Timer(300,this);
            t2.setRepeats(false);
            t2.start();

        }
        else if(count == 1){
            explosion.destroy();
        }
count ++;
    }

    public void setPosition(Vec2 add) {
        Bomb.setPosition(add);
    }

    public void setLinearVelocity(Vec2 mul) {
        Bomb.setLinearVelocity(mul);
    }



    public void setangle(float b){
        Bomb.setAngularVelocity(b);
    }

}

