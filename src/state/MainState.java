package state;

import backgrounds.BGHills;
import backgrounds.Background;
import backgrounds.BackgroundHandler;
import backgrounds.FrontHills;
import entities.Balloon;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.io.IOException;

public class MainState extends BasicGameState {

    private Image skyimage;
    private BackgroundHandler frontground, background;
    private Balloon balloon;
    private ParticleSystem particleSystem;
    private ParticleEmitter particleEmitter;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        initBackground();
        initPlayer();
        initParticle();

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        renderBackground(graphics);
        renderPlayer(graphics);
        renderParticle();

    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        updateBackground(delta);
        updatePlayer(gc, delta);
        updateParticle(delta);
    }

    public void initBackground() throws SlickException {
        frontground = new BackgroundHandler("frontground");
        frontground.add(new FrontHills(0.0f,0, false));
        frontground.add(new BGHills(0.0f,0, false));

        background = new BackgroundHandler("background");
        background.add(new BGHills(0.0f,0, false));
        skyimage = new Image("data/sprite/sky.png");
    }

    public void renderBackground(Graphics graphics){
        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);

        background.render(graphics);
        frontground.render(graphics);

        background.printStats(graphics, 0, 0);
        frontground.printStats(graphics, 200, 0);
    }

    public void updateBackground(int delta){
        float deltaTime = delta /1000;
        frontground.update(deltaTime - 5, 0);
        background.update(deltaTime - 2, 0);
    }

    public void initPlayer(){
        balloon = new Balloon(MainGame.SCREEN_WIDTH / 4.0f, MainGame.SCREEN_HEIGHT / 2.0f);
    }

    public void renderPlayer(Graphics graphics){
        balloon.printStats(graphics, 400, 0);
        balloon.render(graphics);
    }

    public void updatePlayer(GameContainer gc, int delta){
        balloon.update(gc, delta);
    }

    public void initParticle() throws SlickException {
        try {
            //load the test particle and
            Image image = new Image("data/particles/test_particle.png", false);
            particleSystem = new ParticleSystem(image,1500);

            File xmlFile = new File("data/particles/test_emitter.xml");
            particleEmitter = ParticleIO.loadEmitter(xmlFile);
            particleSystem.addEmitter(particleEmitter);
            particleSystem.setPosition(0, MainGame.SCREEN_HEIGHT/2);
            particleSystem.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateParticle(int delta){
        particleSystem.update(delta);
    }

    public void renderParticle(){
        particleSystem.render();
    }

}
