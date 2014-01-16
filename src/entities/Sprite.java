package entities;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

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

    protected OnCollideListener onCollideListener;

    protected boolean isCollidable = false;

    protected Polygon polygon;
    private ArrayList<Float> points = new ArrayList<Float>();

    public Sprite(String imagePath, boolean isCollidable) {
        try {
            this.image = new Image(imagePath);
            this.x = 0;
            this.y = 0;
            this.isCollidable = isCollidable;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Sprite(float x, float y, String imagePath, boolean isCollidable) {
        try {
            this.image = new Image(imagePath);
            this.x = x;
            this.y = y;
            this.isCollidable = isCollidable;
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

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    // returns a HashSet of strings that list all the pixels in an image that aren't transparent
    // the pixels contained in the HashSet follow the guideline of:
    // x,y where x is the absolute x position of the pixel and y is the absolute y position of the pixel
    public HashSet<String> getMask(){
        HashSet<String> mask = new HashSet<String>();
        for(int i = 0; i < image.getWidth(); i++){ // for every (x,y) component in the given box,
            for( int j = 0; j < image.getHeight(); j++){
                if(image.getColor(i, j).getAlpha() != 0){  // if the alpha is not 0, it must be something other than transparent
                    mask.add((int)(x+i)+","+(int)(y- j)); // add the absolute x and absolute y coordinates to our set
                }
            }
        }
        System.out.println(mask);
        return mask;  //return our set
    }

    // Returns true if there is a collision between object a and object b
    public boolean isCollided(Sprite collidableSprite){
        if(collidableSprite.isCollidable()){
            // This method detects to see if the images overlap at all. If they do, collision is possible
            int ax1 = (int) getX();
            int ay1 = (int) getY();
            int ax2 = ax1 + getImage().getWidth();
            int ay2 = ay1 + getImage().getHeight();
            int bx1 = (int) collidableSprite.getX();
            int by1 = (int) collidableSprite.getY();
            int bx2 = bx1 + collidableSprite.getImage().getWidth();
            int by2 = by1 + collidableSprite.getImage().getHeight();

            if(by2 < ay1 || ay2 < by1 || bx2 < ax1 || ax2 < bx1){
                return false; // Collision is impossible.
            }
            else{
                // Collision is possible.
                // get the masks for both images
                HashSet<String> maskPlayer1 = getMask();
                HashSet<String> maskPlayer2 = collidableSprite.getMask();

                maskPlayer1.retainAll(maskPlayer2);  // Check to see if any pixels in maskPlayer2 are the same as those in maskPlayer1

                if(!maskPlayer1.isEmpty()){  // if so, than there exists at least one pixel that is the same in both images, thus
                    if(onCollideListener != null){
                        onCollideListener.onCollide(collidableSprite);
                    }
                    System.out.println("Collided");
                    return true;
                }
            }
        }else{
            Log.info("Given sprite is not collidable. Did you set isCollidable to false?");
        }
        return false;
    }

    public interface OnCollideListener{
        public void onCollide(Sprite collider);
    }

    public abstract void render(Graphics graphics);

    public abstract void update(GameContainer gameContainer, int delta);

    public void setOnCollideListener(OnCollideListener onCollideListener) {
        this.onCollideListener = onCollideListener;
    }

    public boolean isCollidable() {
        return isCollidable;
    }

    public void setCollidable(boolean collidable) {
        isCollidable = collidable;
    }
}
