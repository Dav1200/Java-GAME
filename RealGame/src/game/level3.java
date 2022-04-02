package game;

import city.cs.engine.BoxShape;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class level3 extends Gamelevel{

    private static SoundClip  stage3;
    private Level3Platforms level3plat;
    private platforms plat;
    private Image background;
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
        plat = new platforms(this.getWorld(),getPlayer());
        level3plat = new Level3Platforms(this.getWorld());
        getPlayer().setPosition(new Vec2(-30,-14));
        getPlayer().setShield(true);
        getPlayer().grendadeshoot= true;

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
}
