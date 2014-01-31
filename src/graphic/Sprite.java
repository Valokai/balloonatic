package graphic;

/**
 * User: Tin Htoo Aung
 * Date: 23/01/14
 * Time: 3:02 PM
 */

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * This is an abstract class for sprites. For backgrounds please use <code>Background</code> instead.
 */
public abstract class Sprite {

    /**
     * Position of Sprite on x coordinate
     */
    protected float x;

    /**
     * Position of Sprite on y coordinate
     */
    protected float y;

    /**
     * Image reference to render this
     */
    protected Image image;

    /**
     * Current scale of this
     */
    protected float scale;

    protected Sprite(String imagePath){
        try {
            this.image = new Image(imagePath);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        this.x = 0;
        this.y = 0;
    }

    /**
     * Contructor
     * @param x Position of Sprite on x coordinate
     * @param y Position of Sprite on y coordinate
     * @param imagePath Path to image to render as Sprite
     * @throws SlickException
     */
    protected Sprite(float x, float y, String imagePath) throws SlickException {
        this.x = x;
        this.y = y;
        this.image = new Image(imagePath);
    }

    /**
     * Get position of Sprite on x coordinate
     * @return position of Sprite on x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Set position of Sprite on x coordinate
     * @param x position of Sprite on x coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get position of Sprite on y coordinate
     * @return position of Sprite on y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Set position of Sprite on y coordinate
     * @param y position of Sprite on y coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Get <code>Image</code> reference of this
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**sets the image - used for setting different types of backgrounds
     * @param image string to image location
     */
    public void setImage(String image) {
        try {
            this.image = new Image(image);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void setCollideImage(String image) {

    }

    /**
     * Render this sprite on the screen
     * @param graphics graphics object attached to current scene
     */

    public void render(GameContainer gc, Graphics graphics){
        image.drawCentered(x, y);
    }

    /**
     * Update sprite on screen
     * @param delta
     */
    public void update(GameContainer gameContainer, int delta){}


    /**
     * Get the scale of this sprite
     * @return scale of this sprite
     */
    public float getScale() {
        return scale;
    }

    /**
     * Set the scale of this sprite
     * @param scale scale of this sprite
     */
    public void setScale(float scale) {
        image = image.getScaledCopy(scale);
        this.scale = scale;
    }

    public void draw(float x, float y, float width, float height){
         image.draw(x, y, width, height);
    }

    public void draw(float x, float y, float srcx, float srcy, float srcx2, float srcy2){
           image.draw(x, y, srcx, srcy, srcx2, srcy2);
    }

}
