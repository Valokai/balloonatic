package state;

import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CaveState extends BasicGameState {
    public static final int ID = 4;

    private Font font;
    private StateBasedGame mainGame; // We keep a copy of this so that we can access it during key and mouse events

//    private GameState underneath = null;
//	private Image underneathImage = null;
//	private int blurCount = 0;

    @Override
    public int getID()
    {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException
    {
        font = new AngelCodeFont("data/fonts/GoudyStout.fnt","data/fonts/GoudyStout_0.png");
        mainGame = game;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException
    {
//		renderBlurredUnderneath(container, game, g);
//		g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));

        mainGame.getState(GamePlayingState.ID).render(container, game, g);
        g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));

        g.fillRect(0, 0, container.getWidth(), container.getHeight());

        g.setFont(font);
        g.setColor(Color.yellow);
        g.drawString("In game menu", 150, 150);
        g.setColor(Color.white);
        g.drawString("1. Resume game", 150, 220);
        g.drawString("2. Restart game", 150, 270);
        g.drawString("3. End game", 150, 320);
    }

//	private void renderBlurredUnderneath(GameContainer container,
//			StateBasedGame game, Graphics g) throws SlickException
//	{
//		if (underneathImage == null)
//		{
//			underneath.render(container, game, g);
//
//			underneathImage = new Image(container.getWidth(), container.getHeight());
//			container.getGraphics().copyArea(underneathImage, 0, 0);
//		}
//		else if (blurCount < 5)
//		{
//			long start = System.currentTimeMillis();
//			underneathImage = ImageUtils.blur(underneathImage);
//			++blurCount;
//			System.out.printf("Blur time = %1.4f\n", (System.currentTimeMillis() - start) / 1000.0f);
//		}
//
//		underneathImage.draw(0.0f, 0.0f);
//	}

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException
    {
    }

    public void enter(GameContainer container, StateBasedGame game)
            throws SlickException
    {
//		if (underneath == null)
//		{
//			underneath = game.getState(GamePlayingState.ID);
//		}
//		underneathImage = null;
//		blurCount = 0;

    }

    public void keyReleased(int key, char c)
    {
        if (key == Input.KEY_1)
        {
            // Go straight to the game, no transition at all
            mainGame.enterState(GamePlayingState.ID);
        }
        if (key == Input.KEY_2)
        {
            GamePlayingState playingState = (GamePlayingState)mainGame.getState(GamePlayingState.ID);
            playingState.resetGame();
            mainGame.enterState(GamePlayingState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        if (key == Input.KEY_3)
        {
            mainGame.enterState(GameOverState.ID, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
        }
    }
}


}
