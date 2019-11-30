package Game.frontend.LevelSelect;

import Game.backend.Exceptions.LevelNotAvailableException;
import Game.backend.User.CurrentUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LevelSelectController
{
	private Stage primaryStage;
	@FXML
	private Label levelIndicator;

	public void setPrimaryStage(Stage primaryStage) throws Exception
	{
		this.primaryStage = primaryStage;
		System.out.println("Current level: " + CurrentUser.getUser().getCurrentlyAt());
		if(CurrentUser.getUser().getCurrentlyAt() != -1)
		{
			Game.frontend.GameWindow.GameWindow.getInstance().run(primaryStage);
		}
		levelIndicator.setText("Your level: " + CurrentUser.getUser().getLevels());
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.ResumeGame.ResumeGame.getInstance().run(primaryStage);
	}

	@FXML
	private void level1Click() throws Exception
	{
		play(1);
	}

	@FXML
	private void level2Click() throws Exception
	{
		play(2);
	}

	@FXML
	private void level3Click() throws Exception
	{
		play(3);
	}

	@FXML
	private void level4Click() throws Exception
	{
		play(4);
	}

	@FXML
	private void level5Click() throws Exception
	{
		play(5);
	}

	@FXML
	private void level6Click() throws Exception
	{
		play(6);
	}

	@FXML
	private void level7Click() throws Exception
	{
		play(7);
	}

	@FXML
	private void level8Click() throws Exception
	{
		play(8);
	}

	private void play(int num) throws Exception
	{
		System.out.println("Chosen level: " + num);
		try
		{
			if(CurrentUser.getUser().getLevels() < num)
				throw new LevelNotAvailableException("Not yet unlocked");
			CurrentUser.getUser().setCurrentLevel(num);
			System.out.println("Playing: " + num);
			Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
		}
		catch(LevelNotAvailableException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
