package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;

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
    private Image skyimage;



    @Override
    public int getID() {
        return Game.STATE.HISCORE;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        skyimage = new Image("data/image/sky.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        skyimage.draw();
        graphics.drawString("HIGH SCORES",
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 4f);


        graphics.drawString(
                highScore,
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 3.5f + 80.0f);


        graphics.drawString(
                "Press any key...",
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 1.1f);
    }

    // Called when we enter this game state, a good place to variables to initial values if needed
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        anyKeyPressed = false;
        setHighScore(MainGame.SBoard.displayScore());
    }

    // Event called on key down, we just flag that a key was pressed, and let the update handle it from there
    public void keyPressed(int key, char c)
    {
        anyKeyPressed = true;
    }


    public void setHighScore(String highScores)
    {
        highScore = highScores;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException
    {
        if (anyKeyPressed)
        {
            stateBasedGame.enterState(Game.STATE.MENU, new CombinedTransition(), new BlobbyTransition());
        }
    }
}

