package Game.backend.Plants.Barrier;

import java.io.Serializable;

public final class TallNut extends Barrier implements Serializable
{
	private static final long serialVersionUID = 1;
	private static final int cost = 75;
	private static final int maxCooldown = 300;
	private static int cooldown;

	public TallNut()
	{
		this.health = 1000;
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

	@Override
	public int getCost()
	{
		return cost;
	}

	@Override
	public void resetCooldown()
	{
		cooldown = 0;
	}

	public static void increment()
	{
		cooldown += 1;
		if(cooldown >= maxCooldown)
			cooldown = maxCooldown;
	}

	public static String getCostImage()
	{
		return "Game/assets/backend/Plants/Barrier/Tallnut/TallnutCost.gif";
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Plants/Barrier/Tallnut/Tallnut.gif";
	}
}
