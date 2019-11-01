package Game.frontend.GameWindow;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Timer;

public class GameWindowController
{
	private Stage primaryStage;
	@FXML
	private ImageView mover1;
	@FXML
	private ImageView mover2;
	@FXML
	private ImageView mover3;
	@FXML
	private ImageView mover4;
	@FXML
	private ImageView mover5;
	@FXML
	private Label coinCounter;
	@FXML
	private Label sunCounter;
	@FXML
	private ProgressBar waveProgress;
	@FXML
	private ImageView demoPea;
	@FXML
	private ImageView demoZombie;
	@FXML
	private ImageView demoSun;
	@FXML
	private ImageView demoCoin;
	@FXML
	private ImageView slot1;
	@FXML
	private AnchorPane pane;
	private Timer timer;

	void setUp()
	{
		mover1.setX(273.0);
		mover2.setX(268.0);
		mover3.setX(263.0);
		mover4.setX(255.0);
		mover5.setX(250.0);
		coinCounter.setText("0");
		sunCounter.setText("0");
		demoPea.setX(458.0);
		demoZombie.setX(1200);
		demoSun.setY(-73);
		demoCoin.setY(-62);
	}

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void pauseClick() throws Exception
	{
		timer.cancel();
		Game.frontend.Pause.PauseScreen.run(primaryStage);
	}

	@FXML
	private void slot1click()
	{
		System.out.println("pea shooter selected");
	}

	ImageView getMover1()
	{
		return mover1;
	}

	ImageView getMover2()
	{
		return mover2;
	}

	ImageView getMover3()
	{
		return mover3;
	}

	ImageView getMover4()
	{
		return mover4;
	}

	ImageView getMover5()
	{
		return mover5;
	}

	Label getCoinCounter()
	{
		return coinCounter;
	}

	Label getSunCounter()
	{
		return sunCounter;
	}

	ProgressBar getWaveProgress()
	{
		return waveProgress;
	}

	ImageView getDemoPea()
	{
		return demoPea;
	}

	ImageView getDemoZombie()
	{
		return demoZombie;
	}

	ImageView getDemoSun()
	{
		return demoSun;
	}

	ImageView getDemoCoin()
	{
		return demoCoin;
	}

	ImageView getSlot1()
	{
		return slot1;
	}

	public AnchorPane getPane()
	{
		return pane;
	}

	void setTimer(Timer timer)
	{
		this.timer = timer;
	}

	@FXML
	private void coinClick()
	{
		coinCounter.setText("50");
		demoCoin.setDisable(true);
		demoCoin.setVisible(false);
		Platform.runLater(() -> pane.getChildren().remove(demoCoin));
	}

	@FXML
	private void sunClick()
	{
		sunCounter.setText("50");
		demoSun.setDisable(true);
		demoSun.setVisible(false);
		Platform.runLater(() -> pane.getChildren().remove(demoSun));
	}
}
