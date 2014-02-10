package graphic.powerup;

import graphic.Balloon;
import graphic.BalloonEffect;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 10/02/14
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class PCharge extends Powerup implements BalloonEffect{

    private Circle circle;
    private int counter;
    private int invisibleInterval = 800;

    public PCharge() throws SlickException {
        super("data/image/charge.png");
        circle = new Circle(0, 0, 50);
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        balloon.addBalloonEffect(this, "charge");
        sceneHandler.removeSceneObject(this);
    }

    @Override
    public void drawOnBalloon(Balloon balloon, Graphics graphics) {
        balloon.setLockLife(false);
        balloon.setRenderLock(false);
        counter ++;
        if(counter > 2000) {        //shield blinks when about to expire
            if(counter%10==0) {
                circle.setX(balloon.getX()-balloon.getImage().getWidth());
                circle.setY(balloon.getY()-balloon.getImage().getWidth());
                graphics.fill(circle);
            }
            //counter ++;
        }
        else {
            circle.setX(balloon.getX()-balloon.getImage().getWidth());
            circle.setY(balloon.getY()-balloon.getImage().getWidth());
            graphics.fill(circle);
        }
        if(counter == invisibleInterval){
            balloon.removeBalloonEffect("charge");
            balloon.setLockLife(false);
        }
    }

    @Override
    public boolean isDrawnOnFront() {
        return false;
    }
}
