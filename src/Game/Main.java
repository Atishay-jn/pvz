package Game;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Plants vs Zombies");
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}
}
