package Game.backend.Projectiles.Bomb;

import java.io.Serializable;

public final class CellBlast extends Bomb implements Serializable
{
	private static final long serialVersionUID = 1;
	public static final int height = 95;
	public static final int width = 95;

	public CellBlast(int _xVal, int _yVal)
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
		return "Game/assets/backend/Projectiles/Bomb/CellFire.gif";
	}
}
