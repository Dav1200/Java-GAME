package game;


import city.cs.engine.*;

public class ShieldPickup extends StaticBody {

    private static final Shape Shieldshape= new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("item/Shield.png", 2.5f);



    protected AttachedImage images;

    public ShieldPickup(World w) {
        super(w,Shieldshape);
        //setGravityScale(0);
        //this.applyForce(new Vec2(1,1));
        //setLinearVelocity(new Vec2(0,0));

        images = addImage(image);

        //addImage(image);
    }


}
