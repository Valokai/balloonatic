package graphic;

import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 31/01/14
 * Time: 12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class FuelGaugeCover extends Sprite{

    public FuelGaugeCover() throws SlickException {
        super("data/image/fuelPointer.png");
    }



    /**render the image
     *
     */
    public void render(){
        image.drawCentered(x, y);
    }
}
