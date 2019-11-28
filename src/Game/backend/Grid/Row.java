package Game.backend.Grid;

import Game.backend.Exceptions.CellOccupiedException;
import Game.backend.Exceptions.PlantNotPresentException;
import Game.backend.LawnMover;
import Game.backend.Plants.Plant;
import Game.backend.Projectiles.Projectile;
import Game.backend.Zombies.Zombie;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable
{
	private static final long serialVersionUID = 1;
	private ArrayList<Cell> cells;
	private ArrayList<Zombie> incoming;
	private ArrayList<Projectile> projectiles;
	private LawnMover lawnMover;
	private int number;
	private int yVal;

	public Row(int _num, int _yVal)
	{
		this.cells = new ArrayList<>();
		for(int i = 0; i < 9; i++)
			this.cells.add(new Cell());
		this.incoming = new ArrayList<>();
		this.projectiles = new ArrayList<>();
		this.lawnMover = new LawnMover(100);
		this.number = _num;
		this.yVal = _yVal;
	}

	public void plant(Plant p, int col) throws CellOccupiedException
	{
		this.cells.get(col).plant(p);
	}

	public void cleanCell(int col) throws PlantNotPresentException
	{
		this.cells.get(col).clean();
	}

	public Cell getCell(int col)
	{
		return this.cells.get(col);
	}

	public ArrayList<Zombie> getIncoming()
	{
		return incoming;
	}

	public ArrayList<Projectile> getProjectiles()
	{
		return projectiles;
	}

	public LawnMover getLawnMover()
	{
		return lawnMover;
	}

	public void addIncoming(Zombie z)
	{
		this.incoming.add(z);
	}

	public void update()
	{
		this.cells.forEach((Cell c) ->
		{
			Projectile p = c.produce();
			if(p != null)
				this.projectiles.add(p);
		});
		//TODO
	}
}
