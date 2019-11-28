package Game.backend.DynamicObjects;

import Game.backend.Displayable;

import java.io.Serializable;

public abstract class DynamicObject implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;
	int xVal;
	int yVal;
	int timeout = 0;
	int maxTimeout;

	protected int getxVal()
	{
		return this.xVal;
	}

	protected int getyVal()
	{
		return this.yVal;
	}

	public abstract void update();

	public boolean isAvailable()
	{
		return this.timeout < this.maxTimeout;
	}
}
