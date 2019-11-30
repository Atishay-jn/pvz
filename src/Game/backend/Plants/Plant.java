package Game.backend.Plants;

import Game.backend.Displayable;

import java.io.Serializable;

public abstract class Plant implements Displayable, Serializable
{
	private static final long serialVersionUID = 1;
	protected int health;

	public int getHealth()
	{
		return this.health;
	}

	public boolean takeDamage(int damage)
	{
		this.health -= damage;
		return this.health <= 0;
	}

	public abstract int getCost();

	public abstract void resetCooldown();
}
