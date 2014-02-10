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
import scrollables.Birds;
import scrollables.GreenHills;
import scrollables.SecondHills;
import util.GameFont;
import util.ParticleManager;


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
    private ScrollingHandler frontground, background, backlayer;//, birdlayer;

    private SceneHandler sceneHandler;

    private Balloon balloon;

    private ParticleManager particleManager = new ParticleManager();
    private Sprite fuelGagueCover;
    private Sprite fuelGague;
    private boolean introduction = true;

    Font font = new TrueTypeFont(new java.awt.Font("Tahoma", 4, 36), false);

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


        //birdlayer = new ScrollingHandler("birds", new Birds(0.0f, 0, true, 1));
        //birdlayer.add(new Birds(0.0f, 0, true, 2));
        //birdlayer.add(new Birds(0.0f, 0, true, 3));
        //birdlayer.add(new Birds(0.0f, 0, true, 4));

        skyimage = new Image("data/image/sky.png");


        particleManager.addParticle("data/particles/emitter.xml", "data/particles/particle.png");
        particleManager.addParticle("data/particles/emitter_fast.xml", "data/particles/particle.png");
        introduction = true;

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {


        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);
        background.render(gameContainer, graphics);
        backlayer.render(gameContainer, graphics);
        particleManager.render(graphics);
//        birdlayer.render(gameContainer, graphics);
        frontground.render(gameContainer, graphics);   //render the frontground scrollables


        sceneHandler.render(gameContainer, graphics);    //render the balloon        balloon.printStats(graphics, 400, 0);   //error checking, print stats of ballon
        frontground.printStats(graphics, 200, 0, balloon);  //error checking of frontground scrollable
        //birdlayer.printStats(graphics, 400, 0, balloon);  //error checking of frontground scrollable

        //render fuel
        //graphics.drawString("Lives: "+balloon.getLives(), 850, 0);
        //graphics.drawString("Balloon y: "+balloon.getY(), 850, 0);



        /*
        MainGame.titleFont.drawString(
                20,
                70,
                "Lives: " + balloon.getLives(),
                GameFont.Alignment.LEFT,
                Color.yellow);
         */

        //render score
        String dist = String.format("%4d", (int) frontground.getDistance());
        MainGame.titleFont.drawString(
                20,
                100,
                "Distance : " + dist,
                GameFont.Alignment.LEFT,
                Color.yellow);

        graphics.drawString("Slain Birds: " + balloon.getBirdCounter(), 600, 0);

        //The fuel gauge stuff

        fuelGague.draw(0,80,90,590);
        fuelGagueCover.draw(20,150 + (500 - balloon.getFuel()/2), 50, 8);

        if(introduction) {


            graphics.setFont(font);
            graphics.setColor(new Color(0,0,0,0.3f));
            graphics.fillRect(0,0,1280,720);

            graphics.setColor(Color.white);
            graphics.drawString("Hold space to go up.", 400, 200.0f);
        }



    }







    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        if(introduction) {
            Input input = gameContainer.getInput();
            if(input.isKeyDown(Input.KEY_SPACE)) {
                introduction = false;
            }

        } else {

            float deltaTime = delta / 1000;

            float speedMultiplier = 1f;
            sceneHandler.update(gameContainer, delta, speedMultiplier);
            backgroundMove(background,  -(1 * speedMultiplier), 0, stateBasedGame);
            backgroundMove(backlayer, -(2 * speedMultiplier), 0, stateBasedGame);
            //backgroundMove(birdlayer, deltaTime - (5 * speedMultiplier), 0 , stateBasedGame);
            backgroundMove(frontground, -(4 * speedMultiplier), 0, stateBasedGame); //update the front scrollable


            //particleManager.upate(delta);


            if (balloon.getLives() <= 0) {
                balloon.stopBurner();
                EnterNameState enterNameState = (EnterNameState) stateBasedGame.getState(Game.STATE.ENTERNAME);
                enterNameState.setScore((int) (frontground.getDistance()));
                stateBasedGame.enterState(Game.STATE.ENTERNAME, new CombinedTransition(), new BlobbyTransition());
            }

            fuelGague.update(gameContainer, delta); // really bad practice but I just wanted to get it working for now, see git notes.
        }

    }

    /*moves the background, separate method for clarity*/
    public void backgroundMove(ScrollingHandler bg, float x, float y, StateBasedGame sbg) {
        bg.update(x, y, balloon, sbg);
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        init(container, game);
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
        super.leave(container, game);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
