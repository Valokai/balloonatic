package entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import state.MainGame;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 21/01/14
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SceneObject extends Sprite implements Movable {

    public SceneObject(String imagePath) {
        super(imagePath, false);
    }

    public SceneObject(float x, float y, String imagePath) {
        super(x, y, imagePath, false);
        image = image.getScaledCopy(.5f);
    }

    public SceneObject(String imagePath, boolean isCollidable) {
        super(imagePath, isCollidable);
    }

    public SceneObject(float x, float y, String imagePath, boolean isCollidable) {
        super(x, y, imagePath, isCollidable);
    }

    @Override
    public void render(Graphics graphics) {
        image.draw(x, y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        move(delta);
    }


    @Override
    public void move(int delta) {
        y += (float) (new Random().nextInt(8) * Math.sin(Math.toDegrees(x/800)));
        x += delta * 0.02;
        image.rotate(new Random().nextFloat());
    }
}
