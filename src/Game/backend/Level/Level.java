package Game.backend.Level;

import Game.backend.Plants.Plant;

import java.util.ArrayList;

public final class Level
{
	private ArrayList<Wave> wave;
	private int number;
	private Plant reward;

	public void addWave(Wave w) {
		wave.add(w);
	}

	public Wave getWave(int idx)
	{
		return wave.get(idx);
	}

	public int getNumber()
	{
		return number;
	}

	public Plant getReward()
	{
		return reward;
	}

	public int getNumWaves()
	{
		return this.wave.size();
	}
}
