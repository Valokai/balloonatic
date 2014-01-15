package state;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import parallax.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainState extends BasicGameState {

    private ParallaxImage backgroundImage;
    private Camera camera = new Camera(MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);
    private ParallaxWorld world = new ParallaxWorld();
    private Image skyimage, hills1;
    private int hills1x = 0, hills1y = 0;


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        skyimage = new Image("data/sprite/sky.png");
        hills1 = new Image("data/sprite/hills1.png");
        /*
        ParallaxLayer backgroundLayer = world.addLayer(0.0f);
        ParallaxLayer mountainLayer = world.addLayer(0.8f);
//        ParallaxLayer triggerLayer = world.addLayer(1f);

        ArrayList<String> backgroundImages = new ArrayList<String>();
        backgroundImages.add("data/sprite/sky.png");
        backgroundLayer.addBackgroundImage(0, 0, backgroundImages);

        ArrayList<String> mountainLayerImages = new ArrayList<String>();
        mountainLayerImages.add("data/sprite/hills2.png");
        mountainLayer.addImage(0, 0, mountainLayerImages);
        mountainLayer.addImage(0, 0, mountainLayerImages);

//        triggerLayer.addImage(300, 0, "data/sprite/hills1.png");
        */
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        skyimage.draw(0, 0);
        hills1.draw(hills1x, hills1y);
        /*
        world.render(camera);
        graphics.drawString("Camera (x, y): (" + camera.getLookAtX() + ", " + camera.getLookAtY() + ")", 0, 0);
        graphics.drawString("Camera (width,height): ("+ camera.getWidth() + ", " + camera.getHeight() + ")", 0, 15);
        graphics.drawString("Camera Scale : " + camera.getZoom(), 0, 30);
        */
    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        hills1x -= delta * 0.2;
        //hills1y -= delta;
       // double cameraSpeed = 200.0;

        // delta is in milliseconds, so divide by 1000 and update our
        // game time, which is stored in seconds
        //float deltaTime = delta / 1000.0f;
        //camera.lookAt(camera.getLookAtX() + cameraSpeed * deltaTime, camera.getLookAtY());
    }
}
