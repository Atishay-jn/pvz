package Game.frontend.PlantSelect;

import Game.Main;
import Game.backend.User.CurrentUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlantSelect extends CurrentUser
{
	private static PlantSelect uniqueInstance = null;
	private PlantSelect() {}
	public static PlantSelect getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new PlantSelect();
		return uniqueInstance;
	}
	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(PlantSelect.class.getResource("PlantSelect.fxml"));
		Parent root = loader.load();
		PlantSelectController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
