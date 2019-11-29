package Game.frontend.ResumeGame;

import Game.Main;
import Game.backend.User.CurrentUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ResumeGame extends CurrentUser
{
	private static ResumeGame uniqueInstance = null;
	private ResumeGame() {}
	public static ResumeGame getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new ResumeGame();
		return uniqueInstance;
	}
	private ChoiceBox<String> userChoice = null;
	private ResumeGameController controller = null;

	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(ResumeGame.class.getResource("ResumeGame.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		controller.setStage(primaryStage);
		userChoice = controller.getChoiceBox();
		setUpChoices();
		userChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> newChoice(newValue));

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private void setUpChoices()
	{
		userChoice.getItems().addAll("User1", "User2", "User3", "User4", "User5", "---");
		userChoice.setValue("---");
	}

	private void newChoice(String value)
	{
		if(value.equals("---"))
			controller.updateButtonState(true);
		else
			controller.updateButtonState(false);
	}
}
