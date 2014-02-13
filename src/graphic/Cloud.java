package graphic;

import graphic.powerup.Powerup;
import org.newdawn.slick.*;

/**
 * User: Nick Meek
 * Date: 13/02/14
 * A class to display the animated windmills
 * Has a number of constructors so you cna adjust scale and color filter
 */
public class Cloud extends Powerup implements BalloonEffect {

    protected float scale;
    protected Color colour;
    protected int step; // the offset used in scrolling. Differs for each layer for parallex


    public Cloud() throws SlickException {
        super("data/image/cloud2.png");
        this.scale = .8f + (int)(Math.random() * ((1.8 - .8) + 1));
        this.colour = null;
        this.step = -3;
    }


    @Override
    public void rotate() {
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {

    }

    @Override
    public void move(int delta) {
        x += delta / 1000 + step;//To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void drawOnBalloon(Balloon balloon, Graphics graphics) {
    }

    @Override
    public boolean isDrawnOnFront() {
        return false;
    }
}
