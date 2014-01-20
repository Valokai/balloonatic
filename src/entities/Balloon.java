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
    Image biggrad = null;
    Image lilgrad = null;
    Image grad = null;

    public Balloon() throws SlickException {
        super("data/images/balloon-small.png");
        biggrad = new Image("data/images/balloongrad.png");
        lilgrad = new Image("data/images/balloongrad2.png");
        grad = new Image("data/images/balloongrad2.png");
        setSpeed(0);
    }

    public Balloon(float x, float y) throws SlickException {
        super(x, y, "data/images/balloon-small.png");
        biggrad = new Image("data/images/balloongrad.png");
        lilgrad = new Image("data/images/balloongrad2.png");
        grad = new Image("data/images/balloongrad2.png");
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
        grad.draw(x-400,y-1250);
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
    }

    private void updatePlayer(float deltaTime, Input input)
    {
        if (input.isKeyDown(Input.KEY_SPACE))
        {
            setSpeed(getSpeed() - (deltaTime * 500.0f));
            move(0.0f, getSpeed() * deltaTime);
            grad = biggrad;
        }
        else
        {
            setSpeed(getSpeed() + (deltaTime * 500.0f));
            move(0.0f, getSpeed() * deltaTime);
            grad = lilgrad;
        }
    }


}
