package graphic;

import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * This class represent a Background Image of the game.
 *
 * For creation of game characters, please use <code>Sprite</code>
 */
public class Background extends Sprite {

    /**
     * Constructor
     * @param imagePath path to image of this Background
     * @throws SlickException
     */
    protected Background(String imagePath, boolean collidable) throws SlickException {
        super(imagePath,collidable);
    }

    /**
     * Contructor
     * @param x x position
     * @param y y position
     * @param imagePath path to image of this Background
     * @throws SlickException
     */
    protected Background(float x, float y, String imagePath, boolean collidable) throws SlickException {
        super(x, y, imagePath, collidable);
    }

    /**
     * //TODO
     */
    public void restToEnd(){
        //TODO
    }
}
