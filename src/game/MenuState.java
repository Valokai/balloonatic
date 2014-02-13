package game;

import com.aem.sticky.button.Button;
import com.aem.sticky.button.events.ClickListener;
import graphic.Background;
import graphic.TextGraphic;
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
    public static Music bGM = null;
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
        this.stateBasedGame = stateBasedGame;
        this.gameContainer = gameContainer;
        bGM = new Music("data/sound/field/fieldbgm.ogg");
        btnManager = new ButtonManager(this);
        btnManager.addButton(130, 300, "data/buttons/PressToStart_1.png", "data/buttons/PressToStart_2.png", "data/sound/critical.ogg", "btnStart");
        btnManager.addButton(140, 400, "data/image/text/Story.png", "data/image/text/Story.png", "data/sound/critical.ogg", "btnStory");
        btnManager.addButton(140, 500, "data/buttons/Settings_1.png", "data/buttons/Settings_2.png", "data/sound/critical.ogg", "btnSettings");
        btnManager.addButton(140, 600, "data/buttons/Quit_1.png", "data/buttons/Quit_2.png", "data/sound/critical.ogg", "btnQuit");
        //btnManager.addButton(140, 150, "data/buttons/CheatCode_1.png", "data/buttons/CheatCode_1.png", "data/sound/critical.ogg", "btnStory");
        background = new Background(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT, "data/image/staticBackground.png", false);
        titleText = new TextGraphic(350, 150, "data/image/text/Balloonatic.png");

        particleManager.addParticle("data/particles/emitter.xml", "data/particles/particle.png");
        if(Game.music){
            bGM.loop();
        }

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
        if (clicked == btnManager.getById("btnStart")) {
            stateBasedGame.enterState(Game.STATE.MAIN, new CombinedTransition(), new BlobbyTransition());
        }
        if (clicked == btnManager.getById("btnSettings")) {
            stateBasedGame.enterState(Game.STATE.SETTINGS, new CombinedTransition(), new BlobbyTransition());
        }
        if (clicked == btnManager.getById("btnStory")) {
            stateBasedGame.enterState(Game.STATE.STORY, new CombinedTransition(), new BlobbyTransition());
        }
    }

    @Override
    public void onRightClick(Button clicked, float mx, float my) {
    }

    @Override
    public void onDoubleClick(Button clicked, float mx, float my) {
    }

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        if (key == Input.KEY_SPACE) {
            stateBasedGame.enterState(Game.STATE.MAIN, new CombinedTransition(), new BlobbyTransition());
        }
        if (key == Input.KEY_ESCAPE) {
            gameContainer.exit();
        }
    }

}
