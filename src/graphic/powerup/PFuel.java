package graphic.powerup;

import graphic.Balloon;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 3/02/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PFuel extends Powerup{

    private Sound pickup;



    public PFuel() throws SlickException {
        super("data/image/fuel.png");
        pickup = new Sound("data/sound/effects/fuel.ogg");

    }


    public PFuel(String imagePath) throws SlickException {
        super(imagePath);
    }

    public PFuel(float x, float y, String imagePath) throws SlickException {
        super(x, y, imagePath);
    }



    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);

    }


    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        sceneHandler.removeSceneObject(this);
        balloon.setFuel(1000);
        pickup.play();
    }
}
