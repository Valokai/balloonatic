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
public class BackHills extends Background {

    public BackHills(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/backgrounds/Hills1a.png", false);

        if(type==1) {
            this.setImage("data/image/backgrounds/Hills1a.png");
        }
        if(type==2) {
            this.setImage("data/image/backgrounds/Hills1b.png");
        }
        if(type==3) {
            this.setImage("data/image/backgrounds/Hills1c.png");
        }
        if(type==4) {
            this.setImage("data/image/backgrounds/Hills1d.png");
        }

    }

}
