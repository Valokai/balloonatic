package game;

import com.aem.sticky.button.Button;
import com.aem.sticky.button.SimpleButton;
import com.aem.sticky.button.events.ClickListener;
import graphic.Background;
import handlers.SceneHandler;
import javafx.scene.effect.Bloom;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import util.ParticleManager;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 29/01/14
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuState extends BasicGameState {

    private SimpleButton btn;
    private Background background;
    private SceneHandler sceneHandler = SceneHandler.getInstance();
    private Music bGM = null;
    private ParticleManager particleManager = new ParticleManager();

    @Override
    public int getID() {
        return Game.STATE.MENU;
    }

    @Override
    public void init(GameContainer gameContainer, final StateBasedGame stateBasedGame) throws SlickException {
        bGM = new Music("data/sound/menu/menuBGM.ogg");
        btn = new SimpleButton(new Rectangle(50, 50, 200, 100), new Image("data/image/balloon.png"), new Image("data/image/balloon2.png"), new Sound("data/sound/critical.ogg"));
        btn.addListener(new ClickListener() {
            @Override
            public void onClick(Button clicked, float mx, float my) {
                stateBasedGame.enterState(Game.STATE.MAIN, new CombinedTransition(), new BlobbyTransition());
            }

            @Override
            public void onRightClick(Button clicked, float mx, float my) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onDoubleClick(Button clicked, float mx, float my) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        background = new Background(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT, "data/image/title.png", false);
        particleManager.addParticle("data/particles/emitter.xml", "data/particles/particle.png");
    }


    @Override
    public void enter(GameContainer gameContainer, final StateBasedGame stateBasedGame) throws SlickException
    {
      bGM.loop();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.render(gameContainer, graphics);
        btn.render(gameContainer, graphics);
        particleManager.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        btn.update(gameContainer, delta);
        background.update(gameContainer, delta);
        particleManager.upate(delta);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);
        btn.mouseClicked(button, x, y, clickCount);
    }
}