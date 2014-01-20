package entities;

import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 21/01/14
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class BalloonDarkness extends Sprite{

    float loonspeed;
    float gameTime = 0.0f;

    public BalloonDarkness() {
        super("data/images/balloongrad.png");
        setSpeed(0);
    }

    public BalloonDarkness(float x, float y) {
        super(x, y, "data/images/balloongrad.png");
        setSpeed(0);
    }

    public void reset(float x, float y) {
        this.x = x;
        this.y = y;
        loonspeed = 0;
    }

    public void setSpeed(float speed){
        loonspeed = speed;
    }

    public float getSpeed(){
        return loonspeed;
    }

    public void move(float offsetX, float offsetY){
        x += offsetX;
        y += offsetY;
    }

    public void render(){
        image.draw(x-400, y-1250);
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
