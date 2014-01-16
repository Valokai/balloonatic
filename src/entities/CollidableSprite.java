package entities;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CollidableSprite extends Sprite {

    protected OnCollideListener onCollideListener;

    public CollidableSprite(String imagePath) {
        super(imagePath);
    }

    public CollidableSprite(float x, float y, String imagePath) {
        super(x, y, imagePath);
    }

    

    public interface OnCollideListener{
        public void onCollide(CollidableSprite collider);
    }

}
