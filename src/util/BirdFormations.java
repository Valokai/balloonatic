package util;

import org.newdawn.slick.geom.Vector2f;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 5/02/14
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class BirdFormations {

    Random random = new Random();


    public List<Vector2f> getRandomBirdFormation(float x, float y) {
        float nextFloat = random.nextFloat();

        if (nextFloat > 0.8) {
            return birdTriangle(x, y);
        } else if (nextFloat > 0.6 && nextFloat < 0.8) {
            return birdBlock(x, y);
        } else if (nextFloat > 0.4 && nextFloat < 0.6) {
            return birdLine(x, y);
        } else return randomBirds(x, y);


    }


    /**
     * returns a bird triangle formation
     *
     * @param x
     * @param y
     * @return
     */
    private List<Vector2f> birdTriangle(float x, float y) {
        return Arrays.asList(
                new Vector2f(60 + 1400, y + 60),
                new Vector2f(40 + 1400, y + 40),
                new Vector2f(20 + 1400, y + 20),
                new Vector2f(0 + 1400, y),
                new Vector2f(60 + 1400, y - 60),
                new Vector2f(40 + 1400, y - 40),
                new Vector2f(20 + 1400, y - 20)
        );
    }

    /**
     * returns a block of birds, similar to copter blocks
     *
     * @param x
     * @param y
     * @return
     */
    private List<Vector2f> birdBlock(float x, float y) {

        return Arrays.asList(
                new Vector2f(x + 1400 - 20, y),
                new Vector2f(x + 1400, y + 30),
                new Vector2f(x + 1400 + 20, y),
                new Vector2f(x + 1400 + 40, y + 30),
                new Vector2f(x + 1400 + 60, y),
                new Vector2f(x + 1400 + 80, y + 30)
        );
    }

    /**
     * returns two random birds
     *
     * @param x
     * @param y
     * @return
     */
    private List<Vector2f> randomBirds(float x, float y) {
        return Arrays.asList(
                new Vector2f(((random.nextFloat() * 2399) + 0) + 1400, (random.nextFloat() * 520) + 0),
                new Vector2f(((random.nextFloat() * 2399) + 0) + 1400, (random.nextFloat() * 520) + 0)
        );
    }

    /**
     * returns a verticle line of 5 birds
     *
     * @param x
     * @param y
     * @return
     */
    private List<Vector2f> birdLine(float x, float y) {
        return Arrays.asList(
                new Vector2f(x + 1400, y),
                new Vector2f(x + 1400, y + 30),
                new Vector2f(x + 1400, y + 60),
                new Vector2f(x + 1400, y + 90),
                new Vector2f(x + 1400, y + 120)
        );
    }


}
