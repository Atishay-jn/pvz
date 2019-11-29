package Game.backend.User;

import Game.backend.DynamicObjects.DynamicObject;
import Game.backend.Exceptions.InsufficientCoinsException;
import Game.backend.Exceptions.InsufficientSunsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public final class User implements Serializable
{
	private static final long serialVersionUID = 1;
	private String name;
	private int levels;
	private int coins;
	private boolean[] plantUnlocked = new boolean[11];
	private HashMap<Integer, Integer> selectedPlants = new HashMap<>();
	private int currentWaveNumber;
	private int currentSuns;
	private ArrayList<DynamicObject> currentDynamicObjects = new ArrayList<>();

	public User(String name)
	{
		this.name = name;
		this.levels = 1;
		this.coins = 0;
		this.plantUnlocked[0] = true;
		this.currentWaveNumber = -1;
		this.currentSuns = -1;
	}

	public boolean[] getPlantUnlocked()
	{
		return plantUnlocked;
	}

	public String getName()
	{
		return name;
	}

	public int getLevels()
	{
		return levels;
	}

	public int getCoins()
	{
		return coins;
	}

	public HashMap<Integer, Integer> getSelectedPlants()
	{
		return selectedPlants;
	}

	public int getCurrentWaveNumber()
	{
		return currentWaveNumber;
	}

	public int getCurrentSuns()
	{
		return currentSuns;
	}

	public ArrayList<DynamicObject> getCurrentDynamicObjects()
	{
		return currentDynamicObjects;
	}

	public void buy(int _coins) throws InsufficientCoinsException
	{
		if(this.coins < _coins)
			throw new InsufficientCoinsException("Not enough coins!");
		this.coins -= _coins;
	}

	public void spendSuns(int _suns) throws InsufficientSunsException
	{
		if(this.currentSuns < _suns)
			throw new InsufficientSunsException("Not enough suns!");
		this.currentSuns -= _suns;
	}
}