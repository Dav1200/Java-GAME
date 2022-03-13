package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class enemy extends Walker implements StepListener {

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
    protected int stage;
    protected boolean move;
    private AttachedImage simage;
    private AttachedImage fimage ;


    public int getRespawn() {
        return respawn;
    }

    public void setRespawn(int respawn) {
        this.respawn = respawn;
    }

    private int respawn;


    public platforms getPlat() {
        return plat;
    }

    public enemy(World world, platforms plat) {
        super(world, enemy);
        fimage = addImage(enemyimg);
        //;
        this.plat = plat;
        respawn = 2;
        stage = 0;
        move = false;

    }


    public void enemywalk(float x, float y) {
        if (stage == 1) {
            if (x < 10) {
                this.startWalking(3);
                fimage.flipHorizontal();
            } else if (x > 17) {
                this.startWalking(-3);
                fimage.flipHorizontal();
            }
        }

if(stage ==2){

    if(move == false){
        removeAttachedImage(fimage);
        simage = addImage(enemyimgg);
        simage.flipHorizontal();
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

        PlatformCollision platcollision = new PlatformCollision(plat,this);
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

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
