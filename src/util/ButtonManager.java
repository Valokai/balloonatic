package util;

import com.aem.sticky.button.SimpleButton;
import com.aem.sticky.button.events.ClickListener;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 30/01/14
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class ButtonManager {

    private Map<String, SimpleButton> buttons = new HashMap<String, SimpleButton>();

    private ClickListener clickListener;

    public ButtonManager(ClickListener listener){
        this.clickListener = listener;
    }

    public void addButton(int x, int y, String btnPathNormalState, String btnPathHoverState, String oggPath, String id) throws SlickException {
        Image normal = new Image(btnPathNormalState);
        normal = normal.getScaledCopy(0.8f);
        Image hover = new Image(btnPathHoverState);
        hover = hover.getScaledCopy(0.8f);
        Shape shape = new Rectangle(x, y, normal.getWidth(), normal.getHeight());
        SimpleButton simpleButton = new SimpleButton(shape, normal, hover, new Sound(oggPath));
        simpleButton.addListener(clickListener);
        buttons.put(id, simpleButton);
    }

    public void update(GameContainer gameContainer, int delta){
        for (String s : buttons.keySet()) {
            buttons.get(s).update(gameContainer, delta);
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics){
        for (String s : buttons.keySet()) {
            buttons.get(s).render(gameContainer, graphics);
        }
    }

    public void mouseClicked(int button, int x, int y, int clickCount) {
        for (String s : buttons.keySet()) {
            buttons.get(s).mouseClicked(button, x, y, clickCount);
        }
    }

    public SimpleButton getById(String id){
        return buttons.get(id);
    }
}
