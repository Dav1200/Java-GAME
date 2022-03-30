package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Button extends StaticBody {

    private static final Shape top = new PolygonShape(-2.11f, 0.45f, -2.02f, 0.07f, 2.08f, 0.09f, 2.01f, 0.45f);
    private static final Shape bottom = new PolygonShape(-2.35f, -0.01f, -2.37f, -0.51f, 2.44f, -0.46f, 2.38f, -0.05f);
    private static BodyImage buttonimg =
            new BodyImage("item/buttonac.png", 1f);


    public static BodyImage getButtomimgd() {
        return buttomimgd;
    }

    public static void setButtomimgd(BodyImage buttomimgd) {
        Button.buttomimgd = buttomimgd;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    private boolean pressed;


    protected static BodyImage buttomimgd = new BodyImage("item/buttonacc.png", 1f);
    ;


    public Button(World w) {
        super(w, bottom);

        setAlwaysOutline(true);

        this.addImage(buttonimg);
        this.setPosition(new Vec2(-28.5f, 1));
        SolidFixture toop = new SolidFixture(this, top);
        pressed = false;
        //SolidFixture boot = new SolidFixture(this,bottom);

        CollisionListener buttoncollision = new CollisionListener() {
            @Override
            public void collide(CollisionEvent collisionEvent) {
                if (!pressed) {
                    removeAllImages();
                    addImage(buttomimgd);
                    toop.destroy();
                    pressed = true;
                    // get acces to the platforms and instead of using steplistener just detect collision
                    //encapsulate in platform class,
                    // fix enemy and platform class so many types can be created fromm the baseclass instead of cluttering everythingin one place.
                }
            }


        };
        if(pressed)
        {
            System.out.println("roland");
        }
        addCollisionListener(buttoncollision);

    }


}
