package parallax;

import java.util.ArrayList;

public class ParallaxWorld 
{
	private ArrayList<ParallaxLayer> layers = new ArrayList<ParallaxLayer>();
	
	public ParallaxWorld()
	{
	}

	public ParallaxLayer addLayer(double movementRate) 
	{
		ParallaxLayer layer = new ParallaxLayer(movementRate);
		
		layers.add(layer);
		
		return layer;
	}

	public void render(Camera camera) 
	{
		for (ParallaxLayer layer : layers)
		{
			layer.render(camera);
		}
	}
}
