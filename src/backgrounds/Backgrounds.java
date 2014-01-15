package backgrounds;

import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Backgrounds {

    float x, y;
    Image image;

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
    public void resetToEnd() {
        this.x = 1400.0f;
        this.y = 0;
    }
    public void render() {
        image.draw(x, y);
    }

}
