package graphic;

import org.newdawn.slick.SlickException;

/**
 * Nick Meek
 * Date: 07/02/14
 * To make static graphic objects, title text etc.
 */
public class TextGraphic extends Sprite {

    public TextGraphic(float x, float y, String path) throws SlickException {
        super(x, y, path);
    }

    /**
     * render the image
     */
    public void render() {
        image.drawCentered(x, y);
    }
}