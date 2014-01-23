package graphic;

/**
 * User: Tin Htoo Aung
 * Date: 23/01/14
 * Time: 3:02 PM
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * This is an abstract class for all sprite. For background, please use <code>Background</code> instead.
 */
public abstract class Sprite {

    private float x;
    private float y;
    private Image image;

    /**
     * Constructor
     * @param imagePath path to sprite image
     * @throws SlickException
     */
    protected Sprite(String imagePath) throws SlickException {
        this.image = new Image(imagePath);
        this.x = 0;
        this.y = 0;
    }

    protected Sprite(float x, float y, String imagePath) throws SlickException {
        this.x = x;
        this.y = y;
        this.image = new Image(imagePath);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
