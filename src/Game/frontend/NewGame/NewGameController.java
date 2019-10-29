package Game.frontend.NewGame;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable
{
	public Button NewGameButton;
	public Button ResumeButton;
	public Button HelpButton;
	public Button ExitButton;
	private Stage primaryStage;

	void setPrimaryStage(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	}

	public void resumeClick()
	{
		System.out.println("resume click");
	}

	public void helpClick()
	{
		System.out.println("Help click");
	}

	public void exitClick()
	{
		primaryStage.close();
	}

	public void newGameClick()
	{
		System.out.println("new Game");
	}
}

