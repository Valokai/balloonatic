package graphic.powerup;

import graphic.Balloon;
import graphic.SceneObject;
import handlers.SceneHandler;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 3/02/14
 * Time: 12:36 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Powerup extends SceneObject {

    private Balloon balloon;
    private int timesrotated;
    private boolean clockwise;

    protected SceneHandler sceneHandler = SceneHandler.getInstance();

    protected Powerup(String imagePath) throws SlickException {
        super(imagePath, true);
        this.balloon = (Balloon) SceneHandler.getInstance().getSceneObjectById("balloon");
        timesrotated = 0;
        clockwise = true;
    }

    protected Powerup(float x, float y, String imagePath) throws SlickException {
        super(x, y, imagePath, true);
        this.balloon = (Balloon) SceneHandler.getInstance().getSceneObjectById("balloon");
    }

    @Override
    public void move(int delta) {
        if(balloon.getLives()>0)
            x += delta / 1000 - 4;
    }

    @Override
    public boolean isReadyForDisposal() {
        return x < 0;
    }

    public void rotate() {
        if (timesrotated == 10) {
            clockwise = false;
        }
        if (timesrotated == -10) {
            clockwise = true;
        }

        if (clockwise) {
            getImage().rotate(3);
            timesrotated++;
        } else if (!clockwise) {
            getImage().rotate(-3);
            timesrotated--;
        }

    }


    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        if (x > 0 && x < 400) {
            if (isCollided(balloon)) {
                onCollideWithBalloon(balloon);
            }
        }
        rotate();
    }

    public abstract void onCollideWithBalloon(Balloon balloon);
}
