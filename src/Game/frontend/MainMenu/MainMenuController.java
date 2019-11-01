package Game.frontend.MainMenu;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainMenuController
{
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void resumeClick() throws Exception
	{
		Game.frontend.ResumeGame.ResumeGame.run(primaryStage);
		System.out.println("resume click");
	}

	@FXML
	private void helpClick() throws Exception
	{
		//TODO: connect
		Game.frontend.GameWindow.GameWindow.run(primaryStage, true);
		//		Game.frontend.Help.Help.run(primaryStage);
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
