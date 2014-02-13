package graphic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import java.util.HashSet;

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
public abstract class SceneObject extends Sprite {

    /**
     * Can a player collide with this object.
     */
    protected boolean isCollidable;

    private HashSet<String> mask;


    /**
     * Constructor
     *
     * @param imagePath path to image file
     * @throws SlickException
     */
    protected SceneObject(String imagePath, boolean isCollidable) throws SlickException {
        super(imagePath);
        this.isCollidable = isCollidable;
    }

    /**
     * Constructor
     *
     * @param x         x position
     * @param y         y position
     * @param imagePath path to image file
     * @throws SlickException
     */
    protected SceneObject(float x, float y, String imagePath, boolean isCollidable) throws SlickException {
        super(x, y, imagePath);
        this.isCollidable = isCollidable;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        move(delta);
    }

    public HashSet<String> getMask() {
        mask = new HashSet<String>();
        int iw = image.getWidth() / 2;
        int ih = image.getHeight() / 2;
        for (int i = 0; i < image.getWidth(); i++) { // for every (x,y) component in the given box,
            for (int j = 0; j < image.getHeight(); j++) {
                if (image.getColor(i, j).getAlpha() != 0) {  // if the alpha is not 0, it must be something other than transparent
                    mask.add((int) (x - iw + i) + "," + (int) (y - ih + j)); // add the absolute x and absolute y coordinates to our set
                }
            }
        }
        return mask;
    }

    /**
     * Move the scene object
     */
    public abstract void move(int delta);


    /**
     * Check if this object is out of screen
     *
     * @return true if this object is out of screen, otherwise false
     */
    public abstract boolean isReadyForDisposal();

    /**
     * colliding status
     *
     * @return true if the sprite is collidable, false for not
     */
    public boolean isCollidable() {
        return isCollidable;
    }

    public void setCollidable(boolean collidable) {
        isCollidable = collidable;
    }


    public HashSet<String> showMask() {
        return mask;
    }

    public boolean isCollided(SceneObject collidable) {
        if (collidable != null && collidable.isCollidable()) {

            HashSet<String> maskPlayer2 = collidable.getMask();
            HashSet<String> maskPlayer1 = getMask();
            maskPlayer1.retainAll(maskPlayer2);  // Check to see if any pixels in maskPlayer2 are the same as those in maskPlayer1

            if (!maskPlayer1.isEmpty()) {  // if so, than there exists at least one pixel that is the same in both images, thus
                return true;
            }
        }
        return false;
    }
}
