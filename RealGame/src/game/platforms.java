package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class platforms extends StaticBody implements StepListener {

    private static BodyImage grounds = new BodyImage("Platformimg/woodtile.png", 1);
    private static final BodyImage metal = new BodyImage("Platformimg/Metalplat.png", 1);
    private EnemybulletCol dav;
    private World w;
    private boolean loop2;
private boolean loop;
private  Button b;

    private Player p;

    public platforms(World w, Player p) {
        super(w);
loop = true;
loop2 = true;
        this.p = p;
        w.addStepListener(this);
        if (w instanceof level1) {


            // dav = new EnemybulletCol(this);
            platforms(-17f, -14.7f);
            multiplat(5);
            //platforms(47f,10f);
            DeathPlatform();
            //Stage 2 platforms
            // platformss(47f,-10f);

            platforms(17f, 5f);
            platforms(77f, -10f);
            stage2platforms(10, 40, -14.7f);
            //stage2platforms(10,60,0);
            tutorialplat();
        }
        if (w instanceof level2) {
            grounds = metal;
            border(60, 0.3f, -16, -16);


        }



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

    public void stage2platforms(float width, float x, float y) {
        StaticBody stage2platform = new StaticBody(this.getWorld(), new BoxShape(width, 0.3f));
        stage2platform.setPosition(new Vec2(x, y));
    }

    public void border(float width, float height, float x, float y) {
        StaticBody stage2platform = new StaticBody(this.getWorld(), new BoxShape(width, height));
        stage2platform.setPosition(new Vec2(x, y));
    }

    public void tutorialplat() {
        StaticBody tutorial = new StaticBody(this.getWorld(), new BoxShape(30, 0.4f));
        // tutorial.addCollisionListener(dav);
        tutorial.setPosition(new Vec2(-60, -15f));
        BoxShape a = new BoxShape(0.5f, 40);

        StaticBody wall1 = new StaticBody(this.getWorld(), new BoxShape(0.5f, 40));
        StaticBody wall2 = new StaticBody(this.getWorld(), new BoxShape(0.5f, 40));



        /*
        DynamicBody wa = new DynamicBody(this.getWorld());
        wa.setPosition(new Vec2(-60,50));

        SolidFixture d = new SolidFixture(wa,a);
        d.setRestitution(1.1f);
*/


        wall1.setPosition(new Vec2(-80, 0));
        wall2.setPosition(new Vec2(-40, 0));

    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if (p.Showplat && loop) {
            for(int i = 0 ; i < 3;i++){
            platforms(18f+i*2,-9f);}

            platforms(10f,0f);
             b = new Button(this.getWorld());

            platforms(0f,0f);
            platforms(-30f,0f);
            platforms(-27f,0f);
            loop = false;


        }

        if(p.Showplat && loop2){
if(b.isPressed()){
        loop2 =false;
        platforms(0f,10f);

    }}}

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}



