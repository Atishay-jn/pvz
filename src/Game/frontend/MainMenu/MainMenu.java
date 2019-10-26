package Game.frontend.MainMenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu
{
	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));
		Parent root = loader.load();
		MainMenuController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, 1500, 750));
		primaryStage.show();
	}
}