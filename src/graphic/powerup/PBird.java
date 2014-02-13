package graphic.powerup;

import graphic.Balloon;
import graphic.BalloonEffect;
import graphic.Feather;
import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 3/02/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PBird extends Powerup implements BalloonEffect {

    private Animation bird;
    private Image[] birdimages;

    private Sound death, birdsound;


    public PBird() throws SlickException {
        super("data/image/goldbird.png");
        birdimages = new Image[]{new Image("data/image/bird1.png"), new Image("data/image/bird2.png")};
        bird = new Animation(birdimages, 50);
        death = new Sound("data/sound/effects/gameover1.wav");
        birdsound = new Sound("data/sound/effects/bird_screech.ogg");

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);

    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        balloon.setOnShake(true);
        balloon.removeBalloonEffect("bird");
        balloon.addBalloonEffect(this, "bird");
        sceneHandler.removeSceneObject(this);
        balloon.setParticleTimer(200);
        for (int i = 0; i < 6; i++) {
            sceneHandler.spawn(x, y, Feather.class, "Feather" + i);
            // int count = 5;
            //while (count>0) {
            //    sceneHandler.spawn(x, y, Blood.class);
            //   count--;
            //}
        }

        balloon.setBirdCounter(1);
        if (!balloon.isLockLife()) {
            balloon.setFuel(balloon.getFuel() - 40 < 0 ? 0 : balloon.getFuel() - 40);
            balloon.setFuelState(2);
        }
        death.play(0.5f, 0.3f);
        birdsound.play(0.8f, 0.1f);
        balloon.removeBalloonEffect("bird");
    }

    @Override
    public void move(int delta) {
        x += delta / 1000 - 14;
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
