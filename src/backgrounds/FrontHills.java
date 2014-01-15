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
public class FrontHills extends Backgrounds {

    public FrontHills(float x, float y) {
        this.x = x;
        this.y = y;
        try {
            image = new Image("data/sprite/hills1.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
