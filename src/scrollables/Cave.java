package scrollables;

import graphic.Background;
import graphic.powerup.PFuel;
import graphic.powerup.PGoldFuel;
import graphic.powerup.PShield;
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
public class Cave extends Background {

    private int type;

    public Cave(float x, float y, boolean collidable, int type) throws SlickException {
        super(x, y, "data/image/cave/cave_fg1.png", "data/image/cave/cave_fg1_mask.png", collidable);
        this.type = type;
        this.name = "cave";

        if (type == 1) {
            this.setImage("data/image/cave/cave_fg1.png");
            this.setCollisionImage("data/image/cave/cave_fg1_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(529.0f + 1400, 410.0f),
                    new Vector2f(1385.0f + 1400, 343.0f)
            ));
            //setShieldCoordinates(Arrays.asList(
            //        new Vector2f(1400, 353.0f)
            //));
        }

        if (type == 2) {
            this.setImage("data/image/cave/cave_fg_mid1.png");
            this.setCollisionImage("data/image/cave/cave_fg_mid1_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(120.0f + 1400, 350.0f),
                    new Vector2f(1268.0f + 1400, 518.0f)
            ));

        }

        if (type == 3) {
            this.setImage("data/image/cave/cave_fg_mid2.png");
            this.setCollisionImage("data/image/cave/cave_fg_mid2_mask.png");
            setGoldCoordinates(Arrays.asList(

                    new Vector2f(529.0f + 1400, 310.0f)
            ));
        }

        if (type == 4) {
            this.setImage("data/image/cave/cave_fg_exit.png");
            this.setCollisionImage("data/image/cave/cave_fg_exit_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(742.0f + 1400, 449.0f),
                    new Vector2f(1742.0f + 1400, 249.0f)

            ));

        }

        if (type == 5) {
            this.setImage("data/image/backgrounds/Hills3e.png");
            this.setCollisionImage("data/image/backgrounds/Hills3e_mask.png");

        }

        if (type == 6) {
            this.setImage("data/image/backgrounds/Hills3f.png");
            this.setCollisionImage("data/image/backgrounds/Hills3f_mask.png");

        }

        if (type == 7) {
            this.setImage("data/image/backgrounds/Hills3g.png");
            this.setCollisionImage("data/image/backgrounds/Hills3g_mask.png");
            setGoldCoordinates(Arrays.asList(

                    new Vector2f(2200.0f + 1400, 410.0f)
            ));
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
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), PFuel.class);
        }
        for (Vector2f coordinate : goldCoordinates) {
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), PGoldFuel.class);
        }
        for (Vector2f coordinate : shieldCoordinates) {
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), PShield.class);
        }

    }
}
