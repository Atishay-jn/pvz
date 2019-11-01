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
		System.out.println("Returning to menu");
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}

	@FXML
	private void nextClick()
	{
		System.out.println(choiceBox.getValue() + " selected");
		System.out.println("Going to level select");
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
