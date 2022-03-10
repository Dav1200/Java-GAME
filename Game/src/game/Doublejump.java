package game;

import org.jbox2d.common.Vec2;

public class Doublejump extends BackpackItem{

    public Doublejump(Player player) {
        super(player);
    }

    @Override
    public String getType() {
        return "DoubleJump Active";
    }

    @Override
    public void function() {
        /*if(player.jumpcount > 60) {
            player.setLinearVelocity(new Vec2(0, 20));
            player.jumpcount =0;
        }*/
    }
}
