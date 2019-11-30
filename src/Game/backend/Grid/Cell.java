package Game.backend.Grid;

import Game.backend.Exceptions.CellOccupiedException;
import Game.backend.Exceptions.PlantNotPresentException;
import Game.backend.Plants.Barrier.Barrier;
import Game.backend.Plants.DynamicPlants.DynamicPlant;
import Game.backend.Plants.Plant;
import Game.backend.Projectiles.Projectile;

import java.io.Serializable;

public final class Cell implements Serializable
{
	private static final long serialVersionUID = 1;

	public Plant getPlant()
	{
		return plant;
	}

	private Plant plant;

	public Cell()
	{
		this.plant = null;
	}

	public void clean() throws PlantNotPresentException
	{
		if(this.plant == null)
			throw new PlantNotPresentException("Plant not found");
		this.plant = null;
	}

	public void plant(Plant p) throws CellOccupiedException
	{
		if(this.plant != null)
			throw new CellOccupiedException("Cell already has a plant!");
		this.plant = p;
	}

	public Projectile produce()
	{
		if(this.plant == null)
			return null;
		if(this.plant instanceof Barrier)
			return null;
		DynamicPlant d = (DynamicPlant) this.plant;
		return d.produce();
	}

	public boolean hasPlant()
	{
		return this.plant != null;
	}

	public boolean takeDamage(int damage)
	{
		if(this.plant.takeDamage(damage))
		{
			this.plant = null;
			return true;
		}
		return false;
	}
}
