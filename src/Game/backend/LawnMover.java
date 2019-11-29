package Game.backend;

import java.io.Serializable;

public final class LawnMover implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;
	private int position;
	private boolean activated;

	public LawnMover(int _position)
	{
		this.activated = false;
		this.position = _position;
	}

	public void update()
	{
		if(this.activated)
			this.position += 5;
		if(this.position >= 500)
			this.position = 500;
	}

	public int getPosition()
	{
		return position;
	}

	public void setActivated(boolean activated)
	{
		this.activated = activated;
	}

	@Override
	public String getImage()
	{
		return null;
	}
}
