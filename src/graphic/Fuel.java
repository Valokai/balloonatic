package graphic;

import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fuel extends SceneObject {

    public Fuel() throws SlickException {
        super("data/image/fuelStatic.png", true);
    }
    @Override
    public void move(int delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isReadyForDisposal() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
