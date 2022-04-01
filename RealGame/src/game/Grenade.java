package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Grenade extends BackpackItem{

    public Grenade(Player player) {
        super(player);
        image = new ImageIcon("item/icon41.png").getImage();
    }

    @Override
    public String getType() {
            return "Grenade";}

    @Override
    public void puton() {
        super.puton();
        aimage.setOffset(new Vec2(1,0));
    }

    @Override
    public void function() {
        if(player.grendadeshoot) {
            player.grendadeshoot = false;
            grenadeActionListener g = new grenadeActionListener(player);
            Timer t = new Timer(5000,g);
            t.setRepeats(false);
            t.start();
            player.ThrowGrenade();
        }

    }
}
