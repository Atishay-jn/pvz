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
		if(value.equals("---"))
		{
			plantImage.setVisible(false);
			plantDescription.setVisible(false);
		}
		else
		{
			plantImage.setImage(new Image("./Game/assets/backend/pea_shooter.gif"));
			plantImage.setVisible(true);
			plantDescription.setText("Hi I am a pea shooter");
			plantDescription.setVisible(true);
		}
	}
}
