package Game.backend.Projectiles;

import Game.backend.Displayable;

import java.io.Serializable;

public abstract class Projectile implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;
	protected int xVal;
	protected int yVal;

	public Projectile(int _xVal, int _yVal)
	{
		this.yVal = _yVal-82;
		this.xVal = _xVal+70;
	}

	public int getxVal()
	{
		return xVal;
	}

	public void setxVal(int xVal)
	{
		this.xVal = xVal;
	}

	public abstract int getHeight();

	public abstract int getWidth();

	public int getyVal()
	{
		return yVal;
	}
}