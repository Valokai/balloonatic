package graphic;

/**
 * User: Tin Htoo Aung
 * Date: 23/01/14
 * Time: 3:02 PM
 */

import org.newdawn.slick.Color;
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
    private float scale;

    /**
     * Can a player collide with this object.
     */
    private boolean isCollidable;

    /*colliding status, true for colliding*/
    protected boolean collider;

    /*image map of collision points*/
    protected Image collisionImage;


    protected Sprite(String imagePath){
        try {
            this.image = new Image(imagePath);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        this.x = 0;
        this.y = 0;
        this.isCollidable = false;
    }

    /**
     * Constructor
     * @param imagePath path to sprite image
     * @param collidable boolean whether image is collidable
     * @throws SlickException
     */
    protected Sprite(String imagePath, boolean collidable) throws SlickException {
        this.image = new Image(imagePath);
        this.x = 0;
        this.y = 0;
        this.isCollidable = collidable;
    }

    /**
     * Contructor
     * @param x Position of Sprite on x coordinate
     * @param y Position of Sprite on y coordinate
     * @param imagePath Path to image to render as Sprite
     * @param collidable boolean whether image is collidable
     * @throws SlickException
     */
    protected Sprite(float x, float y, String imagePath, boolean collidable) throws SlickException {
        this.x = x;
        this.y = y;
        this.image = new Image(imagePath);
        this.isCollidable = collidable;
    }

    /**
     * Contructor
     * @param x Position of Sprite on x coordinate
     * @param y Position of Sprite on y coordinate
     * @param imagePath Path to image to render as Sprite
     * @param collisionImage Path to image that acts as collision map
     * @param collidable boolean whether image is collidable
     * @throws SlickException
     */
    protected Sprite(float x, float y, String imagePath, String collisionImage, boolean collidable) throws SlickException {
        this.x = x;
        this.y = y;
        this.image = new Image(imagePath);
        this.collisionImage = new Image(collisionImage);
        this.isCollidable = collidable;
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

    /**
     * Render sprite on screen
     * @param graphics graphics object attached to current scene
     */
    public void render(Graphics graphics){
        image.draw(x, y);
    }

    /**
     * Get scale of this sprite
     * @return scale of this sprite
     */
    public float getScale() {
        return scale;
    }

    /**
     * Set scale of this sprite
     * @param scale scale of this sprite
     */
    public void setScale(float scale) {
        image = image.getScaledCopy(scale);
        this.scale = scale;
    }

    public  void checkCollide(String name, float imagex, float imagey, Graphics g, Balloon balloon, int x, int y){}

    /**colliding status
     * @return true for colliding, false for not colliding
     */
    public boolean isColliding() {
        return collider;
    }

    /**colliding status
     * @return true if the sprite is collidable, false for not
     */
    public boolean isCollidable() {
        return isCollidable;
    }



}
