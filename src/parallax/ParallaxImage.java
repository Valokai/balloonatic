package parallax;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ParallaxImage 
{
	private double centreX;
	private double centreY;
	private Image sprite = null;
	private double depth;
	private boolean atInfinity;
	
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
			sprite.drawCentered((float)((camera.getWidth() / 2.0) + this.centreX), (float)((camera.getHeight() / 2.0) + this.centreY));
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
}
