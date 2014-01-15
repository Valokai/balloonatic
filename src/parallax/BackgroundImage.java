package parallax;

import state.MainGame;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BackgroundImage extends ParallaxImage {

    public BackgroundImage(double x, double y, double movementRate, String imageFile) {
        super(x, y, movementRate, imageFile);
    }

    @Override
    public void drawInfinityImage(Camera camera) {
        sprite.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);
    }
}
