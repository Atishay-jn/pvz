package Game.frontend.GameWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Timer;

public class GameWindowController
{
	private Stage primaryStage;
	@FXML
	private Label coinCounter;
	@FXML
	private Label sunCounter;
	@FXML
	private ProgressBar waveProgress;
	@FXML
	private AnchorPane pane;
	private Timer timer;

	void setUp()
	{
		coinCounter.setText("0");
		sunCounter.setText("0");
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

	public AnchorPane getPane()
	{
		return pane;
	}

	void setTimer(Timer timer)
	{
		this.timer = timer;
	}
}
