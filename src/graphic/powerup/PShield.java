package graphic.powerup;

import graphic.Balloon;
import graphic.BalloonEffect;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 5/02/14
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class PShield extends Powerup implements BalloonEffect{

    private Circle circle;

    private int invisibleInterval;

    private int counter;



    public PShield() throws SlickException {
        super("data/image/shield.png");
        this.invisibleInterval = 600;
    }

    @Override
    public void render(GameContainer gc, Graphics graphics) {
        super.render(gc, graphics);
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        balloon.addBalloonEffect(this, "shield");
        sceneHandler.removeSceneObject(this);
    }

    @Override
    public void drawOnBalloon(Balloon balloon, Graphics graphics) {
        balloon.setLockLife(true);
        balloon.setRenderLock(false);
        circle = new Circle(balloon.getX(), balloon.getY(), balloon.getImage().getHeight()/2 + 10);
        Color color = graphics.getColor();
        graphics.setColor(new Color(45, 45, 45, 50));
        graphics.fill(circle);
        graphics.setColor(color);
        counter ++;
        if(counter == invisibleInterval){
            balloon.removeBalloonEffect("shield");
            balloon.setLockLife(false);
        }
    }
}
