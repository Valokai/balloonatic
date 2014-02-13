package graphic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class FuelGauge extends Sprite {
    private int fuelstate = 0;
    private float timer = 0;
    Balloon balloon;

    public FuelGauge() throws SlickException {
        super("data/image/fuelGauge.png");
    }

    public FuelGauge(Balloon balloon) throws SlickException {
        super("data/image/fuelGauge.png");
        this.balloon = balloon;
    }

    public void setState(int fuelstate) {
        this.fuelstate = fuelstate;
        timer = 2;
    }


    public void updateImage(GameContainer gameContainer, int delta) {
        if (balloon.getFuelState() == 0) {
            setImage("data/image/fuelGauge.png");
        } else if (balloon.getFuelState() == 1) {
            setImage("data/image/fuelGaugeup.png");
        } else if (balloon.getFuelState() == 2) {
            setImage("data/image/fuelGaugedown.png");
        }
    }


    public void update(GameContainer gameContainer, int delta) {
        updateImage(gameContainer, delta);
    }


    /**
     * render the image
     */
    public void render() {
        image.getScaledCopy(50, 50).drawCentered(x, y);
    }
}
