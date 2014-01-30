package scrollables;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import graphic.*;


/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 28/01/14
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class SecondHills extends Background {

    public SecondHills(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/backgrounds/Hills2a.png", collidable);

        if(type==1) {
            this.setImage("data/image/backgrounds/Hills2a.png");
        }
        if(type==2) {
            this.setImage("data/image/backgrounds/Hills2b.png");
        }
        if(type==3) {
            this.setImage("data/image/backgrounds/Hills2c.png");
        }
        if(type==4) {
            this.setImage("data/image/backgrounds/Hills2d.png");
        }

    }

}
