package Game.backend.Plants.DynamicPlants.Collector;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public final class TwinSunflower extends Collector implements Serializable
{
	private static final long serialVersionUID = 1;
	private static final int cost = 75;
	private static final int maxCooldown = 500;
	private static int cooldown;

	public TwinSunflower(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
		this.health = 250;
		this.counter = 0;
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
		return "Game/assets/backend/Plants/Collector/TwinSunflower/TwinSunflowerCost.gif";
	}

	@Override
	public Projectile produce()
	{
		this.counter++;
		if(this.counter >= 100)
			this.counter = 0;
		if(this.counter == 0)
			return new Game.backend.Projectiles.Produce.TwinSun(this.xVal, this.yVal);
		return null;
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Plants/Collector/TwinSunflower/TwinSunflower.gif";
	}
}
