package parallax;

public class Camera 
{
	public double lookAtX;
	public double lookAtY;
	public double width;
	public double height;
	public double zoomFactor;
	
	public Camera(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.zoomFactor = 1.1;
	}
	
	public void lookAt(double x, double y)
	{
		this.lookAtX = x;
		this.lookAtY = y;
	}

	public double getLeft()
	{
		return (this.lookAtX - this.width / 2.0f);
	}

	public double getRight()
	{
		return (this.lookAtX + this.width / 2.0f);
	}

	public double getLookAtX() 
	{
		return this.lookAtX;
	}

	public double getLookAtY() 
	{
		return this.lookAtY;
	}

	public double getWidth() 
	{
		return this.width;
	}

	public double getHeight() 
	{
		return this.height;
	}
	
	public double getZoom() 
	{
		return this.zoomFactor;
	}

	public void zoomBy(double zoom) 
	{
		this.zoomFactor *= zoom;
		
		if (this.zoomFactor < 0.5)
		{
			this.zoomFactor = 0.5;
		}
		else if (this.zoomFactor > 2.0)
		{
			this.zoomFactor = 2.0;
		}
	}
}
