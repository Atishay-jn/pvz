package Game.backend.Level;

import Game.backend.Zombies.TrafficZombie;
import Game.backend.Zombies.VanillaZombie;

import java.util.ArrayList;

public final class Levels
{
	private static ArrayList<Level> levels;
	static {
		levels = new ArrayList<Level>();
	}
	public static void initialize() {
		Level l;
		for(int i=0;i<8;i++) {
			l = new Level();
			levels.add(l);
		}
		Wave wave = new Wave(1,700);
		wave.setRow1Zombie(new VanillaZombie());
		levels.get(0).addWave(wave);
		levels.get(1).addWave(wave);
		levels.get(2).addWave(wave);
		wave = new Wave(1,700);
		wave.setRow1Zombie(new VanillaZombie());
		wave.setRow3Zombie(new VanillaZombie());
		levels.get(3).addWave(wave);
		levels.get(4).addWave(wave);
		levels.get(5).addWave(wave);
		wave = new Wave(1,700);
		wave.setRow1Zombie(new TrafficZombie());
		wave.setRow4Zombie(new VanillaZombie());
		levels.get(6).addWave(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(2,700);
		wave.setRow4Zombie(new VanillaZombie(1200));
		levels.get(0).addWave(wave);
		wave.setRow3Zombie(new VanillaZombie(1200));
		levels.get(1).addWave(wave);
		levels.get(2).addWave(wave);
		wave.setRow2Zombie(new TrafficZombie(1200));
		levels.get(3).addWave(wave);
		levels.get(4).addWave(wave);
		wave.setRow4Zombie(new VanillaZombie(1200));
		levels.get(4).addWave(wave);
		levels.get(5).addWave(wave);
		levels.get(6).addWave(wave);
		levels.get(7).addWave(wave);
		wave = new Wave(3,800);
		wave.setRow3Zombie(new TrafficZombie(1200));
	}

	public static Level getLevel(int idx)
	{
		return levels.get(idx);
	}

}
