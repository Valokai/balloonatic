package util;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

// Extend the Slick font class to add support for aligning text

public class GameFont extends AngelCodeFont {
    public enum Alignment {
        LEFT,
        CENTRE,
        RIGHT
    }

    public GameFont(String fntFile, String imgFile) throws SlickException {
        super(fntFile, imgFile);
    }

    public void drawString(float x, float y, String message, Alignment align, Color colour) {
        float width = this.getWidth(message);
        float height = this.getLineHeight();

        switch (align) {
            case RIGHT:
                drawString(x - width, y - height, message, colour);
                break;
            case CENTRE:
                drawString(x - width / 2.0f, y - height, message, colour);
                break;
            default:
                drawString(x, y - height, message, colour);
                break;
        }
    }
}
