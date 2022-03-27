package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class SpikeplatCollision implements CollisionListener, StepListener {
    private Spikeplat spike;
    private Player p;
    private boolean onplatform;
    private int count;
    private int use;
    private int healsteps;
    private enemy e;
    private boolean n;

    private int teleport;;
    public SpikeplatCollision(Player p, Spikeplat spike,enemy e) {
        this.spike = spike;
        this.p = p;
        this.e = e;
        onplatform = false;
        use = 1;
        healsteps = 10;
        teleport =1;
        n = true;



    }

    public SpikeplatCollision() {
        onplatform = false;

    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (use >= 1) {
            if (collisionEvent.getOtherBody() instanceof Player) {
                onplatform = true;
                //spike.player.moves = false;
                use--;

            }
        }
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(e.stage == 2 && e.getRespawn() ==0 && n){
            spike.spikeplat.removeAllImages();
            spike.removeAllCollisionListeners();
            grenadepickup g = new grenadepickup(this.e.getWorld());
            g.setPosition(new Vec2(62,3));
            if(spike.player.isGrenadepicked()) {
                spike.player.getBackpack().additem(new Grenade(spike.player));
                n =false;
            }

        }
        if(e.getRespawn()!=0){
        if (spike.player.getPosition().y > -2 && spike.player.getPosition().y < 3 && spike.player.getPosition().x >50 && spike.player.getPosition().x < 70) {
                if (onplatform) {
                    count++;
                    if (count % 60 == 0 && healsteps != 0) {
                        spike.player.setLives(spike.player.getLives() - 1);
                        count = 0;
                        healsteps--;
                    }}
                 /*if (count == 203 ) {
                    onplatform = false;
                    if(count == )

                }*/
                }

        }


    }

    @Override
    public void postStep(StepEvent stepEvent) {

        /*

        if(teleport != 0){
            if(regen.player.getLives() == 10 && onplatform){
                regen.player.setPosition(new Vec2(46,-14));
                regen.player.moves = true;
                teleport--;
                regen.w.getA().destroy();
                regen.Dav.destroy();
                regen.removeAllImages();
            }
        }
*/
    }
}




