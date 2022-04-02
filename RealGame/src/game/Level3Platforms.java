package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;

public class Level3Platforms {
    private platforms plat;
    private World w;
    private static final BodyImage Platfromsimg = new BodyImage("Platformimg/platform.png", 1);
    public Level3Platforms(World w){
        this.w = w;
        plat = new platforms(w);

        for(int i = 0; i < 18;i++) {
            plat.platforms(-32+i*3f, -9f, Platfromsimg);
        }

        for(int i = 0; i < 18;i++) {
            plat.platforms(-19+i*3f, 0f, Platfromsimg);
        }

        for(int i = 0; i < 18;i++) {
            plat.platforms(-32+i*3f, 9f, Platfromsimg);
        }
        for(int i = 0; i < 18;i++) {
            plat.platforms(-19+i*3f, 18f, Platfromsimg);
        }


    }

}
