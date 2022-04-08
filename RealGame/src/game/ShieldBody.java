package game;

import city.cs.engine.*;
import game.Player;
import org.jbox2d.common.Vec2;

public class ShieldBody extends StaticBody implements StepListener
{

;


private static final BodyImage shieldimg = new BodyImage("item/Shield2.png",5);
private AttachedImage aimagel;
  private Player player;
  private  AttachedImage limage;
    public ShieldBody(World w, Shape s,Player player) {
        super(w, s);
        this.player = player;
        setAlwaysOutline(true);
        aimagel = addImage(shieldimg);

    }





    @Override
    public void preStep(StepEvent stepEvent) {
        if(player.getFacing().equals("right")){
            if(aimagel.isFlippedHorizontal()){
                aimagel.flipHorizontal();
            }

        setPosition(new Vec2(player.getPosition().x+2,player.getPosition().y));
    }
            if(player.getFacing().equals("left")){
                if(!aimagel.isFlippedHorizontal()){
                    aimagel.flipHorizontal();
                }
            setPosition(new Vec2(player.getPosition().x-3,player.getPosition().y));

        }    }

    @Override
    public void postStep(StepEvent stepEvent) {


    }
}
