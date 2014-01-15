package parallax;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class ParallaxLayer 
{
	private double movementRate;
	private Stack<ArrayList<ParallaxImage>> stacks = new Stack<ArrayList<ParallaxImage>>();
	
	public ParallaxLayer(double movementRate) 
	{
		this.movementRate = movementRate;
	}

	public ArrayList<ParallaxImage> addImage(double x, double y, ArrayList<String> imageFiles)
    {
        ParallaxImage image;
        ArrayList<ParallaxImage> layerImages = new ArrayList<ParallaxImage>();
        for(String imageFile : imageFiles){
            image = new ParallaxImage(x, y, this.movementRate, imageFile);
            if (image.isOK()){
                layerImages.add(image);
            }
        }
        stacks.push(layerImages);

        return layerImages;
    }

    public ParallaxImage addBackgroundImage(double x, double y, ArrayList<String> imageFiles)
    {
        BackgroundImage image;
        ArrayList<ParallaxImage> layerImages = new ArrayList<ParallaxImage>();
        for(String imageFile : imageFiles){
            image = new BackgroundImage(x, y, this.movementRate, imageFile);
            if (image.isOK()){
                layerImages.add(image);
            }
        }
        stacks.push(layerImages);

        return null;
    }

	public void render(Camera camera)
	{
        if(camera.getLookAtX() > 1000){
            camera.lookAt(0, 0);
        }
        ArrayList<ParallaxImage> layerImages = stacks.peek();
        for(ParallaxImage image: layerImages){
            image.render(camera);
        }
		
	}

}
