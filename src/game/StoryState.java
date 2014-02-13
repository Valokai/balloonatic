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
public class StoryState extends BasicGameState implements ClickListener {

    private ButtonManager btnManager;
    private Background background;
    private ParticleManager particleManager = new ParticleManager();
    Font font = new TrueTypeFont(new java.awt.Font("Tahoma", 1, 36), true);

    private StateBasedGame stateBasedGame;

    @Override
    public int getID() {
        return Game.STATE.STORY;
    }

    @Override
    public void init(GameContainer gameContainer, final StateBasedGame stateBasedGame) throws SlickException {
        this.stateBasedGame = stateBasedGame;




        btnManager = new ButtonManager(this);


        btnManager.addButton(350, 620, "data/buttons/back_1.png", "data/buttons/back_2.png", "data/sound/critical.ogg", "btnBack");

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
        graphics.setColor(new Color(0,0,0,0.3f));
        graphics.fillRect(60,130,790,450);
        graphics.setColor(Color.white);
        font.drawString(70,150, "The International Balloonatic Challenge");
        font.drawString(70,200, "is an annual event where Balloonatics");
        font.drawString(70,250, "challenge themselves against the harsh");
        font.drawString(70,300, "terrain.");
        font.drawString(70,400, "Diago is the reigning champion, it ");
        font.drawString(70,450, "is up to you to beat him.");
        font.drawString(70,500, "Are you a true Ballonatic?");





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

        if (clicked == btnManager.getById("btnBack")) {
            stateBasedGame.enterState(Game.STATE.MENU, new CombinedTransition(), new BlobbyTransition());

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
