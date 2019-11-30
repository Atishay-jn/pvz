package Game.frontend.Win;

import Game.Main;
import Game.backend.User.SaveGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Win extends SaveGame
{
	private static Win uniqueInstance = null;
	private Win() {}
	public static Win getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Win();
		return uniqueInstance;
	}
	public void run(Stage primaryStage) throws Exception
	{
		SaveGame.serialize();
		FXMLLoader loader = new FXMLLoader(Win.class.getResource("Win.fxml"));
		Parent root = loader.load();
		WinController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
