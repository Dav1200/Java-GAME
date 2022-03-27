package game;

public abstract class BackpackItem {
    protected Player player;

    public BackpackItem(Player player){
        this.player = player;

    }

    public abstract String getType();
    public abstract void function();


}
