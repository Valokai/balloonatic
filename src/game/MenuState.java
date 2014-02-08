package game;

import com.aem.sticky.button.Button;
import com.aem.sticky.button.events.ClickListener;
import graphic.Background;
import graphic.TextGraphic;
import handlers.SceneHandler;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;
import util.ButtonManager;
import util.ParticleManager;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 29/01/14
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuState extends BasicGameState implements ClickListener {

    private ButtonManager btnManager;
    private Background background;
    public static  Music bGM = null;
    private ParticleManager particleManager = new ParticleManager();
    private TextGraphic titleText;

    private StateBasedGame stateBasedGame;
    private GameContainer gameContainer;

    @Override
    public int getID() {
        return Game.STATE.MENU;
    }

    @Override
    public void init(GameContainer gameContainer, final StateBasedGame stateBasedGame) throws SlickException {
        bGM = new Music("data/sound/field/fieldbgm.ogg");

        this.stateBasedGame = stateBasedGame;
        this.gameContainer = gameContainer;

        btnManager = new ButtonManager(this);
        btnManager.addButton(130, 280, "data/buttons/PressToStart_1.png", "data/buttons/PressToStart_2.png", "data/sound/critical.ogg", "btnStart");
        btnManager.addButton(140, 365, "data/buttons/cheatCode_1.png", "data/buttons/cheatCode_2.png", "data/sound/critical.ogg", "btnCheckpoint");
        btnManager.addButton(140, 455, "data/buttons/Settings_1.png", "data/buttons/Settings_2.png", "data/sound/critical.ogg", "btnSettings");
        btnManager.addButton(140, 540, "data/buttons/Quit_1.png", "data/buttons/Quit_2.png", "data/sound/critical.ogg", "btnQuit");
        background = new Background(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT, "data/image/staticBackground.png", false);
        titleText = new TextGraphic(350, 150, "data/image/text/Balloonatic.png");


        if(Game.music){
            bGM.loop();
        }
        particleManager.addParticle("data/particles/emitter.xml", "data/particles/particle.png");
    }


    @Override
    public void enter(GameContainer gameContainer, final StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.render(gameContainer, graphics);
        particleManager.render(graphics);
        btnManager.render(gameContainer, graphics);
        titleText.render(gameContainer, graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        background.update(gameContainer, delta);
        particleManager.upate(delta);
        btnManager.update(gameContainer, delta);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);
        btnManager.mouseClicked(button, x, y, clickCount);
    }

    @Override
    public void onClick(Button clicked, float mx, float my) {
        if (clicked == btnManager.getById("btnQuit")) {
            gameContainer.exit();
        }

        if (clicked == btnManager.getById("btnCheckpoint")) {
            stateBasedGame.enterState(Game.STATE.ENTERCHEATCODE, new CombinedTransition(), new BlobbyTransition());
        }

        if (clicked == btnManager.getById("btnSettings")) {
            stateBasedGame.enterState(Game.STATE.SETTINGS, new CombinedTransition(), new BlobbyTransition());
        }
    }

    @Override
    public void onRightClick(Button clicked, float mx, float my) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onDoubleClick(Button clicked, float mx, float my) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        if (key == Input.KEY_SPACE) {
            stateBasedGame.enterState(Game.STATE.MAIN, new CombinedTransition(), new BlobbyTransition());
        }
    }
}
