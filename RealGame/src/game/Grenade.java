package game;

import javax.swing.*;

public class Grenade extends BackpackItem{

    public Grenade(Player player) {
        super(player);
    }

    @Override
    public String getType() {
            return "Grenade";}

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
