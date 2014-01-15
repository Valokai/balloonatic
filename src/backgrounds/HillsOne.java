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
public class HillsOne extends Backgrounds {
    Image image;
    public float x, y;

    public HillsOne(float x, float y) {

        this.x = x;
        this.y = y;
        try {
            image = new Image("data/sprite/hills1.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

    public float getX() {
        return x;
    }

    public float getY()   {
        return y;
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }


    public void render() {
        image.draw(x, y);
    }

}
