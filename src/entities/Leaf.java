package entities;

import state.MainGame;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 22/01/14
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Leaf extends SceneObject {

    public Leaf(String imagePath) {
        super(imagePath);
        image = image.getScaledCopy(0.5f);
    }

    public Leaf(float x, float y, String imagePath) {
        super(x, y, imagePath);
        image = image.getScaledCopy(0.5f);
    }

    public Leaf(String imagePath, boolean isCollidable) {
        super(imagePath, isCollidable);
        image = image.getScaledCopy(0.5f);
    }

    public Leaf(float x, float y, String imagePath, boolean isCollidable) {
        super(x, y, imagePath, isCollidable);
        image = image.getScaledCopy(0.5f);
    }

    @Override
    public void move(int delta) {
        float amplitude = randomizer.nextInt(8)/2f;
        y += delta * randomizer.nextInt(8)/100f;
        y += (float) (amplitude * Math.sin(Math.toDegrees(x/800)));
        x += delta * randomizer.nextInt(20)/100f;
        image.rotate(randomizer.nextFloat());
    }

    @Override
    public boolean isOutofScreen() {
        return (y > MainGame.SCREEN_HEIGHT);
    }
}
