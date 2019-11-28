package Game.backend.Plants.DynamicPlants.Bomb;

import Game.backend.Plants.DynamicPlants.DynamicPlant;

import java.io.Serializable;

abstract class Bomb extends DynamicPlant implements Serializable
{
	private static final long serialVersionUID = 1;

	public Bomb(int _xVal)
	{
		super(_xVal);
	}
}
