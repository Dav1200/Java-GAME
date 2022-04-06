package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class RunningCoin extends DynamicBody implements StepListener {
    private static final float radius = 2.0f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =   new BodyImage("item/coin.png", 2 * radius);
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

    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }

    public static final float RANGE = 12;
    private Gamelevel world;

    private State state;

    public RunningCoin(Gamelevel world) {
        super(world, ballShape);
        this.world = world;
         addImage(ballImage);
        state = State.STAND_STILL;
        getWorld().addStepListener(this);
        world.getPlayer().CanJump =false;
    }

    public boolean inRangeLeft() {
        Body a = world.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;    //gap in (0,RANGE)
    }

    public boolean inRangeRight() {
        Body a = world.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;  //gap in (-RANGE, 0)
    }

    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != State.ROLL_RIGHT) {

                state = State.ROLL_RIGHT;
                setAngularVelocity(120);
                //setLinearVelocity(new Vec2(-10, 1));

            }
        } else if (inRangeLeft()) {
            if (state != State.ROLL_LEFT) {
                state = State.ROLL_LEFT;
                setAngularVelocity(-120);
                // setLinearVelocity(new Vec2(10,0));
            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                setAngularVelocity(0);
                setLinearVelocity(new Vec2(0, 0));
            }
            refreshRoll();
        }


        if(this.getPosition().y < -18){
            this.setPosition(new Vec2(0,21));
            this.setAngularVelocity(0);
            this.setLinearVelocity(new Vec2( 0,0));
        }
    }

    // use this to prevent the balls from slowing
    // down and stopping due to friction when they
    // should be rolling
    private void refreshRoll() {
        switch (state) {
            case ROLL_LEFT:
                 setAngularVelocity(150);
                // setLinearVelocity(new Vec2(10,1));
                break;
            case ROLL_RIGHT:
                setAngularVelocity(-150);
                // setLinearVelocity(new Vec2(-10,0));
                break;
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    }

    public void play(){
        coincollect.play();

    }
}

