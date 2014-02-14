package graphic;

import graphic.powerup.Powerup;
import org.newdawn.slick.*;

/**
 * User: Nick Meek
 * Date: 13/02/14
 * A class to display the animated windmills
 * Has a number of constructors so you cna adjust scale and color filter
 */
public class Windmill extends Powerup implements BalloonEffect {

    private SpriteSheet wmSheet;
    private Animation wm;
    protected float scale;
    protected Color colour;
    protected int step; // the offset used in scrolling. Differs for each layer for parallex


    public Windmill() throws SlickException {
        super("data/image/goldbird.png");
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);

        this.scale = 1f + (int)(Math.random() * ((1.2 - 1) + 1));
        this.colour = null;
        this.step = -4;
    }

    public Windmill(float s) throws SlickException {
        super("data/image/goldbird.png");
        this.scale = 1f;
        this.scale = s;
        this.colour = null;
        this.step = -4;
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);
    }

    public Windmill(float s, Color c) throws SlickException {
        super("data/image/goldbird.png");
        this.scale = 1f;
        this.scale = s;
        this.colour = c;
        this.step = -4;
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);
    }

    public Windmill(float s, Color c, int st) throws SlickException {
        super("data/image/goldbird.png");
        this.scale = 1f;
        this.scale = s;
        this.colour = c;
        this.step = st;
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);
    }

    public Windmill(float s, int st) throws SlickException {
        super("data/image/goldbird.png");
        this.scale = 1f;
        this.scale = s;
        this.colour = null;
        this.step = st;
        wmSheet = new SpriteSheet("data/image/SmallWindmill.png", 103, 104);
        wm = new Animation(wmSheet, 100);
        wm.setAutoUpdate(false);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
        wm.update(delta);
        if (wm.getFrame() == 6) {
            wm.restart();
        }
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {

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

    @Override
    public boolean isReadyForDisposal() {
        return (x < - image.getWidth()- 100);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
