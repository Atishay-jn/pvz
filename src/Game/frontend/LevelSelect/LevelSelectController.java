package Game.frontend.LevelSelect;

import Game.backend.User.CurrentUser;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LevelSelectController
{
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.ResumeGame.ResumeGame.getInstance().run(primaryStage);
	}

	@FXML
	private void level1Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(1);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void level2Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(2);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void level3Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(3);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void level4Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(4);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void level5Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(5);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void level6Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(6);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void level7Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(7);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void level8Click() throws Exception
	{
		CurrentUser.getUser().setCurrentLevel(8);
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}
}
