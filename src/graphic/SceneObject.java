package graphic;

import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Scene Objects are sprite which does not react or effect the game. They are just used for visual presentation.
 * Flying leaves, for instance
 */
public abstract class SceneObject extends Sprite{

    /**
     * Constructor
     * @param imagePath path to image file
     * @throws SlickException
     */
    protected SceneObject(String imagePath) throws SlickException {
        super(imagePath);
    }

    /**
     * Constructor
     * @param x x position
     * @param y y position
     * @param imagePath path to image file
     * @throws SlickException
     */
    protected SceneObject(float x, float y, String imagePath) throws SlickException {
        super(x, y, imagePath);
    }

    /**
     * Move the scene object
     */
    public abstract void move();

    /**
     * Check if this object is out of screen
     * @return true if this object is out of screen, otherwise false
     */
    public abstract boolean isOutofScreen();


}
