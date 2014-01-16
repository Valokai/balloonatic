package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Sprite {

    protected Image image, collisionImage;
    protected float x, y;
    protected boolean collider = false;

    public Sprite(String imagePath) {
        try {
            this.image = new Image(imagePath);
            this.x = 0;
            this.y = 0;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Sprite(float x, float y, String imagePath, String collisionPath) {
        try {
            this.collisionImage = new Image(collisionPath);
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

    public void printStats(String name, float imagex, float imagey, Graphics g, Balloon balloon, int x, int y) {

        g.drawOval(balloon.getX(), balloon.getY(), 2, 2);
        g.drawString(name, x, y-20);
        g.drawString(""+balloonColliding(balloon, (int)imagex, (int)imagey),x,y);

        if(!balloonColliding(balloon, (int)imagex, (int)imagey).equals("0, 0, 0")) collider = true;
        else collider = false;
    }

    public boolean isColliding() {

        return collider;
    }



    public String balloonColliding(Balloon balloon, int imagex, int imagey){

        String rgb = "";
        rgb += image.getColor((int)balloon.getX()-imagex, (int) balloon.getY()-imagey).getRed() + ", ";
        rgb += image.getColor((int)balloon.getX()-imagex, (int) balloon.getY()-imagey).getGreen() + ", ";
        rgb += image.getColor((int)balloon.getX()-imagex, (int) balloon.getY()-imagey).getBlue();

        return rgb;
    }
}
