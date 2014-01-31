package game;

import graphic.*;
import handlers.SceneHandler;
import handlers.ScrollingHandler;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;
import scrollables.BackHills;
import scrollables.GreenHills;
import scrollables.SecondHills;
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
    private ScrollingHandler frontground, background, backlayer;

    private SceneHandler sceneHandler = SceneHandler.getInstance();

    private Balloon balloon;


    private ParticleManager particleManager = new ParticleManager();
    private Sprite fuelGagueCover;
    private Sprite fuelGague;

    @Override
    public int getID() {
        return Game.STATE.MAIN;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        frontground = new ScrollingHandler("frontground", new GreenHills(0.0f,0,true,1)); //create front collidable scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 2)); //add more map to the front scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 3)); //add more map to the front scrollable
        frontground.add(new GreenHills(0.0f, 0, true, 4)); //add more map to the front scrollable

        background = new ScrollingHandler("background", new BackHills(0.0f,0,false,1)); //create front collidable scrollable
        background.add(new BackHills(0.0f, 0, false, 2)); //add more map to the front scrollable
        background.add(new BackHills(0.0f,0,false,3)); //add more map to the front scrollable
        background.add(new BackHills(0.0f,0,false,4)); //add more map to the front scrollable

        balloon = (Balloon) sceneHandler.spawn(280, 200, Balloon.class, "balloon");
        fuelGague = new FuelGauge();
        fuelGague.setX(40);
        fuelGague.setY(400);

        fuelGagueCover = new FuelGaugeCover();
        fuelGagueCover.setX(40);
        fuelGagueCover.setY(200);

        sceneHandler.spawn(280, 200, Leaf.class, "leaf");
        backlayer = new ScrollingHandler("background", new SecondHills(0.0f,0,false,1)); //create back non collidable scrollable
        backlayer.add(new SecondHills(0.0f, 0, false, 2)); //add more map to the back scrollable
        backlayer.add(new SecondHills(0.0f, 0, false, 3)); //add more map to the back scrollable
        backlayer.add(new SecondHills(0.0f, 0, false, 4)); //add more map to the back scrollable
        skyimage = new Image("data/image/sky.png");

        particleManager.addParticle("data/particles/emitter.xml", "data/particles/particle.png");
        particleManager.addParticle("data/particles/emitter_fast.xml", "data/particles/particle.png");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);
        background.render(gameContainer, graphics);
        backlayer.render(gameContainer, graphics);
        particleManager.render(graphics);
        frontground.render(gameContainer, graphics);   //render the frontground scrollables


        sceneHandler.render(gameContainer, graphics);    //render the balloon        balloon.printStats(graphics, 400, 0);   //error checking, print stats of ballon
        frontground.printStats(graphics, 200, 0, balloon);  //error checking of frontground scrollable

        if(balloon.isCollided(sceneHandler.getSceneObjectById("leaf"))){
            graphics.drawString("Collided", 500, 300);
        }

        //render fuel
        graphics.drawString("Lives: "+balloon.getLives(), 850, 0);
        //render score
        graphics.drawString("Distance: "+(int)frontground.getDistance()+"m",1000,0);

        //The fuel gauge stuff
        fuelGague.draw(20, 100, 50, 550);
        fuelGagueCover.draw(20, 150+(500 - balloon.getFuel()/2), 50, 8);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        float deltaTime = delta /1000;
        float scrollDeltaTime = (delta / 1000) ;
        backgroundMove(background, scrollDeltaTime-1, 0, stateBasedGame);
        backgroundMove(backlayer, scrollDeltaTime-2, 0, stateBasedGame);
        backgroundMove(frontground, scrollDeltaTime-4, 0, stateBasedGame); //update the front scrollable
        sceneHandler.update(gameContainer, delta);
        particleManager.upate(delta);


        if(balloon.getLives() <= 0){
            EnterNameState enterNameState = (EnterNameState)stateBasedGame.getState(Game.STATE.ENTERNAME);
            enterNameState.setScore((int)(frontground.getDistance()));
            stateBasedGame.enterState(Game.STATE.ENTERNAME, new CombinedTransition(), new BlobbyTransition());
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
