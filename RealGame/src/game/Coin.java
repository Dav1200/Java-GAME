package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Coin extends StaticBody{
    private static final Shape coin = new CircleShape(1);

    private static SoundClip coincollect;
    static{
        try {
            coincollect = new SoundClip("Sound/coin.wav");

            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("item/coiin.png", 2.5f);
    protected AttachedImage CoinIcon;

    public Coin(World w) {
        super(w,coin);
        CoinIcon = addImage(image);

    }

    @Override
    public void destroy(){
        super.destroy();
        coincollect.play();

    }

}
