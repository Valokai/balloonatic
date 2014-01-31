package handlers;


import game.Game;
import graphic.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import game.MainGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;

import java.util.ArrayList;

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
        g.drawString(this.name, x, y);
        g.drawString("bglist: " + bglist.size(), x, y+20);
        g.drawString("renderlist: " + renderlist.size(), x, y+40);
        g.drawString("PosX(0): " + renderlist.get(0).getX(), x, y+60);
        g.drawString("count: " + count, x, y+80);

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


    }

    /**updates image locations, sets new images to be rendered, recycles images for infinite loop
     *
     * @param moveX   amount to move the x-coordinate by
     * @param moveY   amount to move the y-coordinate by
     * @param balloon original balloon object needed for collision
     */
    public void update(float moveX, float moveY, Balloon balloon, StateBasedGame stateBasedGame) {


        renderlist.get(0).move(moveX, moveY);

        /*calculate the balloons horizontal movement if it's the collidable frontground */
        if (name.equals("frontground")){
        distance -= moveX / 100;
        }

        /*handles the images, loads the next one when needed and removes the previous when not needed*/
        if(renderlist.get(0).getX() == -1000.0) {
            renderlist.add(bglist.get(count));
            renderlist.get(1).resetToEnd();
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
                balloon.editLives(-1);  //decrease the lives because they collide*/
                    balloon.reset(280,150);
                    return;
                }

        }  else {
            if(collider) {
                balloon.editLives(-1);
                balloon.reset(280,150);
                }
            }

    }



}
