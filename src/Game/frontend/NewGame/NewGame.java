package Game.frontend.NewGame;

import Game.Main;
import Game.backend.User.CurrentUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGame extends CurrentUser
{
	private static NewGame uniqueInstance = null;
	private NewGame() {}
	public static NewGame getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new NewGame();
		return uniqueInstance;
	}
	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(NewGame.class.getResource("NewGame.fxml"));
		Parent root = loader.load();
		NewGameController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
