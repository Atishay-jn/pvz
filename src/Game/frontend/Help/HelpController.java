package Game.frontend.Help;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class HelpController
{
	private Stage primaryStage;

	@FXML
	private void mainMenuClick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}

	@FXML
	private void almanacClicked()
	{
		System.out.println("Almanac clicked");
	}

	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
}
