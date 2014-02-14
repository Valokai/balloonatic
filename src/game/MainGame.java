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

    public static int SCREEN_WIDTH = 1280;
    public static int SCREEN_HEIGHT = 720;

    private static String OS = System.getProperty("os.name").toLowerCase();

    public MainGame() {
        super(Game.TITLE);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new MenuState());
        addState(new MainState());
        addState(new HighScoreState());
        addState(new EnterNameState());
        addState(new SettingsState());
        addState(new StoryState());
        enterState(Game.STATE.MENU);
    }

    // Main entry point for the game, set up the app and its window etc u
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new MainGame());
        if (OS.indexOf("mac") >= 0){
            app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
        }else{
            app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, true);
        }
        app.setVSync(Game.VSYNC);
        app.setShowFPS(false);
        app.start();
    }
}