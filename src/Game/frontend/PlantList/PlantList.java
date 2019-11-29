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
	private static PlantList uniqueInstance = null;
	private PlantList() {}
	public static PlantList getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new PlantList();
		return uniqueInstance;
	}
	private ImageView plantImage = null;
	private ChoiceBox<String> plantChoice = null;
	private TextArea plantDescription = null;

	public void run(Stage primaryStage) throws Exception
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

	private void setUpChoices()
	{
		plantChoice.getItems().addAll( "---", "Pea Shooter", "Wallnut", "Tallnut", "Firey", "Frosty", "Gun", "Repeater", "Jalapeno", "Potato Mine", "Sunflower", "Twin Sunflower");
		plantChoice.setValue("---");
		plantChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> newChoice(newValue));
	}

	private void newChoice(String value)
	{
		switch(value) {
			case "Wallnut":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Barrier/Wallnut/Wallnut.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("A small barrier. \nWon't let anyone through while its alive");
				plantDescription.setVisible(true);
				break;
			case "Tallnut":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Barrier/Tallnut/Tallnut.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("Big brother of Wallnut \nLife's motto: You shall not pass");
				plantDescription.setVisible(true);
				break;
			case "Pea Shooter":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Shooters/PeaShooter/PeaShooter.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("Shoots peas to damage zombies");
				plantDescription.setVisible(true);
				break;
			case "Firey":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Shooters/Firey/Firey.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("Pea shooter with a fire inside. \nFire peas cause twice the damage and\n unfreeze any frozen zombies");
				plantDescription.setVisible(true);
				break;
			case "Frosty":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Shooters/Frosty/Frosty.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("Pea shooter for the cold. \nSlows down all zombies hit by it by 0.5x");
				plantDescription.setVisible(true);
				break;
			case "Gun":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Shooters/Gun/Gun.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("The repeater got even faster!\n4 peas in the same time pea shooter \nshoots one");
				plantDescription.setVisible(true);
				break;
			case "Repeater":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Shooters/Repeater/Repeater.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("The pea shooter just got faster. \nShoots twice the number of peas");
				plantDescription.setVisible(true);
				break;
			case "Jalapeno":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Bomb/Jalapeno/Jalapeno.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("Is that smoke? \nJalapeno burns the entire row at once \nsparing none");
				plantDescription.setVisible(true);
				break;
			case "Potato Mine":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Bomb/PotatoMine/PotatoMineArmed.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("Yikes! \nPotato mine is the perfect old school \nmine. Come too close and that's the last \ntime you do. But remember it takes \na while to activate");
				plantDescription.setVisible(true);
				break;
			case "Sunflower":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Collector/Sunflower/Sunflower.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("The perfect source continuous stream\nof Sun. Gives you extra sun tokens");
				plantDescription.setVisible(true);
				break;
			case "Twin Sunflower":
				plantImage.setImage(new Image("./Game/assets/backend/Plants/Collector/TwinSunflower/TwinSunflower.gif"));
				plantImage.setVisible(true);
				plantDescription.setText("Sunflower on steroids. \nIt's sun tokens are worth twice that \nof the normal Sunflower.");
				plantDescription.setVisible(true);
				break;
			default:
				plantImage.setVisible(false);
				plantDescription.setVisible(false);
		}
	}
}
