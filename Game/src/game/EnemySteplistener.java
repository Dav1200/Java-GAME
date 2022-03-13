
package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class EnemySteplistener implements StepListener {
    private Gameview view;
    private Player player;
    private enemy en;
    private int count;
    private int seconds = 0;
    protected int bulletseconds;
    protected float enemyX;
    protected float enemyY;
    protected float pX;
    protected float pY;
    private int ecount;
    private enemy g;

    public EnemySteplistener(Gameview view, Player player, enemy en) {
        this.player = player;
        this.view = view;
        this.en = en;
        count = 1;
        seconds = 1;
        bulletseconds = 0;
        ecount = 0;
        g = new enemy(this.en.getWorld(), en.getPlat());
        g.setPosition(new Vec2(-60,0));


    }

    public void preStep(StepEvent e) {
    }

    public void postStep(StepEvent e) {
        count++;
        ecount++;
        //view.setCentre(player.getPosition());
        //view.setZoom(student.getBooks()+5);
        seconds = count / 60;
       // System.out.println(coun/seconds);
        //Bullet timing so the bullet isnt shot repeatedly

        bulletseconds++;
        view.sec = seconds;
        //bullet EnemySteplistener


        if (bulletseconds >= 60) {
            bulletseconds = 60;
        }
        // System.out.println(bulletseconds);
        // System.out.println(bulletseconds/60);
        //System.out.println(player.getPosition());

        en.enemywalk(enemyX,enemyY);
        //Enemy Function to update position
        enemyX = en.getPosition().x;
        enemyY = en.getPosition().y;

        en.x = en.getPosition().x;
        en.y = en.getPosition().y;
        pX = player.getPosition().x;
        pY = player.getPosition().y;


        if(ecount == 50){
            en.shootplayer(new Vec2(pX,pY));
            g.shootplayer(new Vec2(pX,pY));
          ecount = 0;}

        en.x = enemyX;
        en.y = enemyY;

    //
//
    }

}