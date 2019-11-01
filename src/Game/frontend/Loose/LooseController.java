package Game.frontend.Loose;

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
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}

	@FXML
	private void restartClick()
	{
		//TODO: connect
		System.out.println("restarting");
	}
}
