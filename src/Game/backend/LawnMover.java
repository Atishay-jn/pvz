package Game.backend;

import java.io.Serializable;

public final class LawnMover implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;

	private int position;

	public LawnMover(int _position)
	{
		this.position = _position;
	}

	public void update()
	{
		this.position += 5;
		if(this.position >= 500)
			this.position = 500;
	}

	public int getPosition()
	{
		return position;
	}

	@Override
	public String getImage()
	{
		return null;
	}
}
