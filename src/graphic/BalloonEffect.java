package graphic;

import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 5/02/14
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BalloonEffect {
    public void drawOnBalloon(Balloon balloon, Graphics graphics);

    public boolean isDrawnOnFront();
}
