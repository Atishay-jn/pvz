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
		Game.frontend.ResumeGame.ResumeGame.getInstance().run(primaryStage);
		System.out.println("resume click");
	}

	@FXML
	private void helpClick() throws Exception
	{
		Game.frontend.GameWindow.GameWindow.getInstance().run(primaryStage);
//				Game.frontend.Help.Help.getInstance().run(primaryStage);
	}

	@FXML
	private void exitClick()
	{
		primaryStage.close();
		System.exit(0);
	}

	@FXML
	private void newGameClick() throws Exception
	{
		Game.frontend.NewGame.NewGame.getInstance().run(primaryStage);
		System.out.println("new Game");
	}
}
