package graphic.powerup;

import graphic.Balloon;
import graphic.BalloonEffect;
import org.newdawn.slick.*;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 3/02/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PSpiral extends Powerup implements BalloonEffect {

    private Animation bird;
    private Image[] birdimages;

    private Sound death;
    private boolean up;
    Random random = new Random();


    public PSpiral() throws SlickException {
        super("data/image/bee1.png");
        birdimages = new Image[]{new Image("data/image/bee1.png"), new Image("data/image/bee2.png")};
        bird = new Animation(birdimages, 50);
        death = new Sound("data/sound/effects/gameover1.wav");
        up = random.nextBoolean();
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        // balloon.addBalloonEffect(this, "bird");
        sceneHandler.removeSceneObject(this);
        //balloon.setBirdCounter(1);
        if (!balloon.isLockLife()) {
            balloon.setFuel(balloon.getFuel() - 100 < 0 ? 0 : balloon.getFuel() - 100);
            balloon.setFuelState(2);
            death.play(0.5f, 0.3f);
            //birdsound.play(0.8f, 0.1f);
        }
    }

    @Override
    public void move(int delta) {
        if (up) {
            y += delta / 1000 - 5;
        } else {
            y += delta / 1000 + 5;
        }

        if (y > 400) {
            up = true;
        } else if (y < 100) {
            up = false;
        }

        x += delta / 1000 - 8;
    }

    @Override
    public void render(GameContainer gc, Graphics graphics) {
        bird.draw(x - 20, y - 20);
    }

    @Override
    public void drawOnBalloon(Balloon balloon, Graphics graphics) {
    }

    @Override
    public boolean isDrawnOnFront() {
        return false;
    }
}
