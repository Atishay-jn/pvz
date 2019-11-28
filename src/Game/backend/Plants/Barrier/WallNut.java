package Game.backend.Plants.Barrier;

import java.io.Serializable;

public final class WallNut extends Barrier implements Serializable
{
	private static final long serialVersionUID = 1;
	private static final int cost = 50;
	private static final int maxCooldown = 100;
	private static int cooldown;

	public WallNut()
	{
		this.health = 100;
	}

	public static int getMaxCooldown()
	{
		return maxCooldown;
	}

	public static float getCooldown()
	{
		return cooldown;
	}

	public static void setCooldown(int cd)
	{
		cooldown = cd;
	}

	public static int getCost()
	{
		return cost;
	}

	public static void increment()
	{
		cooldown += 1;
		if(cooldown >= maxCooldown)
			cooldown = maxCooldown;
	}

	@Override
	public String getImage()
	{
		return null;
	}
}
