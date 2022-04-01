package game;

import city.cs.engine.BodyImage;

import javax.swing.*;

public class Shield extends  BackpackItem{



    public Shield(Player player) {
        super(player);
        image = new ImageIcon("item/Shield.png").getImage();
    }

    @Override
    public String getType() {
        return "Shield";
    }

    @Override
    public void function() {
        if(player.isShield()) {

            player.putShield();
        }
    }
}
