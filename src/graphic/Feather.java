package graphic;

import game.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import util.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 10/02/14
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Feather extends SceneObject {

    public Feather() throws SlickException {
        super("data/particles/feather.png", false);
        image = image.getScaledCopy(0.12f);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gc, Graphics graphics) {
        super.render(gc, graphics);
    }

    @Override
    public void move(int delta) {
        x -= delta * 0.2;
        y += delta * 0.15 * Utils.randomizer.nextInt(3) - Utils.randomizer.nextInt(2);
        image.setRotation(Utils.randomizer.nextInt(80) - Utils.randomizer.nextInt(40));
    }

    @Override
    public boolean isReadyForDisposal() {
        return (x < 0 || x > Game.SCREEN_WIDTH || y > Game.SCREEN_HEIGHT || y < 0);
    }
}
