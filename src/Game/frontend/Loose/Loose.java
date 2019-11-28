package Game.frontend.Loose;

import Game.Main;
import Game.backend.User.SaveGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loose extends SaveGame
{
	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(Loose.class.getResource("Loose.fxml"));
		Parent root = loader.load();
		LooseController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
