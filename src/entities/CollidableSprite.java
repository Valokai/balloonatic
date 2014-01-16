package entities;

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

    public interface OnCollideListener{
        public void onCollide(CollidableSprite collider);
    }

}
