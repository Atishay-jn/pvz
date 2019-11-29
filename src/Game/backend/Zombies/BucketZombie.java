package Game.backend.Zombies;

import java.io.Serializable;

public final class BucketZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public BucketZombie(int xVal)
	{
		super(200, 5, xVal, 1);
	}

	@Override
	public String getImage()
	{
		if(this.frozen)
			return null;
		return null;
	}

	public BucketZombie clone()
	{
		return (BucketZombie) super.clone();
	}
}
