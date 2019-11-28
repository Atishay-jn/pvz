package Game.backend.Projectiles.Warhead;

import java.io.Serializable;

public final class Icy extends Warhead implements Serializable
{
	private static final long serialVersionUID = 1;

	public Icy(int _xVal)
	{
		super(_xVal);
		this.speed = 5;
		this.damage = 50;
	}

	@Override
	public String getImage()
	{
		return null;
	}
}
