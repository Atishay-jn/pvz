package Game.backend.Zombies;

import java.io.Serializable;

public final class VanillaZombie extends Zombie implements Serializable
{
	private static final long serialVersionUID = 1;

	public VanillaZombie(int yVal)
	{
		super(200, 2, yVal, 1);
	}

	@Override
	public String getImage()
	{
		return "Game/assets/backend/Zombies/LawnZombie.gif";
	}

	public VanillaZombie clone()
	{
		return (VanillaZombie) super.clone();
	}
}
