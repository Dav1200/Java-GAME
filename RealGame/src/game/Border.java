package game;

import city.cs.engine.World;

public class Border extends platforms {


    public Border(World w) {
        super(w);
        //stage 1
        border(0.5f,40,-20,0);
        border(0.5f,40,20,0);
        //stage 2
        border(0.5f,40,40,0);
        border(0.5f,40,80,0);
    }

}
