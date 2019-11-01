package Game.frontend.MainMenu;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainMenuController
{
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private void resumeClick() throws Exception {
		Game.frontend.ResumeGame.ResumeGame.run(primaryStage);
		System.out.println("resume click");
	}

	@FXML
	private void helpClick()
	{
		System.out.println("Help click");
	}

	@FXML
	private void exitClick()
	{
		primaryStage.close();
	}

	@FXML
	private void newGameClick() throws Exception
	{
		Game.frontend.NewGame.NewGame.run(primaryStage);
		System.out.println("new Game");
	}
}
