package state;

import backgrounds.*;
import entities.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


import java.util.ArrayList;

public class MainState extends BasicGameState {

    private Image skyimage;
    private BackgroundHandler frontground, background;
    Balloon balloon;




    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        frontground = new BackgroundHandler("frontground", new FrontHills(0.0f,0));
        background = new BackgroundHandler("background", new BGHills(0.0f,0));

        frontground.add(new FrontHills(0.0f,0));
        frontground.add(new BGHills(0.0f,0));


        background.add(new BGHills(0.0f,0));


        /*draw blue background, always active*/
        skyimage = new Image("data/sprite/sky.png");
        balloon = new Balloon(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {





        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);

        background.render();
        frontground.render();

        background.printStats(graphics, 0, 0);
        frontground.printStats(graphics, 200, 0);
        balloon.printStats(graphics, 400, 0);



        balloon.render();


    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        float deltaTime = delta /1000;
        Input input = gc.getInput();


       // frontground.update(deltaTime-5, 0);
        backgroundMove(frontground, deltaTime-5, 0);
        backgroundMove(background, deltaTime-2, 0);

        //background.update(deltaTime- 2, 0);

        balloon.update(gc, delta);

        if(balloon.getY() > 800 || balloon.getY() < 0){
            balloon.reset(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f)  ;
        }

    }

    public void backgroundMove(BackgroundHandler bg, float x, float y) {
       // if(balloon.getY() < 200 && balloon.getY() > -1000 && balloon.getSpeed() < 0) {
            bg.update(x, y);
           // return;
       // }
       // if(balloon.getY() < 200 && balloon.getY() > -1000 && balloon.getSpeed() > 0) {
         //   bg.update( x, y-4, balloon);
        //    return;
      //  }
       // if(balloon.getY() > 200) {
       //     bg.update(x, y, balloon);
        //    return;
       // }

    }

}
