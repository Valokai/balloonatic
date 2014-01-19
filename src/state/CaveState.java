package state;

import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CaveState extends BasicGameState {

   public static int stateId = -1;


    public CaveState(int stateId)
    {
        this.stateId = stateId;
    }

    @Override
    public int getID() {
        return stateId;
    }

    private StateBasedGame mainGame; // We keep a copy of this so that we can access it during key and mouse events


    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException
    {
        mainGame = game;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException
    {

        mainGame.getState(MainState.stateId).render(container, game, g);
        g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        g.fillRect(0, 0, container.getWidth(), container.getHeight());
    }



    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException
    {
        mainGame.getState(MainState.stateId).update(container,game,delta);
    }

    public void enter(GameContainer container, StateBasedGame game)
            throws SlickException
    {
    }

    public void keyReleased(int key, char c)
    {
    }
}

