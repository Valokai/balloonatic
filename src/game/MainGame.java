package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

/**
 * User: Tin Htoo Aung
 * Date: 14/01/14
 * Time: 1:25 PM
 */

/**
 * Starter class fo the game
 */
public class MainGame extends StateBasedGame {

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    private static String OS = System.getProperty("os.name").toLowerCase();

    public MainGame() {
        super(Game.TITLE);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (OS.indexOf("mac") >= 0) {
            SCREEN_WIDTH = gd.getDisplayMode().getWidth();
            SCREEN_HEIGHT = gd.getDisplayMode().getHeight();
        } else {
            SCREEN_WIDTH = 1280;
            SCREEN_HEIGHT = 720;
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new MenuState());
        addState(new MainState());
        addState(new HighScoreState());
        addState(new EnterNameState());
        addState(new EnterCheatcodeState());
        addState(new SettingsState());
        addState(new StoryState());
        enterState(Game.STATE.MENU);
    }

    // Main entry point for the game, set up the app and its window etc u
    public static void main(String[] args) throws SlickException {

        AppGameContainer app = new AppGameContainer(new MainGame());
        app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
        app.setVSync(Game.VSYNC);
//        app.setFullscreen(true);
        //app.setShowFPS(Game.DEBUG.SHOW_FPS);
        app.setShowFPS(false);
        app.start();
    }
}