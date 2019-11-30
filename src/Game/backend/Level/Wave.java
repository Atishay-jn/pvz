package Game.backend.Level;

import Game.backend.Zombies.Zombie;

import java.util.ArrayList;

public final class Wave
{
	private int number;
	private int nextCountdown;
	private ArrayList<Zombie> row0Zombie = new ArrayList<>();
	private ArrayList<Zombie> row1Zombie = new ArrayList<>();
	private ArrayList<Zombie> row2Zombie = new ArrayList<>();
	private ArrayList<Zombie> row3Zombie = new ArrayList<>();
	private ArrayList<Zombie> row4Zombie = new ArrayList<>();

	public Wave(int number, int nextCountdown)
	{
		this.number = number;
		this.nextCountdown = nextCountdown;
	}

	public void setRow0Zombie(Zombie z) {
		row0Zombie.add(z);
	}

	public void setRow1Zombie(Zombie z) {
		row1Zombie.add(z);
	}

	public void setRow2Zombie(Zombie z) {
		row2Zombie.add(z);
	}

	public void setRow3Zombie(Zombie z) {
		row3Zombie.add(z);
	}

	public void setRow4Zombie(Zombie z) {
		row4Zombie.add(z);
	}

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

	public int getNextCountdown()
	{
		return nextCountdown;
	}

	public int getNumber()
	{
		return number;
	}
}
