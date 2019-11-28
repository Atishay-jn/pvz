package Game.backend.Projectiles.Warhead;

import java.io.Serializable;

public final class Firey extends Warhead implements Serializable
{
	private static final long serialVersionUID = 1;

	public Firey(int _xVal)
	{
		super(_xVal);
		this.speed = 5;
		this.damage = 100;
	}

	@Override
	public String getImage()
	{
		return null;
	}
}
