package Game.backend.Zombies;

import Game.backend.Displayable;
import Game.backend.Exceptions.ZombiesAteYourBrainsException;
import Game.backend.Projectiles.Projectile;
import Game.backend.Projectiles.Warhead.Warhead;

import java.io.Serializable;

public abstract class Zombie implements Displayable, Serializable, Cloneable
{
	private static final long serialVersionUID = 1;
	public static final int width = 90;
	public static final int height = 150;
	boolean frozen;
	private int health;
	private int speed;
	private int xVal;
	private int yVal;
	private int frozenTime;
	private int damage;
	private boolean eating;

	public Zombie(int health, int speed, int _yVal, int damage)
	{
		this.health = health;
		this.speed = speed;
		this.xVal = 1200;
		this.yVal = _yVal - height;
		this.frozen = false;
		this.frozenTime = 0;
		this.damage = damage;
		this.eating = false;
	}

	public boolean takeDamage(Projectile p)
	{
		if(p instanceof Game.backend.Projectiles.Warhead.Icy)
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

	public int getDamage()
	{
		return damage;
	}

	public void setEating(boolean eating)
	{
		this.eating = eating;
	}

	public void update() throws ZombiesAteYourBrainsException
	{
		int curSpeed = this.speed;
		if(this.eating)
			curSpeed = 0;
		if(this.frozen)
			this.frozenTime++;
		if(this.frozenTime >= 50)
		{
			this.frozenTime = 0;
			this.frozen = false;
		}
		if(this.frozen)
			this.xVal -= curSpeed / 2;
		else
			this.xVal -= curSpeed;
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

	public int getyVal()
	{
		return yVal;
	}

	protected void setyVal(int yVal)
	{
		this.yVal = yVal;
	}
}
