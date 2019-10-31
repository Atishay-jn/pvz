package Game.frontend.NewGame;

import Game.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class NewGame
{
	private static ImageView zombieImage = null;
	private static Timer timer;
	private static NewGameController controller = null;

	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(NewGame.class.getResource("NewGame.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		zombieImage = controller.getZombieImage();
		zombieImage.setX(1300);

		timer = new Timer();
		timer.schedule(new updater(), 0, 50);
		controller.setTimer(timer);

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	static class updater extends TimerTask
	{
		@Override
		public void run()
		{
			System.out.println(zombieImage.getX());
			zombieImage.setX(zombieImage.getX() - 10);
			if(zombieImage.getX() <= 0)
			{
				timer.cancel();
				System.out.println("removing");
				Platform.runLater(() -> controller.removeZombie());
			}
		}
	}
}
