package Game.backend.Zombies;

import java.io.Serializable;

public final class VanillaZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public VanillaZombie(int xVal)
	{
		super(100, 5, xVal);
	}

	@Override
	public String getImage()
	{
		if(this.frozen)
			return null;
		return null;
	}

	public VanillaZombie clone()
	{
		return (VanillaZombie) super.clone();
	}
}
