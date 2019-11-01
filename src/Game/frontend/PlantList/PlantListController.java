package Game.frontend.PlantList;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PlantListController
{
	@FXML
	private ChoiceBox<String> plantChoice;
	@FXML
	private ImageView plantImage;
	@FXML
	private TextArea plantDescription;
	private Stage primaryStage;

	void setPrimaryStage(Stage s)
	{
		primaryStage = s;
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.Almanac.Almanac.run(primaryStage);
	}

	ChoiceBox<String> getPlantChoice()
	{
		return plantChoice;
	}

	ImageView getPlantImage()
	{
		return plantImage;
	}

	TextArea getPlantDescription()
	{
		return plantDescription;
	}
}
