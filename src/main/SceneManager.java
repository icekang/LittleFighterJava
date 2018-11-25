package main;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.menu.MenuComponent;

public class SceneManager {
	private static Stage primaryStage;
	private static Scene menuScene;
	
	
	
	public static void setMenuScene() {
		Pane wholePane = new Pane();
		
		wholePane.getChildren().add(MenuComponent.getInstance().getBackgroundPane());
		
		menuScene = new Scene(wholePane, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		primaryStage.setScene(menuScene);
		/*
		primaryStage.setOnCloseRequest(event -> {
			MenuComponent.getInstance().stopBackground();
			MenuComponent.getInstance().stopSound();
		});
		*/
	}
	
	
	public static void setStage(Stage primaryStage) {
		SceneManager.primaryStage = primaryStage;
	}
}
