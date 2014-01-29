package scrollables;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import graphic.*;


/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 28/01/14
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreenHills extends Background {

    public GreenHills(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/concepthills.png", "data/image/concepthills-collide.png", collidable);
    }

}
