package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class Mousecontroller implements MouseListener {

    private Gameview view;
    private Player p;
    private Vec2 pp;

    public Mousecontroller(Player p){
        this.p = p;

    }

    public Mousecontroller(Gameview v, Player p){
        this.p = p;
        this.view = v;

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getPoint());
        pp = view.viewToWorld(e.getPoint());
        p.mousepos = pp;



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



        //



    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void updateStudent(Player player){
        this.p = player;
    }

}