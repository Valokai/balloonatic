package state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameState extends BasicGameState {
    int stateId = -1;

    Image background = null;




    public GameState(int stateId)
    {
        this.stateId = stateId;
    }



    @Override
    public int getID()
    {
        return stateId;
    }


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        // Load required resources
        try
        {
            background = new Image("data/images/cw2.png");
        }
        catch (SlickException e)
        {
            System.out.println("Unable to load resources");
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException
    {
    }


}
