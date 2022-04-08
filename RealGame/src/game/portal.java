package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class portal extends StaticBody implements SensorListener {
    private static final Shape portal = new CircleShape(2f);
    private Sensor portalSensor;
    private GhostlyFixture portalview;
    private static final BodyImage image =
            new BodyImage("item/portal2.gif", 10f);

    private static SoundClip teleport;
    static{
        try {
            teleport = new SoundClip("Sound/teleport.wav");

            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    public portal(World w) {
        super(w);

        addImage(image);
        portalSensor = new Sensor(this, portal);
        portalSensor.addSensorListener(this);
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        teleport.play();

        if (sensorEvent.getContactBody() instanceof RunningCoin) {
            sensorEvent.getContactBody().setPosition(new Vec2(- 20, 0));
            ((RunningCoin) sensorEvent.getContactBody()).setLinearVelocity(new Vec2(0, 0));
            ((RunningCoin) sensorEvent.getContactBody()).setAngularVelocity(0);
        }

        if(sensorEvent.getContactBody() instanceof  Player){

        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {
        System.out.println("bye");
    }
}
