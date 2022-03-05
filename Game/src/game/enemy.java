package game;

import city.cs.engine.*;

public class enemy extends Walker {

    private final static Shape enemy = new BoxShape(1,2);
    protected float Smallenemylives =5;


    public enemy(World world) {
        super(world,enemy);



    }

    public void enemywalk(float x, float y){
        if(x <10){
            this.startWalking(3);
        }
        else if(x>18){
            this.startWalking(-3);
        }

    }

    public float getSmallenemylives() {
        return Smallenemylives;
    }

    public void setSmallenemylives(float smallenemylives) {
        this.Smallenemylives = smallenemylives;
    }

}
