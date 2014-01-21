package backgrounds;
import entities.Balloon;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaterFront extends Background {

    public WaterFront(float x, float y) {
        super(x, y, "data/sprite/water-first.png", "data/sprite/water-first-collide.png");
        try {
            collisionImage = new Image("data/sprite/water-first-collide.png") ;
        } catch (SlickException e){
            e.printStackTrace();
        }
    }
}
