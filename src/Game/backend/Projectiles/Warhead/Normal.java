package Game.backend.Projectiles.Warhead;

import java.io.Serializable;

public final class Normal extends Warhead implements Serializable
{
	private static final long serialVersionUID = 1;

	public Normal(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
		this.speed = 7;
		this.damage = 50;
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Projectiles/Warhead/Pea.png";
	}
}
