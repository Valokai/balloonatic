package game;

import com.aem.sticky.button.Button;
import com.aem.sticky.button.SimpleButton;
import com.aem.sticky.button.events.ClickListener;
import graphic.Background;
import graphic.TextGraphic;
import handlers.SceneHandler;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
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
public class SettingsState extends BasicGameState implements ClickListener {

    private ButtonManager btnManager;
    private Background background;
    private ParticleManager particleManager = new ParticleManager();
    private TextGraphic titleText, difficultyText, musicText, miniBalloonDiff,  miniBalloonMusic ;

    private StateBasedGame stateBasedGame;
    private GameContainer gameContainer;

    @Override
    public int getID() {
        return Game.STATE.SETTINGS;
    }

    @Override
    public void init(GameContainer gameContainer, final StateBasedGame stateBasedGame) throws SlickException {
        this.stateBasedGame = stateBasedGame;
        this.gameContainer = gameContainer;

        titleText= new TextGraphic(400, 200, "data/image/text/settings.png");
        difficultyText = new TextGraphic(350, 300, "data/image/text/difficulty.png");
        musicText = new TextGraphic(600, 300, "data/image/text/music.png");

        miniBalloonDiff = new TextGraphic(250, 420, "data/image/balloon.png");
        miniBalloonDiff.setScale(.5f);

        miniBalloonMusic = new TextGraphic(580, 370, "data/image/balloon.png");
        miniBalloonMusic.setScale(.5f);

        btnManager = new ButtonManager(this);
        btnManager.addButton(80, 360, "data/buttons/learnerText_1.png", "data/buttons/learnerText_2.png", "data/sound/critical.ogg", "btnLearner");
        btnManager.addButton(80, 410, "data/buttons/pilotText_1.png", "data/buttons/pilotText_2.png", "data/sound/critical.ogg", "btnPilot");
        btnManager.addButton(80, 460, "data/buttons/balloonaticText_1.png", "data/buttons/balloonaticText_2.png", "data/sound/critical.ogg", "btnHard");

        btnManager.addButton(500, 360, "data/buttons/on_1.png", "data/buttons/on_2.png", "data/sound/critical.ogg", "btnSoundOn");
        btnManager.addButton(500, 410, "data/buttons/off_1.png", "data/buttons/off_2.png", "data/sound/critical.ogg", "btnSoundOff");

        background = new Background(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT, "data/image/staticBackground.png", false);

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
        difficultyText.render(gameContainer, graphics);
        miniBalloonDiff.render(gameContainer, graphics);
        miniBalloonMusic.render(gameContainer,graphics);
        musicText.render(gameContainer, graphics);
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
        if (clicked == btnManager.getById("btnSoundOn")) {
            miniBalloonMusic.setY(370f);
            //do something to affect difficulty
        }

        if (clicked == btnManager.getById("btnSoundOff")) {
            miniBalloonMusic.setY(420f);
            //do something to affect difficulty

        }

        if (clicked == btnManager.getById("btnHard")) {
            miniBalloonDiff.setY(470f);
            //do something to affect difficulty

        }

        if (clicked == btnManager.getById("btnHard")) {
            miniBalloonDiff.setY(360f);
            //do something to affect difficulty

        }

        if (clicked == btnManager.getById("btnHard")) {
            miniBalloonDiff.setY(410f);
            //do something to affect difficulty

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
