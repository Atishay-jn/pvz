package Game.backend.Level;

import Game.backend.Grid.Grid;
import Game.backend.Zombies.*;

import java.util.ArrayList;

public final class Levels
{
	private static ArrayList<Level> levels;
//	static {
//		levels = new ArrayList<Level>();
//	}
	public static void initialize() {
		levels = new ArrayList<Level>();
		Level l;
		for(int i = 0; i < 8; i++)
		{
			l = new Level();
			levels.add(l);
		}
		levels.get(0).setReward(1);
		levels.get(1).setReward(3);
		levels.get(2).setReward(10);
		levels.get(3).setReward(7);
		levels.get(4).setReward(0);
		levels.get(5).setReward(2);
		levels.get(6).setReward(1);
		levels.get(7).setReward(1);
		Wave wave = new Wave(1, -1);
		wave = Vanilla1(wave);
		levels.get(0).addWave(wave);
//		levels.get(1).addWave(wave);
//		levels.get(2).addWave(wave);
//		wave = new Wave(3, 700);
//		wave = Vanilla3(wave);
//		levels.get(0).addWave(wave);
//		wave = new Wave(4, 700);
//		wave = Vanilla3(wave);
//		wave = Vanilla2(wave);
//		wave = Vanilla0(wave);
//		levels.get(0).addWave(wave);
//		wave = new Wave(5, 700);
//		wave = Traffic0(wave);
//		wave = Traffic1(wave);
//		wave = Vanilla2(wave);
//		wave = Vanilla3(wave);
//		wave = Vanilla4(wave);
//		levels.get(0).addWave(wave);
//		wave = new Wave(6, -1);
//		wave = Traffic(wave);
//		levels.get(0).addWave(wave);
		wave = new Wave(1, 600);
		wave = Vanilla1(wave);
		levels.get(2).addWave(wave);
		levels.get(1).addWave(wave);
		wave = new Wave(2, 300);
		wave = Vanilla1(wave);
		levels.get(1).addWave(wave);
		wave = new Wave(3, -1);
		wave = Vanilla2(wave);
		wave = Traffic1(wave);
		levels.get(1).addWave(wave);
//		wave = new Wave(4, 700);
//		wave = Vanilla0(wave);
//		wave = Vanilla1(wave);
//		wave = Vanilla2(wave);
//		wave = Vanilla3(wave);
//		wave = Vanilla3(wave);
//		levels.get(1).addWave(wave);
//		wave = new Wave(5, 500);
//		wave = Traffic3(wave);
//		wave = Traffic1(wave);
//		wave = Vanilla4(wave);
//		wave = Vanilla4(wave);
//		wave = Vanilla4(wave);
//		levels.get(1).addWave(wave);
//		wave = new Wave(6, 500);
//		wave = Traffic(wave);
//		levels.get(1).addWave(wave);
//		wave = new Wave(7, -1);
//		wave = Traffic(wave);
//		wave = Vanilla(wave);
//		wave = Runner3(wave);
//		levels.get(1).addWave(wave);
		wave = new Wave(2, 150);
		wave = Vanilla3(wave);
		wave = Vanilla3(wave);
		levels.get(2).addWave(wave);
		wave = new Wave(3, -1);
		wave = Runner2(wave);
		levels.get(2).addWave(wave);
//		wave = new Wave(4, 400);
//		wave = Traffic(wave);
//		levels.get(2).addWave(wave);
//		wave = new Wave(5, 500);
//		wave = Traffic(wave);
//		wave = Vanilla(wave);
//		wave = Vanilla(wave);
//		levels.get(2).addWave(wave);
//		wave = new Wave(6, 500);
//		wave = Traffic3(wave);
//		wave = Runner0(wave);
//		levels.get(2).addWave(wave);
//		wave = new Wave(7, -1);
//		wave = Runner(wave);
//		wave = Traffic(wave);
//		wave = Vanilla(wave);
//		levels.get(2).addWave(wave);
		wave = new Wave(1, 500);
		wave = Traffic1(wave);
		levels.get(3).addWave(wave);
		wave = new Wave(2, 500);
		wave = Traffic1(wave);
		levels.get(3).addWave(wave);
		wave = new Wave(3, 500);
		wave = Traffic3(wave);
		levels.get(3).addWave(wave);
		wave = new Wave(4, 500);
		wave = Runner0(wave);
		wave = Runner3(wave);
		wave = Runner2(wave);
		levels.get(3).addWave(wave);
		wave = new Wave(5, 500);
		wave = Runner(wave);
		wave = Vanilla(wave);
		levels.get(3).addWave(wave);
		wave = new Wave(6, 500);
		wave = Vanilla(wave);
		wave = Vanilla(wave);
		wave = Vanilla(wave);
		wave = Traffic3(wave);
		wave = Traffic0(wave);
		levels.get(3).addWave(wave);
		wave = new Wave(7, -1);
		wave = Runner(wave);
		wave = Runner(wave);
		wave = Traffic0(wave);
		wave = Traffic(wave);
		wave = Vanilla2(wave);
		wave = Vanilla4(wave);
		levels.get(3).addWave(wave);
		wave = new Wave(1, 600);
		wave = Traffic0(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(2, 600);
		wave = Traffic2(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(3, 600);
		wave = Runner4(wave);
		wave = Vanilla2(wave);
		wave = Vanilla2(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(4, 600);
		wave = Runner3(wave);
		wave = Vanilla3(wave);
		wave = Vanilla2(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(5, 600);
		wave = Runner(wave);
		wave = Vanilla(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(6, 100);
		wave = Vanilla(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(7, 600);
		wave = Traffic(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(8, 500);
		wave = Bucket3(wave);
		wave = Bucket1(wave);
		wave = Traffic0(wave);
		wave = Traffic4(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(9, -1);
		wave = Bucket(wave);
		wave = Vanilla(wave);
		levels.get(4).addWave(wave);
		wave = new Wave(1, 600);
		wave = Runner1(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(2, 500);
		wave = Runner1(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(3, 600);
		wave = Vanilla4(wave);
		wave = Vanilla3(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(4, 300);
		wave = Traffic(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(5, 400);
		wave = Vanilla(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(6, 400);
		wave = Rugby2(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(7, 200);
		wave = Traffic(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(8, 400);
		wave = Rugby(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(9, 200);
		wave = Bucket(wave);
		wave = Vanilla(wave);
		wave = Vanilla1(wave);
		wave = Vanilla0(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(10, -1);
		wave = Traffic(wave);
		wave = Rugby(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(1, 650);
		wave = Runner1(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(2, 550);
		wave = Runner2(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(3, 650);
		wave = Vanilla4(wave);
		wave = Vanilla3(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(4, 400);
		wave = Traffic(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(5, 500);
		wave = Vanilla(wave);
		wave = Vanilla(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(6, 500);
		wave = Rugby2(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(7, 200);
		wave = Traffic(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(8, 500);
		wave = Rugby(wave);
		wave = Vanilla3(wave);
		wave = Vanilla0(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(9, 400);
		wave = Bucket(wave);
		wave = Vanilla0(wave);
		wave = Vanilla(wave);
		wave = Vanilla1(wave);
		wave = Vanilla3(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(10, -1);
		wave = Runner(wave);
		wave = Vanilla(wave);
		wave = Vanilla(wave);
		wave = Rugby(wave);
		levels.get(6).addWave(wave);
		wave = new Wave(1, 600);
		wave = Traffic0(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(2, 500);
		wave = Vanilla1(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(3, 600);
		wave = Vanilla4(wave);
		wave = Vanilla3(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(4, 400);
		wave = Traffic3(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(5, 500);
		wave = Vanilla(wave);
		wave = Vanilla(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(6, 400);
		wave = Rugby2(wave);
		wave = Vanilla0(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(7, 200);
		wave = Runner(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(8, 400);
		wave = Rugby(wave);
		wave = Vanilla(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(9, 200);
		wave = Bucket(wave);
		wave = Vanilla(wave);
		wave = Vanilla1(wave);
		wave = Vanilla0(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(10, 300);
		wave = Boss3(wave);
		wave = Rugby2(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(11, 100);
		wave = Vanilla(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(12, 50);
		wave = Traffic4(wave);
		wave = Runner3(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(13, 50);
		wave = Runner2(wave);
		wave = Vanilla(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(14, 500);
		wave = Traffic(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(15, -1);
		wave = Boss(wave);
		levels.get(7).addWave(wave);
	}

	private static Wave Vanilla0(Wave wave)
	{
		wave.setRow0Zombie(new VanillaZombie(Grid.rowYVal[0]));
		return wave;
	}

	private static Wave Vanilla1(Wave wave)
	{
		wave.setRow1Zombie(new VanillaZombie(Grid.rowYVal[1]));
		return wave;
	}

	private static Wave Vanilla2(Wave wave)
	{
		wave.setRow2Zombie(new VanillaZombie(Grid.rowYVal[2]));
		return wave;
	}

	private static Wave Vanilla3(Wave wave)
	{
		wave.setRow1Zombie(new VanillaZombie(Grid.rowYVal[3]));
		return wave;
	}

	private static Wave Vanilla4(Wave wave)
	{
		wave.setRow4Zombie(new VanillaZombie(Grid.rowYVal[4]));
		return wave;
	}

	private static Wave Vanilla(Wave wave)
	{
		wave = Vanilla1(wave);
		wave = Vanilla2(wave);
		wave = Vanilla0(wave);
		wave = Vanilla3(wave);
		wave = Vanilla4(wave);
		return wave;
	}

	private static Wave Traffic0(Wave wave)
	{
		wave.setRow0Zombie(new TrafficZombie(Grid.rowYVal[0]));
		return wave;
	}

	private static Wave Traffic1(Wave wave)
	{
		wave.setRow1Zombie(new TrafficZombie(Grid.rowYVal[1]));
		return wave;
	}

	private static Wave Traffic2(Wave wave)
	{
		wave.setRow2Zombie(new TrafficZombie(Grid.rowYVal[2]));
		return wave;
	}

	private static Wave Traffic3(Wave wave)
	{
		wave.setRow1Zombie(new TrafficZombie(Grid.rowYVal[3]));
		return wave;
	}

	private static Wave Traffic4(Wave wave)
	{
		wave.setRow4Zombie(new TrafficZombie(Grid.rowYVal[4]));
		return wave;
	}

	private static Wave Traffic(Wave wave)
	{
		wave = Traffic1(wave);
		wave = Traffic2(wave);
		wave = Traffic0(wave);
		wave = Traffic3(wave);
		wave = Traffic4(wave);
		return wave;
	}

	private static Wave Runner0(Wave wave)
	{
		wave.setRow0Zombie(new RunnerZombie(Grid.rowYVal[0]));
		return wave;
	}

	private static Wave Runner1(Wave wave)
	{
		wave.setRow1Zombie(new RunnerZombie(Grid.rowYVal[1]));
		return wave;
	}

	private static Wave Runner2(Wave wave)
	{
		wave.setRow2Zombie(new RunnerZombie(Grid.rowYVal[2]));
		return wave;
	}

	private static Wave Runner3(Wave wave)
	{
		wave.setRow1Zombie(new RunnerZombie(Grid.rowYVal[3]));
		return wave;
	}

	private static Wave Runner4(Wave wave)
	{
		wave.setRow4Zombie(new RunnerZombie(Grid.rowYVal[4]));
		return wave;
	}

	private static Wave Runner(Wave wave)
	{
		wave = Runner1(wave);
		wave = Runner2(wave);
		wave = Runner0(wave);
		wave = Runner3(wave);
		wave = Runner4(wave);
		return wave;
	}

	private static Wave Rugby0(Wave wave)
	{
		wave.setRow0Zombie(new RugbyZombie(Grid.rowYVal[0]));
		return wave;
	}

	private static Wave Rugby1(Wave wave)
	{
		wave.setRow1Zombie(new RugbyZombie(Grid.rowYVal[1]));
		return wave;
	}

	private static Wave Rugby2(Wave wave)
	{
		wave.setRow2Zombie(new RugbyZombie(Grid.rowYVal[2]));
		return wave;
	}

	private static Wave Rugby3(Wave wave)
	{
		wave.setRow1Zombie(new RugbyZombie(Grid.rowYVal[3]));
		return wave;
	}

	private static Wave Rugby4(Wave wave)
	{
		wave.setRow4Zombie(new RugbyZombie(Grid.rowYVal[4]));
		return wave;
	}

	private static Wave Rugby(Wave wave)
	{
		wave = Rugby0(wave);
		wave = Rugby1(wave);
		wave = Rugby2(wave);
		wave = Rugby3(wave);
		wave = Rugby4(wave);
		return wave;
	}

	private static Wave Bucket0(Wave wave)
	{
		wave.setRow0Zombie(new BucketZombie(Grid.rowYVal[0]));
		return wave;
	}

	private static Wave Bucket1(Wave wave)
	{
		wave.setRow1Zombie(new BucketZombie(Grid.rowYVal[1]));
		return wave;
	}

	private static Wave Bucket2(Wave wave)
	{
		wave.setRow2Zombie(new BucketZombie(Grid.rowYVal[2]));
		return wave;
	}

	private static Wave Bucket3(Wave wave)
	{
		wave.setRow1Zombie(new BucketZombie(Grid.rowYVal[3]));
		return wave;
	}

	private static Wave Bucket4(Wave wave)
	{
		wave.setRow4Zombie(new BucketZombie(Grid.rowYVal[4]));
		return wave;
	}

	private static Wave Bucket(Wave wave)
	{
		wave = Bucket0(wave);
		wave = Bucket1(wave);
		wave = Bucket2(wave);
		wave = Bucket3(wave);
		wave = Bucket4(wave);
		return wave;
	}

	private static Wave Boss0(Wave wave)
	{
		wave.setRow0Zombie(new BossZombie(Grid.rowYVal[0]));
		return wave;
	}

	private static Wave Boss1(Wave wave)
	{
		wave.setRow1Zombie(new BossZombie(Grid.rowYVal[1]));
		return wave;
	}

	private static Wave Boss2(Wave wave)
	{
		wave.setRow2Zombie(new BossZombie(Grid.rowYVal[2]));
		return wave;
	}

	private static Wave Boss3(Wave wave)
	{
		wave.setRow1Zombie(new BossZombie(Grid.rowYVal[3]));
		return wave;
	}

	private static Wave Boss4(Wave wave)
	{
		wave.setRow4Zombie(new BossZombie(Grid.rowYVal[4]));
		return wave;
	}

	private static Wave Boss(Wave wave)
	{
		wave = Boss0(wave);
		wave = Boss1(wave);
		wave = Boss2(wave);
		wave = Boss3(wave);
		wave = Boss4(wave);
		return wave;
	}

	public static Level getLevel(int idx)
	{
		return levels.get(idx - 1);
	}
}
