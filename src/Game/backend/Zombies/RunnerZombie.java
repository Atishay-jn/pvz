package Game.backend.Zombies;

import java.io.Serializable;

public final class RunnerZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public RunnerZombie(int yVal)
	{
		super(200, 4, yVal, 1);
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Zombies/RunnerZombie.gif";
	}

	public RunnerZombie clone()
	{
		return (RunnerZombie) super.clone();
	}
}
