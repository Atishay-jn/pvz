package Game.frontend.ZombieList;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ZombieListController
{
	@FXML
	private ChoiceBox<String> zombieChoice;
	@FXML
	private ImageView zombieImage;
	@FXML
	private TextArea zombieDescription;
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

	ChoiceBox<String> getZombieChoice()
	{
		return zombieChoice;
	}

	ImageView getZombieImage()
	{
		return zombieImage;
	}

	TextArea getZombieDescription()
	{
		return zombieDescription;
	}
}
