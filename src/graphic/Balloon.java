package graphic;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.SlickException;
import org.newdawn.slick.*;

/**
 * Balloon Sprite, Player of the game
 */
public class Balloon extends Sprite{

    private float speed;


    protected Balloon() throws SlickException {
        super("data/sprite/balloon.png");
    }

    public Balloon(float x, float y) throws SlickException {
        super(x, y, "data/sprite/balloon.png");
        setSpeed(0);
    }

    public void reset(float x, float y) {
        setX(x);
        setY(y);
        setSpeed(0);
    }

    public void setSpeed(float speed){
        this.speed = speed;
    }

    public float getSpeed(){
        return speed;
    }

    public void move(float offsetX, float offsetY){
        setX(getX() + offsetX);
        setY(getY() + offsetY);
    }






}
