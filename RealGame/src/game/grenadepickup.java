package game;


import city.cs.engine.*;

public class grenadepickup extends StaticBody {

    private static final Shape grenade= new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("item/icon41.png", 2.5f);



    protected AttachedImage images;

    public grenadepickup(World w) {

        super(w,grenade);
        //setGravityScale(0);
        //this.applyForce(new Vec2(1,1));
        //setLinearVelocity(new Vec2(0,0));

        images = addImage(image);

        //addImage(image);
    }


}
