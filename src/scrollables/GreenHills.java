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
public class GreenHills extends Background {

    public GreenHills(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/backgrounds/Hills3a.png", "data/image/backgrounds/Hills3a_mask.png", collidable);
        if(type==1) {
            this.setImage("data/image/backgrounds/Hills3a.png");
            this.setCollisionImage("data/image/backgrounds/Hills3a_mask.png");
        }
        if(type==2) {
            this.setImage("data/image/backgrounds/Hills3b.png");
            this.setCollisionImage("data/image/backgrounds/Hills3b_mask.png");
        }
        if(type==3) {
            this.setImage("data/image/backgrounds/Hills3c.png");
            this.setCollisionImage("data/image/backgrounds/Hills3c_mask.png");
        }
        if(type==4) {
            this.setImage("data/image/backgrounds/Hills3d.png");
            this.setCollisionImage("data/image/backgrounds/Hills3d_mask.png");
        }
    }

}
