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

    public abstract float getX();
    public abstract float getY();
    public abstract void move(float x, float y);
    public abstract void render();



}
