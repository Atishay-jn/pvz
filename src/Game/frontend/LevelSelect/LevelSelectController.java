package Game.frontend.LevelSelect;

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
		Game.frontend.ResumeGame.ResumeGame.run(primaryStage);
	}

	@FXML
	private void level1Click()
	{
		//TODO
		System.out.println("level 1");
	}

	@FXML
	private void level2Click()
	{
		System.out.println("level 2");
	}

	@FXML
	private void level3Click()
	{
		System.out.println("level 3");
	}

	@FXML
	private void level4Click()
	{
		System.out.println("level 4");
	}

	@FXML
	private void level5Click()
	{
		System.out.println("level 5");
	}

	@FXML
	private void level6Click()
	{
		System.out.println("level 6");
	}

	@FXML
	private void level7Click()
	{
		System.out.println("level 7");
	}

	@FXML
	private void level8Click()
	{
		System.out.println("level 8");
	}
}
