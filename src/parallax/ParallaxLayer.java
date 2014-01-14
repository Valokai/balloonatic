package parallax;

import java.util.ArrayList;

public class ParallaxLayer 
{
	private double movementRate;
	private ArrayList<ParallaxImage> images = new ArrayList<ParallaxImage>();
	
	public ParallaxLayer(double movementRate) 
	{
		this.movementRate = movementRate;
	}

	public ParallaxImage addImage(double x, double y, String imageFile)
	{
		ParallaxImage image = new ParallaxImage(x, y, this.movementRate, imageFile);
		
		if (image.isOK())
		{
			images.add(image);
		}
		else
		{
			image = null;
		}
		
		return null;
	}

	public void render(Camera camera)
	{
		for (ParallaxImage image : images)
		{
			image.render(camera);
		}
		
	}

}
