package game;

public class Doublegun extends BackpackItem{

    public Doublegun(Player player) {
        super(player);
    }

    @Override
    public String getType() {
        if(player.doublegun){
        return "DoubleGun";}

    return "Empty";
    }

    @Override
    public void function() {
        if(player.doublegun) {
            if (player.timer == 120) {
                player.doubleshoot();
                player.bulletcount = 2;
                player.timer = 0;
            }
        }
    }
}
