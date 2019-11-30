package Game.backend.Level;

import Game.backend.Grid.Grid;
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
		wave.setRow1Zombie(new VanillaZombie(Grid.rowYVal[1]));
		levels.get(0).addWave(wave);
		levels.get(1).addWave(wave);
		levels.get(2).addWave(wave);
		wave = new Wave(2,700);
		wave.setRow1Zombie(new VanillaZombie(Grid.rowYVal[1]));
		levels.get(0).addWave(wave);
		levels.get(1).addWave(wave);
		wave = new Wave(3,700);
		wave.setRow3Zombie(new VanillaZombie(Grid.rowYVal[3]));
		levels.get(0).addWave(wave);
		wave = new Wave(4,700);
		wave.setRow3Zombie(new VanillaZombie(Grid.rowYVal[3]));
		wave.setRow2Zombie(new VanillaZombie(Grid.rowYVal[2]));
		wave.setRow0Zombie(new VanillaZombie(Grid.rowYVal[0]));
		levels.get(0).addWave(wave);
		wave = new Wave(5, 700);
		wave.setRow1Zombie(new TrafficZombie(Grid.rowYVal[1]));
		wave.setRow0Zombie(new TrafficZombie(Grid.rowYVal[0]));
		wave.setRow3Zombie(new VanillaZombie(Grid.rowYVal[3]));
		wave.setRow2Zombie(new VanillaZombie(Grid.rowYVal[2]));
		wave.setRow4Zombie(new VanillaZombie(Grid.rowYVal[4]));
		levels.get(0).addWave(wave);
		wave = new Wave(6,-1);
		wave.setRow0Zombie(new TrafficZombie(Grid.rowYVal[0]));
		wave.setRow1Zombie(new TrafficZombie(Grid.rowYVal[1]));
		wave.setRow2Zombie(new TrafficZombie(Grid.rowYVal[2]));
		wave.setRow3Zombie(new TrafficZombie(Grid.rowYVal[3]));
		wave.setRow4Zombie(new TrafficZombie(Grid.rowYVal[4]));
		levels.get(0).addWave(wave);
		wave = new Wave(3,700);

	}

	public static Level getLevel(int idx)
	{
		return levels.get(idx);
	}

}
