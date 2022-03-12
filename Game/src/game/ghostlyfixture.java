package game;

import city.cs.engine.Body;
import city.cs.engine.GhostlyFixture;
import city.cs.engine.Shape;

public class ghostlyfixture extends GhostlyFixture {

    public ghostlyfixture(Body body, Shape shape) {
        super(body, shape);
        this.setDensity(5);
    }
}
