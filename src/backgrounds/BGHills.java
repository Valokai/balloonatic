package backgrounds;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class BGHills extends Background {

    public BGHills(float x, float y, boolean isCollidable) {
        super(x, y, "data/sprite/hills2.png", isCollidable);
    }
}
