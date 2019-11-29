package Game.frontend.Help;

import Game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Help
{
	private static Help uniqueInstance = null;
	private Help() {}
	public static Help getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Help();
		return uniqueInstance;
	}
	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(Help.class.getResource("Help.fxml"));
		Parent root = loader.load();
		HelpController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}