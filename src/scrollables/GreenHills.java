package scrollables;

import graphic.Background;
import graphic.Windmill;
import graphic.Cloud;
import graphic.powerup.PFuel;
import graphic.powerup.PGoldFuel;
import graphic.powerup.PShield;
import handlers.SceneHandler;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.Arrays;
import java.util.List;


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
        this.name = "hills";

        if (type == 1) {
            this.setImage("data/image/backgrounds/Hills3a.png");
            this.setCollisionImage("data/image/backgrounds/Hills3a_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(529.0f + 1400, 510.0f)
            ));
            setWindmillCoordinates(Arrays.asList(
                    new Vector2f(100.0f + 1400, 550.0f)
                    //new Vector2f(2009.0f + 1400, 450.0f)
            ));

            setCloudCoordinates(Arrays.asList(
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400, 20f + (int)(Math.random() * ((100 - 20) + 1))),
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1)))
            ));

        }

        if (type == 2) {
            this.setImage("data/image/backgrounds/Hills3b.png");
            this.setCollisionImage("data/image/backgrounds/Hills3b_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(120.0f + 1400, 450.0f),
                    new Vector2f(1268.0f + 1400, 418.0f)
            ));
            setShieldCoordinates(Arrays.asList(
                    new Vector2f(1400, 353.0f)
            ));
            setWindmillCoordinates(Arrays.asList(
                    new Vector2f(729.0f + 1400, 300.0f),
                    new Vector2f(1029.0f + 1400, 600.0f)
                   // new Vector2f(2009.0f + 1400, 450.0f)
            ));

            setCloudCoordinates(Arrays.asList(
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1))),
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1)))
            ));

        }

        if (type == 3) {
            this.setImage("data/image/backgrounds/Hills3c.png");
            this.setCollisionImage("data/image/backgrounds/Hills3c_mask.png");

           setWindmillCoordinates(Arrays.asList(
                    new Vector2f(0f + 1400, 650.0f)
            ));

            setCloudCoordinates(Arrays.asList(
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1))),
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1)))
            ));
        }

        if (type == 4) {
            this.setImage("data/image/backgrounds/Hills3d.png");
            this.setCollisionImage("data/image/backgrounds/Hills3d_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(1742.0f + 1400, 149.0f)
            ));
            setShieldCoordinates(Arrays.asList(
                    new Vector2f(730.0f + 1400, 650.0f)
            ));

            setWindmillCoordinates(Arrays.asList(
                    new Vector2f(100.0f + 1400, 550.0f)
            ));

            setCloudCoordinates(Arrays.asList(
                new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1))),
                new Vector2f( 0f + (int)(Math.random() * ((1200 - 0) + 1)) + 1400,  0f + (int)(Math.random() * ((100 - 0) + 1)))
            ));
        }

        if (type == 5) {
            this.setImage("data/image/backgrounds/Hills3e.png");
            this.setCollisionImage("data/image/backgrounds/Hills3e_mask.png");
            setShieldCoordinates(Arrays.asList(
                    new Vector2f(990.0f + 1400, 353.0f)
            ));

            setWindmillCoordinates(Arrays.asList(
                    new Vector2f(100.0f + 1400, 550.0f),
                    new Vector2f(2009.0f + 1400, 650.0f)
            ));

            setCloudCoordinates(Arrays.asList(
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1))),
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1)))
            ));
        }

        if (type == 6) {
            this.setImage("data/image/backgrounds/Hills3f.png");
            this.setCollisionImage("data/image/backgrounds/Hills3f_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(1385.0f + 1400, 343.0f)
            ));
            //setGoldCoordinates(Arrays.asList(
            //        new Vector2f(529.0f + 1400, 210.0f)
            //));

            /*setWindmillCoordinates(Arrays.asList(
                    new Vector2f(100.0f + 1400, 550.0f),
                    new Vector2f(2009.0f + 1400, 450.0f)
            ));*/

            setCloudCoordinates(Arrays.asList(
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1))),
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1)))
            ));
        }

        if (type == 7) {
            this.setImage("data/image/backgrounds/Hills3g.png");
            this.setCollisionImage("data/image/backgrounds/Hills3g_mask.png");
            setCoordinates(Arrays.asList(
                    new Vector2f(2385.0f + 1400, 343.0f)
            ));

            /*setWindmillCoordinates(Arrays.asList(
                    new Vector2f(100.0f + 1400, 550.0f),
                    new Vector2f(2009.0f + 1400, 450.0f)
            )); */

            setCloudCoordinates(Arrays.asList(
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1))),
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1))),
                    new Vector2f( 0f + (int)(Math.random() * ((1000 - 0) + 1)) + 1400,  20f + (int)(Math.random() * ((100 - 20) + 1)))
            ));
        }
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
        for (Vector2f coordinate : windmillCoordinates) {
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), Windmill.class);
        }
        for (Vector2f coordinate : cloudCoordinates) {
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), Cloud.class);
        }

        for (Vector2f coordinate : shieldCoordinates) {
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), PShield.class);
        }

    }
}
