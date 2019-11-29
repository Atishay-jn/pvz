package Game.frontend.ZombieList;

import Game.Main;
import Game.backend.Zombies.Zombie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ZombieList
{
	private static ZombieList uniqueInstance = null;
	private ZombieList() {}
	public static ZombieList getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new ZombieList();
		return uniqueInstance;
	}
	private ImageView zombieImage = null;
	private ChoiceBox<String> zombieChoice = null;
	private TextArea zombieDescription = null;

	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(ZombieList.class.getResource("ZombieList.fxml"));
		Parent root = loader.load();
		ZombieListController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		zombieImage = controller.getZombieImage();
		zombieChoice = controller.getZombieChoice();
		zombieDescription = controller.getZombieDescription();
		zombieImage.setVisible(false);
		setUpChoices();

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private void setUpChoices()
	{
		zombieChoice.getItems().addAll("Lawn Zombie", "Traffic Zombie", "Bucket Zombie", "Rugby Zombie", "Runner Zombie", "Boss Zombie", "---");
		zombieChoice.setValue("---");
		zombieChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> newChoice(newValue));
	}

	private void newChoice(String value)
	{
		switch(value) {
			case "Lawn Zombie":
				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/LawnZombie.gif"));
				zombieImage.setVisible(true);
				zombieDescription.setText("Lawn Zombie. The generic\nfriendly zombie looking\nfor your brains.");
				zombieDescription.setVisible(true);
				break;
			case "Traffic Zombie":
				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/TrafficZombie.gif"));
				zombieImage.setVisible(true);
				zombieDescription.setText("Traffic Zombie. This one\ncrossed a road to get to your\nhome. Please let him through");
				zombieDescription.setVisible(true);
				break;
			case "Bucket Zombie":
				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/BucketZombie.gif"));
				zombieImage.setVisible(true);
				zombieDescription.setText("Bucket Zombie. Ran out of\nwater? Can I please\nfinish bathing");
				zombieDescription.setVisible(true);
				break;
			case "Rugby Zombie":
				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/RugbyZombie.png"));
				zombieImage.setVisible(true);
				zombieDescription.setText("Rugby Zombie. This zombie\nhas played in the NFL,\nthe best quarterback of all.\nCan take a hit or more ");
				zombieDescription.setVisible(true);
				break;
			case "Runner Zombie":
				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/RunnerZombie.gif"));
				zombieImage.setVisible(true);
				zombieDescription.setText("Runner Zombie. This\nzombie will roll his through\nyour yard before you even\nrealize");
				zombieDescription.setVisible(true);
				break;
			case "Boss Zombie":
				zombieImage.setImage(new Image("./Game/assets/backend/Zombies/BossZombie.gif"));
				zombieImage.setVisible(true);
				zombieDescription.setText("Boss Zombie. The name is\nenough.");
				zombieDescription.setVisible(true);
				break;
			default:
				zombieImage.setVisible(false);
				zombieDescription.setVisible(false);

		}
	}
}
