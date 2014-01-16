package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CollidableSprite extends Sprite {

    protected OnCollideListener onCollideListener;

    public CollidableSprite(String imagePath) {
        super(imagePath);
    }

    public CollidableSprite(float x, float y, String imagePath) {
        super(x, y, imagePath);
    }

    // returns a HashSet of strings that list all the pixels in an image that aren't transparent
    // the pixels contained in the HashSet follow the guideline of:
    // x,y where x is the absolute x position of the pixel and y is the absolute y position of the pixel
    public HashSet<String> getMask(){

        HashSet<String> mask = new HashSet<String>();
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(image.getResourceReference()));
        } catch (IOException e) {
            System.out.println("error");
        }
        int pixel, a;
        for(int i = 0; i < bufferedImage.getWidth(); i++){ // for every (x,y) component in the given box,
            for( int j = 0; j < bufferedImage.getHeight(); j++){

                pixel = bufferedImage.getRGB(i, j); // get the RGB value of the pixel
                a= (pixel >> 24) & 0xff;

                if(a != 0){  // if the alpha is not 0, it must be something other than transparent
                    mask.add((x+i)+","+(y- j)); // add the absolute x and absolute y coordinates to our set
                }
            }
        }
        return mask;  //return our set

    }

    // Returns true if there is a collision between object a and object b
    public boolean isCollided(CollidableSprite collidableSprite){

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

            if(maskPlayer1.size() > 0){  // if so, than there exists at least one pixel that is the same in both images, thus
                if(onCollideListener != null){
                    onCollideListener.onCollide(collidableSprite);
                }
                return true;
            }
        }
        return false;
    }

    public interface OnCollideListener{
        public void onCollide(CollidableSprite collider);
    }

}
