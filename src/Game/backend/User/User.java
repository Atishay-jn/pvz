package Game.backend.User;

import Game.backend.DynamicObjects.DynamicObject;
import Game.backend.Exceptions.InsufficientCoinsException;
import Game.backend.Exceptions.InsufficientSunsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class User implements Serializable
{
	private static final long serialVersionUID = 1;
	private String name;
	private int levels;
	private int coins;
	private int currentlyAt = -1;
	private boolean[] plantUnlocked = new boolean[11];
	private LinkedHashMap<Integer, Integer> selectedPlants = new LinkedHashMap<>();
	private int currentWaveNumber;
	private int waveCountdown;
	private int currentSuns;
	private int currentLevel;
	private ArrayList<DynamicObject> currentDynamicObjects = new ArrayList<>();
	private int fallCounter;

	public User(String name)
	{
		this.name = name;
		this.levels = 1;
		this.coins = 0;
		this.plantUnlocked[4] = true;
		this.plantUnlocked[9] = true;
		this.currentWaveNumber = -1;
		this.waveCountdown = 0;
		this.currentSuns = -1;
		this.fallCounter = 0;
	}

	public int getCurrentlyAt()
	{
		return currentlyAt;
	}

	public void setCurrentlyAt(int currentlyAt)
	{
		this.currentlyAt = currentlyAt;
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

	public LinkedHashMap<Integer, Integer> getSelectedPlants()
	{
		return selectedPlants;
	}

	public void setSelectedPlants(HashMap<Integer, Integer> map)
	{
		selectedPlants = new LinkedHashMap<>(map);
	}

	public int getCurrentWaveNumber()
	{
		return currentWaveNumber;
	}

	public void setCurrentWaveNumber(int currentWaveNumber)
	{
		this.currentWaveNumber = currentWaveNumber;
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

	public void updateWaveCountdown()
	{
		if(this.waveCountdown > 0)
			this.waveCountdown--;
	}

	public int getWaveCountdown()
	{
		return waveCountdown;
	}

	public void setWaveCountdown(int waveCountdown)
	{
		this.waveCountdown = waveCountdown;
	}

	public void resetStats()
	{
		this.currentlyAt = -1;
		this.currentWaveNumber = -1;
		this.waveCountdown = 0;
		this.currentSuns = 0;
		this.currentDynamicObjects.clear();
		this.fallCounter = 0;
	}

	public void unlockPlant(int idx)
	{
		this.plantUnlocked[idx] = true;
	}

	public int getCurrentLevel()
	{
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel)
	{
		this.currentLevel = currentLevel;
	}

	public int getFallCounter()
	{
		return fallCounter;
	}

	public void setFallCounter(int fallCounter)
	{
		this.fallCounter = fallCounter;
	}

	public void collectSun(int suns)
	{
		this.currentSuns += suns;
	}

	public void collectCoins(int coins)
	{
		this.coins += coins;
	}

	public void setLevels(int levels)
	{
		this.levels = levels;
	}

	public void unlock(int idx)
	{
		this.plantUnlocked[idx] = true;
	}
}
