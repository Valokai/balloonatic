package game;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;
import util.GameFont;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 31/01/14
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnterNameState extends BasicGameState {
    boolean anyKeyPressed = false;
    private StateBasedGame mainGame;
    TextField field = null;
    int score = 0;
    String name;
    private GameFont fieldfont = null;


    @Override
    public int getID() {
        return Game.STATE.ENTERNAME;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        mainGame = stateBasedGame;
        fieldfont = new GameFont("data/fonts/AbadiMTCondensed.fnt", "data/fonts/AbadiMTCondensed.png");


        field = new TextField(gameContainer,
                fieldfont,
                MainGame.SCREEN_WIDTH / 2 - 100,
                MainGame.SCREEN_HEIGHT / 2 - 40,
                200,
                80);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        mainGame.getState(Game.STATE.MAIN).render(gameContainer, stateBasedGame, graphics);


        graphics.setColor(new Color(0,0,0,0.2f));
        graphics.fillRect(0,0,1280,720);

        graphics.setColor(Color.orange);
        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                100,
                "You have crashed!",
                GameFont.Alignment.CENTRE,
                Color.red);

        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                250,
                "Your Distance: " + score,
                GameFont.Alignment.CENTRE,
                Color.black);



        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                500,
                "Enter Name",
                GameFont.Alignment.CENTRE,
                Color.black);


        field.render(gameContainer, graphics);


        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 1.1f,
                "Press Enter...",
                GameFont.Alignment.CENTRE,
                Color.black);
    }

    // Called when we enter this game state, a good place to variables to initial values if needed
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        anyKeyPressed = false;
        field.setFocus(true);

        field.setConsumeEvents(false);

    }

    public void leave(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        field.setFocus(false);
    }

    // Event called on key down, we just flag that a key was pressed, and let the update handle it from there
    public void keyPressed(int key, char c) {
        if (key == 28) {  //checks if enter key pressed
            anyKeyPressed = true;
        }
    }


    public void setScore(int scoreNum) {
        score = scoreNum;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (anyKeyPressed) {
            Game.SBoard.addScore(field.getText(), score);
            stateBasedGame.enterState(Game.STATE.HISCORE, new CombinedTransition(), new BlobbyTransition());

        }
    }
}



