package Game.backend.Plants.DynamicPlants.Collector;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public final class TwinSunflower extends Collector implements Serializable
{
	private static final long serialVersionUID = 1;
	private static final int cost = 50;
	private static final int maxCooldown = 300;
	private static int cooldown;

	public TwinSunflower(int _xVal)
	{
		super(_xVal);
		this.health = 100;
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
	public Projectile produce()
	{
		this.counter++;
		if(this.counter >= 100)
			this.counter = 0;
		if(this.counter == 0)
			return new Game.backend.Projectiles.Produce.TwinSun(this.xVal);
		return null;
	}

	public static String getCostImage()
	{
		return "Game/assets/backend/Plants/Collector/TwinSunflower/TwinsunflowerCost.gif";
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Plants/Collector/TwinSunflower/TwinSunflower.gif";
	}
}
