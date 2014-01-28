package graphic;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.SlickException;

/**
 * Balloon Sprite, Player of the game
 */
public class Balloon extends Sprite{

    protected Balloon() throws SlickException {
        super("data/sprite/balloon.png", true);
    }

    public Balloon(float x, float y) throws SlickException {
        super(x, y, "data/sprite/balloon.png", true);
    }

}
