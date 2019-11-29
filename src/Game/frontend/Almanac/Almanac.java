package Game.frontend.Almanac;

import Game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Almanac
{
	private static Almanac uniqueInstance = null;
	private Almanac() {}
	public static Almanac getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Almanac();
		return uniqueInstance;
	}
	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(Almanac.class.getResource("Almanac.fxml"));
		Parent root = loader.load();
		AlmanacController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
