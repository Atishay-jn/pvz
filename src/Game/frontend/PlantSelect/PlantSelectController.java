package Game.frontend.PlantSelect;

import Game.backend.Plants.Barrier.TallNut;
import Game.backend.Plants.Barrier.WallNut;
import Game.backend.Plants.DynamicPlants.Bomb.Jalapeno;
import Game.backend.Plants.DynamicPlants.Bomb.PotatoMine;
import Game.backend.Plants.DynamicPlants.Collector.Sunflower;
import Game.backend.Plants.DynamicPlants.Collector.TwinSunflower;
import Game.backend.Plants.DynamicPlants.Shooter.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PlantSelectController
{
	private Stage primaryStage;

	@FXML
	private ImageView op0;

	@FXML
	private ImageView op1;

	@FXML
	private ImageView op2;

	@FXML
	private ImageView op3;

	@FXML
	private ImageView op4;

	@FXML
	private ImageView op5;

	@FXML
	private ImageView op6;

	@FXML
	private ImageView op7;

	@FXML
	private ImageView op8;

	@FXML
	private ImageView op9;

	@FXML
	private ImageView op10;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		op0.setImage(new Image(TallNut.getCostImage()));
		op1.setImage(new Image(WallNut.getCostImage()));
		op2.setImage(new Image(Jalapeno.getCostImage()));
		op3.setImage(new Image(PotatoMine.getCostImage()));
		op4.setImage(new Image(Sunflower.getCostImage()));
		op5.setImage(new Image(TwinSunflower.getCostImage()));
		op6.setImage(new Image(Firey.getCostImage()));
		op7.setImage(new Image(Frosty.getCostImage()));
		op8.setImage(new Image(Gun.getCostImage()));
		op9.setImage(new Image(PeaShooter.getCostImage()));
		op10.setImage(new Image(Repeater.getCostImage()));

	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.LevelSelect.LevelSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void shopClick() throws Exception
	{
		Game.frontend.Shop.Shop.getInstance().run(primaryStage);
	}

	@FXML
	private void playClick() throws Exception
	{
		Game.frontend.GameWindow.GameWindow.getInstance().run(primaryStage);
	}
}
