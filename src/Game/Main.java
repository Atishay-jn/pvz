package Game;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	public static final int width = 1300;
	public static final int height = 710;
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Plants vs Zombies");
		primaryStage.setResizable(false);
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}
}
