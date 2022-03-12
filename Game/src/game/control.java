package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.Timer;

public class control implements KeyListener, StepListener {

    private static final float speed = 4;
    protected Player player;
    protected track t;
    boolean one = false;
    boolean two = false;
    private enemy enemy;
    protected int jumpcount;
    private boolean active;
    protected int count;

    ArrayList<Integer> Dav = new ArrayList<>();
    ArrayList<Integer> Dav2 = new ArrayList<>();

    public control(Player player, track t, enemy enemy) {
        this.player = player;
        this.t = t;
        this.enemy = enemy;
        active = false;



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


                if (code == KeyEvent.VK_W) {
                    player.jump(20);

                    active = true;
                    if (jumpcount > 13) {
                        // player.removeAllImages();
                        player.setLinearVelocity(new Vec2(0, 20));


                    }
                    jumpcount = -10;

                    //player.getBackpack().getitem().function();

                }
              // if(player.tutorial){

                if(code == KeyEvent.VK_G){
                    enemy.stage++;
                    //player.tutorial = false;
               // }
            }

                if (Dav.contains(1) && Dav.contains(2)) {
                    player.walk(speed * 2);
                } else if (Dav.contains(1) && Dav.contains(3)) {
                    player.walk(-speed * 2);
                }
                if (code == KeyEvent.VK_SPACE) {
                    if (t.bulletseconds == 60) {
                        player.shoot();
                        // player.setLinearVelocity(new Vec2(0,20));


                        t.bulletseconds = 0;
                    }
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

            active = false;


            //Dav.removeAll(Dav);

        }
        if (code == KeyEvent.VK_SPACE) {
            //player.setGravityScale(3);

            //use for double jump
            // ;

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
}