package Game.backend;

import java.io.Serializable;

public final class LawnMover implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;
	public static final int height = 90;
	public static final int width = 110;
	private int xVal;
	private int yVal;
	private boolean activated;
	private boolean imageUpdated;
	private boolean outOfFrame;

	public LawnMover(int _xVal, int _yVal)
	{
		this.activated = false;
		this.xVal = _xVal - width;
		this.yVal = _yVal - height;
		this.imageUpdated = false;
		this.outOfFrame = false;
	}

	public void update()
	{
		if(this.activated)
			this.xVal += 5;
		if(this.xVal >= 1400)
			this.xVal = 1400;
	}

	public boolean isInsideFrame()
	{
		return !this.outOfFrame;
	}

	public void setOutOfFrame(boolean outOfFrame)
	{
		this.outOfFrame = outOfFrame;
	}



	public int getxVal()
	{
		return xVal;
	}

	public void setActivated(boolean activated)
	{
		this.activated = activated;
		this.imageUpdated = true;
	}

	@Override
	public String getImage()
	{
		if(this.activated)
			return "Game/assets/backend/Object/LawnMover/Lawnmower_Activated.gif";
		return "Game/assets/backend/Object/LawnMover/Lawnmower.gif";
	}

	public boolean isImageUpdated()
	{
		return imageUpdated;
	}

	public void setImageUpdated(boolean imageUpdated)
	{
		this.imageUpdated = imageUpdated;
	}

	public int getyVal()
	{
		return yVal;
	}
}
