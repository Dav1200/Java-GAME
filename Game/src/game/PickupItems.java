package game;


import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PickupItems extends DynamicBody {

    private static final Shape booksShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("item/coiin.png", 2f);

    public  PickupItems(World w) {
        super(w,booksShape);
        addImage(image);
    }

    public void coin(){

    }

}
