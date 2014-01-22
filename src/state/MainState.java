package state;

import backgrounds.BGHills;
import backgrounds.Background;
import backgrounds.BackgroundHandler;
import backgrounds.FrontHills;
import entities.Balloon;
import entities.Leaf;
import entities.SceneObject;
import entities.SceneObjectManager;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import util.GameException;
import util.Particle;
import util.ParticleTransmitter;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MainState extends BasicGameState {

    private Image skyimage;
    private BackgroundHandler frontground, background;
    private Balloon balloon;

    private SceneObjectManager sceneObjectManager;

    private ParticleTransmitter particleTransmitter;
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws GameException {
        initBackground();
        initPlayer();
        initParticle();

        sceneObjectManager = new SceneObjectManager();
        sceneObjectManager.addSceneObject(new Leaf(0, 50, "data/particles/leaf.png"));
        sceneObjectManager.addSceneObject(new Leaf(0, 100, "data/particles/leaf.png"));
        sceneObjectManager.addSceneObject(new Leaf(0, 300, "data/particles/leaf.png"));
        sceneObjectManager.addSceneObject(new Leaf(0, 500, "data/particles/leaf.png"));
        sceneObjectManager.addSceneObject(new Leaf(0, 600, "data/particles/leaf.png"));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        renderBackground(graphics);
        renderPlayer(graphics);
        renderParticle();

        sceneObjectManager.render(graphics);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws GameException {
        updateBackground(delta);
        updatePlayer(gc, delta);
        updateParticle(delta);

        sceneObjectManager.update(delta);
    }

    public void initBackground() throws GameException {
        frontground = new BackgroundHandler("frontground");
        frontground.add(new FrontHills(0.0f,0, false));
        frontground.add(new BGHills(0.0f,0, false));

        background = new BackgroundHandler("background");
        background.add(new BGHills(0.0f,0, false));
        try {
            skyimage = new Image("data/sprite/sky.png");
        } catch (SlickException e) {
            throw new GameException(e.getMessage(), e.getCause());
        }
    }

    public void renderBackground(Graphics graphics){
        skyimage.draw(0, 0, MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT);

        background.render(graphics);
        renderParticle();
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

    public void initParticle() throws GameException {
        particleTransmitter = new ParticleTransmitter();

        Particle windFastParticle = new Particle("data/particles/particle.png", "data/particles/emitter_fast.xml", 1000);
        Particle windSlowParticle = new Particle("data/particles/particle.png", "data/particles/emitter.xml", 2000);

        particleTransmitter.registerParticle(windFastParticle, 0, 0);
        particleTransmitter.registerParticle(windSlowParticle, 0, 0);
    }

    public void updateParticle(int delta){
        particleTransmitter.update(delta);
    }

    public void renderParticle(){
        particleTransmitter.render();
    }

}
