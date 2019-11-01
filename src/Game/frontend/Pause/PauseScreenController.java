package Game.frontend.Pause;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PauseScreenController
{
	private Stage window;
	private Stage primaryStage;

	void setWindow(Stage s)
	{
		this.window = s;
	}

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void mainMenuClick() throws Exception
	{
		this.window.close();
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}

	@FXML
	private void resumeClick() throws Exception
	{
		Game.frontend.GameWindow.GameWindow.run(primaryStage, false);
	}

	@FXML
	private void restartClick()
	{
		System.out.println("restart clicked");
	}
}
