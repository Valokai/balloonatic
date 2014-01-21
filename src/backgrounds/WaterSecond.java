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
public class WaterSecond extends Background {

    public WaterSecond(float x, float y) {
        super(x, y, "data/sprite/water-second.png", "data/sprite/water-second.png");
        try {
            collisionImage = new Image("data/sprite/water-second.png") ;
        } catch (SlickException e){
            e.printStackTrace();
        }
    }
}
