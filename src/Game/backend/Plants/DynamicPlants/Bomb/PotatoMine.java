package Game.backend.Plants.DynamicPlants.Bomb;

import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public final class PotatoMine extends Bomb implements Serializable
{
	private static final long serialVersionUID = 1;
	private static final int cost = 75;
	private static final int maxCooldown = 150;
	private static int cooldown;
	private boolean armed;
	private boolean imageUpdated;

	public PotatoMine(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
		this.health = 250;
		this.counter = 0;
		this.armed = false;
		this.imageUpdated = false;
	}

	public static int getMaxCooldown()
	{
		return maxCooldown;
	}

	public static float getCooldown()
	{
		return cooldown;
	}

	@Override
	public void resetCooldown()
	{
		cooldown = 0;
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
	public Projectile produce()
	{
		if(!this.armed)
			this.counter++;
		if(this.counter >= 100 && !this.armed)
		{
			this.armed = true;
			this.imageUpdated = true;
		}
		if(this.armed)
			return new Game.backend.Projectiles.Bomb.CellBlast(this.xVal, this.yVal);
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

	public boolean isImageUpdated()
	{
		return imageUpdated;
	}

	public void setImageUpdated(boolean imageUpdated)
	{
		this.imageUpdated = imageUpdated;
	}
}
