package graphic.powerup;

import graphic.Balloon;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 3/02/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PLife extends Powerup{

    public PLife() throws SlickException {
        super("data/image/leaf.png");
    }

    public PLife(String imagePath) throws SlickException {
        super(imagePath);
    }

    public PLife(float x, float y, String imagePath) throws SlickException {
        super(x, y, imagePath);
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        sceneHandler.removeSceneObject(this);
        balloon.setFuel(1000);
    }
}
