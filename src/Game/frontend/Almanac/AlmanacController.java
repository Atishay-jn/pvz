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
	private void plantClick()
	{
		System.out.println("PlantClick");
	}

	@FXML
	private void zombieClick()
	{
		System.out.println("ZombieClick");
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
}
