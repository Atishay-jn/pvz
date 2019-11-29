package Game.backend.Level;

import Game.backend.Zombies.Zombie;

import java.util.ArrayList;

public class Wave
{
	private ArrayList<Zombie> row0Zombie = new ArrayList<>();
	private ArrayList<Zombie> row1Zombie = new ArrayList<>();
	private ArrayList<Zombie> row2Zombie = new ArrayList<>();
	private ArrayList<Zombie> row3Zombie = new ArrayList<>();
	private ArrayList<Zombie> row4Zombie = new ArrayList<>();

	public ArrayList<Zombie> getZombies(int idx)
	{
		switch(idx)
		{
			case 0:
				return row0Zombie;
			case 1:
				return row1Zombie;
			case 2:
				return row2Zombie;
			case 3:
				return row3Zombie;
			case 4:
				return row4Zombie;
		}
		return null;
	}
}
