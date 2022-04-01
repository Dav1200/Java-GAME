package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Doublegun extends BackpackItem{

    public Doublegun(Player player) {
        super(player);
        image = new ImageIcon("item/icon1.png").getImage();
    }

    @Override
    public String getType() {

        return "DoubleGun";}

    @Override
    public void puton() {
        super.puton();



    }

    @Override
    public void function() {
        if(player.doublegun) {
            if (player.timer == 120) {
                player.doubleshoot();
                player.bulletcount = 2;
                player.timer = 0;
            }
        }
    }
}
