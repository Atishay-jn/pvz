package Game.backend.Plants.DynamicPlants;

import Game.backend.Plants.Plant;
import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public abstract class DynamicPlant extends Plant implements Serializable
{
	private static final long serialVersionUID = 1;
	protected int counter;
	protected int xVal;
	protected int yVal;

	public DynamicPlant(int _xVal, int _yVal)
	{
		this.xVal = _xVal;
		this.yVal = _yVal;
	}

	public abstract Projectile produce();
}
