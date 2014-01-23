package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Sprite {

    protected Image image;
    protected float x, y;

    public Sprite(String imagePath) {
        try {
            this.image = new Image(imagePath);
            this.x = 0;
            this.y = 0;
            this.image.setRotation((float) 75);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Sprite(float x, float y, String imagePath) {
        try {
            this.image = new Image(imagePath);
            this.x = x;
            this.y = y;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public abstract void render();

    public abstract void update(GameContainer gameContainer, int delta);
}
