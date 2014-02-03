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
public class Bird extends Powerup{

    public Bird() throws SlickException {
        super("data/image/goldbird.png");
    }

    public Bird(String imagePath) throws SlickException {
        super(imagePath);
    }

    public Bird(float x, float y, String imagePath) throws SlickException {
        super(x, y, imagePath);
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        sceneHandler.removeSceneObject(this);
        balloon.editLives(-1);
    }

    @Override
    public void move(int delta) {
        x += delta/1000 - 10;
    }
}
