package game;

import city.cs.engine.SoundClip;

import java.awt.*;

public class level3 extends Gamelevel{
    public level3(Game game) {
        super(game);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Image background() {
        return null;
    }

    @Override
    public SoundClip sound() {
        return null;
    }
}
