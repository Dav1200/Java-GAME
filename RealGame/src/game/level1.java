package game;

import city.cs.engine.BodyImage;
import city.cs.engine.SoundClip;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class level1 extends Gamelevel implements StepListener {
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
    private Image background;



    private static SoundClip stage1;

    static {
        try {
            stage1 = new SoundClip("Sound/stage1.wav");

           // stage1.setVolume(0.2);

            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }
    public level1(Game game) {
        super(game);


        background = new ImageIcon("Platformimg/stage1r.png").getImage();
        plat = new platforms(this,getPlayer());
        getE().setPosition(new Vec2(15.5f, 1.75f));
        getPlayer().setPosition(new Vec2(-17, 2));
        a = new RegeneratePlat(this, 4f, 47f, 10f, getPlayer());
        Lava = new Spikeplat(this, 10, 60, 0, getPlayer(), getE());
        jumppad = new jumppad(this);

        a.setName("Regen");
        //Border border = new Border(this);
        p = new PickupItems(this);
        p.setPosition(new Vec2(-5, 0));

        coin = new Coin(this);


        coin.setPosition(new Vec2(17, 6.5f));
        coin2 = new Coin(this);
        coin2.setPosition(new Vec2(77, -8.5f));

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

        if(getPlayer().getScore() == 2){
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
        return stage1;

    }

    @Override
    public String level() {
        return "level1";
    }


}
