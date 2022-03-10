package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class platforms extends StaticBody {

    private static final BodyImage grounds = new BodyImage("Platformimg/woodtile.png", 1);


    public platforms(World w) {
        super(w);
        platforms(-17f, -14.7f);
        multiplat(5);
        //platforms(47f,10f);
        DeathPlatform();
        //Stage 2 platforms
       // platformss(47f,-10f);
        stage2platforms(10,40,-14.7f);
        stage2platforms(10,60,0);
    }
    //ground
    public void platforms(Float x, Float y) {
        StaticBody ground = new StaticBody(this.getWorld(), new BoxShape(2, 0.3f));
        ground.setPosition(new Vec2(x, y));
        ground.addImage(grounds);
        ground.setAlwaysOutline(true);
    }

    public void platformss(Float x, Float y) {
        StaticBody ground = new StaticBody(this.getWorld(), new BoxShape(15, 0.5f));
        ground.setPosition(new Vec2(x, y));
        ground.addImage(grounds);
        ground.setAlwaysOutline(true);
    }

    public void multiplat(int t) {
        for (int i = 0; i < t; i++) {
            if (i == 4) {
                StaticBody ground = new StaticBody(this.getWorld(), new BoxShape(6, 0.3f));
                ground.setPosition(new Vec2(15, -0.7f));

               ground.addImage(grounds).setOffset(new Vec2(-1, 0));
               ground.addImage(grounds).setOffset(new Vec2(-5, 0));
               ground.addImage(grounds).setOffset(new Vec2(3, 0));
            }
            platforms(-17f + i * 4.5f, -14.7f + i * 3.5f);
        }



    }

    public void DeathPlatform() {
        StaticBody ground = new StaticBody(this.getWorld(), new BoxShape(25, 0.3f));
        ground.setPosition(new Vec2(0, -20f));

    }
    public void stage2platforms(float width,float x,float y){
        StaticBody stage2platform = new StaticBody(this.getWorld(),new BoxShape(width,0.3f));
        stage2platform.setPosition(new Vec2(x,y));
    }



}



