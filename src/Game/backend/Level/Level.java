package Game.backend.Level;

import Game.backend.Plants.Plant;

import java.util.ArrayList;

public final class Level
{
	private ArrayList<Wave> wave;
	private int number;
	private int reward;

	Level() {
		wave = new ArrayList<Wave>(10);
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

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

	public int getReward()
	{
		return reward;
	}

	public int getNumWaves()
	{
		return this.wave.size();
	}
}
