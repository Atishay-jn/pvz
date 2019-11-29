package Game.backend.Plants.DynamicPlants.Collector;

import Game.backend.Plants.DynamicPlants.DynamicPlant;

import java.io.Serializable;

abstract class Collector extends DynamicPlant implements Serializable
{
	private static final long serialVersionUID = 1;

	public Collector(int _xVal, int _yVal)
	{
		super(_xVal, _yVal);
	}
}
