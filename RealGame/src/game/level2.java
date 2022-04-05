package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class level2 extends Gamelevel implements StepListener {
    private Player player;
    private platforms plat;
    private enemy e;
    private Spikeplat Lava;
    private RegeneratePlat a;
    private RegeneratePlayercollision regenCollision;
    private jumppad jumppad;
    private static final BodyImage grounds = new BodyImage("Platformimg/regen.png", 2);
    private PickupItems p;
    private Coin coin;
    private Coin coin2;
    private TemporaryPlat level2p;
    private Image background;
    private static SoundClip  intro;
    private EnemyClass enemyClass;
    static {
        try {

            intro = new SoundClip("Sound/intro.wav");

           // intro.setVolume(0.2);
            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    public level2(Game game,Gameview v) {

        super(game);

        background = new ImageIcon("Platformimg/back2.png").getImage();
        plat = new platforms(this.getWorld(),getPlayer());
        plat.woodenbuild(30,2);
        level2p = new TemporaryPlat(this.getWorld(),0.3f,8,20,-10);
        new TemporaryPlat(this.getWorld(),7.5f,0.3f,27.5f,-2);
        a = new RegeneratePlat(this.getWorld(), 4f, 26f, -13f, getPlayer());
        getPlayer().grendadeshoot= true;
        ShieldPickup d = new ShieldPickup(this.getWorld());
        d.setPosition(new Vec2(30,8));
        enemyClass = new EnemyClass(this.getWorld(),new BoxShape(1,2),this.getPlayer(),5);
        enemyClass.setPosition(new Vec2(10,-12));
        this.getWorld().addStepListener(enemyClass);


        getPlayer().setPosition(new Vec2(-18,0));
        //getE().setPosition(new Vec2(16,0));



        //
        //
        /*
        getE().setPosition(new Vec2(17.5f, 0));
        EnemySteplistener t = new EnemySteplistener(v, getPlayer(), getE());
        this.getWorld().addStepListener(t);
        getE().enemywalk(t.enemyX,t.enemyY);
        t.updateStudent(getE());
*/
        //might use or might make new enemy

    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPlayer().coinpick && getE().enemydef) {
            getPlayer().coinpick = false;
            getE().enemydef = false;
            getE().stage++;
        }



    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }


    ;


    public RegeneratePlat getA() {
        return a;
    }


    public PickupItems getP() {
        return p;
    }

    @Override
    public boolean isComplete() {
        if(getPlayer().getScore() == 3){
            return true;
        }
        else
            return false;
    }

    @Override
    public Image background() {
        return background;
    }

    @Override
    public SoundClip sound() {

        return intro;
    }

    @Override
    public String level() {
        return "level2";
    }


}
