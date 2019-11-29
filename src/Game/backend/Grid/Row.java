package Game.backend.Grid;

import Game.backend.Displayable;
import Game.backend.Exceptions.CellOccupiedException;
import Game.backend.Exceptions.PlantNotPresentException;
import Game.backend.Exceptions.ZombiesAteYourBrainsException;
import Game.backend.LawnMover;
import Game.backend.Plants.Plant;
import Game.backend.Projectiles.Bomb.CellBlast;
import Game.backend.Projectiles.Bomb.RowBlast;
import Game.backend.Projectiles.Projectile;
import Game.backend.Projectiles.Warhead.Warhead;
import Game.backend.Zombies.Zombie;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.abs;

public final class Row implements Serializable
{
	private static final long serialVersionUID = 1;
	private ArrayList<Cell> cells;
	private ArrayList<Zombie> incoming;
	private ArrayList<Projectile> projectiles;
	private static int[] cellXVal = {150, 200, 300, 400, 450, 500, 550, 600, 650};
	private LawnMover lawnMover;
	private int number;
	private int yVal;
	private ArrayList<Displayable> toRemove;
	private int boundary;

	public Row(int _num, int _yVal, int _boundary)
	{
		this.cells = new ArrayList<>();
		for(int i = 0; i < 9; i++)
			this.cells.add(new Cell());
		this.incoming = new ArrayList<>();
		this.projectiles = new ArrayList<>();
		this.toRemove = new ArrayList<>();
		this.lawnMover = new LawnMover(_boundary - 50);
		this.boundary = _boundary;
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

	public ArrayList<Displayable> getToRemove()
	{
		return toRemove;
	}

	public LawnMover getLawnMover()
	{
		return lawnMover;
	}

	public void addIncoming(Zombie z)
	{
		this.incoming.add(z);
	}

	public void update() throws ZombiesAteYourBrainsException
	{
		//Get projectiles
		this.cells.forEach((Cell c) ->
		{
			Projectile p = c.produce();
			if(p != null)
				this.projectiles.add(p);
		});

		//Move zombies
		for(Zombie z : this.incoming)
		{
			z.update();
		}

		//Move projectiles
		this.projectiles.forEach((Projectile p) ->
		{
			if(p instanceof Warhead)
				p.setxVal(p.getxVal() + 2);
			if(p.getxVal() > 1000)
			{
				this.toRemove.add(p);
				this.projectiles.remove(p);
			}
		});

		//Move mover
		{
			this.lawnMover.update();
			if(this.lawnMover.getPosition() >= 500)
				this.lawnMover = null;
		}

		//Handle bomb case
		this.projectiles.forEach((Projectile p) ->
		{
			if(p instanceof RowBlast)
			{
				if(!((RowBlast) p).isActivated())
				{
					((RowBlast) p).setActivated(true);
					this.toRemove.addAll(this.incoming);
					this.incoming.clear();
				}
				else
				{
					if(((RowBlast) p).update())
					{
						this.toRemove.add(p);
						this.projectiles.remove(p);
					}
				}
			}
			else if(p instanceof CellBlast)
			{
				if(!((CellBlast) p).isActivated())
				{
					int xVal = p.getxVal();
					for(Zombie z : this.incoming)
					{
						if(abs(z.getxVal() - xVal) <= 10)
						{
							((CellBlast) p).setActivated(true);
							this.toRemove.add(z);
							this.incoming.remove(z);
						}
					}
				}
				else
				{
					if(((CellBlast) p).update())
					{
						this.toRemove.add(p);
						this.projectiles.remove(p);
					}
				}
			}
		});

		//Handle collision
		for(Projectile p : this.projectiles)
		{
			if(p instanceof Warhead)
			{
				for(Zombie z : this.incoming)
					if(z.getxVal() - p.getxVal() < 2)
					{
						this.toRemove.add(p);
						this.projectiles.remove(p);
						if(z.takeDamage(p))
						{
							this.toRemove.add(z);
							this.incoming.remove(z);
						}
					}
			}
		}

		//Handle collision with mover
		for(Zombie z : this.incoming)
		{
			if(this.lawnMover.getPosition() > z.getxVal())
			{
				this.toRemove.add(z);
				this.incoming.remove(z);
			}
		}

		//Handle Mover
		for(Zombie z : this.incoming)
		{
			if(this.lawnMover != null && (z.getxVal() - this.boundary < 5))
				this.lawnMover.setActivated(true);
		}

		//Handle Zombie eating
		for(Zombie z : this.incoming)
		{
			for(int i = 0; i < 9; i++)
			{
				if(this.cells.get(i).hasPlant() && (abs(z.getxVal() - cellXVal[i]) < 5))
				{
					if(this.cells.get(i).takeDamage(z.getDamage()))
						z.setEating(false);
					else
						z.setEating(true);
				}
			}
		}
	}
}