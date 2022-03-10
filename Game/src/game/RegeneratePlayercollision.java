package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class RegeneratePlayercollision implements CollisionListener {
    private RegeneratePlat regen;
    private Player p;
    public RegeneratePlayercollision(Player p,RegeneratePlat regen){
        this.regen = regen;
        this.p = p;


    }
    public RegeneratePlayercollision(){

    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Player){
        System.out.println("hi");}

        }
        }




