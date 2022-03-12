package game;

import org.jbox2d.common.Vec2;

public class Doublejump extends BackpackItem{

    public Doublejump(Player player) {
        super(player);
    }

    @Override
    public String getType() {
        return "Single Shot";
    }

    @Override
    public void function() {
        System.out.println("hi");
        }
    }

