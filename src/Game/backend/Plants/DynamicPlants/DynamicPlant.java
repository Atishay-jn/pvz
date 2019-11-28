package Game.backend.Plants.DynamicPlants;

import Game.backend.Plants.Plant;
import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class DynamicPlant extends Plant implements Serializable
{
	private static final long serialVersionUID = 1;
	protected int counter;
	protected int xVal;

	public DynamicPlant(int _xVal)
	{
		this.xVal = _xVal;
	}

	public abstract Projectile produce();
}
