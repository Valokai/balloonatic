package entities;

import org.newdawn.slick.Graphics;
import state.MainGame;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 22/01/14
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class SceneObjectManager {

    private List<SceneObject> register = new ArrayList<SceneObject>();
    private List<SceneObject> collector = new ArrayList<SceneObject>();
    private static SceneObjectManager INSTANCE;
    private int spawnInterval = 5000;
    private float finishedTime;

    public static SceneObjectManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SceneObjectManager();
        }
        return INSTANCE;
    }

    public SceneObjectManager() {}

    public void addSceneObject(SceneObject sceneObject){
        register.add(sceneObject);
    }

    public void respwan() {
        for (SceneObject sceneObject : collector) {
            sceneObject.setX(sceneObject.randomizer.nextInt(50));
            sceneObject.setY(sceneObject.randomizer.nextInt(MainGame.SCREEN_HEIGHT));
        }
        collector.clear();
    }

    public void update(int delta){
        for (SceneObject sceneObject : register) {
            if(!sceneObject.isOutofScreen()){
                sceneObject.move(delta);
            }else{
                collector.add(sceneObject);
            }
        }
        if(new Random().nextInt(100    ) == 3){
            respwan();
        }
    }

    public void render(Graphics graphics){
        for (SceneObject sceneObject : register) {
            if(!sceneObject.isOutofScreen()){
                sceneObject.render(graphics);
            }
        }

    }


}
