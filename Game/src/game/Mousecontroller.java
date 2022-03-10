package game;

import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class Mousecontroller implements MouseListener {

    private Gameview view;
    private Player p;

    public Mousecontroller(Player p){
        this.p = p;

    }

    public Mousecontroller(Gameview v){
        this.view = v;

    }


    @Override
    public void mouseClicked(MouseEvent e) {



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();



    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
