package game;

import city.cs.engine.BoxShape;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class Gameview extends UserView {
    private Image background;
    private Image Hearts;
    private Player player;
    private enemy e;
    protected int sec = 0;

    public Gameview(World w, int width, int height,Player player,enemy e) {
        super(w, width, height);
        this.player = player;
        this.e = e;

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
        g.drawString("enemy" + e.getSmallenemylives(),10,90);
        g.drawString("Time:"+ sec,10,70);



    }

}
