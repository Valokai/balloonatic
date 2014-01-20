package backgrounds;

import entities.Balloon;
import entities.Sprite;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Background extends Sprite {
    Image collisionImage;


    public Background(String imagePath) {
        super(imagePath);
    }

    public Background(float x, float y, String imagePath, String collisionImage) {
        super(x, y, imagePath, collisionImage);
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void resetToEnd() {
        this.x = 1400.0f;
        this.y = 0;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    @Override
    public void render() {
        image.draw(x, y);
    }

    public void updateCollisionImage() {
        super.collisionImage = this.collisionImage;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {}



}
