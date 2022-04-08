package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Animation {

    private int speed;
    private int frames;
    private int index;
    private int count;
private Vec2 s;
    private BodyImage[] image;



    private BodyImage currentimg;
    private Player p;
    private AttachedImage aimage;


    public Animation(int speed, Player p, BodyImage... args){
        this.speed = speed;
        this.p = p;
        currentimg = p.Playerimg;
    s = new Vec2(1,1);
        image = new BodyImage[args.length];
        for(int i = 0; i<args.length;i++){
            image[i] = args[i];
        }
        frames = args.length;
    }


    public void runanimation(){
        index++;

        if(index >speed){
            index = 0;
            nextframe();
        }

    }



    public void nextframe() {
        for (int i = 0; i < frames; i++) {
            if (count == i){
                currentimg = image[i];


            }



                //p.reset();
            // p.addImage(image[i]);


        }
        count++;
        if (count > frames) {
            count = 0;

           // p.removeAllImages();
        }
    }


    public void draw()
    {
        p.removeAttachedImage(aimage);
        aimage = p.addImage(currentimg);

    }

    public void flipdraw()
    {
        p.removeAttachedImage(aimage);
        aimage = p.addImage(currentimg);
        aimage.flipHorizontal();
        aimage.setOffset(new Vec2(1,0));
    }



    public BodyImage getCurrentimg() {
        return currentimg;
    }

    public void setCurrentimg(BodyImage currentimg) {
        this.currentimg = currentimg;
    }

}
