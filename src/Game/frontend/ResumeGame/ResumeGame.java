package Game.frontend.ResumeGame;

import Game.Main;
import Game.backend.User.CurrentUser;
import Game.backend.User.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ResumeGame extends CurrentUser
{
	private static ResumeGame uniqueInstance = null;
	private ResumeGame() {}
	public static ResumeGame getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new ResumeGame();
		return uniqueInstance;
	}
	private ChoiceBox<String> userChoice = null;
	private ResumeGameController controller = null;

	public void run(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(ResumeGame.class.getResource("ResumeGame.fxml"));
		Parent root = loader.load();
		controller = loader.getController();
		controller.setStage(primaryStage);
		userChoice = controller.getChoiceBox();
		setUpChoices();
		userChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> newChoice(newValue));

		primaryStage.setScene(new Scene(root, Main.width, Main.height));
		primaryStage.show();
	}

	private void setUpChoices()
	{
		File dir = new File("UserFiles");
		File[] directoryListing = dir.listFiles();
		if(directoryListing != null)
		{
			for(File child : directoryListing)
			{
				userChoice.getItems().add(child.getName());
			}
		}
		userChoice.getItems().add("---");
		userChoice.setValue("---");
	}

	private void deserialize(String name) throws IOException, ClassNotFoundException
	{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserFiles/" + name + "/userdata.txt")))
		{
			user = (User) in.readObject();
		}
	}

	private void newChoice(String value)
	{
		if(value.equals("---"))
			controller.updateButtonState(true);
		else
		{
			try
			{
				this.deserialize(value);
				System.out.println(user.getName());
				System.out.println(user.getCurrentlyAt());
			}
			catch(Exception e)
			{
				System.out.println("Error while resuming");
			}
			controller.updateButtonState(false);
		}
	}
}
