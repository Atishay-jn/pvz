package Game.backend.Level;

import java.util.ArrayList;

public final class Levels
{
	private static ArrayList<Level> levels;

	public static void initialize()
	{
		//TODO
	}

	public static Level getLevel(int idx)
	{
		return levels.get(idx);
	}

}
