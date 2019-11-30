package Game.backend.Projectiles.Warhead;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class Warhead extends Projectile implements Serializable
{
	private static final long serialVersionUID = 1;
	public final static int height = 30;
	public final static int width = 30;
	int speed;
	int damage;

	public Warhead(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
	}

	public int getDamage()
	{
		return damage;
	}

	public void update()
	{
		this.xVal += this.speed;
		if(this.xVal >= 1400)
			this.xVal = 1400;
	}

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
}
