package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.geom.Point2D;

public class track implements StepListener {
    private Gameview view;
    private Player player;
    private enemy en;

    private int count;
    private int seconds = 0;
    protected int bulletseconds;
    protected float enemyX;
    protected float enemyY;

    public track(Gameview view, Player player,enemy en) {
        this.player = player;
        this.view = view;
        this.en = en;
        count = 0;
        seconds = 0;
        bulletseconds = 0;
    }

    public void preStep(StepEvent e) {
    }

    public void postStep(StepEvent e) {
        count++;
        //view.setCentre(player.getPosition());
        //view.setZoom(student.getBooks()+5);
        seconds = count / 60;

        //Bullet timing so the bullet isnt shot repeatedly
        bulletseconds++;
        view.sec = seconds;
        //bullet track
        if (bulletseconds >= 60) {
            bulletseconds = 60;
        }
        // System.out.println(bulletseconds);
        // System.out.println(bulletseconds/60);
        //System.out.println(player.getPosition());
        if (player.getPosition().y < -15) {
            player.reset();
        }

        //Enemy Function to update position
        enemyX = en.getPosition().x;
        enemyY = en.getPosition().y;
        en.enemywalk(enemyX,enemyY);

    }

}