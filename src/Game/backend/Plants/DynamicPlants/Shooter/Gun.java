package Game.backend.Plants.DynamicPlants.Shooter;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public final class Gun extends Shooter implements Serializable
{
	private static final long serialVersionUID = 1;
	private static final int cost = 250;
	private static final int maxCooldown = 800;
	private static int cooldown;

	public Gun(int _xVal, int _yVal)
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

	public static void increment()
	{
		cooldown += 1;
		if(cooldown >= maxCooldown)
			cooldown = maxCooldown;
	}

	@Override
	public void resetCooldown()
	{
		cooldown = 0;
	}

	@Override
	public Projectile produce()
	{
		this.counter++;
		if(this.counter >= 8)
			this.counter = 0;
		if(this.counter == 0)
			return new Game.backend.Projectiles.Warhead.Firey(this.xVal, this.yVal);
		return null;
	}

	public static String getCostImage()
	{
		return "Game/assets/backend/Plants/Shooters/Gun/GunCost.gif";
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Plants/Shooters/Gun/Gun.gif";
	}
}
