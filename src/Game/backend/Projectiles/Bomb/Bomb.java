package Game.backend.Projectiles.Bomb;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class Bomb extends Projectile implements Serializable
{
	private static final long serialVersionUID = 1;
	private int counter = 60;

	public Bomb(int _xVal, int _yval)
	{
		super(_xVal, _yval);
	}

	public boolean update()
	{
		this.counter--;
		if(this.counter <= 0)
			this.counter = 0;
		return this.counter <= 0;
	}
}
