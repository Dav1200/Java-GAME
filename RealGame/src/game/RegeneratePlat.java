package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class RegeneratePlat extends StaticBody {

    private static final BodyImage grounds = new BodyImage("Platformimg/regen.png", 2);
    private static final BodyImage hp = new BodyImage("Platformimg/hp.png", 2.5f);
    //private static final Shape hpp = new PolygonShape(
            //-1.374f,1.072f, -1.358f,0.176f, -0.028f,-1.409f, 1.536f,0.065f, 1.057f,1.172f);
    protected StaticBody Dav;
    protected Gamelevel w;

    public int getPlayer() {
        return player.getLives();
    }

    protected Player player;
    private  AttachedImage images;
    protected Shape hpp;
    protected StaticBody hearts;


    public RegeneratePlat(Gamelevel w, float width, float x, float y, Player player) {
        super(w);
        this.w = w;
        this.player = player;
        //addImage(hp);
        //setPosition(new Vec2(49,12));

        hpp = new PolygonShape(
                -1.374f,1.072f, -1.358f,0.176f, -0.028f,-1.409f, 1.536f,0.065f, 1.057f,1.172f);
        hearts = new StaticBody(this.getWorld());
        hearts.addImage(hp);
        GhostlyFixture heartsinvis = new GhostlyFixture(hearts,hpp);
        hearts.setPosition(new Vec2(x,y+3));

        //addImage(hp).setOffset(new Vec2(49.5f,12));
        Dav = new StaticBody(this.getWorld(),new BoxShape(width,0.3f));
        Dav.setPosition(new Vec2(x,y));
        Dav.addImage(grounds);
       // Dav.setAlwaysOutline(true);
        //setName("hiii");
        RegeneratePlayercollision dav = new RegeneratePlayercollision(player,this);
        Dav.addCollisionListener(dav);
        getWorld().addStepListener(dav);


    }





}



