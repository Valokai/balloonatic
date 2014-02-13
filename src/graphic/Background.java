package graphic;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * This class represent a Background Image of the game.
 * <p/>
 * For creation of game characters, please use <code>Sprite</code>
 */
public class Background extends Sprite {

    /*image map of collision points*/
    protected Image collisionImage;
    public String name = "";

    /*colliding status, true for colliding*/
    protected boolean collider;

    protected boolean isCollidable;

    protected int width, height;

    protected ArrayList<Vector2f> coordinates = new ArrayList<Vector2f>();
    protected ArrayList<Vector2f> goldCoordinates = new ArrayList<Vector2f>();
    protected ArrayList<Vector2f> windmillCoordinates = new ArrayList<Vector2f>();
    protected ArrayList<Cloud.CloudCoordinate> cloudCoordinates = new ArrayList<Cloud.CloudCoordinate>();
    protected ArrayList<Vector2f> shieldCoordinates = new ArrayList<Vector2f>();

    protected ArrayList<Vector2f> chargeCoordinates = new ArrayList<Vector2f>();

    public String getName() {
        return name;
    }

    public ArrayList<Vector2f> getChargeCoordinates() {
        return chargeCoordinates;
    }

    public void setChargeCoordinates(List<Vector2f> chargeCoordinates) {
        this.chargeCoordinates = new ArrayList<Vector2f>(chargeCoordinates);
    }

    public ArrayList<Vector2f> getShieldCoordinates() {
        return shieldCoordinates;
    }

    public void setShieldCoordinates(List<Vector2f> shieldCoordinates) {
        this.shieldCoordinates = new ArrayList<Vector2f>(shieldCoordinates);
    }


    public Background(float x, float y, String imagePath, String collisionImage, boolean collidable) throws SlickException {
        super(x, y, imagePath);
        this.collisionImage = new Image(collisionImage);
        this.isCollidable = collidable;
        this.width = 0;
        this.height = 0;
    }

    /**
     * Contructor
     *
     * @param x         x position
     * @param y         y position
     * @param imagePath path to image of this Background
     * @throws SlickException
     */
    public Background(float x, float y, String imagePath, boolean collidable) throws SlickException {
        super(x, y, imagePath);
        this.isCollidable = collidable;
        this.width = 0;
        this.height = 0;
    }

    public Background(float x, float y, int width, int height, String imagePath, String collisionImage, boolean collidable) throws SlickException {
        super(x, y, imagePath);
        this.collisionImage = new Image(collisionImage);
        this.isCollidable = collidable;
        this.width = width;
        this.height = height;
    }

    /**
     * Contructor
     *
     * @param x         x position
     * @param y         y position
     * @param imagePath path to image of this Background
     * @throws SlickException
     */
    public Background(float x, float y, int width, int height, String imagePath, boolean collidable) throws SlickException {
        super(x, y, imagePath);
        this.isCollidable = collidable;
        this.width = width;
        this.height = height;
    }

    /*move the background*/
    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /*reset the background to appropriate position on screen*/
    public void resetToEnd() {
        this.x = 1400.0f;
        this.y = 0;
    }

    @Override
    public void render(GameContainer gc, Graphics graphics) {
        if (width != 0) {
            image.draw(x, y, width, height);
        } else {
            image.draw(x, y);
        }
    }

    public void checkCollide(String name, float imagex, float imagey, Graphics g, Balloon balloon, int x, int y) {
        g.setColor(Color.black);


        if (balloonColliding(balloon.getX(), balloon.getY(), (int) imagex, (int) imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX(), balloon.getY() + 50, (int) imagex, (int) imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX(), balloon.getY() - 50, (int) imagex, (int) imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX() - 30, balloon.getY() - 20, (int) imagex, (int) imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX() + 30, balloon.getY() - 20, (int) imagex, (int) imagey).equals("255, 0, 0"))
            collider = true;


        else collider = false;
    }

    /**
     * checks to see the colour of the pixel associated with coordinates - used for collisions
     *
     * @param bx     the x coordinate of the pixel you want to check
     * @param by     the y coordinate of the pixel you want to check
     * @param imagex the images x coordinate you want to check against the collision image
     * @param imagey the images y coordinate you want to check against the collision image
     * @return a string of the rgb value of the pixel, eg "255, 255, 255"
     */
    public String balloonColliding(float bx, float by, int imagex, int imagey) {
        String rgb = "";
        try {
            if (by <= 0) return "0, 0, 0";
            rgb += collisionImage.getColor((int) bx - imagex, (int) by - imagey).getRed() + ", ";
            rgb += collisionImage.getColor((int) bx - imagex, (int) by - imagey).getGreen() + ", ";
            rgb += collisionImage.getColor((int) bx - imagex, (int) by - imagey).getBlue();
            return rgb;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return rgb;
    }

    public boolean isColliding() {
        return collider;
    }

    public boolean isCollidable() {
        return isCollidable;
    }

    public void setCollidable(boolean collidable) {
        isCollidable = collidable;
    }

    public void setCollisionImage(String image) {
        try {
            this.collisionImage = new Image(image);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Vector2f> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Vector2f> coordinates) {
        this.coordinates = new ArrayList<Vector2f>(coordinates);
    }

    public void setGoldCoordinates(List<Vector2f> coordinates) {
        this.goldCoordinates = new ArrayList<Vector2f>(coordinates);
    }

    public void setWindmillCoordinates(List<Vector2f> coordinates) {
        this.windmillCoordinates = new ArrayList<Vector2f>(coordinates);
    }
    public void setCloudCoordinates(List<Cloud.CloudCoordinate> coordinates) {
        this.cloudCoordinates = new ArrayList<Cloud.CloudCoordinate>(coordinates);
    }

}
