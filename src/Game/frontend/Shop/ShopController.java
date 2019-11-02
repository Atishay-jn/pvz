package Game.frontend.Shop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ShopController
{
	@FXML
	private Label coinCounter;
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.PlantSelect.PlantSelect.run(primaryStage);
	}

	@FXML
	private void buyClick()
	{
		System.out.println("Bought");
	}
}
