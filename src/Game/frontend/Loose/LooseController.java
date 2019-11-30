package Game.frontend.Loose;

import Game.backend.User.CurrentUser;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LooseController
{
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void menuClick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.getInstance().run(primaryStage);
	}

	@FXML
	private void restartClick() throws Exception
	{
		CurrentUser.getUser().setCurrentlyAt(-1);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}
}
