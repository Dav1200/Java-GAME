package game;

import city.cs.engine.BoxShape;
import city.cs.engine.SoundClip;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class level3 extends Gamelevel implements StepListener {

    private static SoundClip  stage3;
    private RunningCoin runningCoin;
    private Level3Platforms level3plat;
    private platforms plat;
    private Image background;
    private EnemyClass enemyClass;
    private  int EnemySpawnCount;
    static {
        try {

            stage3 = new SoundClip("Sound/stage3.wav");

            //stage3.setVolume(0.2);
            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    public level3(Game game) {
        super(game);
        background = new ImageIcon("Platformimg/stage3.png").getImage();
        EnemySpawnCount = 2;
        plat = new platforms(this.getWorld(),getPlayer());
        level3plat = new Level3Platforms(this.getWorld());
        getPlayer().setPosition(new Vec2(-30,-14));
        getPlayer().setShield(true);
        getPlayer().grendadeshoot= true;
        runningCoin = new RunningCoin(this);
        runningCoin.setPosition(new Vec2(0,-9));
        //enemyClass = new EnemyClass(this.getWorld(), new BoxShape(1,2),getPlayer(),5);+
        //
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Image background() {
        return background;
    }

    @Override
    public SoundClip sound() {
        return stage3;
    }

    @Override
    public String level() {
        return "level3";
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(getPlayer().CanJump && EnemySpawnCount >0){
             enemyClass = new EnemyClass(this.getWorld(), new BoxShape(1,2),getPlayer(),5);
            enemyClass.setPosition(new Vec2(0, EnemySpawnCount * 5));
            this.getWorld().addStepListener(enemyClass);
            EnemySpawnCount--;
        }

        }


    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
