package Game.frontend.LevelSelect;

import Game.Main;
import Game.backend.User.CurrentUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelSelect extends CurrentUser
{
	private static LevelSelect uniqueInstance = null;

	private LevelSelect()
	{
	}

	public static LevelSelect getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new LevelSelect();
		return uniqueInstance;
	}

	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(LevelSelect.class.getResource("LevelSelect.fxml"));
		Parent root = loader.load();
		LevelSelectController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}
}
