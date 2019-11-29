package Game.frontend.ZombieList;

import Game.Main;
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
	private static ImageView zombieImage = null;
	private static ChoiceBox<String> zombieChoice = null;
	private static TextArea zombieDescription = null;

	public static void run(Stage primaryStage) throws Exception
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

	private static void setUpChoices()
	{
		zombieChoice.getItems().addAll("Lawn Zombie", "---");
		zombieChoice.setValue("---");
		zombieChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> newChoice(newValue));
	}

	private static void newChoice(String value)
	{
		switch(value) {
			case "Lawn Zombie":
				zombieImage.setImage(new Image("./Game/assets/backend/zombie_normal.gif"));
				zombieImage.setVisible(true);
				zombieDescription.setText("Give me brains!!!!");
				zombieDescription.setVisible(true);
				break;
			case: ""
		}
		if(value.equals("---"))
		{
			zombieImage.setVisible(false);
			zombieDescription.setVisible(false);
		}
		else
		{
			zombieImage.setImage(new Image("./Game/assets/backend/zombie_normal.gif"));
			zombieImage.setVisible(true);
			zombieDescription.setText("Give me brains!!!!");
			zombieDescription.setVisible(true);
		}
	}
}
