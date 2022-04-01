package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class TemporaryPlat extends StaticBody implements Destroy{
    private static final Shape temp = new BoxShape(0.3f,10);
    private static final Shape tempp = new BoxShape(10f,0.3f);
    private static final BodyImage grounds = new BodyImage("Platformimg/woodtile.png", 1);

    public TemporaryPlat(World w, float x,float y, float xx,float yy) {
        super(w,new BoxShape(x,y));
        setPosition(new Vec2(xx,yy));




    }

}
