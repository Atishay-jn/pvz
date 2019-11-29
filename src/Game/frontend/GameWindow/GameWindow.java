package Game.frontend.GameWindow;

import Game.Main;
import Game.backend.User.SaveGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class GameWindow extends SaveGame
{
	private static long count = 0;
	private static GameWindowController controller = null;
	private static Label coinCounter = null;
	private static Label sunCounter = null;
	private static ProgressBar waveProgress = null;
	private static AnchorPane pane = null;
	private static Timer timer;

	public static void resumeTimer()
	{
		timer = new Timer();
		controller.setTimer(timer);
		timer.schedule(new Game.frontend.GameWindow.GameWindow.updater(), 0, 10);
	}

	public static void run(Stage primaryStage) throws Exception
	{

		FXMLLoader loader = new FXMLLoader(GameWindow.class.getResource("GameWindow.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		controller.setUp();
		count = 0;
		fetchObjects();

		timer = new Timer();
		controller.setTimer(timer);
		timer.schedule(new Game.frontend.GameWindow.GameWindow.updater(), 0, 10);

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private static void fetchObjects()
	{
		coinCounter = controller.getCoinCounter();
		sunCounter = controller.getSunCounter();
		waveProgress = controller.getWaveProgress();
		pane = controller.getPane();
	}

	static class updater extends TimerTask
	{
		@Override
		public void run()
		{
		}
	}
}
