package Game.backend.Projectiles.Bomb;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class Bomb extends Projectile implements Serializable
{
	private static final long serialVersionUID = 1;
	private int counter = 60;
	private boolean activated = false;

	public Bomb(int _xVal, int _yval)
	{
		super(_xVal, _yval);
	}

	public boolean isActivated()
	{
		return this.activated;
	}

	public void setActivated(boolean activated)
	{
		this.activated = activated;
	}

	public boolean update()
	{
		if(this.activated)
			this.counter--;
		if(this.counter <= 0)
			this.counter = 0;
		return this.activated && this.counter <= 0;
	}
}
