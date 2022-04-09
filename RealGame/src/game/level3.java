package game;

import city.cs.engine.*;
import game.Gamelevel;
import game.*;
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
    private  Button b;
    private Button b2;
    private portal portal;
    private  StaticBody block;
    private  StaticBody block2;
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
        block = new StaticBody(this.getWorld(),new BoxShape(0.3f,3.2f));
        block.setPosition(new Vec2(20,-12.3f));
        block2 = new StaticBody(this.getWorld(),new BoxShape(0.3f,10.2f));
        block2.setPosition(new Vec2(30,-12.3f));
        plat = new platforms(this.getWorld(),getPlayer());
        level3plat = new Level3Platforms(this.getWorld());
        getPlayer().setPosition(new Vec2(-30,-14));
        getPlayer().setShield(true);
        getPlayer().setGrendadeshoot(true);
        getPlayer().setDoublegun(true);
        Coin coin = new Coin(this.getWorld());
        coin.setPosition(new Vec2(30,19.5f));
        runningCoin = new RunningCoin(this);
        runningCoin.setPosition(new Vec2(0,20));
        portal = new portal(this.getWorld());
        portal.setPosition(new Vec2(1020,1022));
        b = new Button(this.getWorld());
        b.setPosition(new Vec2(25,-15));
        b2 = new Button(this.getWorld());
        b2.setPosition(new Vec2(5,-15));
        //enemyClass = new EnemyClass(this.getWorld(), new BoxShape(1,2),getPlayer(),5);+
        //
    }

    @Override
    public boolean isComplete() {
        if(getPlayer().getScore() == 5){
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
        return stage3;
    }

    @Override
    public String level() {
        return "level3";
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(getPlayer().isCanJump() && EnemySpawnCount >0){
             enemyClass = new EnemyClass(this.getWorld(), new BoxShape(1,2),getPlayer(),2);
            enemyClass.setPosition(new Vec2(0, EnemySpawnCount * 5));
            this.getWorld().addStepListener(enemyClass);
            EnemySpawnCount--;
        }
        if(b.isPressed()){
            block.destroy();
            block2.destroy();
        }
        if(b2.isPressed()){
            portal.setPosition(new Vec2(20,22));
        }



        }


    @Override
    public void postStep(StepEvent stepEvent) {
        if(getPlayer().isCanJump()){
            portal.destroy();
        }

    }
}
