package handlers;


import game.MainGame;
import graphic.Background;
import graphic.Balloon;
import graphic.DeadPlayer;
import graphic.powerup.PBird;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import util.BirdFormations;
import util.ScoreBoard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class ScrollingHandler {

    private ArrayList<Background> renderlist, bglist;   //renderlist for images to render, bg list is list of all images
    private String name;    //the name of this scrollable, eg Foreground
    int count = 1;   //count for controlling renderlist and bglist
    private boolean collider = false, collider2 = false;    //two booleans for collisions for when two images are rendered
    private float distance = 0;
    private Random random = new Random();
    private BirdFormations birdformations = new BirdFormations();
    private boolean DeadPlayersSpawned = false;

    private SceneHandler sceneHandler = SceneHandler.getInstance();

    /**constructor, initializes variables
     *
     * @param name       name of this object
     * @param firstbackground  the first image in the list
     */
    public ScrollingHandler(String name, Background firstbackground) {
        renderlist = new ArrayList<Background>();
        bglist = new ArrayList<Background>();
        renderlist.add(firstbackground);
        bglist.add(firstbackground);
        this.name = name;
    }

    /**add a new scrollable sprite to this scrollable
     *
     * @param bg  background you want to add to this scrollable
     */
    public void add(Background bg) {
        bglist.add(bg);
    }


    /**print the stats for error checking
     *
     * @param g
     * @param x
     * @param y
     * @param balloon
     */
    public void printStats(Graphics g, int x, int y, Balloon balloon) {
        //g.drawString(this.name, x, y);
        //g.drawString("bglist: " + bglist.size(), x, y+20);
        //g.drawString("renderlist: " + renderlist.size(), x, y+40);
        // g.drawString("PosX(0): " + renderlist.get(0).getX(), x, y+60);
        // g.drawString("count: " + count, x, y+80);

        if(renderlist.size()>1 && renderlist.get(0).getX()<-2120) {
            if(renderlist.get(1).isCollidable()) { //if its collidable, check for collide
                renderlist.get(1).checkCollide(name, renderlist.get(1).getX(), renderlist.get(1).getY(), g, balloon, 400, (name.equals("background")) ? 400 : 500);
                collider2 = renderlist.get(1).isColliding();
            }
        }
        else {
            if(renderlist.get(0).isCollidable()) {    //if its collidable, check for collide
                renderlist.get(0).checkCollide(name, renderlist.get(0).getX(), renderlist.get(0).getY(), g, balloon, 400, (name.equals("background")) ? 400 : 500);
                collider = renderlist.get(0).isColliding();
            }
        }

    }

    public float getDistance(){
        return distance;
    }

    /**renders all the images in the renderlist
     *
     */
    public void render(GameContainer gameContainer, Graphics graphics) {
        for(int i = 0; i<renderlist.size(); i++) {
            renderlist.get(i).render(gameContainer, graphics);
        }
        sceneHandler.render(gameContainer, graphics);

    }

    /**updates image locations, sets new images to be rendered, recycles images for infinite loop
     *
     * @param moveX   amount to move the x-coordinate by
     * @param moveY   amount to move the y-coordinate by
     * @param balloon original balloon object needed for collision
     */
        public void update(float moveX, float moveY, Balloon balloon, StateBasedGame stateBasedGame) {


        if (DeadPlayersSpawned == false){
            spawnDeadPlayers();
            DeadPlayersSpawned = true;
        }


        renderlist.get(0).move(moveX, moveY);

        /*calculate the balloons horizontal movement if it's the collidable frontground */
        if (name.equals("frontground")){
//            distance -= moveX / 100;
            distance -= moveX / 10;
        }

        if(((Math.random() * 9000) + 1000) / 1000.0 > 9.98) {      //chance to spawn a bird formation
           spawnBirds();
        }

        /*handles the images, loads the next one when needed and rsemoves the previous when not needed*/
        if(renderlist.get(0).getX() == -1000.0) {
            renderlist.add(bglist.get(count));
            Background backgroundHill = renderlist.get(1);
            backgroundHill.resetToEnd();
            count++;

        }
        if(renderlist.get(0).getX() < -1000.0) {
            renderlist.get(1).move(moveX, moveY);
        }

        if(renderlist.get(0).getX() == -2600.0) {
            renderlist.remove(0);
        }

        if(count == bglist.size()) {
            count = 0;
        }
        //if(collider && name.equals("frontground") || collider2) balloon.reset(280,100);
        if(renderlist.size()==2 && renderlist.get(0).getX() <= -2120 && name.equals("frontground")) {
            if(collider2) {
                balloon.setLives(0);  //decrease the lives because they collide*/
                if(balloon.isLockLife()) {
                    balloon.reset(280,150);
                }
                return;
            }

        }  else {
            if(collider) {
                balloon.setLives(0);
                if(balloon.isLockLife()) {
                    balloon.reset(280,150);
                }
            }
        }

    }

    public void spawnBirds() {
        for (Vector2f coordinate : birdformations.getRandomBirdFormation((random.nextFloat() * 1300) + 0, (random.nextFloat() * 420) + 0)) {
            sceneHandler.spawn(coordinate.getX(), coordinate.getY(), PBird.class);
        }
    }

     public void spawnDeadPlayers() {
         for (int i = 0; i < MainGame.SBoard.scores.size(); i++){
             System.err.println(MainGame.SBoard.showScore(i));
             sceneHandler.spawn(MainGame.SBoard.showScore(i)*10+280,650, DeadPlayer.class);
         }

     }

}
