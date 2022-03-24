package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionlistener implements ActionListener {
    Player p;
    public actionlistener(Player p){
        this.p = p;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

p.play();
    }
}
