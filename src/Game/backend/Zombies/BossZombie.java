package Game.backend.Zombies;

import java.io.Serializable;

public final class BossZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public BossZombie(int yVal)
	{
		super(1000, 1, yVal, 5);
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Zombies/BossZombie.gif";
	}

	public BossZombie clone()
	{
		return (BossZombie) super.clone();
	}
}
