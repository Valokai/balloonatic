package graphic;

import game.Game;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 28/01/14
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Leaf extends SceneObject {

    public Leaf() throws SlickException {
        super("data/image/leaf.png", false);
    }

    protected Leaf(String imagePath, boolean isCollidable) throws SlickException {
        super(imagePath, isCollidable);
    }

    protected Leaf(float x, float y, String imagePath, boolean isCollidable) throws SlickException {
        super(x, y, imagePath, isCollidable);
    }

    @Override
    public void move(int delta) {
        x += delta * 0.01;
    }

    @Override
    public boolean isReadyForDisposal() {
        return (x > Game.SCREEN_WIDTH ||x < 0);
    }
}
