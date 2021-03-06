package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class jumppad implements StepListener,Destroy {
    private static final Shape leftleg = new PolygonShape(-1.9f,0.03f, -1.88f,-1.53f, -1.03f,-1.55f, -1.02f,-0.01f);
    private static final Shape rightleg = new PolygonShape(0.91f,-0.05f, 0.89f,-1.49f, 1.75f,-1.5f, 1.75f,0.06f);
    private static final Shape top = new PolygonShape(-1.85f,1.22f, -1.79f,0.07f, 1.73f,0.08f, 1.74f,1.27f);
    private static final BodyImage trampoline= new BodyImage("Platformimg/trampoline.png", 4f);
    private static SoundClip jump;
    static{
        try {
            jump = new SoundClip("Sound/boing.wav");

            // Open an audio input stream
            // stage1.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    public jumppad(World w) {

        TrampolineCollision trampolineCollision = new TrampolineCollision(this);
        StaticBody Trampoline = new StaticBody(w);

        SolidFixture leftl = new SolidFixture(Trampoline,leftleg);
        SolidFixture rightl = new SolidFixture(Trampoline,rightleg);
        SolidFixture topbase = new SolidFixture(Trampoline,top);

        //topbase.setRestitution(1.5f);
        //topbase.setFriction(10);

        Trampoline.addCollisionListener(trampolineCollision);
        Trampoline.setPosition(new Vec2(47,-13));
        Trampoline.addImage(trampoline);

        /*
        StaticBody trampo = new StaticBody(this.getWorld(),new BoxShape(1,0.3f));
        trampo.setPosition(new Vec2(47,-13));
        //stage2platforms(1,47,-13);
        trampo.addImage(trampoline);
*/
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

    public void play(){
        jump.play();
    }
}
