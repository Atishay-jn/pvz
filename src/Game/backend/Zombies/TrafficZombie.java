package Game.backend.Zombies;

import java.io.Serializable;

public final class TrafficZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public TrafficZombie(int yVal)
	{
		super(400, 2, yVal, 1);
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Zombies/TrafficZombie.gif";
	}

	public TrafficZombie clone()
	{
		return (TrafficZombie) super.clone();
	}
}
