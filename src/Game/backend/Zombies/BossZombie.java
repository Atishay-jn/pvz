package Game.backend.Zombies;

import java.io.Serializable;

public final class BossZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public BossZombie(int xVal)
	{
		super(1000, 2, xVal, 3);
	}

	@Override
	public String getImage()
	{
		if(this.frozen)
			return null;
		return null;
	}

	public BossZombie clone()
	{
		return (BossZombie) super.clone();
	}
}
