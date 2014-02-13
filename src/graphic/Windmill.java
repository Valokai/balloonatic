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
    protected float scale;
    protected Color colour;


    public Windmill() throws SlickException {
        super("data/image/goldbird.png");
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);
        // wm.addFrame(wmSheet.getSprite(0, 0), 50);
        scale = 1f;
        colour = null;
    }

    public Windmill(float s) throws SlickException {
        super("data/image/goldbird.png");
        scale = 1f;
        this.scale = s;
        colour = null;
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);
        // wm.addFrame(wmSheet.getSprite(0, 0), 50);
    }

    public Windmill(float s, Color c) throws SlickException {
        super("data/image/goldbird.png");
        scale = 1f;
        this.scale = s;
        this.colour = c;
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);
        // wm.addFrame(wmSheet.getSprite(0, 0), 50);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        wm.update(delta);
        if (wm.getFrame() == 9) {
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
        if(this.colour == null){
            wm.draw(x - 50, y - 50, 100 * scale, 100 * scale);
        }else{
        wm.draw(x - 50, y - 50, 100 * scale, 100 * scale, colour);
        }
    }

    @Override
    public void drawOnBalloon(Balloon balloon, Graphics graphics) {
    }

    @Override
    public boolean isDrawnOnFront() {
        return false;
    }
}
