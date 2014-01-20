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

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        initBackground();
        balloon = new Balloon(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f);

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

    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        float deltaTime = delta /1000;
        backgroundMove(frontground, deltaTime-5, 0);
        backgroundMove(background, deltaTime-2, 0);
        balloon.update(gc, delta);

    }

    public void backgroundMove(BackgroundHandler bg, float x, float y) {
        bg.update(x, y);
    }

    public void initBackground() throws SlickException {
        frontground = new BackgroundHandler("frontground");
        frontground.add(new FrontHills(0.0f,0, false));
        frontground.add(new BGHills(0.0f,0, false));

        background = new BackgroundHandler("background");
        background.add(new BGHills(0.0f,0, false));
        skyimage = new Image("data/sprite/sky.png");
    }

}
