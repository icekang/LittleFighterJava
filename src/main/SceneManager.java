package main;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.menu.MenuComponent;
import main.controls.ControlsComponent;
import main.charac.CharComponent;
import entity.character.allList;

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
	
	public static Scene getCharScene() {
		return charScene;
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
			charScene = new Scene(CharComponent.getInstance().getBackgroundPane(), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		allList.initPlayCard();
		CharComponent.getInstance().newRound();
		primaryStage.setScene(charScene);
		
		primaryStage.setOnCloseRequest(event -> {
			CharComponent.getInstance().stopSound();
		});
	}
	
	public static void setStage(Stage primaryStage) {
		SceneManager.primaryStage = primaryStage;
	}
}
