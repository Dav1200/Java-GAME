package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Gameview extends UserView implements StepListener {
    private Image background;
    private Image Hearts;
    private Player player;
    private enemy e;
    protected int sec = 0;
    private boolean set;

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
        g.drawImage(Hearts,0,10,this);
        g.scale(2,2);
        g.drawString("Lives:"+ player.getLives(), 10,30);
        g.drawString("Score:"+ player.getScore(), 10,50);
       // System.out.println(this.track.getSeconds());
        g.drawString("enemy" + e.getRespawn(),10,90);
        g.drawString("Time:"+ sec,10,70);

    }


    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {
        if(e.getRespawn() == 0 && set==false){
            setView(new Vec2(60,0),this.getZoom());
            player.setPosition(new Vec2(48,13));
            set = true;
        }

    }
}