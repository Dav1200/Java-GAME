package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.Timer;

public class control implements KeyListener {

    private static final float speed = 4;
    protected Player player;
    protected track t;
    boolean one = false;
    boolean two = false;
    private enemy enemy;

    ArrayList<Integer> Dav = new ArrayList<>();

    public control(Player player, track t, enemy enemy) {
        this.player = player;
        this.t = t;
        this.enemy = enemy;


    }

    @Override
    public void keyPressed(KeyEvent e) {
//player only able to move if conditions met.
        player.setGravityScale(5);
        if (player.getLives() >= 0) {


            int code = e.getKeyCode();
            //System.out.println(player.second);

            if (code == KeyEvent.VK_D) {


                player.walk(speed);
            } else if (code == KeyEvent.VK_A) {
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
            }

            if (Dav.contains(1) && Dav.contains(2)) {
                player.walk(speed * 2);
            } else if (Dav.contains(1) && Dav.contains(3)) {
                player.walk(-speed * 2);
            }
            if (code == KeyEvent.VK_SPACE) {
                if (t.bulletseconds == 60) {
                    player.shoot();

                    t.bulletseconds = 0;
                }
            }
            if(code == KeyEvent.VK_Q){
                player.getBackpack().toggle();
            }
            else if(code == KeyEvent.VK_R){
                player.getBackpack().getitem().function();
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
        } else if (code == KeyEvent.VK_SHIFT) {

            //Dav.removeAll(Dav);

        }
        if (code == KeyEvent.VK_SPACE) {
            //player.setGravityScale(3);

            //use for double jump
            // player.setLinearVelocity(new Vec2(0,10));

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}