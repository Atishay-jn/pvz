package Game.backend.Projectiles;

import Game.backend.Displayable;

import java.io.Serializable;

public abstract class Projectile implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;
	protected int xVal;

	public Projectile(int _xVal)
	{
		this.xVal = _xVal;
	}

	protected int getxVal()
	{
		return xVal;
	}

	protected void setxVal(int xVal)
	{
		this.xVal = xVal;
	}
}