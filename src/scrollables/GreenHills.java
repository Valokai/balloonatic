package scrollables;

import graphic.Background;
import graphic.Leaf;
import graphic.powerup.PLife;
import handlers.SceneHandler;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.Arrays;


/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 28/01/14
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreenHills extends Background {

    private int type;

    public GreenHills(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/backgrounds/Hills3a.png", "data/image/backgrounds/Hills3a_mask.png", collidable);
        this.type = type;
        if(type==1) {
            this.setImage("data/image/backgrounds/Hills3a.png");
            this.setCollisionImage("data/image/backgrounds/Hills3a_mask.png");
            setCoordinates( Arrays.asList(
                    new Vector2f(1036.0f + 1400, 429.0f),
                    new Vector2f(84.0f + 1400, 525.0f),
                    new Vector2f(1136.0f + 1400, 378.0f),
                    new Vector2f(1589.0f + 1400, 437.0f),
                    new Vector2f(2055.0f + 1400, 505.0f),
                    new Vector2f(2307.0f + 1400, 403.0f)
            ));
        }
        if(type==2) {
            this.setImage("data/image/backgrounds/Hills3b.png");
            this.setCollisionImage("data/image/backgrounds/Hills3b_mask.png");
            setCoordinates( Arrays.asList(
                    new Vector2f(1742.0f + 1400, 149.0f),
                    new Vector2f(1268.0f + 1400, 418.0f)
            ));
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void resetToEnd() {
        super.resetToEnd();
        SceneHandler sceneHandler = SceneHandler.getInstance();
        for (Vector2f coordinate : coordinates) {
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), PLife.class);
        }
    }
}
