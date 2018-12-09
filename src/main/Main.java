package main;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	public static final int SCREEN_WIDTH = 990;
	public static final int SCREEN_HEIGHT = 685;
	
	@Override
	public void start(Stage primaryStage) {
		SceneManager.setStage(primaryStage);
		SceneManager.setMenuScene();
		
		primaryStage.setTitle("Little Fighter");
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
