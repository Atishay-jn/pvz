package Game.frontend.NewGame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Game.backend.User.User;
import Game.backend.User.CurrentUser;

public class NewGameController
{
	@FXML
	private Button addUserButton;
	@FXML
	private TextField usernameTextBox;
	private Stage primaryStage;
	@FXML
	private ImageView zombieImage;
	@FXML
	private AnchorPane pane;
	private String input;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		addUserButton.setDisable(true);
	}

	@FXML
	private void newUserClick() throws Exception
	{
		User user = new User(input);
		CurrentUser.setUser(user);
		Game.frontend.LevelSelect.LevelSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void mainMenuClick() throws Exception
	{
		Game.frontend.MainMenu.MainMenu.getInstance().run(primaryStage);
	}

	@FXML
	private void usernameKeyRelease()
	{
		this.input = usernameTextBox.getText();
		boolean isDisabled = input.isEmpty() || !input.matches("[a-zA-Z0-9]+");
		addUserButton.setDisable(isDisabled);
	}
}

