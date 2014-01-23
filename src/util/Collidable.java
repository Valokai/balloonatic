package util;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Object which involves in collision must implment this interface.
 */
public interface Collidable {

    /**
     * Call when the collision occurred with <code>Collider</code>
     * @param collider object which collide with this object
     */
    public void onCollide(Collidable collider);
}
