package Game.frontend.Almanac;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AlmanacController
{
	private Stage primaryStage;

	@FXML
	private void mainMenuClick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}

	@FXML
	private void plantClick() throws Exception
	{
		Game.frontend.PlantList.PlantList.run(primaryStage);
	}

	@FXML
	private void zombieClick() throws Exception
	{
		Game.frontend.ZombieList.ZombieList.run(primaryStage);
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
}
