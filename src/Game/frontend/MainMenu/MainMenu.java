package Game.frontend.MainMenu;

import Game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu
{
	private static MainMenu uniqueInstance = null;
	private MainMenu() {}
	public static MainMenu getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new MainMenu();
		return uniqueInstance;
	}
	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(MainMenu.class.getResource("MainMenu.fxml"));
		Parent root = loader.load();
		MainMenuController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
