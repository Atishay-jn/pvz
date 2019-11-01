package Game.frontend.NewGame;

import Game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGame
{
	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(NewGame.class.getResource("NewGame.fxml"));
		Parent root = loader.load();
		NewGameController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
