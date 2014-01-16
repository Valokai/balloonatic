package backgrounds;

import entities.Sprite;
import org.newdawn.slick.GameContainer;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Background extends Sprite {

    public Background(String imagePath, boolean isCollidable) {
        super(imagePath, isCollidable);
    }

    public Background(float x, float y, String imagePath, boolean isCollidable) {
        super(x, y, imagePath, isCollidable);
    }

    public void resetToEnd() {
        this.x = 1400.0f;
        this.y = 0;
    }

    @Override
    public void render() {
        image.draw(x, y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {}

}
