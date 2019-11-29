package Game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main extends Application
{
	public static final int width = 1300;
	public static final int height = 710;
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Plants vs Zombies");
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		playMusic();
		Game.frontend.MainMenu.MainMenu.getInstance().run(primaryStage);
	}

	private void playMusic() throws Exception
	{
		AudioInputStream music = AudioSystem.getAudioInputStream(new File("src/Game/assets/songs/music.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(music);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}
}
