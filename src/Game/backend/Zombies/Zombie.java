package Game.backend.Zombies;

import Game.backend.Displayable;
import Game.backend.Exceptions.ZombiesAteYourBrainsException;
import Game.backend.Projectiles.Projectile;
import Game.backend.Projectiles.Warhead.Warhead;

import java.io.Serializable;

public abstract class Zombie implements Displayable, Serializable, Cloneable
{
	private static final long serialVersionUID = 1;
	boolean frozen;
	private int health;
	private int speed;
	private int xVal;
	private int frozenTime;

	protected Zombie(int health, int speed, int xVal)
	{
		this.health = health;
		this.speed = speed;
		this.xVal = xVal;
		this.frozen = false;
		this.frozenTime = 0;
	}

	public boolean takeDamage(Projectile p)
	{
		if(p instanceof Game.backend.Projectiles.Bomb.Bomb)
			this.health = 0;
		else if(p instanceof Game.backend.Projectiles.Warhead.Icy)
		{
			this.frozen = true;
			Warhead w = (Game.backend.Projectiles.Warhead.Warhead) p;
			this.health -= w.getDamage();
		}
		else if(p instanceof Game.backend.Projectiles.Warhead.Firey)
		{
			this.frozen = false;
			this.frozenTime = 0;
			Warhead w = (Game.backend.Projectiles.Warhead.Warhead) p;
			this.health -= w.getDamage();
		}
		else
		{
			Warhead w = (Game.backend.Projectiles.Warhead.Normal) p;
			this.health -= w.getDamage();
		}
		return this.health <= 0;
	}

	public int getxVal()
	{
		return xVal;
	}

	public void update() throws ZombiesAteYourBrainsException
	{
		if(this.frozen)
			this.frozenTime++;
		if(this.frozenTime >= 50)
		{
			this.frozenTime = 0;
			this.frozen = false;
		}
		if(this.frozen)
			this.xVal -= speed / 2;
		else
			this.xVal -= this.speed;
		if(this.xVal < 100)
			throw new ZombiesAteYourBrainsException("You Loose");
	}

	public Zombie clone()
	{
		try
		{
			return (Zombie) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			return null;
		}
	}
}
