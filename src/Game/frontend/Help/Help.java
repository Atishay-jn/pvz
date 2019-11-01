package Game.frontend.Help;

import Game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Help
{
	private static HelpController controller = null;

	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(Help.class.getResource("Help.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}