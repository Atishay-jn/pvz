package Game.backend.Projectiles.Produce;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class Produce extends Projectile implements Serializable
{
	private static final long serialVersionUID = 1;
	public static final int width = 90;
	public static final int height = 55;

	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public int getWidth()
	{
		return width;
	}

	public abstract int getValue();

	public Produce(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
	}
}
