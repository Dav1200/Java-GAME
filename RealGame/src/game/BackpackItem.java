package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class BackpackItem {
    protected Player player;
    protected Image image;
    protected AttachedImage aimage;

    public BackpackItem(Player player){
        this.player = player;

    }

    public void puton(){
        /*
        aimage = player.addImage(image);
        aimage.setOffset(new Vec2(-1,0));
       // aimage.setOffset(new Vec2(2,0));
        if(player.getFacing().equals("left")){
            aimage.setOffset(new Vec2(-5,0));
            aimage.flipHorizontal();

        }
        if(player.getFacing().equals("right")){


        } */   }

    public void putoff(){

        //player.removeAttachedImage(aimage);
    }

    public abstract String getType();
    public abstract void function();



}
