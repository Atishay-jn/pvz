package Game.backend.Projectiles.Bomb;

import java.io.Serializable;

public final class RowBlast extends Bomb implements Serializable
{
	private static final long serialVersionUID = 1;

	public RowBlast(int _xVal)
	{
		super(_xVal);
	}

	@Override
	public String getImage()
	{
		return null;
	}
}
