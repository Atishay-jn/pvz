package Game.frontend.Help;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class HelpController
{
	private Stage primaryStage;

	@FXML
	private void mainMenuClick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.getInstance().run(primaryStage);
	}

	@FXML
	private void almanacClicked() throws Exception
	{
		Game.frontend.Almanac.Almanac.run(primaryStage);
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
}
