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
        super("data/image/balloon.png", true);
    }

    public Balloon(float x, float y) throws SlickException {
        super(x, y, "data/image/balloon.png",true);
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

    public void update(GameContainer gameContainer, int delta){
        float deltaTime = delta / 1000.0f;
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
