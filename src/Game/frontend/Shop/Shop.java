package Game.frontend.Shop;

import Game.Main;
import Game.backend.User.SaveGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Shop extends SaveGame
{
	private static ImageView op1;
	private static ImageView op2;
	private static ImageView op3;
	private static ImageView op4;
	private static ShopController controller;

	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(Shop.class.getResource("Shop.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		fetchObjects();
		initialize();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private static void fetchObjects()
	{
		op1 = controller.getOp1();
		op2 = controller.getOp1();
		op3 = controller.getOp1();
		op4 = controller.getOp1();
		op1.setImage(new Image("Game/assets/backend/Plants/Shooters/Firey/Firey.gif"));
		op2.setImage(new Image("Game/assets/backend/Plants/Shooters/Gun/Gun.gif"));
		op3.setImage(new Image("Game/assets/backend/Plants/Barrier/Tallnut/Tallnut.gif"));
		op4.setImage(new Image("Game/assets/backend/Plants/Collector/TwinSunflower/TwinSunflower.gif"));
	}

	private static void initialize()
	{
		//TODO
		boolean[] unlockedPlants = user.getPlantUnlocked();
		if(unlockedPlants[7])
			op1.setOpacity(0.5);
		if(unlockedPlants[8])
			op2.setOpacity(0.5);
		if(unlockedPlants[9])
			op3.setOpacity(0.5);
		if(unlockedPlants[10])
			op4.setOpacity(0.5);
	}
}
