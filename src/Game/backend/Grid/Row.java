package Game.backend.Grid;

import Game.backend.LawnMover;
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

	//TODO
}
