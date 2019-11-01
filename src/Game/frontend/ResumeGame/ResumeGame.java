package Game.frontend.ResumeGame;

import Game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ResumeGame
{
	private static ChoiceBox<String> userChoice = null;
	private static ResumeGameController controller = null;

	public static void run(Stage primaryStage) throws Exception
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

	private static void setUpChoices()
	{
		userChoice.getItems().addAll("User1", "User2", "User3", "User4", "User5", "---");
		userChoice.setValue("---");
	}

	private static void newChoice(String value)
	{
		if(value.equals("---"))
			controller.updateButtonState(true);
		else
			controller.updateButtonState(false);
	}
}
