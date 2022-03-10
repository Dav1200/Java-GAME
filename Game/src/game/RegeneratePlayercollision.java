package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class RegeneratePlayercollision implements CollisionListener, StepListener {
    private RegeneratePlat regen;
    private Player p;
    private boolean onplatform;
    private int count;
    private int use;
    private int healsteps;

    public RegeneratePlayercollision(Player p, RegeneratePlat regen) {
        this.regen = regen;
        this.p = p;
        onplatform = false;
        use = 1;
        healsteps = 10;


    }

    public RegeneratePlayercollision() {
        onplatform = false;

    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (use >= 1) {
            if (collisionEvent.getOtherBody() instanceof Player) {
                onplatform = true;
                use--;

            }
        }
    }

    @Override
    public void preStep(StepEvent stepEvent) {

        if (regen.player.getPosition().y > 8) {
            if (regen.player.getLives() < 10) {
                if (onplatform) {
                    count++;
                    if (count % 120 == 0 && healsteps != 0) {
                        regen.player.setLives(regen.player.getLives() + 1);
                        count = 0;
                        healsteps--;
                    }
                 /*if (count == 203 ) {
                    onplatform = false;
                    if(count == )

                }*/
                }
            }
        }


    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}




