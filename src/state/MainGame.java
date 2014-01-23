package state;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class MainGame extends StateBasedGame {

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    public MainGame() {
        super("Balloonatic");
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new MainState());
        enterState(0, new FadeOutTransition(), new FadeInTransition());
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
