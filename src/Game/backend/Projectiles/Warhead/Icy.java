package Game.backend.Projectiles.Warhead;

import java.io.Serializable;

public final class Icy extends Warhead implements Serializable
{
	private static final long serialVersionUID = 1;

	public Icy(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
		this.speed = 3;
		this.damage = 50;
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Projectiles/Warhead/Icy.png";
	}
}
