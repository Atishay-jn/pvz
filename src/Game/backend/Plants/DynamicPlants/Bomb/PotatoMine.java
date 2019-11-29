package Game.backend.Plants.DynamicPlants.Bomb;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public final class PotatoMine extends Bomb implements Serializable
{
	private static final long serialVersionUID = 1;
	private static final int cost = 25;
	private static final int maxCooldown = 300;
	private static int cooldown;
	private boolean armed;

	public PotatoMine(int _xVal)
	{
		super(_xVal);
		this.health = 100;
		this.counter = 0;
		this.armed = false;
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
		if(!this.armed)
			this.counter++;
		if(this.counter >= 100)
			this.armed = true;
		if(this.armed)
			return new Game.backend.Projectiles.Bomb.CellBlast(this.xVal);
		return null;
	}

	public static String getCostImage()
	{
		return "Game/assets/backend/Plants/Bomb/PotatoMine/PotatoCost.gif";
	}

	@Override
	public String getImage()
	{
		if(this.armed)
			return "Game/assets/backend/Plants/Bomb/PotatoMine/PotatoMineArmed.gif";
		return "Game/assets/backend/Plants/Bomb/PotatoMine/PotatoMineUnArmed.gif";
	}
}
