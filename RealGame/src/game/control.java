package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

public class control implements KeyListener, StepListener {

    private static final float speed = 12;
    protected Player player;
    protected EnemySteplistener t;
    boolean one = false;
    boolean two = false;
    private enemy enemy;
    protected int jumpcount;
    private boolean active;
    protected int count;
    private Game g;
    private int jcount;
    private Gamelevel gl;
    private  Timer Bullettimmer;
    private Boolean shoot;

    ArrayList<Integer> Dav = new ArrayList<>();
    ArrayList<Integer> Dav2 = new ArrayList<>();

    public control(Player player, EnemySteplistener t, enemy enemy, Game g, Gamelevel gl) {
        this.player = player;
        this.t = t;
        this.g = g;
        this.gl = gl;
        this.enemy = enemy;
        active = true;
        shoot = true;
        ActionListener Baction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            shoot = true;
            }
        };

        Bullettimmer = new Timer(800,Baction);
        Bullettimmer.setRepeats(false);


    }

    @Override
    public void keyPressed(KeyEvent e) {
//player only able to move if conditions met.
        player.setGravityScale(5);
        if (player.moves) {
            if (player.getLives() >= 0) {


                int code = e.getKeyCode();
                //System.out.println(player.second);

                if (code == KeyEvent.VK_D) {
                    jumpcount = 0;


                    player.walk(speed);
                } else if (code == KeyEvent.VK_A) {
                    jumpcount = 0;
                    player.walk(-speed);

                }

                if (code == KeyEvent.VK_SHIFT) {
                    Dav.add(1);

                }
                if (code == KeyEvent.VK_D) {
                    Dav.add(2);


                } else if (code == KeyEvent.VK_A)
                    Dav.add(3);

                if(player.CanJump){
                if (code == KeyEvent.VK_W) {
                    if (player.jcount < 2) {
                         player.jump(50);

                        player.setLinearVelocity(new Vec2(0, 30));
                        player.jcount++;


                    }}


                    //player.getBackpack().getitem().function();

                }


                if (code == KeyEvent.VK_ESCAPE) {
                    g.move();


                    //player.tutorial = false;

                }

                if (code == KeyEvent.VK_K) {


                    //player.tutorial = false;

                }


                if (Dav.contains(1) && Dav.contains(2)) {
                    player.walk(speed * 1.45f);
                } else if (Dav.contains(1) && Dav.contains(3)) {
                    player.walk(-speed * 1.45f);
                }
                if (code == KeyEvent.VK_SPACE && shoot) {

                        player.shoot();
                        player.ShootAni = true;
                        Bullettimmer.start();
                        shoot = false;
                        // player.setLinearVelocity(new Vec2(0,20));



                }
                if (code == KeyEvent.VK_Q) {
                    player.getBackpack().toggle();
                } else if (code == KeyEvent.VK_R) {

                    player.getBackpack().getitem().function();
                }

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Dav.removeAll(Dav);

        //player.setLinearVelocity(new Vec2(0,0));
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            player.stopWalking();


            //player.setLinearVelocity(new Vec2(0, 0));

        } else if (code == KeyEvent.VK_A) {
            player.stopWalking();



            //player.setLinearVelocity(new Vec2(0, 0));
        } else if (code == KeyEvent.VK_W) {

            active = true;


            //Dav.removeAll(Dav);

        }
        if (code == KeyEvent.VK_SPACE) {
            //player.setGravityScale(3);

            //use for double jump
            // ;

        }

        if (code == KeyEvent.VK_S) {
            try {
                gamesaverloader.save(gl, "Saves/Save.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (code == KeyEvent.VK_L) {
            try {
                Gamelevel a = gamesaverloader.load("Saves/Save.txt", g, gl);
                g.setlevel(a);
                System.out.println(a);
                //player.setLives(a);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        if (active) {

            jumpcount++;
            if (jumpcount > 50) {
                jumpcount = 50;

            }
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        //System.out.println(jumpcount);
    }

    public void updateStudent(Player player) {
        this.player = player;
    }

    public void gamelevelupdate(Gamelevel gl) {
        this.gl = gl;

    }
}