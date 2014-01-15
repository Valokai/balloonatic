package parallax;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import state.MainGame;

public class ParallaxImage 
{
    protected double centreX;
    protected double centreY;
	protected Image sprite = null;
    protected double depth;
    protected boolean atInfinity;
	
	public ParallaxImage(double x, double y, double movementRate, String imageFile)
	{
		// Avoid unreasonably large values that might cause problems with floating point errors
		// We handle these cases as if they were at infinity, i.e. not moving ever
		this.atInfinity = (movementRate < 0.05);
		
		if (this.atInfinity)
		{
			this.depth = 1.0;	// Leave position, size unchanged - we won't apply perspective transformation
		}
		else
		{
			this.depth = 1.0 / movementRate;
		}
		
		this.centreX = x * this.depth;
		this.centreY = y * this.depth;
		try 
		{
			this.sprite = new Image(imageFile);
		} 
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean isOK()
	{
		return (this.sprite != null);
	}
	
	public void render(Camera camera)
	{
		if (this.atInfinity)
		{
            drawInfinityImage(camera);
		}
		else
		{
			double zoomedDepth = this.depth + (1.0 / camera.getZoom()) - 1.0;

			double cx = (this.centreX - camera.getLookAtX()) / zoomedDepth;
			double cy = (this.centreY - camera.getLookAtY()) / zoomedDepth;

			double scl = this.depth / zoomedDepth;
			double left = (cx - (scl * sprite.getWidth() / 2.0));
			double top = (cy - (scl * sprite.getHeight() / 2.0));
			
			sprite.draw((float)((camera.getWidth() / 2.0) + left), (float)((camera.getHeight() / 2.0) + top), (float)scl);

		}
	}

    public void drawInfinityImage(Camera camera){
        sprite.drawCentered((float)((camera.getWidth() / 2.0) + this.centreX), (float)((camera.getHeight() / 2.0) + this.centreY));
    }

    public double getCentreX() {
        return centreX;
    }

    public void setCentreX(double centreX) {
        this.centreX = centreX;
    }

    public double getCentreY() {
        return centreY;
    }

    public void setCentreY(double centreY) {
        this.centreY = centreY;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public boolean isAtInfinity() {
        return atInfinity;
    }

    public void setAtInfinity(boolean atInfinity) {
        this.atInfinity = atInfinity;
    }
}
