package main;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.menu.MenuComponent;
import main.controls.ControlsComponent;
import main.charac.CharComponent;

public class SceneManager {
	private static Stage primaryStage;
	private static Scene menuScene;
	private static Scene controlScene;
	private static Scene charScene;
	
	
	public static void setMenuScene() {
		if(menuScene==null)
			menuScene = new Scene(MenuComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		primaryStage.setScene(menuScene);
		
		primaryStage.setOnCloseRequest(event -> {
			MenuComponent.getInstance().stopSound();
		});
	}
	
	
	public static Scene getControlScene() {
		return controlScene;
	}
	
	public static void setControlScene() {
		if(controlScene==null)
			controlScene = new Scene(ControlsComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		primaryStage.setScene(controlScene);
		
		primaryStage.setOnCloseRequest(event -> {
			ControlsComponent.getInstance().stopSound();
		});
	}
	
	public static void setCharSelectScene() {
		if(charScene==null)
			menuScene = new Scene(CharComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		primaryStage.setScene(menuScene);
		
		primaryStage.setOnCloseRequest(event -> {
			CharComponent.getInstance().stopSound();
		});
	}
	
	public static void setStage(Stage primaryStage) {
		SceneManager.primaryStage = primaryStage;
	}
}
