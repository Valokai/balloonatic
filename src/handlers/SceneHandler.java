package handlers;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 28/01/14
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */

import game.Game;
import graphic.SceneObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.*;

/**
 * This singleton class serves as a handler for all sceneobjects. It is responsible to
 * <ul>
 *     <li>Spwan Scene Object</li>
 *     <li>Maintain the life cycle of each scene object</li>
 *     <li>Detect Collision</li>
 * </ul>
 */
public class SceneHandler {

    /**
     * Instance of this class.
     */
    private static SceneHandler INSTANCE;

    /**
     * A set of all scene object registered to this handler.
     */
    private volatile Map<String, SceneObject> registeredSceneObjects = new HashMap<String, SceneObject>();

    /**
     * keys of scene object marked to be disposed.
     */
    private volatile List<String> disposedSceneObjects = new ArrayList<String>();          

    static{
        INSTANCE = new SceneHandler();
    }

    /**
     * Get SceneHandler Instance
     * @return SceneHandler instance
     */
    public static SceneHandler getInstance(){
        return INSTANCE;
    }

    /**
     * Default Constructor
     */
    public SceneHandler() {
    }

    /**
     * Spwan a given sceneobject at given x,y fuelCoordinates
     * @param x x position of scene object to be spawned
     * @param y y position of scene object to be spawned
     * @param clazz class decedanded from SceneObject to be spwaned (this class must have default constructor)
     * @param id id for sceneobject to be spawned
     */
    public SceneObject spawn(float x, float y, Class<? extends SceneObject> clazz, String id){
        SceneObject sceneObject = null;
        try {
            sceneObject = clazz.newInstance();
            registerSceneObject(id, sceneObject);
            sceneObject.setX(x);
            sceneObject.setY(y);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sceneObject;
    }

    /**
     * Spwan a given sceneobject at given x,y fuelCoordinates
     * @param x x position of scene object to be spawned
     * @param y y position of scene object to be spawned
     * @param clazz class decedanded from SceneObject to be spwaned (this class must have default constructor)
     */
    public SceneObject spawn(float x, float y, Class<? extends SceneObject> clazz){
        SceneObject sceneObject = null;
        try {
            sceneObject = clazz.newInstance();
            registerSceneObject(String.valueOf(sceneObject.hashCode()), sceneObject);
            sceneObject.setX(x);
            sceneObject.setY(y);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sceneObject;
    }

    /**
     * Update handler
     * @param delta
     */
    public void update(GameContainer gameContainer, int delta, float speedMultiplier){
        SceneObject sceneObject;
        for (String key : registeredSceneObjects.keySet()) {
            sceneObject = registeredSceneObjects.get(key);
            if(sceneObject.isReadyForDisposal()){
                disposedSceneObjects.add(key);
            }else{
                sceneObject.update(gameContainer, delta);
            }
        }
        for (String key : disposedSceneObjects) {
            registeredSceneObjects.remove(key);
        }
        disposedSceneObjects.clear();
    }

    /**
     * Render SceneObjects
     * @param gc
     * @param graphics
     */
    public void render(GameContainer gc, Graphics graphics){
        for (String key : registeredSceneObjects.keySet()) {
              registeredSceneObjects.get(key).render(gc, graphics);
        }
        printStat(graphics);
    }

    /**
     * Register a sceneObject to this handler
     * @param sceneObject
     */
    public void registerSceneObject(String id, SceneObject sceneObject){
        synchronized (registeredSceneObjects){
            registeredSceneObjects.put(id, sceneObject);
        }
    }

    private void printStat(Graphics graphics){
        graphics.drawString("Number of SO : " + registeredSceneObjects.size(), 10, 30);
    }

    public SceneObject getSceneObjectById(String id){
        return registeredSceneObjects.get(id);
    }

    public void clearAll(){
        registeredSceneObjects.clear();
        disposedSceneObjects.clear();
    }

    public Map<String, SceneObject> getRegisteredSceneObjects() {
        return registeredSceneObjects;
    }

    public void setRegisteredSceneObjects(Map<String, SceneObject> registeredSceneObjects) {
        this.registeredSceneObjects = registeredSceneObjects;
    }

    public void removeSceneObject(SceneObject sceneObject){
        disposedSceneObjects.add(String.valueOf(sceneObject.hashCode()));
    }

    public void removeSceneObjectById(String id){
        disposedSceneObjects.add(id);
    }
}
