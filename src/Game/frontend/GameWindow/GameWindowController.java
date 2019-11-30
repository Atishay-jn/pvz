package Game.frontend.GameWindow;

import Game.backend.User.CurrentUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;

public class GameWindowController
{
	private Stage primaryStage;
	@FXML
	private GridPane gridPane;
	@FXML
	private Label coinCounter;
	@FXML
	private Label sunCounter;
	@FXML
	private ProgressBar waveProgress;
	@FXML
	private AnchorPane pane;
	private Timer timer;
	@FXML
	private VBox seedSlots;
	@FXML
	private boolean shovel = false;
	private int currentPlant = -1;

	public boolean isShovel() {
		return shovel;
	}

	public void usedShovel() {
		shovel = false;
	}

	public void usedCurrentPlant() {
		currentPlant = -1;
	}

	void setUp()
	{
		coinCounter.setText("0");
		sunCounter.setText("0");
	}

	public int getCurrentPlant() {
		return currentPlant;
	}

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@FXML
	private void pauseClick() throws Exception
	{
		CurrentUser.getUser().setCurrentlyAt(CurrentUser.getUser().getCurrentLevel());
		timer.cancel();
		GameWindow.getInstance().saveGrid();
		Game.frontend.Pause.PauseScreen.getInstance().run(primaryStage);
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

	public VBox getSeedSlots()
	{
		return seedSlots;
	}

	public GridPane getGridPane()
	{
		return gridPane;
	}

	@FXML
	private void slot6click(MouseEvent mouseEvent)
	{
		LinkedHashMap<Integer,Integer> h = CurrentUser.getUser().getSelectedPlants();
		int count = 6;
		for(Map.Entry<Integer,Integer> e: h.entrySet()) {
			count --;
			if(count == 0) {
				currentPlant = e.getKey();
			}
		}
	}

	@FXML
	private void slot5click(MouseEvent mouseEvent)
	{
		LinkedHashMap<Integer,Integer> h = CurrentUser.getUser().getSelectedPlants();
		int count = 5;
		for(Map.Entry<Integer,Integer> e: h.entrySet()) {
			count --;
			if(count == 0) {
				currentPlant = e.getKey();
			}
		}
	}

	@FXML
	private void slot4click(MouseEvent mouseEvent)
	{
		LinkedHashMap<Integer,Integer> h = CurrentUser.getUser().getSelectedPlants();
		int count = 4;
		for(Map.Entry<Integer,Integer> e: h.entrySet()) {
			count --;
			if(count == 0) {
				currentPlant = e.getKey();
			}
		}
	}

	@FXML
	private void slot3click(MouseEvent mouseEvent)
	{
		LinkedHashMap<Integer,Integer> h = CurrentUser.getUser().getSelectedPlants();
		int count = 3;
		for(Map.Entry<Integer,Integer> e: h.entrySet()) {
			count --;
			if(count == 0) {
				currentPlant = e.getKey();
			}
		}
	}

	@FXML
	private void slot2click(MouseEvent mouseEvent)
	{
		LinkedHashMap<Integer,Integer> h = CurrentUser.getUser().getSelectedPlants();
		int count = 2;
		for(Map.Entry<Integer,Integer> e: h.entrySet()) {
			count --;
			if(count == 0) {
				currentPlant = e.getKey();
			}
		}
	}

	@FXML
	private void slot1click(MouseEvent mouseEvent)
	{
		LinkedHashMap<Integer,Integer> h = CurrentUser.getUser().getSelectedPlants();
		int count = 1;
		for(Map.Entry<Integer,Integer> e: h.entrySet()) {
			count --;
			if(count == 0) {
				currentPlant = e.getKey();
			}
		}
	}

	@FXML
	private void shovelClick(MouseEvent mouseEvent) {
		if(!shovel) {
			shovel = true;
			currentPlant = -1;
		}
		else
			shovel = false;
	}

}
