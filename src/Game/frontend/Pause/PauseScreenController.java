package Game.frontend.Pause;

import Game.backend.User.CurrentUser;
import Game.backend.User.SaveGame;
import Game.frontend.GameWindow.GameWindow;
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
		CurrentUser.getUser().setCurrentlyAt(CurrentUser.getUser().getCurrentLevel());
		SaveGame.serialize();
		GameWindow.getInstance().saveGrid();
		Game.frontend.MainMenu.MainMenu.getInstance().run(primaryStage);
	}

	@FXML
	private void resumeClick()
	{
		Game.frontend.GameWindow.GameWindow.getInstance().resumeTimer();
		this.window.close();
		//		Game.frontend.GameWindow.GameWindow.run(primaryStage);
	}

	@FXML
	private void restartClick() throws Exception
	{
		this.window.close();
		CurrentUser.getUser().setCurrentlyAt(-1);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}
}
