package state;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainState extends BasicGameState {

    private Rectangle rectangle;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        rectangle = new Rectangle(0, 0, 200, 200);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        rectangle.setLocation(200, 200);
        graphics.setColor(Color.red);
        graphics.fill(rectangle);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
