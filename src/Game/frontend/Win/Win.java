package Game.frontend.Win;

import Game.Main;
import Game.backend.User.SaveGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Win extends SaveGame
{
	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(Win.class.getResource("Win.fxml"));
		Parent root = loader.load();
		WinController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
