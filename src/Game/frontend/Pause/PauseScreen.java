package Game.frontend.Pause;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PauseScreen
{
	public static void run(Stage primaryStage) throws Exception
	{
		Stage pauseWindow = new Stage();
		pauseWindow.initModality(Modality.APPLICATION_MODAL);
		pauseWindow.setTitle("Plants vs Zombie");
		pauseWindow.setResizable(false);
		pauseWindow.initStyle(StageStyle.UNDECORATED);

		FXMLLoader loader = new FXMLLoader(PauseScreen.class.getResource("PauseScreen.fxml"));
		Parent root = loader.load();
		PauseScreenController controller = loader.getController();
		controller.setWindow(pauseWindow);
		controller.setPrimaryStage(primaryStage);
		pauseWindow.setScene(new Scene(root, 600, 500));
		pauseWindow.showAndWait();
	}
}
