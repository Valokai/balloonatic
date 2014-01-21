package entities;

import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Balloon extends Sprite{

    float loonspeed;
    float gameTime = 0.0f;
    float distance =0;

    public Balloon() {
        super("data/images/balloon-small.png");
        setSpeed(0);
    }

    public Balloon(float x, float y) {
        super(x, y, "data/images/balloon-small.png", "data/images/balloon-small.png");
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
        image.drawCentered(x, y);
    }

    public void printStats(Graphics g, int x, int y) {
        g.drawString("Balloon X: " + getX(), x, y);
        g.drawString("Balloon Y: " + getY(), x, y+20);
        g.drawString("Speed: " + getSpeed(), x, y+40);

    }

    public void update(GameContainer gameContainer, int delta){
        float deltaTime = delta / 1000.0f;
        gameTime += deltaTime;

        Input input = gameContainer.getInput();

        updatePlayer(deltaTime, input);
        distance++;
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

    public float getDistance() {
        return distance;
    }



}
