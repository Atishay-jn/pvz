package Game.frontend.ResumeGame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ResumeGameController
{
	private Stage primaryStage;
	@FXML
	private Button nextButton;
	@FXML
	private ChoiceBox<String> choiceBox;

	void setStage(Stage s)
	{
		primaryStage = s;
	}

	@FXML
	private void menuCLick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.getInstance().run(primaryStage);
	}

	@FXML
	private void nextClick() throws Exception
	{
		Game.frontend.LevelSelect.LevelSelect.getInstance().run(primaryStage);
	}

	ChoiceBox<String> getChoiceBox()
	{
		return choiceBox;
	}

	void updateButtonState(boolean disabled)
	{
		nextButton.setDisable(disabled);
	}
}
