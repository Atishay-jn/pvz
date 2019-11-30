package Game.frontend.Win;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class WinController
{
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void mainClick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.getInstance().run(primaryStage);
	}

	@FXML
	private void restartClick() throws Exception
	{
		Game.frontend.LevelSelect.LevelSelect.getInstance().run(primaryStage);
	}
}
