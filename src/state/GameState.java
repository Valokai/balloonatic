package state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import entities.Balloon;
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
    Balloon balloon = null;

    float gameTime = 0.0f;




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
            background = new Image("data/images/cw2.jpg");
        }
        catch (SlickException e)
        {
            System.out.println("Unable to load resources");
        }



        balloon = new Balloon();
        balloon.Reset(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f);
        balloon.setSpeed(0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException
    {
        float deltaTime = delta / 1000.0f;
        gameTime += deltaTime;

        Input input = gameContainer.getInput();

        updatePlayer(deltaTime, input);
    }


    private void updatePlayer(float deltaTime, Input input)
    {
        if (input.isKeyDown(Input.KEY_SPACE))
        {
            balloon.setSpeed(balloon.getSpeed() - (deltaTime * 50.0f));
            balloon.move(0.0f, balloon.getSpeed() * deltaTime);
        }
        else
        {
            balloon.setSpeed(balloon.getSpeed() + (deltaTime * 50.0f));
            balloon.move(0.0f, balloon.getSpeed() * deltaTime);
        }
    }




    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        background.draw(0.0f, 0.0f, 1280.0f, 800.0f);
        balloon.render();
    }


}
