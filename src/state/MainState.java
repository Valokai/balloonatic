package state;

import backgrounds.BGHills;
import backgrounds.Background;
import backgrounds.BackgroundHandler;
import backgrounds.FrontHills;
import entities.Balloon;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainState extends BasicGameState {

    private Image skyimage;
    private BackgroundHandler frontground, background;
    Balloon balloon;
    Balloon balloon2;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        frontground = new BackgroundHandler("frontground", new FrontHills(0.0f,0, false));
        background = new BackgroundHandler("background", new BGHills(0.0f,0, false));

        frontground.add(new FrontHills(0.0f,0, false));
        frontground.add(new BGHills(0.0f,0, false));


        background.add(new BGHills(0.0f,0, false));


        /*draw blue background, always active*/
        skyimage = new Image("data/sprite/sky.png");
        balloon = new Balloon(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f);
        balloon2 = new Balloon(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f + 100);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);

        background.render(graphics);
        frontground.render(graphics);

        background.printStats(graphics, 0, 0);
        frontground.printStats(graphics, 200, 0);
        balloon.printStats(graphics, 400, 0);
        balloon.render(graphics);
        balloon2.render(graphics);

//        for (Background background1 : frontground.getRenderlist()) {
//            String stats = (balloon.isCollided(background1)) ? "collided" : "";
//            graphics.drawString("Balloon & FrontHill Collision : " + stats, 0, 100);
//        }

        String stats = (balloon.isCollided(balloon2)) ? "collided" : "";
        graphics.drawString("Balloon & FrontHill Collision : " + stats, 0, 100);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        float deltaTime = delta /1000;
        backgroundMove(frontground, deltaTime-5, 0);
        backgroundMove(background, deltaTime-2, 0);
        balloon.update(gc, delta);
//        balloon2.update(gc, delta);
        if(balloon.getY() > 800 || balloon.getY() < 0){
            balloon.reset(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f)  ;
        }

    }

    public void backgroundMove(BackgroundHandler bg, float x, float y) {
        bg.update(x, y);
    }

}
