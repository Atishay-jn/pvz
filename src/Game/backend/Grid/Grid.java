package Game.backend.Grid;

import Game.backend.Exceptions.CellOccupiedException;
import Game.backend.Exceptions.PlantNotPresentException;
import Game.backend.Level.Wave;
import Game.backend.Plants.Plant;
import Game.backend.Projectiles.Projectile;
import Game.backend.Zombies.Zombie;

import java.io.Serializable;
import java.util.ArrayList;

public final class Grid implements Serializable
{
	private static final long serialVersionUID = 1;
	public static int[] rowYVal = {130, 245, 365, 480, 600};
	public static int[] rowBoundary = {375, 370, 360, 350, 340};
	private ArrayList<Row> rows;

	public Grid()
	{
		this.rows = new ArrayList<>();
		for(int i = 0; i < 5; i++)
		{
			rows.add(new Row(i, rowYVal[i], rowBoundary[i]));
		}
	}

	public void addZombies(Wave wave)
	{
		for(int i = 0; i < 5; i++)
		{
			ArrayList<Zombie> zombies = wave.getZombies(i);
			if(zombies == null)
				return;
			for(Zombie z : zombies)
			{
				System.out.println("Adding zombie on row: " + i);
				this.getRow(i).addIncoming(z.clone());
			}
		}
	}

	public Row getRow(int idx)
	{
		return this.rows.get(idx);
	}

	public void plant(int row, int col, Plant plant) throws CellOccupiedException
	{
		this.rows.get(row).getCell(col).plant(plant);
	}

	public void clean(int row, int col) throws PlantNotPresentException
	{
		this.rows.get(row).getCell(col).clean();
	}

	public void removeProduce(int row, Projectile p)
	{
		this.rows.get(row).removeProduce(p);
	}
}
