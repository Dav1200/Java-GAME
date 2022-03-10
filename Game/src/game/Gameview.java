package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Gameview extends UserView implements StepListener {
    private Image background;
    private Image Hearts;
    protected Player player;
    private Image fullh;
    private Image emptyh;
    private enemy e;
    protected Point2D.Float pxcoverted;
    protected int pycoverted;
    protected int px;
    protected int sec = 0;
    private boolean set;
    protected int ex;
    protected int ey;
    private int tick;
    private Point2D.Float points;
    private String face;

    public Gameview(World w, int width, int height, Player player, enemy e) {
        super(w, width, height);
        this.player = player;
        this.e = e;
        set = false;


        background = new ImageIcon("Platformimg/stage1r.png").getImage();
        Hearts = new ImageIcon("enemy/maxh.png").getImage();
        fullh = new ImageIcon("playerimages/fullh.png").getImage();
        emptyh = new ImageIcon("playerimages/emptyhh.png").getImage();


    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        tick = e.getSmallenemylives() + 7;
//
        g.drawImage(emptyh, px - 70, pycoverted - 50, 100, 20, this);
        g.drawImage(fullh, px - 70, pycoverted - 50, player.getLivess(), 20, this);


        // g.scale(0.2f,0.2f);
        //g.drawImage(Hearts,0,10,this);
        // g.scale(2,2);
        g.scale(1.5f, 1.5f);
        g.setColor(Color.white);
        g.drawString("Lives:" + player.getLives(), 10, 30);
        g.drawString("Score:" + player.getScore(), 10, 50);
        // System.out.println(this.track.getSeconds());
        g.drawString("enemy" + e.getRespawn(), 10, 90);
        g.drawString("Time:" + sec, 10, 70);

        g.setColor(Color.red);
        g.fillRect(467, 20, 50, 10);
        g.setColor(Color.green);
        g.fillRect(467, 20, e.getSmallenemylivess(), 10);


        //System.out.println(ex);


        //
    }


    @Override
    public void preStep(StepEvent stepEvent) {
        pxcoverted = worldToView(new Vec2(player.getPosition()));
        pycoverted = Math.round(pxcoverted.y);
        px = Math.round(pxcoverted.x);
        face = player.getFacing();

        //System.out.println(Math.round(pxcoverted.x));
        //System.out.println(pxcoverted);
        if (face.equals("left")) {
            px += 35;
        }

}



    @Override
    public void postStep(StepEvent stepEvent) {
        if (e.stage == 2 && set == false) {
            setView(new Vec2(60, 0), this.getZoom());
            player.setPosition(new Vec2(48, 13));
            set = true;


        }
        //this.points = worldToView(new Vec2((e.getPosition().x),(e.getPosition().y-50)));
        //this.ex = (int)points.x;
        // this.ey = (int)points.y;

        // System.out.println(ex);


    }
}