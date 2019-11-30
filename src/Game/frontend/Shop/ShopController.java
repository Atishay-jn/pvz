package Game.frontend.Shop;

import Game.backend.User.CurrentUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ShopController
{
	@FXML
	private Label coinCounter;
	private Stage primaryStage;
	@FXML
	private ImageView op1;
	@FXML
	private ImageView op2;
	@FXML
	private ImageView op3;
	@FXML
	private ImageView op4;
	@FXML
	private Button buyButton;

	void setPrimaryStage(Stage primaryStage)
	{
		String str = "";
		int k = CurrentUser.getUser().getCoins();
		while(k>0) {
			str = ((char)k%10) + str;
			k /= 10;
		}
		coinCounter.setText(str);
		this.primaryStage = primaryStage;
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.PlantSelect.PlantSelect.getInstance().run(primaryStage);
	}

	public Label getCoinCounter()
	{
		return coinCounter;
	}

	public ImageView getOp1()
	{
		return op1;
	}

	public ImageView getOp2()
	{
		return op2;
	}

	public ImageView getOp3()
	{
		return op3;
	}

	public ImageView getOp4()
	{
		return op4;
	}

	public Button getBuyButton()
	{
		return buyButton;
	}
}
