package state;

import backgrounds.*;
import entities.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


import java.util.ArrayList;

public class MainState extends BasicGameState {

    private Image skyimage;
    private ArrayList<Backgrounds> frontground = new ArrayList<Backgrounds>();
    private ArrayList<Backgrounds> backgrounds = new ArrayList<Backgrounds>();
    float currentFrontX = 0, bgFrontX = 0;
    int imageCount, bgimageCount;
    Balloon balloon;




    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        frontground.add(new HillsOne(0.0f,100.0f));

        backgrounds.add(new HillsTwo(0.0f,100.0f));
        //backgrounds.add(new HillsTwo(3900.0f,100.0f));


        /*draw blue background, always active*/
        skyimage = new Image("data/sprite/sky.png");
        balloon = new Balloon(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f);


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

        /*for error checking*/
        graphics.drawString("image x: " + currentFrontX,0,0);
        graphics.drawString("images: " + imageCount, 0,20);

        graphics.drawString("bgimage x: " + bgFrontX,0,40);
        graphics.drawString("bgimages: " + bgimageCount, 0,60);
        balloon.render();


    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        float deltaTime = delta /1000;

        /*move the background images*/
        backgrounds.get(0).move(deltaTime -2, 0);
        //backgrounds.get(1).move(deltaTime -3, 0);

        bgFrontX = backgrounds.get(0).getX();
        bgimageCount = backgrounds.size();

        /*handles the frontground images, loads the next one when needed and removes the previous when not needed*/
        if(backgrounds.get(0).getX() == -2800.0) {
            backgrounds.add(new HillsTwo(1100,100));
        }
        if(backgrounds.get(0).getX() < -2800.0) {
            backgrounds.get(1).move(deltaTime -2, 0);
        }
        if(backgrounds.get(0).getX() == -4000.0) {
            backgrounds.remove(0);
        }



        /*move the front hills image relative to view*/
        frontground.get(0).move(deltaTime -5, 0);

        /*for error checking, strings at top of window*/
        currentFrontX = frontground.get(0).getX();
        imageCount = frontground.size();


        /*handles the frontground images, loads the next one when needed and removes the previous when not needed*/
        if(frontground.get(0).getX() == -2800) {
            frontground.add(new HillsOne(1100,100));
        }
        if(frontground.get(0).getX() < -2800.0) {
            frontground.get(1).move(deltaTime -5, 0);
        }
        if(frontground.get(0).getX() == -4000.0) {
            frontground.remove(0);
        }
        balloon.update(gc, delta);
    }
}
