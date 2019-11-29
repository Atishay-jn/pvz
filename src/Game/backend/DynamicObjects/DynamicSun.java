package Game.backend.DynamicObjects;

import java.io.Serializable;

public final class DynamicSun extends DynamicObject implements Serializable
{
	private static final long serialVersionUID = 1;
	public static final int value = 50;

	public DynamicSun(int _x, int _y)
	{
		this.xVal = _x;
		this.yVal = _y;
		this.maxTimeout = 150;
	}

	@Override
	public void update()
	{
		this.yVal += 2;
		if(this.yVal > 600)
			this.yVal = 600;
		if(this.yVal == 600)
			this.timeout++;
		if(this.timeout > this.maxTimeout)
			this.timeout = this.maxTimeout;
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Object/Sun.gif";
	}
}
