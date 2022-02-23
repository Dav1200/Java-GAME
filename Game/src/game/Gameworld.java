package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Gameworld extends World {

    private Player player;
    private platforms plat;

    public Gameworld() {
        plat = new platforms(this);
        player = new Player(this);
        player.setPosition(new Vec2(-17,2));


    }


    public Player getPlayer() {
        return player;
    }
}
