package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class platforms extends StaticBody {

    private static final BodyImage grounds = new BodyImage("Platformimg/ground.png",1);

    public platforms(World w) {
        super(w);
        ground();


    }


    //ground
    public void ground(){
        StaticBody ground = new StaticBody(this.getWorld(),new BoxShape(3,0.3f));
        ground.setPosition(new Vec2(-17f, -14.7f));
        ground.setFillColor(Color.lightGray);
        //ground.addImage(grounds);

    }


}
