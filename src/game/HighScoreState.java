package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;
import util.GameFont;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class HighScoreState extends BasicGameState {
    boolean anyKeyPressed = false;
    String highScore = null;
    private GameFont fieldfont = null;
    private GameFont scorefont = null;
    private StateBasedGame mainGame;


    @Override
    public int getID() {
        return Game.STATE.HISCORE;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        mainGame = stateBasedGame;
        fieldfont = new GameFont("data/fonts/AbadiMTCondensed.fnt", "data/fonts/AbadiMTCondensed.png");
        scorefont = new GameFont("data/fonts/Corbel16.fnt", "data/fonts/Corbel16.png");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        mainGame.getState(Game.STATE.MAIN).render(gameContainer, stateBasedGame, graphics);

        graphics.setColor(new Color(0,0,0,0.3f));
        graphics.fillRect(0,0,1280,720);

        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 4f,
                "HIGH SCORES",
                GameFont.Alignment.CENTRE,
                Color.black);


        scorefont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 3.5f + 80.0f,
                highScore,
                GameFont.Alignment.CENTRE,
                Color.orange
        );


        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 1.1f,
                "Press any key...",
                GameFont.Alignment.CENTRE,
                Color.black
        );
    }

    // Called when we enter this game state, a good place to variables to initial values if needed
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        anyKeyPressed = false;
        setHighScore(Game.SBoard.displayScore());
    }

    // Event called on key down, we just flag that a key was pressed, and let the update handle it from there
    public void keyPressed(int key, char c) {
        anyKeyPressed = true;
    }


    public void setHighScore(String highScores) {
        highScore = highScores;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (anyKeyPressed) {
            stateBasedGame.enterState(Game.STATE.MENU, new CombinedTransition(), new BlobbyTransition());
        }
    }
}


