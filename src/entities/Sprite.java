package entities;

import org.newdawn.slick.*;

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

        g.setColor(Color.black);
        g.drawOval(balloon.getX(), balloon.getY(), 2, 2);
        g.drawOval(balloon.getX(), balloon.getY()+50, 2, 2);
        g.drawOval(balloon.getX(), balloon.getY()-50, 2, 2);
        g.drawOval(balloon.getX()-30, balloon.getY()-20, 2, 2);
        g.drawOval(balloon.getX()+30, balloon.getY()-20, 2, 2);
        //g.drawString(name, x, y-20);
        //g.drawString(""+balloonColliding(balloon.getX(), balloon.getY(), (int)imagex, (int)imagey),x,y);




            /*
        if(!balloonColliding(balloon.getX(), balloon.getY(), (int)imagex, (int)imagey).equals("0, 0, 0") ||
                !balloonColliding(balloon.getX(), balloon.getY()+50, (int)imagex, (int)imagey).equals("0, 0, 0") ||
                !balloonColliding(balloon.getX(), balloon.getY()-50, (int)imagex, (int)imagey).equals("0, 0, 0") ||
                !balloonColliding(balloon.getX()-30, balloon.getY()-20, (int)imagex, (int)imagey).equals("0, 0, 0") ||
                !balloonColliding(balloon.getX()+30, balloon.getY()-20, (int)imagex, (int)imagey).equals("0, 0, 0")) collider = true;   */


        if(balloonColliding(balloon.getX(), balloon.getY(), (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX(), balloon.getY()+50, (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX(), balloon.getY()-50, (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX()-30, balloon.getY()-20, (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX()+30, balloon.getY()-20, (int)imagex, (int)imagey).equals("255, 0, 0")) collider = true;


        //if(balloonColliding(balloon.getX(), balloon.getY(), (int)imagex, (int)imagey).equals("255, 0, 0")) collider = true;

        else collider = false;
    }

    public boolean isColliding() {
        return collider;
    }



    public String balloonColliding(float bx, float by, int imagex, int imagey){

        if(by <= 0) return "0, 0, 0";
        String rgb = "";
        rgb += collisionImage.getColor((int)bx-imagex, (int)by-imagey).getRed() + ", ";
        rgb += collisionImage.getColor((int)bx-imagex, (int)by-imagey).getGreen() + ", ";
        rgb += collisionImage.getColor((int)bx-imagex, (int)by-imagey).getBlue();

        return rgb;
    }
}
