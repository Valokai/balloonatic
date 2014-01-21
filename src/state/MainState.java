package state;

import backgrounds.*;
import entities.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


import java.util.ArrayList;

public class MainState extends BasicGameState {

    private Image skyimage;
    private BackgroundHandler frontground, background, thirdground;
    Balloon balloon;
    float distance = 0;
    //two of each to emulate memory usage, can change because won't have loop of same background in original
    Background fronthills,fronthills2, bghills,bghills2, cavefront,cavefront2, cavesecond, cavesecond2, waterfront,waterfront2, watersecond,watersecond2;




    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        //maps
        fronthills = new FrontHills(0.0f, 0);
        fronthills2 = new FrontHills(0.0f, 0);
        bghills = new BGHills(0.0f, 0);
        bghills2 = new BGHills(0.0f, 0);
        cavefront = new CaveFront(0.0f, 0);
        cavefront2 = new CaveFront(0.0f, 0);
        cavesecond = new CaveSecond(0.0f, 0);
        cavesecond2 = new CaveSecond(0.0f, 0);
        waterfront = new WaterFront(0.0f, 0);
        waterfront2 = new WaterFront(0.0f, 0);
        watersecond = new WaterSecond(0.0f, 0);
        watersecond2 = new WaterSecond(0.0f, 0);

        frontground = new BackgroundHandler("frontground", fronthills);
        //frontground = new BackgroundHandler("frontground", new BrightHills(0.0f,0));
        background = new BackgroundHandler("background", bghills);

        frontground.add(fronthills2);
        frontground.add(fronthills);
        frontground.add(fronthills2);
        frontground.add(fronthills);

        //second scenario
        frontground.add(cavefront);
        frontground.add(cavefront2);
        frontground.add(cavefront);
        frontground.add(cavefront2);
        frontground.add(cavefront);

        //third scenario
        frontground.add(waterfront2);
        frontground.add(waterfront);
        frontground.add(waterfront2);
        frontground.add(waterfront);
        frontground.add(waterfront2);



        background.add(bghills2);

        //second scenario
        background.add(cavesecond);
        background.add(cavesecond2);

        //third scenario
        background.add(watersecond);
        background.add(watersecond2);


        /*draw blue background, always active*/
        skyimage = new Image("data/sprite/sky.png");
        balloon = new Balloon(280, 100);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);

        background.render();
        frontground.render();




        //frontground.

        balloon.render();

        balloon.printStats(graphics, 400, 0);
        background.printStats(graphics, 0, 0, balloon);
        frontground.printStats(graphics, 200, 0, balloon);
        graphics.drawString("Disance: " + distance + "m", 800, 0);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        float deltaTime = delta /1000;
        Input input = gc.getInput();


        //frontground.update(deltaTime-5, 0);
        backgroundMove(frontground, deltaTime-5, 0);
        backgroundMove(background, deltaTime-2, 0);

        //background.update(deltaTime- 2, 0);

        balloon.update(gc, delta);

        if(balloon.getY() > 800 || balloon.getY() < 5    ){
            balloon.reset(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f)  ;
        }
        distance = balloon.getDistance();

    }

    public void backgroundMove(BackgroundHandler bg, float x, float y) {
        bg.update(x, y, balloon);
    }

}
