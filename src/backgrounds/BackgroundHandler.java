package backgrounds;


import org.newdawn.slick.Graphics;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 16/01/14
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class BackgroundHandler {

    private ArrayList<Background> renderlist, bglist;
    private String name;
    int count = 1;

    public BackgroundHandler(String name) {
        renderlist = new ArrayList<Background>();
        bglist = new ArrayList<Background>();
        this.name = name;
    }

    public void add(Background bg) {
        bglist.add(bg);
        if(renderlist.isEmpty())renderlist.add(bglist.get(0));
    }

    public void printStats(Graphics g, int x, int y) {
        g.drawString(this.name, x, y);
        g.drawString("bglist: " + bglist.size(), x, y+20);
        g.drawString("renderlist: " + renderlist.size(), x, y+40);
        g.drawString("PosX(0): " + renderlist.get(0).getX(), x, y+60);
        g.drawString("count: " + count, x, y+80);
    }

    public void render(Graphics graphics) {
        for(int i = 0; i<renderlist.size(); i++) {
            renderlist.get(i).render(graphics);
        }
    }

    public void update(float moveX, float moveY) {

        renderlist.get(0).move(moveX, moveY);

        /*handles the images, loads the next one when needed and removes the previous when not needed*/
        if(renderlist.get(0).getX() == -2500.0) {
            renderlist.add(bglist.get(count));
            renderlist.get(1).resetToEnd();
            count++;
        }
        if(renderlist.get(0).getX() < -2500.0) {
            renderlist.get(1).move(moveX, moveY);
        }
        if(renderlist.get(0).getX() == -4000.0) {
            renderlist.remove(0);

        }
        if(count == bglist.size()) {
            count = 0;
        }
    }

    public ArrayList<Background> getRenderlist() {
        return renderlist;
    }

    public void setRenderlist(ArrayList<Background> renderlist) {
        this.renderlist = renderlist;
    }
}
