package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

import java.awt.Button;

public class Collision implements CollisionListener {
    private Player player;
    private platforms plat;
    private enemy en;
    private Gamelevel gamelevel;
    private Game game;

    public Collision(Player player, platforms plat, enemy en, Game game, Gamelevel gamelevel) {
        this.player = player;
        this.plat = plat;
        this.en = en;
        this.game = game;
        this.gamelevel = gamelevel;
    }

    public Collision(Player player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        /*
        if (collisionEvent.getPosition().y < -15) {
            player.setPosition(new Vec2(-17, -6));
            player.setLives(player.getLives() - 1);

        }
        */
        if (collisionEvent.getOtherBody() instanceof PickupItems) {
            collisionEvent.getOtherBody().destroy();
            player.doublegun = true;

        }
        if (collisionEvent.getOtherBody() instanceof Coin) {
            collisionEvent.getOtherBody().destroy();
            player.setScore(player.getScore() + 1);
            System.out.println(gamelevel.isComplete());
            player.coinpick = true;


        }

        if(collisionEvent.getOtherBody() instanceof  ShieldPickup){
            collisionEvent.getOtherBody().destroy();
            player.setShield(true);
        }

        if (collisionEvent.getOtherBody() instanceof grenadepickup) {
            collisionEvent.getOtherBody().destroy();
            player.setGrenadepicked(true);
            player.grendadeshoot= true;


        }


        if (collisionEvent.getOtherBody() instanceof Coin && gamelevel.isComplete()) {
            gamelevel.sound().stop();
            game.goToNextLevel();
        }

        if(collisionEvent.getOtherBody() instanceof RunningCoin){
            collisionEvent.getOtherBody().destroy();
            ((RunningCoin) collisionEvent.getOtherBody()).play();
            player.setRcoinCollected(true);
            player.CanJump = true;

        }


        if (collisionEvent.getOtherBody() instanceof enemy) {

            player.setLives(player.getLives() - 1);
            if (((enemy) collisionEvent.getOtherBody()).stage == 1) {
                player.setPosition(new Vec2(-17, -6));
            }
            if (((enemy) collisionEvent.getOtherBody()).stage == 2) {
                player.setPosition(new Vec2(47, 10));
            }
        }

        if (collisionEvent.getOtherBody() != player) {
            player.jcount = 0;

        }

    }


}

;



