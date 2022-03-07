package game;


import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PickupItems extends StaticBody {

    private static final Shape booksShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("item/coiin.png", 2f);

    public  PickupItems(World w) {
        super(w,booksShape);
        //setGravityScale(0);
        //this.applyForce(new Vec2(1,1));
       // setLinearVelocity(new Vec2(0,0));

        addImage(image);
    }


}
