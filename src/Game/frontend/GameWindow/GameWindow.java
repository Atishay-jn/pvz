package Game.frontend.GameWindow;

import Game.Main;
import Game.backend.Displayable;
import Game.backend.User.SaveGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class GameWindow extends SaveGame
{
	private static GameWindow uniqueInstance = null;
	private GameWindowController controller = null;
	private Label coinCounter = null;
	private Label sunCounter = null;
	private ProgressBar waveProgress = null;
	private AnchorPane pane = null;
	private Timer timer;
	private VBox seedSlots = null;
	private ImageView demoZombie;
	private ArrayList<ImageView> standby = new ArrayList<>();
	private HashMap<Displayable, ImageView> currentFrame = new HashMap<>();

	private GameWindow()
	{
	}

	public static GameWindow getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new GameWindow();
		return uniqueInstance;
	}

	public void resumeTimer()
	{
		timer = new Timer();
		controller.setTimer(timer);
		timer.schedule(new updater(), 0, 20);
	}

	public void run(Stage primaryStage) throws Exception
	{

		FXMLLoader loader = new FXMLLoader(GameWindow.class.getResource("GameWindow.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		controller.setUp();
		fetchObjects();

		initialize();

		timer = new Timer();
		controller.setTimer(timer);
		timer.schedule(new Game.frontend.GameWindow.GameWindow.updater(), 0, 40);

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private void fetchObjects()
	{
		demoZombie = controller.getDemoZombie();
		demoZombie.toFront();
		demoZombie.setX(1200);
		demoZombie.setY(0);
		coinCounter = controller.getCoinCounter();
		sunCounter = controller.getSunCounter();
		waveProgress = controller.getWaveProgress();
		pane = controller.getPane();
		seedSlots = controller.getSeedSlots();
	}

	private void initialize()
	{
		initializeSlots();
	}

	private void initializeSlots()
	{
		int slotIndex = 0;
		for(Map.Entry<Integer, Integer> pair : user.getSelectedPlants().entrySet())
		{
			switch(pair.getKey())
			{
				case 0:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
				case 1:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.WallNut.getCostImage()));
					Game.backend.Plants.Barrier.WallNut.setCooldown(pair.getValue());
					break;
				case 2:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.DynamicPlants.Bomb.Jalapeno.getCostImage()));
					Game.backend.Plants.DynamicPlants.Bomb.Jalapeno.setCooldown(pair.getValue());
					break;
				case 3:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.tCostImage()));
					Game.backend.Plants.DynamicPlants.Bomb.PotatoMine.setCooldown(pair.getValue());
					break;
				case 4:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
				case 5:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
				case 6:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
				case 7:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
				case 8:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
				case 9:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
				case 10:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Game.backend.Plants.Barrier.TallNut.getCostImage()));
					Game.backend.Plants.Barrier.TallNut.setCooldown(pair.getValue());
					break;
			}
		})
	}

	private void updateCooldown()
	{

	}

	public class updater extends TimerTask
	{
		@Override
		public void run()
		{
			updateCooldown();
			//			System.out.println(demoZombie.getImage().equals(new Image("Game/assets/backend/Zombies/LawnZombie.gif")));
			//			//			System.out.println(demoZombie.getX());
			//			Platform.runLater(() -> demoZombie.setX(demoZombie.getX() - 1));
			//			if(demoZombie.getX() < 360)
			//				Platform.runLater(() -> pane.getChildren().remove(demoZombie));
		}
	}
}
