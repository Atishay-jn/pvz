package Game.frontend.PlantSelect;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PlantSelectController
{
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.LevelSelect.LevelSelect.run(primaryStage);
	}

	@FXML
	private void shopClick() throws Exception
	{
		Game.frontend.Shop.Shop.run(primaryStage);
	}
}
