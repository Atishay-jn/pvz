package Game.frontend.Shop;

import Game.Main;
import Game.backend.Exceptions.InsufficientCoinsException;
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
	private ImageView selectedPlant = null;
	private Button buyButton;
	private ShopController controller;
	private int selectedItem = -1;

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
		selectedItem = -1;
		FXMLLoader loader = new FXMLLoader(Shop.class.getResource("Shop.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		fetchObjects();
		initialize();
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
		op1.setOpacity(unlockedPlants[6] ? 0.5 : 0.8);
		op2.setOpacity(unlockedPlants[8] ? 0.5 : 0.8);
		op3.setOpacity(unlockedPlants[0] ? 0.5 : 0.8);
		op4.setOpacity(unlockedPlants[5] ? 0.5 : 0.8);
		buyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> this.buy());
		Shop.this.buyButton.setDisable(true);
		if(!unlockedPlants[6])
			op1.setOnMouseClicked(new handler(1, op1));
		if(!unlockedPlants[8])
			op2.setOnMouseClicked(new handler(2, op2));
		if(!unlockedPlants[0])
			op3.setOnMouseClicked(new handler(3, op3));
		if(!unlockedPlants[5])
			op4.setOnMouseClicked(new handler(4, op4));
	}

	private void buy()
	{
		System.out.println("Buy click");
		int coinsReq = -1;
		int unlockedPlant = -1;
		switch(this.selectedItem)
		{
			case 1:
				coinsReq = 200;
				unlockedPlant = 6;
				break;
			case 2:
				coinsReq = 500;
				unlockedPlant = 8;
				break;
			case 3:
				coinsReq = 500;
				unlockedPlant = 0;
				break;
			case 4:
				coinsReq = 750;
				unlockedPlant = 5;
				break;
		}
		try
		{
			user.buy(coinsReq);
			user.unlockPlant(unlockedPlant);
			this.selectedPlant.setOpacity(0.5);
			System.out.println("Bought " + this.selectedItem);
		}
		catch(InsufficientCoinsException e)
		{
			System.out.println(e.getMessage());
			this.selectedPlant.setOpacity(0.8);
		}
		try
		{
			SaveGame.serialize();
		}
		catch(Exception e)
		{
			System.out.println("Error while saving!");
		}
		this.selectedPlant = null;
		this.selectedItem = -1;
		Shop.this.buyButton.setDisable(true);
		op1.setDisable(false);
		op2.setDisable(false);
		op3.setDisable(false);
		op4.setDisable(false);
	}

	private class handler implements EventHandler<MouseEvent>
	{
		private int itemNum;
		private ImageView iv;

		handler(int num, ImageView iv)
		{
			this.itemNum = num;
			this.iv = iv;
		}

		@Override
		public void handle(MouseEvent event)
		{
			Shop.this.selectedPlant = iv;
			Shop.this.selectedItem = itemNum;
			this.iv.setOpacity(1);
			Shop.this.buyButton.setDisable(false);
			if(op1 != iv)
				op1.setDisable(true);
			if(op2 != iv)
				op2.setDisable(true);
			if(op3 != iv)
				op3.setDisable(true);
			if(op4 != iv)
				op4.setDisable(true);
		}
	}
}
