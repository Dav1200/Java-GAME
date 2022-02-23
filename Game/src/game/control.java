package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;

public class control implements KeyListener {

    private static final float speed =4;
    private Player player;
    boolean one = false;
   boolean two = false;
    ArrayList<Integer>Dav = new ArrayList<>();
    ArrayList<Integer>Dav2 = new ArrayList<>();

    public control(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            System.out.println("hi");
            player.walk(speed);


        } else if (code == KeyEvent.VK_A) {
            player.walk(-speed);


        }


        if(code == KeyEvent.VK_SHIFT){
            Dav.add(1);


        }
         if(code == KeyEvent.VK_SPACE){
            Dav.add(2);



        }

        if(Dav.contains(1)&&Dav.contains(2)){
            player.jump(10);
        }

        else if(code == KeyEvent.VK_SPACE){
            player.jump(4);
        }


        }





    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D) {
            player.stopWalking();

        } else if (code == KeyEvent.VK_A) {
            player.stopWalking();
        }
        else if(code == KeyEvent.VK_SHIFT){
            Dav.removeAll(Dav);

        }
        else if(code == KeyEvent.VK_SPACE){
            Dav.removeAll(Dav);

    }}

    @Override
    public void keyTyped(KeyEvent e) {
    }

}