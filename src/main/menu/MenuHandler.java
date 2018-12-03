package main.menu;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import main.SceneManager;

public class MenuHandler {
	
	public static void exit() {
		MenuComponent.getInstance().stopSound();
		MenuComponent.getInstance().startTransitionSound();
		System.exit(0);
	}
	
	public static void moveToControlsScene() {
		MenuComponent.getInstance().stopSound();
		MenuComponent.getInstance().startTransitionSound();
		SceneManager.setControlScene();
	}
	
	public static void moveToGameScene() {
		MenuComponent.getInstance().stopSound();
		MenuComponent.getInstance().startTransitionSound();
		SceneManager.setCharSelectScene();
	}
	
	public static void drawBorder(Canvas canvas, Color color) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setStroke(color);
		gc.strokeRoundRect(0, 0, canvas.getWidth(), canvas.getHeight(), 0, 0);
	}
	
	public static void undrawBorder(Canvas canvas, String text) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		gc.setFont(Font.font("Minecraft", 30));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(text, canvas.getWidth() / 2, canvas.getHeight()* 4 / 5);
	}
}
