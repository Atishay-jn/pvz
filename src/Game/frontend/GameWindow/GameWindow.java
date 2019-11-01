package Game.frontend.GameWindow;

import Game.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class GameWindow
{
	private static boolean mover4en = false;
	private static long count = 0;
	private static GameWindowController controller = null;
	private static ImageView slot1 = null;
	private static ImageView mover1 = null;
	private static ImageView mover2 = null;
	private static ImageView mover3 = null;
	private static ImageView mover4 = null;
	private static ImageView mover5 = null;
	private static Label coinCounter = null;
	private static Label sunCounter = null;
	private static ProgressBar waveProgress = null;
	private static ImageView demoPea = null;
	private static ImageView demoZombie = null;
	private static ImageView demoSun = null;
	private static ImageView demoCoin = null;
	private static AnchorPane pane = null;
	private static Timer timer;

	public static void run(Stage primaryStage, boolean restart) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(GameWindow.class.getResource("GameWindow.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		if(restart)
		{
			controller.setUp();
			count = 0;
		}
		fetchObjects();

		timer = new Timer();
		controller.setTimer(timer);
		timer.schedule(new Game.frontend.GameWindow.GameWindow.updater(), 0, 10);

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private static void fetchObjects()
	{
		slot1 = controller.getSlot1();
		slot1.setImage(new Image("./Game/assets/backend/peaTile.png"));
		mover1 = controller.getMover1();
		mover2 = controller.getMover2();
		mover3 = controller.getMover3();
		mover4 = controller.getMover4();
		mover5 = controller.getMover5();
		coinCounter = controller.getCoinCounter();
		sunCounter = controller.getSunCounter();
		waveProgress = controller.getWaveProgress();
		demoCoin = controller.getDemoCoin();
		demoPea = controller.getDemoPea();
		demoZombie = controller.getDemoZombie();
		demoSun = controller.getDemoSun();
		pane = controller.getPane();
	}

	static class updater extends TimerTask
	{
		@Override
		public void run()
		{
			//			System.out.println(demoZombie.getX());
			count++;
			if(count >= 10000)
				timer.cancel();
			if(count > 100)
				demoPea.setVisible(true);
			if(count > 150)
				demoZombie.setVisible(true);
			if(count > 200)
				demoSun.setVisible(true);
			if(count > 400)
				demoCoin.setVisible(true);
			if(demoPea.isVisible())
			{
				if(demoPea.getX() < 1290)
					demoPea.setX(demoPea.getX() + 1);
				else
					Platform.runLater(() -> pane.getChildren().remove(demoPea));
			}
			if(demoZombie.isVisible())
			{
				if(demoZombie.getX() > 250)
					demoZombie.setX(demoZombie.getX() - 1);
				else
				{
					Platform.runLater(() -> pane.getChildren().remove(demoZombie));
					mover4en = true;
				}
			}
			if(demoSun.isVisible())
			{
				if(demoSun.getY() < 600)
					demoSun.setY(demoSun.getY() + 1);
			}
			if(demoCoin.isVisible())
			{
				if(demoCoin.getY() < 600)
					demoCoin.setY(demoCoin.getY() + 1);
			}
			if(mover4en)
			{
				waveProgress.setProgress(1.0);
				if(mover4.getX() < 1250)
					mover4.setX(mover4.getX() + 5);
				else
					Platform.runLater(() -> pane.getChildren().remove(mover4));
			}
			else
				waveProgress.setProgress(1 - (demoZombie.getX() / 1300));
		}
	}
}
