package game;

import graphic.*;
import handlers.SceneHandler;
import handlers.ScrollingHandler;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;
import scrollables.BackHills;
import scrollables.Cave;
import scrollables.GreenHills;
import scrollables.SecondHills;
import util.GameFont;
import util.ParticleManager;

import static org.newdawn.slick.util.FontUtils.drawCenter;


/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainState extends BasicGameState {

    private Image skyimage;

    /*the scrollable foreground and backgrounds*/
    private ScrollingHandler frontground, background, backlayer, cavefront, cavesecond;//, birdlayer;
    private SceneHandler sceneHandler;
    private Balloon balloon;
    private Sprite fuelGagueCover;
    private Sprite fuelGague;
    private boolean introduction = true, paused = false;

    Font font = new TrueTypeFont(new java.awt.Font("Tahoma", 1, 36), true);

    @Override
    public int getID() {
        return Game.STATE.MAIN;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        frontground = new ScrollingHandler("frontground", new GreenHills(0.0f, 0, true, 1)); //create front collidable scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 2)); //add more map to the front scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 3)); //add more map to the front scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 4)); //add more map to the front scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 5)); //add more map to the front scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 6)); //add more map to the front scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 7)); //add more map to the front scrollable

        background = new ScrollingHandler("background", new BackHills(0.0f, 0, false, 1)); //create front collidable scrollable
        background.add(new BackHills(0.0f, 0, false, 2)); //add more map to the front scrollable
        background.add(new BackHills(0.0f, 0, false, 3)); //add more map to the front scrollable
        background.add(new BackHills(0.0f, 0, false, 4)); //add more map to the front scrollable

        sceneHandler = SceneHandler.getInstance();
        sceneHandler.clearAll();

        balloon = (Balloon) sceneHandler.spawn(280, 595, Balloon.class, "balloon");
        fuelGague = new FuelGauge(balloon);
        fuelGague.setX(40);
        fuelGague.setY(400);

        fuelGagueCover = new FuelGaugeCover();
        fuelGagueCover.setX(40);
        fuelGagueCover.setY(200);

        backlayer = new ScrollingHandler("background", new SecondHills(0.0f, 0, false, 1)); //create back non collidable scrollable
        backlayer.add(new SecondHills(0.0f, 0, false, 2)); //add more map to the back scrollable
        backlayer.add(new SecondHills(0.0f, 0, false, 3)); //add more map to the back scrollable
        backlayer.add(new SecondHills(0.0f, 0, false, 4)); //add more map to the back scrollable


        frontground.add(new Cave(0.0f, 0, true, 1));  //add more map to the front scrollable
        frontground.add(new Cave(0.0f, 0, true, 2)); //add more map to the front scrollable
        frontground.add(new Cave(0.0f, 0, true, 3)); //add more map to the front scrollable
        frontground.add(new Cave(0.0f, 0, true, 4)); //add more map to the front scrollable

        skyimage = new Image("data/image/sky.png");

        introduction = true;
        paused = false;

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);
        background.render(gameContainer, graphics);
        backlayer.render(gameContainer, graphics);
        frontground.render(gameContainer, graphics);   //render the frontground scrollables
        sceneHandler.render(gameContainer, graphics);    //render the balloon
        frontground.printStats(graphics, 200, 0, balloon);  //error checking of frontground scrollable

        //render score
        String dist = String.format("%4d", (int) frontground.getDistance());
        Game.titleFont.drawString(
                20,
                100,
                "Distance : " + dist + "m",
                GameFont.Alignment.LEFT,
                Color.yellow);

        fuelGague.draw(0, 80, 90, 590);
        fuelGagueCover.draw(20, 150 + (500 - balloon.getFuel() / 2), 50, 8);

        if (introduction) {
            graphics.setFont(font);
            graphics.setColor(new Color(0, 0, 0, 0.1f));
            graphics.fillRect(0, 0, 1280, 720);

            if (paused) {
                drawCenter(font, "PRESS SPACE TO CONTINUE", gameContainer.getWidth() / 2, 280, 50, Color.white);
                drawCenter(font, "PAUSED", gameContainer.getWidth() / 2, 50, 50, Color.red);
                drawCenter(font, "PRESS ESC TO QUIT", gameContainer.getWidth() / 2, 600, 50, Color.red);
            } else {
                graphics.setColor(Color.white);
                graphics.drawString("Hold space to go up.", 450, 280.0f);
                graphics.drawString("The Birds and the Bees deplete your fuel.", 250, 400.0f);
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            if (paused) {
                stateBasedGame.enterState(Game.STATE.MENU, new CombinedTransition(), new BlobbyTransition());
            } else {
                introduction = true;
                paused = true;
                sceneHandler.pause();
            }
        }
        if (introduction) {      //if paused for introduction
            if (input.isKeyDown(Input.KEY_SPACE)) {
                introduction = false;
                paused = false;
                sceneHandler.unpause();
            }
        } else {
            float speedMultiplier = 1f;
            sceneHandler.update(gameContainer, delta, speedMultiplier);

            CrashedBalloon crashedBalloon = (CrashedBalloon) sceneHandler.getSceneObjectById("crashedBalloon");
            if(crashedBalloon != null){
                if(crashedBalloon.isReadyForDisposal()){
                    EnterNameState enterNameState = (EnterNameState) stateBasedGame.getState(game.Game.STATE.ENTERNAME);
                    enterNameState.setScore((int) (frontground.getDistance()));
                    stateBasedGame.enterState(game.Game.STATE.ENTERNAME, new CombinedTransition(), new BlobbyTransition());
                }
            }

            if (balloon.getLives() <= 0) {
                balloon.stopBurner();
                balloon.setOnShake(true);
                if(crashedBalloon == null){
                    sceneHandler.removeSceneObjectById("balloon");
                    sceneHandler.spawn(balloon.getX(), balloon.getY(), CrashedBalloon.class, "crashedBalloon");
                }

            }else {
                backgroundMove(background, -(1 * speedMultiplier), 0, stateBasedGame);
                backgroundMove(backlayer, -(2 * speedMultiplier), 0, stateBasedGame);
                backgroundMove(frontground, -(4 * speedMultiplier), 0, stateBasedGame);
                fuelGague.update(gameContainer, delta); // really bad practice but I just wanted to get it working for now, see git notes.
            }
        }

    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        init(container, game);
    }

    /*moves the background, separate method for clarity*/
    public void backgroundMove(ScrollingHandler bg, float x, float y, StateBasedGame sbg) {
        bg.update(x, y, balloon, sbg);
    }
}
