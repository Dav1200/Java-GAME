package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Gameview extends UserView implements StepListener {
    private Image background;
    private Image Hearts;
    private Player player;
    private enemy e;
    protected int sec = 0;
    private boolean set;
    protected int ex;
    protected int ey;
    private int tick;
    private Point2D.Float points;
    public Gameview(World w, int width, int height,Player player,enemy e) {
        super(w, width, height);
        this.player = player;
        this.e = e;
        set = false;



        background = new ImageIcon("Platformimg/background0.png").getImage();
        Hearts = new ImageIcon("Platformimg/ground.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
    @Override
    protected void paintForeground(Graphics2D g) {
        tick   = e.getSmallenemylives()+7;
        g.drawImage(Hearts,0,10,this);
        g.scale(2,2);
        g.drawString("Lives:"+ player.getLives(), 10,30);
        g.drawString("Score:"+ player.getScore(), 10,50);
       // System.out.println(this.track.getSeconds());
        g.drawString("enemy" + e.getRespawn(),10,90);
        g.drawString("Time:"+ sec,10,70);
        g.setColor(Color.red);
        g.fillRect(330,20,50,10);
        g.setColor(Color.green);
        g.fillRect(330,20,e.getSmallenemylivess(),10);




        //System.out.println(ex);


       //
    }


    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {
        if(e.stage==2 && set==false){
            setView(new Vec2(60,0),this.getZoom());
            player.setPosition(new Vec2(48,13));
            set = true;


        }
         //this.points = worldToView(new Vec2((e.getPosition().x),(e.getPosition().y-50)));
        //this.ex = (int)points.x;
       // this.ey = (int)points.y;

       // System.out.println(ex);



    }
}