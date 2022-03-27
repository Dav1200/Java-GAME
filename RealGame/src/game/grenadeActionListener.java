package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class grenadeActionListener implements ActionListener {
    private Player p;

    public grenadeActionListener(Player p){
        this.p = p;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        p.grendadeshoot =true;
    }
}
