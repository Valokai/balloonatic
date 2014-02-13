package graphic;

import graphic.powerup.Powerup;
import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 3/02/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Windmill extends Powerup implements BalloonEffect {

    private SpriteSheet wmSheet;
    private Animation wm;


    public Windmill() throws SlickException {
        super("data/image/goldbird.png");
        wmSheet = new SpriteSheet("data/image/Windmill.png", 352, 374);
        wm = new Animation(wmSheet, 100);
        // wm.addFrame(wmSheet.getSprite(0, 0), 50);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        wm.update(delta);
        if (wm.getFrame() == 32) {
            wm.restart();
        }


    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {

    }

    @Override
    public void move(int delta) {
        x += delta / 1000 - 4;
    }

    @Override
    public void render(GameContainer gc, Graphics graphics) {
        wm.draw(x - 175, y - 175, 50, 50);
    }

    @Override
    public void drawOnBalloon(Balloon balloon, Graphics graphics) {
    }

    @Override
    public boolean isDrawnOnFront() {
        return false;
    }
}
