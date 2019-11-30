package Game.backend.Projectiles.Bomb;

import java.io.Serializable;

public final class RowBlast extends Bomb implements Serializable
{
	private static final long serialVersionUID = 1;
	public static final int height = 105;
	public static final int width = 895;

	public RowBlast(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
	}

	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public int getWidth()
	{
		return width;
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Projectiles/Bomb/RowFire.gif";
	}
}
