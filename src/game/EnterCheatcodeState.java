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
public class EnterCheatcodeState extends BasicGameState {
    int keyNum = -1;
    private StateBasedGame mainMenu;
    TextField field = null;
    String cheatCode;


    String name;
    private GameFont fieldfont = null;


    @Override
    public int getID() {
        return Game.STATE.ENTERCHEATCODE;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        mainMenu = stateBasedGame;
        fieldfont = new GameFont("data/fonts/AbadiMTCondensed.fnt", "data/fonts/AbadiMTCondensed.png");

        field = new TextField(gameContainer,
                fieldfont,
                MainGame.SCREEN_WIDTH / 2 - 300,
                MainGame.SCREEN_HEIGHT / 2 - 40,
                600,
                80);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        mainMenu.getState(Game.STATE.MENU).render(gameContainer, stateBasedGame, graphics);
        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 4f,
                "Enter Cheat Code",
                GameFont.Alignment.CENTRE,
                Color.white);


        field.render(gameContainer, graphics);


        fieldfont.drawString(
                MainGame.SCREEN_WIDTH / 2.0f,
                MainGame.SCREEN_HEIGHT / 1.1f,
                "Press Enter To Confirm Or Esc To Return",
                GameFont.Alignment.CENTRE,
                Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        if (keyNum == 28) {
            //get cheatcode and jump to appropriate point in game
            cheatCode = field.getText();
            // but until then
            stateBasedGame.enterState(Game.STATE.MENU);
        }
        if (keyNum == 1) {
            stateBasedGame.enterState(Game.STATE.MENU);
        }

    }

    // Called when we enter this game state, a good place to variables to initial values if needed
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        field.setFocus(true);
        keyNum = -1;
        field.setConsumeEvents(false);

    }

    public void leave(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        field.setFocus(false);
    }

    // Event called on key down, we just flag that a key was pressed, and let the update handle it from there
    public void keyPressed(int key, char c) {
        if (key > -1) {  //checks if enter key pressed
            keyNum = key;
            System.out.println(keyNum);
        }


    }


}



