package graphic;

import game.Game;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 10/02/14
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeadPlayer extends SceneObject {

    public DeadPlayer() throws SlickException {
        super("data/image/deadballoon.png", true);
    }

    protected DeadPlayer(String imagePath, boolean isCollidable) throws SlickException {
        super(imagePath, isCollidable);
    }

    protected DeadPlayer(float x, float y, String imagePath, boolean isCollidable) throws SlickException {
        super(x, y, imagePath, isCollidable);
    }
    @Override
    public void move(int delta) {
        x += delta/1000 - 4;
    }

    @Override
    public boolean isReadyForDisposal() {
        return (x < 0);
    }

}
