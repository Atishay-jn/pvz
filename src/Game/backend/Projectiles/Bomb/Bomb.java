package Game.backend.Projectiles.Bomb;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class Bomb extends Projectile implements Serializable
{
	private static final long serialVersionUID = 1;

	public Bomb(int _xVal)
	{
		super(_xVal);
	}
}
