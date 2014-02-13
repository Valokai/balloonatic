package scrollables;

import graphic.Background;
import org.newdawn.slick.SlickException;


/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 28/01/14
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class CaveSecond extends Background {

    public CaveSecond(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/backgrounds/cave_bg1.png", collidable);

        if (type == 1) {
            this.setImage("data/image/backgrounds/cave_bg1.png");
        }
        if (type == 2) {
            this.setImage("data/image/backgrounds/cave_bg1.png");
        }
        if (type == 3) {
            this.setImage("data/image/backgrounds/cave_bg1.png");
        }
        if (type == 4) {
            this.setImage("data/image/backgrounds/cave_bg1.png");
        }

    }

}
