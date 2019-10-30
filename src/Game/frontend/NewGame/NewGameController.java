package Game.frontend.NewGame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewGameController
{
	@FXML
	private Button addUserButton;
	@FXML
	private TextField usernameTextBox;
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		addUserButton.setDisable(true);
	}

	@FXML
	private void newUserClick()
	{
		System.out.println("New user by the name: " + usernameTextBox.getText());
	}

	@FXML
	private void mainMenuClick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.run(primaryStage);
	}

	@FXML
	private void usernameKeyRelease()
	{
		String input = usernameTextBox.getText();
		boolean isDisabled = input.isEmpty() || !input.matches("[a-zA-Z0-9]+");
		addUserButton.setDisable(isDisabled);
	}
}

