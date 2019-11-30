package Game.frontend.GameWindow;

import Game.Main;
import Game.backend.Displayable;
import Game.backend.Plants.Barrier.TallNut;
import Game.backend.Plants.Barrier.WallNut;
import Game.backend.Plants.DynamicPlants.Bomb.Jalapeno;
import Game.backend.Plants.DynamicPlants.Bomb.PotatoMine;
import Game.backend.Plants.DynamicPlants.Collector.Sunflower;
import Game.backend.Plants.DynamicPlants.Collector.TwinSunflower;
import Game.backend.Plants.DynamicPlants.Shooter.*;
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
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(TallNut.getCostImage()));
					TallNut.setCooldown(pair.getValue());
					break;
				case 1:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(WallNut.getCostImage()));
					WallNut.setCooldown(pair.getValue());
					break;
				case 2:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Jalapeno.getCostImage()));
					Jalapeno.setCooldown(pair.getValue());
					break;
				case 3:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(PotatoMine.getCostImage()));
					PotatoMine.setCooldown(pair.getValue());
					break;
				case 4:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Sunflower.getCostImage()));
					Sunflower.setCooldown(pair.getValue());
					break;
				case 5:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(TwinSunflower.getCostImage()));
					TwinSunflower.setCooldown(pair.getValue());
					break;
				case 6:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Firey.getCostImage()));
					Firey.setCooldown(pair.getValue());
					break;
				case 7:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Frosty.getCostImage()));
					Frosty.setCooldown(pair.getValue());
					break;
				case 8:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Gun.getCostImage()));
					Gun.setCooldown(pair.getValue());
					break;
				case 9:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(PeaShooter.getCostImage()));
					PeaShooter.setCooldown(pair.getValue());
					break;
				case 10:
					((ImageView) seedSlots.getChildren().get(slotIndex++)).setImage(new Image(Repeater.getCostImage()));
					Repeater.setCooldown(pair.getValue());
					break;
			}
		}
	}

	private void updateCooldown()
	{
		user.getSelectedPlants().forEach((k, v) ->
		{
			switch(k)
			{
				case 0:
					TallNut.increment();
					break;
				case 1:
					WallNut.increment();
					break;
				case 2:
					Jalapeno.increment();
					break;
				case 3:
					PotatoMine.increment();
					break;
				case 4:
					Sunflower.increment();
					break;
				case 5:
					TwinSunflower.increment();
					break;
				case 6:
					Firey.increment();
					break;
				case 7:
					Frosty.increment();
					break;
				case 8:
					Gun.increment();
					break;
				case 9:
					PeaShooter.increment();
					break;
				case 10:
					Repeater.increment();
					break;
			}
		});
	}

	private void updateCooldownDisplay()
	{
		int slotIndex = 0;
		for(Map.Entry<Integer, Integer> en : user.getSelectedPlants().entrySet())
		{
			double op = 0.5;
			switch(en.getKey())
			{
				case 0:
					op = TallNut.getCooldown() == TallNut.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 1:
					op = WallNut.getCooldown() == WallNut.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 2:
					op = Jalapeno.getCooldown() == Jalapeno.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 3:
					op = PotatoMine.getCooldown() == PotatoMine.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 4:
					op = Sunflower.getCooldown() == Sunflower.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 5:
					op = TwinSunflower.getCooldown() == TwinSunflower.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 6:
					op = Firey.getCooldown() == Firey.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 7:
					op = Frosty.getCooldown() == Frosty.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 8:
					op = Gun.getCooldown() == Gun.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 9:
					op = PeaShooter.getCooldown() == PeaShooter.getMaxCooldown() ? 1.0 : 0.5;
					break;
				case 10:
					op = Repeater.getCooldown() == Repeater.getMaxCooldown() ? 1.0 : 0.5;
					break;
			}
			seedSlots.getChildren().get(slotIndex++).setOpacity(op);
		}
	}

	public class updater extends TimerTask
	{
		@Override
		public void run()
		{
			updateCooldown();
			updateCooldownDisplay();
			//			System.out.println(demoZombie.getImage().equals(new Image("Game/assets/backend/Zombies/LawnZombie.gif")));
			//			//			System.out.println(demoZombie.getX());
			//			Platform.runLater(() -> demoZombie.setX(demoZombie.getX() - 1));
			//			if(demoZombie.getX() < 360)
			//				Platform.runLater(() -> pane.getChildren().remove(demoZombie));
		}
	}
}
