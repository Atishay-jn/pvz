package Game.backend.Zombies;

import java.io.Serializable;

public final class RugbyZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public RugbyZombie(int xVal)
	{
		super(300, 5, xVal);
	}

	@Override
	public String getImage()
	{
		if(this.frozen)
			return null;
		return null;
	}

	public RugbyZombie clone()
	{
		return (RugbyZombie) super.clone();
	}
}
