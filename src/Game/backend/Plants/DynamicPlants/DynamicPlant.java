package Game.backend.Plants.DynamicPlants;

import Game.backend.Plants.Plant;
import Game.backend.Projectiles.Projectile;

public abstract class DynamicPlant extends Plant
{
	protected int counter;

	public abstract Projectile produce();
}
