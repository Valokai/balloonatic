package graphic;

import game.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 10/02/14
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeadPlayer extends SceneObject {

    public DeadPlayer() throws SlickException {
        super("data/image/deadballoon.png", true);
    }

    @Override
    public void render(GameContainer gc, Graphics graphics) {
        super.render(gc, graphics);
        graphics.setFont(Game.scoreFont);
<<<<<<< HEAD


        for (int i = 0; i < Game.SBoard.scores.size(); i++){
            if(-20<(Game.SBoard.getX(i)) && Game.SBoard.getX(i)<1400){
                Game.scoreFont.drawString(Game.SBoard.getX(i)-50, 600, Game.SBoard.showName(i));
=======
<<<<<<< HEAD
        for (int i = 0; i < Game.SBoard.scores.size(); i++) {
            if (-20 < (Game.SBoard.getX(i)) && Game.SBoard.getX(i) < 1400) {
                Game.scoreFont.drawString(Game.SBoard.getX(i) - 60, 600, Game.SBoard.showName(i));
=======
        for (int i = 0; i < Game.SBoard.scores.size(); i++){
            if(-20<(Game.SBoard.getX(i)) && Game.SBoard.getX(i)<1400){
                Game.scoreFont.drawString(Game.SBoard.getX(i)-50, 600, Game.SBoard.showName(i));
>>>>>>> 396c7f69183600ed0ebb9d956b54c629a5291a68
>>>>>>> 8d3d95dd38a771a5584b55681c5b3d7e12541d4b
            }
        }

    }

    @Override
    public void move(int delta) {
        x += delta / 1000 - 4;
    }

    @Override
    public boolean isReadyForDisposal() {
        return (x < 0);
    }

}
