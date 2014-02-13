package graphic;

import game.Game;
import org.newdawn.slick.SlickException;
import util.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 13/02/14
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class CrashedBalloon extends SceneObject {

    public CrashedBalloon() throws SlickException {
        super("data/image/crashedBalloon.png", false);
    }

    @Override
    public void move(int delta) {
        y += delta * Utils.randomizer.nextInt(5)/10;
    }

    @Override
    public boolean isReadyForDisposal() {
        return (y > Game.SCREEN_HEIGHT - getImage().getHeight() - 20);
    }
}
