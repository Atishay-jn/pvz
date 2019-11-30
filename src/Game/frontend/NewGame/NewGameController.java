package Game.frontend.NewGame;

import Game.backend.Exceptions.UsernameExistsException;
import Game.backend.User.CurrentUser;
import Game.backend.User.SaveGame;
import Game.backend.User.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

public class NewGameController
{
	@FXML
	private Button addUserButton;
	@FXML
	private TextField usernameTextBox;
	private Stage primaryStage;
	private String input;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		addUserButton.setDisable(true);
	}

	@FXML
	private void newUserClick() throws Exception
	{
		if(!new File("UserFiles/" + input).mkdir())
			throw new UsernameExistsException("User already exists");
		User user = new User(input);
		CurrentUser.setUser(user);
		SaveGame.serialize();
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
		File user_dir = new File("UserFiles/" + input);
		if(user_dir.exists())
			isDisabled = true;
		addUserButton.setDisable(isDisabled);
	}
}

