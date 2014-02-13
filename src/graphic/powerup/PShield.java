package graphic.powerup;

import game.Game;
import graphic.Balloon;
import graphic.BalloonEffect;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 5/02/14
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class PShield extends Powerup implements BalloonEffect {

    private Image circle = new Image("data/image/bubble.png");

    private int invisibleInterval;

    private int counter;


    public PShield() throws SlickException {
        super("data/image/shield.png");
        this.invisibleInterval = 2500;
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        balloon.addBalloonEffect(this, "shield");
        sceneHandler.removeSceneObject(this);
        Game.AUDIO.SHIELD_POP.play(1,0.8f);
    }


    @Override
    public void drawOnBalloon(Balloon balloon, Graphics graphics) {
        if (!sceneHandler.isPaused()) {
            balloon.setLockLife(true);
            balloon.setRenderLock(false);
            counter++;
            if (counter > 2000) {        //shield blinks when about to expire
                if (counter % 10 == 0) {
                    circle.draw(balloon.getX() - balloon.getImage().getWidth(), balloon.getY() - balloon.getImage().getWidth());
                }
                //counter ++;
            } else {
                circle.draw(balloon.getX() - balloon.getImage().getWidth(), balloon.getY() - balloon.getImage().getWidth());
            }
            if (counter == invisibleInterval) {
                balloon.removeBalloonEffect("shield");
                balloon.setLockLife(false);
                Game.AUDIO.SHIELD_POP.play(1,.8f);
            }
        }
    }

    @Override
    public boolean isDrawnOnFront() {
        return true;
    }
}
