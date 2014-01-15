package entities;

import org.newdawn.slick.*;
import state.MainGame;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Balloon {
    Image loon = null;
    float loonx, loony, loonspeed;
    float gameTime = 0.0f;

    public Balloon(float x, float y)
    {
        loonx = x;
        loony = y;
        try
        {
            loon = new Image("data/images/balloon-small.png");
            setSpeed(0);
        }
        catch(SlickException e)
        {
           System.out.println("error loading loon graphic");
        }
    }


    public float getX()
    {
     return loonx;
    }
    public float getY()
    {
        return loony;
    }
    public void setSpeed(float speed)
    {
       loonspeed = speed;
    }
    public float getSpeed()
    {
        return loonspeed;
    }

    public void move(float offsetX, float offsetY)
    {
        loonx += offsetX;
        loony += offsetY;
    }

    public void render()
    {
        loon.drawCentered(loonx, loony);
    }

    public void update(GameContainer gameContainer, int delta){
        float deltaTime = delta / 1000.0f;
        gameTime += deltaTime;

        Input input = gameContainer.getInput();

        updatePlayer(deltaTime, input);
    }

    private void updatePlayer(float deltaTime, Input input)
    {
        if (input.isKeyDown(Input.KEY_SPACE))
        {
            setSpeed(getSpeed() - (deltaTime * 500.0f));
            move(0.0f, getSpeed() * deltaTime);
        }
        else
        {
            setSpeed(getSpeed() + (deltaTime * 500.0f));
            move(0.0f, getSpeed() * deltaTime);
        }
    }


}
