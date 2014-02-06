package game;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Game Properties class
 */
public class Game {

    /**
     * Game Screen Width
     */
    public static final int SCREEN_WIDTH = 1280;

    /**
     * Game Screen Height
     */
    public static final int SCREEN_HEIGHT = 800;
    /**
     * Game Title
     */
    public static final String TITLE = "Balloonatic";

    /**
     * IS VSYNC ENABLE?
     */
    public static final boolean VSYNC = true;


    /**
     * Debugging Infromation
     */
    public static class DEBUG {

        /**
         * s
         * Is FPS String show on screen?
         */
        public static boolean SHOW_FPS = false;

    }

    public static class STATE {
        public static final int SETTINGS = 5;
        public static final int ENTERCHEATCODE = 4;
        public static final int ENTERNAME = 3;
        public static final int HISCORE = 2;
        public static final int MAIN = 1;
        public static final int MENU = 0;


    }


}
