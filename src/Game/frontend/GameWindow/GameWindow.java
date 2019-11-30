package Game.frontend.GameWindow;

import Game.Main;
import Game.backend.Displayable;
import Game.backend.DynamicObjects.Coin;
import Game.backend.DynamicObjects.DynamicObject;
import Game.backend.DynamicObjects.DynamicSun;
import Game.backend.Exceptions.CellOccupiedException;
import Game.backend.Exceptions.InsufficientSunsException;
import Game.backend.Exceptions.ZombiesAteYourBrainsException;
import Game.backend.Grid.Grid;
import Game.backend.Grid.Row;
import Game.backend.LawnMover;
import Game.backend.Plants.Barrier.TallNut;
import Game.backend.Plants.Barrier.WallNut;
import Game.backend.Plants.DynamicPlants.Bomb.Jalapeno;
import Game.backend.Plants.DynamicPlants.Bomb.PotatoMine;
import Game.backend.Plants.DynamicPlants.Collector.Sunflower;
import Game.backend.Plants.DynamicPlants.Collector.TwinSunflower;
import Game.backend.Plants.DynamicPlants.Shooter.*;
import Game.backend.Plants.Plant;
import Game.backend.User.SaveGame;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	private GridPane frontendGrid = null;
	private Grid grid = null;
	private Plant plant;
	private HashMap<Displayable, ImageView> currentFrame = new HashMap<>();
	private ArrayList<ImageView> toRemove = new ArrayList<>();
	private static int[] rowYVal = {130, 245, 365, 180, 600};
	private static int[] colXVal = {360, 460, 575, 667, 767, 870, 963, 1066, 1179};

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
		frontendGrid = controller.getGridPane();
	}

	private void initialize() throws IOException, ClassNotFoundException
	{
		initializeSlots();
		initializePlane();
		initializeGrid();
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

	private void initializePlane()
	{
		if(frontendGrid == null)
			System.out.println("Null");
		frontendGrid.getChildren().forEach((n) ->
		{
			int r = GridPane.getRowIndex(n) == null ? 0 : GridPane.getRowIndex(n);
			int c = GridPane.getColumnIndex(n) == null ? 0 : GridPane.getColumnIndex(n);
			n.setOnMouseClicked(new cellHandler(r, c));
		});
	}

	private void initializeGrid() throws IOException, ClassNotFoundException
	{
		if(user.getCurrentlyAt() == -1)
		{
			user.resetStats();
			grid = new Grid();
		}
		else
		{
			String userName = user.getName();
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserFiles/" + userName + "/grid.txt")))
			{
				grid = (Grid) in.readObject();
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

	private void updateDynamicObjects()

	{
		Random generator = new Random();
		user.setFallCounter(user.getFallCounter() + 1);
		if(user.getFallCounter() % 150 == 0)
			user.getCurrentDynamicObjects().add(new DynamicSun((400 + generator.nextInt(500)), 0));
		if(user.getFallCounter() % 500 == 0)
			user.getCurrentDynamicObjects().add(new Coin((400 + generator.nextInt(500)), 0));
		for(DynamicObject dyOb : user.getCurrentDynamicObjects())
			dyOb.update();
	}

	private void updateDynamicObjectsDisplay()
	{
		for(DynamicObject dyOb : user.getCurrentDynamicObjects())
		{
			if(currentFrame.containsKey(dyOb))
			{
				currentFrame.get(dyOb).setY(dyOb.getyVal());
			}
			else
			{
				ImageView iv = new ImageView();
				iv.setX(dyOb.getxVal());
				iv.setY(dyOb.getyVal());
				iv.setFitHeight(DynamicObject.height);
				iv.setFitWidth(DynamicObject.width);
				iv.setOnMouseClicked(new dynamicHandler(dyOb));
				iv.setImage(new Image(dyOb.getImage()));
				iv.toFront();
				iv.setVisible(true);
				iv.setDisable(false);
				currentFrame.put(dyOb, iv);
			}
		}
	}

	private void fetchPlantImages()
	{
		frontendGrid.getChildren().forEach((n) ->
		{
			int r = GridPane.getRowIndex(n) == null ? 0 : GridPane.getRowIndex(n);
			int c = GridPane.getColumnIndex(n) == null ? 0 : GridPane.getColumnIndex(n);
			if(grid.getRow(r).getCell(c).hasPlant())
			{
				Plant p = grid.getRow(r).getCell(c).getPlant();
				if(((ImageView) n).getImage() != null)
				{
					if(p instanceof PotatoMine && ((PotatoMine) p).isImageUpdated())
					{
						((ImageView) n).setImage(new Image(p.getImage()));
						((PotatoMine) p).setImageUpdated(false);
					}
				}
				else
				{
					((ImageView) n).setImage(new Image(p.getImage()));
				}
			}
			else
			{
				((ImageView) n).setImage(null);
			}
		});
	}

	private void updateRows()
	{
		try
		{
			grid.getRow(0).update();
			grid.getRow(1).update();
			grid.getRow(2).update();
			grid.getRow(3).update();
			grid.getRow(4).update();
		}
		catch(ZombiesAteYourBrainsException e)
		{
			System.out.println(e.getMessage());
			timer.cancel();
			loose();
		}
	}

	private void updateWaves()
	{
		//TODO
	}

	private void updateRowsDisplay()
	{
		for(int i = 0; i < 5; i++)
		{
			Row r = grid.getRow(i);
			if(r.getLawnMover() != null)
			{
				if(!r.getLawnMover().isOutOfFrame() && r.getLawnMover().isImageUpdated())
				{
					if(!currentFrame.containsKey(r.getLawnMover()))
					{
						LawnMover mover = r.getLawnMover();
						ImageView iv = new ImageView();
						iv.setX(mover.getxVal());
						iv.setY(mover.getyVal());
						iv.setFitHeight(LawnMover.height);
						iv.setFitWidth(LawnMover.width);
						iv.setImage(new Image(mover.getImage()));
						iv.setVisible(true);
						iv.setDisable(false);
						currentFrame.put(r.getLawnMover(), iv);
					}
				}
				else if(!r.getLawnMover().isOutOfFrame() && !r.getLawnMover().isImageUpdated())
				{
					currentFrame.get(r.getLawnMover()).setImage(new Image(r.getLawnMover().getImage()));
					r.getLawnMover().setImageUpdated(false);
				}
			}
		}
		//TODO
	}

	private void cleanFrame()
	{
		//todo
	}

	private void displayFrame()
	{
		coinCounter.setText(Integer.toString(user.getCoins()));
		sunCounter.setText(Integer.toString(user.getCurrentSuns()));
		for(ImageView iv : toRemove)
		{
			pane.getChildren().remove(iv);
		}
		for(Map.Entry<Displayable, ImageView> e : currentFrame.entrySet())
		{
			//			if(!pane.getChildren().contains(e.getValue()));
			//				Platform.runLater(() -> pane.getChildren().add(e.getValue()));
			if(!pane.getChildren().contains(e.getValue()))
				pane.getChildren().add(e.getValue());
		}
	}

	private void loose()
	{
		//TODO
	}

	private void win()
	{
		//TODO
	}

	private class dynamicHandler implements EventHandler<MouseEvent>
	{
		Displayable obj;

		dynamicHandler(Displayable obj)
		{
			System.out.println("Created");
			this.obj = obj;
		}

		@Override
		public void handle(MouseEvent event)
		{
			System.out.println("Clicked");
			if(obj instanceof DynamicSun)
				user.collectSun(50);
			else
				user.collectCoins(50);
			user.getCurrentDynamicObjects().remove(obj);
			ImageView iv = currentFrame.remove(obj);
			toRemove.add(iv);
		}
	}

	public class updater extends TimerTask
	{
		@Override
		public void run()
		{
			//			System.out.println(currentFrame.size() + pane.getChildren().size());
			updateCooldown();
			Platform.runLater(() -> updateCooldownDisplay());
			updateDynamicObjects();
			updateDynamicObjectsDisplay();
			Platform.runLater(() -> fetchPlantImages());
			//			updateRows();
			//			updateWaves();
			//			updateRowsDisplay();
			cleanFrame();
			Platform.runLater(() -> displayFrame());
			//			displayFrame();
			//			System.out.println(demoZombie.getImage().equals(new Image("Game/assets/backend/Zombies/LawnZombie.gif")));
			//			//			System.out.println(demoZombie.getX());
			//			Platform.runLater(() -> demoZombie.setX(demoZombie.getX() - 1));
			//			if(demoZombie.getX() < 360)
			//				Platform.runLater(() -> pane.getChildren().remove(demoZombie));
		}
	}

	private class cellHandler implements EventHandler<MouseEvent>
	{
		private int row;
		private int col;

		cellHandler(int row, int col)
		{
			this.row = row;
			this.col = col;
		}

		@Override
		public void handle(MouseEvent event)
		{
			try
			{
				plantFromIndex(controller.getCurrentPlant());
				user.spendSuns(plant.getCost());
				if(plant != null)
					grid.plant(row, col, plant);
				plant.resetCooldown();
			}
			catch(CellOccupiedException ignored)
			{
				System.out.println("Can't plant at: " + row + " " + col);
			}
			catch(InsufficientSunsException e)
			{
				System.out.println(e.getMessage());
				plant = null;
			}
		}

		private void plantFromIndex(int index)
		{
			int _x = colXVal[col];
			int _y = rowYVal[row];
			switch(index)
			{
				case 0:
					plant = new TallNut();
					break;
				case 1:
					plant = new WallNut();
					break;
				case 2:
					plant = new Jalapeno(_x, _y);
					break;
				case 3:
					plant = new PotatoMine(_x, _y);
					break;
				case 4:
					plant = new Sunflower(_x, _y);
					break;
				case 5:
					plant = new TwinSunflower(_x, _y);
					break;
				case 6:
					plant = new Firey(_x, _y);
					break;
				case 7:
					plant = new Frosty(_x, _y);
					break;
				case 8:
					plant = new Gun(_x, _y);
					break;
				case 9:
					plant = new PeaShooter(_x, _y);
					break;
				case 10:
					plant = new Repeater(_x, _y);
					break;
				default:
					plant = null;
			}
		}
	}
}
