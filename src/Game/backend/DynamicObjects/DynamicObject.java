package Game.backend.DynamicObjects;

import Game.backend.Displayable;

import java.io.Serializable;

public abstract class DynamicObject implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;
	public static final int width = 90;
	public static final int height = 55;
	int xVal;
	int yVal;
	int timeout = 0;
	int maxTimeout;

	public int getxVal()
	{
		return this.xVal;
	}

	public int getyVal()
	{
		return this.yVal;
	}

	public abstract void update();

	public boolean isAvailable()
	{
		return this.timeout < this.maxTimeout;
	}
}
