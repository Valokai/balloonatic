package graphic;

import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class FuelGauge extends Sprite {

    public FuelGauge() throws SlickException {
        super("data/image/fuelGauge.png");
    }



    /**render the image
     *
     */
    public void render(){
        image.getScaledCopy(50,50).drawCentered(x, y);
    }
}
