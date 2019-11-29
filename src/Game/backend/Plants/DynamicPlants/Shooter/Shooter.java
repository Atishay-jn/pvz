package Game.backend.Plants.DynamicPlants.Shooter;

import Game.backend.Plants.DynamicPlants.DynamicPlant;

import java.io.Serializable;

abstract class Shooter extends DynamicPlant implements Serializable
{
	private static final long serialVersionUID = 1;

	public Shooter(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
	}
}
