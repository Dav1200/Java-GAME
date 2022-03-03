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
    public Gameview(World w, int width, int height,Player player) {
        super(w, width, height);
        this.player = player;
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

    }


}
