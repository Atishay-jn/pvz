package Game.backend.Projectiles.Warhead;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class Warhead extends Projectile implements Serializable
{
	private static final long serialVersionUID = 1;
	int speed;
	int damage;

	public Warhead(int _xVal)
	{
		super(_xVal);
	}

	public int getDamage()
	{
		return damage;
	}

	public void update()
	{
		this.xVal += this.speed;
		if(this.xVal >= 500)
			this.xVal = 500;
	}
}
