package Game.frontend.Shop;

import Game.Main;
import Game.backend.User.SaveGame;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Shop extends SaveGame
{
	private static Shop instance = null;
	private ImageView op1;
	private ImageView op2;
	private ImageView op3;
	private ImageView op4;
	private Button buyButton;
	private ShopController controller;
	private int slectedItem = -1;

	private Shop()
	{
	}

	public static Shop getInstance()
	{
		if(instance == null)
			instance = new Shop();
		return instance;
	}

	public void run(Stage primaryStage) throws Exception
	{
		slectedItem = -1;
		FXMLLoader loader = new FXMLLoader(Shop.class.getResource("Shop.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		fetchObjects();
		//		initialize();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private void fetchObjects()
	{
		op1 = controller.getOp1();
		op2 = controller.getOp2();
		op3 = controller.getOp3();
		op4 = controller.getOp4();
		buyButton = controller.getBuyButton();
		op1.setImage(new Image("Game/assets/backend/Plants/Shooters/Firey/Firey.gif"));
		op2.setImage(new Image("Game/assets/backend/Plants/Shooters/Gun/Gun.gif"));
		op3.setImage(new Image("Game/assets/backend/Plants/Barrier/Tallnut/Tallnut.gif"));
		op4.setImage(new Image("Game/assets/backend/Plants/Collector/TwinSunflower/TwinSunflower.gif"));
	}

	private void initialize()
	{
		//TODO
		boolean[] unlockedPlants = user.getPlantUnlocked();
		op1.setOpacity(unlockedPlants[7] ? 0.5 : 0.8);
		op2.setOpacity(unlockedPlants[8] ? 0.5 : 0.8);
		op3.setOpacity(unlockedPlants[9] ? 0.5 : 0.8);
		op4.setOpacity(unlockedPlants[10] ? 0.5 : 0.8);

		if(!unlockedPlants[7])
			op1.setOnMouseClicked(new handler(1, op1));
		if(!unlockedPlants[8])
			op2.setOnMouseClicked(new handler(2, op2));
		if(!unlockedPlants[9])
			op3.setOnMouseClicked(new handler(3, op3));
		if(!unlockedPlants[10])
			op4.setOnMouseClicked(new handler(4, op4));
	}

	private class handler implements EventHandler<MouseEvent>
	{
		private int inum;
		private ImageView iv;

		handler(int num, ImageView iv)
		{
			this.inum = num;
			this.iv = iv;
		}

		@Override
		public void handle(MouseEvent event)
		{
			Shop.this.slectedItem = inum;
			this.iv.setOpacity(1);
		}
	}
}
