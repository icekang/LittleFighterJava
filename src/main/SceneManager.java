package main;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.menu.MenuComponent;
import main.controls.ControlsComponent;

public class SceneManager {
	private static Stage primaryStage;
	private static Scene menuScene;
	private static Scene controlScene;
	
	
	
	public static void setMenuScene() {
		menuScene = new Scene(MenuComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		primaryStage.setScene(menuScene);
		
		primaryStage.setOnCloseRequest(event -> {
			MenuComponent.getInstance().stopSound();
		});
	}
	
	public static void setControlScene() {
		controlScene = new Scene(ControlsComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		primaryStage.setScene(controlScene);
		
		primaryStage.setOnCloseRequest(event -> {
			ControlsComponent.getInstance().stopSound();
		});
	}
	
	public static void setStage(Stage primaryStage) {
		SceneManager.primaryStage = primaryStage;
	}
}
