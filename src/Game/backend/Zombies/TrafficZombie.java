package Game.backend.Zombies;

import java.io.Serializable;

public final class TrafficZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public TrafficZombie(int xVal)
	{
		super(400, 2, xVal, 1);
	}

	@Override
	public String getImage()
	{
		if(this.frozen)
			return null;
		return null;
	}

	public TrafficZombie clone()
	{
		return (TrafficZombie) super.clone();
	}
}
