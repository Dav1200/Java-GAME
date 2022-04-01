package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShieldActionListner implements ActionListener {
    private ShieldBody shieldBody;
    private Player player;
    public ShieldActionListner(ShieldBody shieldBody,Player player){
        this.shieldBody = shieldBody;
        this.player = player;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shieldBody.destroy();
        player.ShowShield = false;

    }
}
