package graphic;

import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class TextGraphic extends Sprite {

    public TextGraphic(float x, float y, String path) throws SlickException {
        super(x, y, path);
    }



    /**render the image
     *
     */
    public void render(){
        image.drawCentered(x, y);
    }
}