package entities;

import org.newdawn.slick.*;

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

    public Balloon()
    {
        try
        {
            loon = new Image("data/images/balloon-small.png");
        }
        catch(SlickException e)
        {
           System.out.println("error loading loon graphic");
        }
    }

    public void Reset(float x, float y)
    {
        loonx = x;
        loony = y;
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


}
