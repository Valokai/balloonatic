package state;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 14/01/14
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainGame extends StateBasedGame {

    public static final int SCREEN_WIDTH = 1024;
    public static final int SCREEN_HEIGHT = 800;

    public MainGame() {
        super("Balloonatic");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    // Main entry point for the game, set up the app and its window etc
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new MainGame());
        app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
        app.setVSync(true);
        app.setShowFPS(false);
        app.start();
    }
}
