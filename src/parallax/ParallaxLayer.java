package parallax;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class ParallaxLayer 
{
	private double movementRate;
	private Stack<ArrayList<ParallaxImage>> stacks = new Stack<ArrayList<ParallaxImage>>();
    float cameraMark = 0;
	
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
        ArrayList<ParallaxImage> layerImages = stacks.peek();
        if(cameraMark > 500){
//            if(new Random().nextInt(5) > 2.5){
//                stacks.push(stacks.pop());
//            }
            for(ParallaxImage image: layerImages){
                image.setCentreX(camera.getLookAtX());
                image.setCentreY(camera.getLookAtY());
            }
            cameraMark = 0;
        }

        cameraMark++;
        System.out.println(cameraMark);
        for(ParallaxImage image: layerImages){
            image.render(camera);
        }
		
	}

}
