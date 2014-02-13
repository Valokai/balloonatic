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
public class Birds extends Background {

    private int type;

    public Birds(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/hazards/birds1.png", "data/image/hazards/birds1-map.png", collidable);
        this.type = type;

        if (type == 1) {
            this.setImage("data/image/hazards/birds1.png");
            this.setCollisionImage("data/image/hazards/birds1-map.png");
        }
        if (type == 2) {
            this.setImage("data/image/hazards/birds2.png");
            this.setCollisionImage("data/image/hazards/birds2-map.png");
        }
        if (type == 3) {
            this.setImage("data/image/hazards/birds3.png");
            this.setCollisionImage("data/image/hazards/birds3-map.png");
        }
        if (type == 4) {
            this.setImage("data/image/hazards/birds4.png");
            this.setCollisionImage("data/image/hazards/birds4-map.png");
        }

    }

}
