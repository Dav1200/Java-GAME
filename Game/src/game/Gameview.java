package game;

import city.cs.engine.BoxShape;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class Gameview extends UserView {
    private Image background;
    private Image Hearts;
    public Gameview(World w, int width, int height) {
        super(w, width, height);
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

    }


}
