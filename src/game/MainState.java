package game; backlayer = new ScrollingHandler("background", new BackHills(0.0f,0,false,1)); //create back non collidable scrollable
        backlayer.add(new BackHills(0.0f, 0, false, 2)); //add more map to the back scrollable
        backlayer.add(new BackHills(0.0f, 0, false, 3)); //add more map to the back scrollable
        backlayer.add(new BackHills(0.0f, 0, false, 4)); //add more map to the back scrollable

import graphic.Balloon;
import graphic.Leaf;
import handlers.SceneHandler;
import handlers.ScrollingHandler;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import scrollables.BackHills;
import scrollables.GreenHills;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainState extends BasicGameState {

    private Image skyimage;

    /*the scrollable foreground and backgrounds*/
    private ScrollingHandler frontlayer, midlayer, backlayer;

    private SceneHandler sceneHandler = SceneHandler.getInstance();

    private Balloon balloon;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        frontlayer = new ScrollingHandler("frontground", new GreenHills(0.0f,0,true,1)); //create front collidable scrollable
        frontlayer.add(new GreenHills(0.0f, 0, true, 1)); //add more map to the front scrollable

        midlayer = new ScrollingHandler("midlayer", new SecondHills(0.0f,0,false,1));
        midlayer.add(new SecondHills(0.0f,0,false,2));
        midlayer.add(new SecondHills(0.0f,0,false,3));
        midlayer.add(new SecondHills(0.0f,0,false,4));

       balloon = (Balloon) sceneHandler.spawn(280, 100, Balloon.class, "balloon");
        sceneHandler.spawn(280, 200, Leaf.class, "leaf");
		 backlayer = new ScrollingHandler("background", new BackHills(0.0f,0,false,1)); //create back non collidable scrollable
        backlayer.add(new BackHills(0.0f, 0, false, 2)); //add more map to the back scrollable
        backlayer.add(new BackHills(0.0f, 0, false, 3)); //add more map to the back scrollable
        backlayer.add(new BackHills(0.0f, 0, false, 4)); //add more map to the back scrollable        skyimage = new Image("data/image/sky.png");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);

sceneHandler.render(gameContainer, graphics);    //render the balloon
/*render the scrollable layers*/
        backlayer.render();
        midlayer.render();
        frontlayer.render();

        balloon.printStats(graphics, 400, 0);   //error checking, print stats of ballon
        frontlayer.printStats(graphics, 200, 0, balloon);  //error checking of frontground scrollable

        if(balloon.isCollided(sceneHandler.getSceneObjectById("leaf"))){
            graphics.drawString("Collided", 500, 300);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        float deltaTime = delta /1000;
        backgroundMove(backlayer, deltaTime-1, 0);
        backgroundMove(midlayer, deltaTime-2, 0);
        backgroundMove(frontlayer, deltaTime-4, 0); //update the front scrollable
        sceneHandler.update(gameContainer, delta);
    }

    /*moves the background, separate method for clarity*/
    public void backgroundMove(ScrollingHandler bg, float x, float y) {
        bg.update(x, y, balloon);
    }


}
