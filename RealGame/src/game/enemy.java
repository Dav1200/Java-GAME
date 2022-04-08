package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class enemy extends Walker implements StepListener{

    private final static Shape enemy = new BoxShape(1, 2);
    private static final BodyImage enemyimg= new BodyImage("enemy/idle2.png", 5f);
    private static final BodyImage enemyimgg= new BodyImage("enemy/enemygif.gif", 6f);
    private static final BodyImage bullets = new BodyImage("enemy/Bullet.png", 1f);

    //private final static Shape enemyy = new BoxShape(1,2);
    // private final static Shape enemyy = new BoxShape(1,2);
    protected int Smallenemylives = 5;
    protected float x;
    protected float y;
    private int counter;
    //protected DynamicBody bullet;
    protected platforms plat;

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    private String facing;

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    protected int stage;
    protected boolean move;
    private AttachedImage simage;

    public AttachedImage getFimage() {
        return fimage;
    }

    private AttachedImage fimage ;

    public boolean isEnemydef() {
        return enemydef;
    }

    public void setEnemydef(boolean enemydef) {
        this.enemydef = enemydef;
    }

    private boolean enemydef;


    public int getRespawn() {
        return respawn;
    }

    public void setRespawn(int respawn) {
        this.respawn = respawn;
    }

    private int respawn;
    private Gamelevel world;

    public platforms getPlat() {
        return plat;
    }

    public enemy(Gamelevel world, platforms plat) {
        super(world, enemy);
        fimage = addImage(enemyimg);
        //;
        this.plat = plat;
        respawn = 1;
        stage = 1;
        move = false;
        enemydef =false;
        facing = "";

    }


    public void enemywalk(float x, float y) {
        if (stage == 1) {
            if (x < 10) {
                this.startWalking(3);
                facing = "right";

                fimage.flipHorizontal();
            } else if (x > 17) {
                this.startWalking(-3);
                fimage.flipHorizontal();
                facing = "left";
            }
        }

if(stage ==2){

    if(move == false){
        removeAttachedImage(fimage);
        simage = addImage(enemyimgg);

    setRespawn(2);
    setPosition(new Vec2(60,5));

    System.out.println(getPosition());}
    move = true;
    if (x < 51) {
        this.startWalking(3);
        simage.flipHorizontal();
    } else if (x > 68) {
        this.startWalking(-3);
        simage.flipHorizontal();
    }

}

if( world instanceof level2){
    System.out.println("si");
}

    }


    public int getSmallenemylives() {
        return Smallenemylives;
    }

    public int getSmallenemylivess() {
        return Smallenemylives * 10;
    }

    public void setSmallenemylives(int smallenemylives) {
        this.Smallenemylives = smallenemylives;
    }

    public void shootplayer(Vec2 t) {
        //when bullet hits player.

        DynamicBody bullet = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        bullet.addImage(bullets);
        EnemyhitCollision pickups = new EnemyhitCollision(this);


        //when the bullet hits platform

        EnemybulletCol platcollision = new EnemybulletCol(this);
        bullet.addCollisionListener(platcollision);


        bullet.addCollisionListener(pickups);
        //listenbullet.addCollisionListener(bullet);

        Vec2 dir = t.sub(this.getPosition());
        dir.normalize();

        bullet.setPosition(this.getPosition().add(dir.mul(3f)));

        bullet.setLinearVelocity(dir.mul(30));
        if (getRespawn() == 0) {
            bullet.destroy();

        }


    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if(getRespawn() == 0){
            enemydef = true;

        }

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
