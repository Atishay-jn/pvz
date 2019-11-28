package Game.backend.Projectiles.Produce;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class Produce extends Projectile implements Serializable
{
	private static final long serialVersionUID = 1;

	public Produce(int _xVal)
	{
		super(_xVal);
	}
}
