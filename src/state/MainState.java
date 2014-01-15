package state;

import backgrounds.Backgrounds;
import backgrounds.*;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 15/01/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainState extends BasicGameState {

    private Image skyimage;
    private ArrayList<Backgrounds> frontground = new ArrayList<Backgrounds>();
    private ArrayList<Backgrounds> backgrounds = new ArrayList<Backgrounds>();
    float currentFrontX = 0, currentFrontY = 0;
    int imageCount;




    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        frontground.add(new HillsOne(0.0f,100.0f));
        //frontground.add(new HillsOne(3900.0f,0.0f));
        backgrounds.add(new HillsTwo(0.0f,100.0f));
        backgrounds.add(new HillsTwo(3900.0f,100.0f));


        skyimage = new Image("data/sprite/sky.png");


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);

        for(int i = 0; i<backgrounds.size(); i++) {
            backgrounds.get(i).render();
        }

        for(int i = 0; i<frontground.size(); i++) {
            frontground.get(i).render();
        }

        graphics.drawString("image x: " + currentFrontX,0,0);
        graphics.drawString("images: " + imageCount, 0,20);


    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        float deltaTime = delta /1000;
        backgrounds.get(0).move(deltaTime -3, 0);
        backgrounds.get(1).move(deltaTime -3, 0);

        frontground.get(0).move(deltaTime -10, 0);

        currentFrontX = frontground.get(0).getX();
        imageCount = frontground.size();


        if(frontground.get(0).getX() == -2800) {
            frontground.add(new HillsOne(1100,100));
        }
        if(frontground.get(0).getX() < -2800.0) {
            frontground.get(1).move(deltaTime -10, 0);
        }
        if(frontground.get(0).getX() == -4000.0) {
            frontground.remove(0);
        }



    }
}
