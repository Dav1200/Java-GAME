package game;

import city.cs.engine.*;

public class Coin extends StaticBody{
    private static final Shape coin = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("item/coiin.png", 2.5f);
    protected AttachedImage CoinIcon;

    public Coin(World w) {
        super(w,coin);
        CoinIcon = addImage(image);

    }
}
