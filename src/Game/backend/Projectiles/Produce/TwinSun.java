package Game.backend.Projectiles.Produce;

import java.io.Serializable;

public final class TwinSun extends Produce implements Serializable
{
	private static final long serialVersionUID = 1;
	public static final int value = 100;

	@Override
	public int getValue()
	{
		return value;
	}

	public TwinSun(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Projectiles/Produce/TwinSun.gif";
	}
}
