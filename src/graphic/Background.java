package graphic;

import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Background extends Sprite {

    protected Background(String imagePath) throws SlickException {
        super(imagePath);
    }

    protected Background(float x, float y, String imagePath) throws SlickException {
        super(x, y, imagePath);
    }
}
