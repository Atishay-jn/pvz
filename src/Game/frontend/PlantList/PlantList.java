package Game.frontend.PlantList;

import Game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PlantList
{
	private static ImageView plantImage = null;
	private static ChoiceBox<String> plantChoice = null;
	private static TextArea plantDescription = null;

	public static void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(PlantList.class.getResource("PlantList.fxml"));
		Parent root = loader.load();
		PlantListController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		plantImage = controller.getPlantImage();
		plantChoice = controller.getPlantChoice();
		plantDescription = controller.getPlantDescription();
		plantImage.setVisible(false);
		setUpChoices();

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private static void setUpChoices()
	{
		plantChoice.getItems().addAll("Pea Shooter", "---");
		plantChoice.setValue("---");
		plantChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> newChoice(newValue));
	}

	private static void newChoice(String value)
	{
//		switch(value) {
//			case "Wallnut":
//				plantImage.setImage(new Image("./Game/assets/backend/Plants/Barrier/Wallnut/Wallnut.gif"));
//				plantImage.setVisible(true);
//				plantDescription.setText("");
//				break;
//			case "Traffic Zombie":
//				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/TrafficZombie.gif"));
//				zombieImage.setVisible(true);
//				zombieDescription.setText("Traffic Zombie. This one crossed a road to get to your home. Please let him through");
//				zombieDescription.setVisible(true);
//				break;
//			case "Bucket Zombie":
//				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/BucketZommbie.gif "));
//				zombieImage.setVisible(true);
//				zombieDescription.setText("Bucket Zombie. Ran out of water? Can I please finish bathing");
//				zombieDescription.setVisible(true);
//				break;
//			case "Rugby Zombie":
//				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/RugbyZombie.png"));
//				zombieImage.setVisible(true);
//				zombieDescription.setText("Rugby Zombie. This zombie has played in the NFL, the best quarterback of all. Can take a hit or more ");
//				zombieDescription.setVisible(true);
//				break;
//			case "Runner Zombie":
//				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/RunnerZombie.gif "));
//				zombieImage.setVisible(true);
//				zombieDescription.setText("Runner Zombie. This zombie will roll his through your yard before you even realize");
//				zombieDescription.setVisible(true);
//				break;
//			case "Boss Zombie":
//				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/BossZombie.gif "));
//				zombieImage.setVisible(true);
//				zombieDescription.setText("Boss Zombie. The name is enough.");
//				zombieDescription.setVisible(true);
//				break;
//			default:
//				zombieImage.setVisible(false);
//				zombieDescription.setVisible(false);
//
//		}
	}
}
