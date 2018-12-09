package main.menu;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import main.Main;
import main.interfaces.*;

public class MenuComponent implements BackGroundMusic {
	
	private static final ClassLoader CLASS_LOADER = MenuComponent.class.getClassLoader();
	
	public static MenuComponent instance = new MenuComponent();
	
	private Media START_SOUND;
	static MediaPlayer startMP;
	private Media TRANSITION_SOUND;
	static MediaPlayer transitionMP;
	
	private Pane backgroundPane;
	private Canvas canvasVSMode;
	private Canvas canvasControls;
	private Canvas canvasExit;
	
	public MenuComponent() {
		
		try {
			START_SOUND = new Media(CLASS_LOADER.getResource("sounds/main.mp3").toURI().toString());
			TRANSITION_SOUND = new Media(CLASS_LOADER.getResource("sounds/Transition.mp3").toURI().toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		backgroundPane = new Pane();
		
		Canvas screen = new Canvas(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		GraphicsContext gc = screen.getGraphicsContext2D();
		
		Image imageBackground = new Image(ClassLoader.getSystemResource("images/MenuBackground.png").toString());
		gc.drawImage(imageBackground, 0, 0);
		
		Image imageLogo = new Image(ClassLoader.getSystemResource("images/GameLogo.png").toString());
		gc.drawImage(imageLogo, Main.SCREEN_WIDTH / 2 - imageLogo.getWidth() / 2, 10);
		
		gc.setFont(Font.font("Minecraft", 40));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("Main Menu", Main.SCREEN_WIDTH / 2, imageLogo.getHeight() * 8 / 7);
		
		canvasVSMode = new Canvas(132, 132/3);
		canvasControls = new Canvas(132, 132/3);
		canvasExit = new Canvas(132, 132/3);
		
		canvasVSMode.setTranslateX(Main.SCREEN_WIDTH / 2 - canvasVSMode.getWidth() / 2);
		canvasVSMode.setTranslateY(imageLogo.getHeight() * 9 / 7);
		gc = canvasVSMode.getGraphicsContext2D();
		
		gc.setFont(Font.font("Minecraft", 30));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("Start", canvasVSMode.getWidth() / 2, canvasVSMode.getHeight()* 4 / 5);
		
		canvasControls.setTranslateX(Main.SCREEN_WIDTH / 2 - canvasControls.getWidth() / 2);
		canvasControls.setTranslateY(imageLogo.getHeight() * 11 / 7);
		gc = canvasControls.getGraphicsContext2D();
		
		gc.setFont(Font.font("Minecraft", 30));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("Controls", canvasControls.getWidth() / 2, canvasControls.getHeight() * 4 / 5);
		
		canvasExit.setTranslateX(Main.SCREEN_WIDTH / 2 - canvasVSMode.getWidth() / 2);
		canvasExit.setTranslateY(imageLogo.getHeight() * 13 / 7);
		gc = canvasExit.getGraphicsContext2D();
		
		gc.setFont(Font.font("Minecraft", 30));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("Exit", canvasVSMode.getWidth() / 2, canvasVSMode.getHeight()* 4 / 5);
		
		canvasVSMode.setOnMouseEntered(event -> MenuHandler.drawBorder(canvasVSMode, Color.DARKORANGE));
		canvasControls.setOnMouseEntered(event -> MenuHandler.drawBorder(canvasControls, Color.DARKORANGE));
		canvasExit.setOnMouseEntered(event -> MenuHandler.drawBorder(canvasExit, Color.DARKORANGE));
		
		canvasVSMode.setOnMouseExited(event -> MenuHandler.undrawBorder(canvasVSMode, "Start"));
		canvasControls.setOnMouseExited(event -> MenuHandler.undrawBorder(canvasControls, "Controls"));
		canvasExit.setOnMouseExited(event -> MenuHandler.undrawBorder(canvasExit, "Exit"));
		
		canvasVSMode.setOnMouseClicked(event -> MenuHandler.moveToGameScene());
		canvasControls.setOnMouseClicked(event -> MenuHandler.moveToControlsScene());
		canvasExit.setOnMouseClicked(event -> MenuHandler.exit());
		
		/*try { new Thread(() -> {
			startMP = new MediaPlayer(START_SOUND);
			startMP.setCycleCount(MediaPlayer.INDEFINITE);
			startMP.play();
		}).start();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		backgroundPane.getChildren().addAll(screen, canvasVSMode, canvasControls, canvasExit);
	}
	
	public void startSound() {
		try { new Thread(() -> {
			startMP = new MediaPlayer(START_SOUND);
			startMP.setCycleCount(MediaPlayer.INDEFINITE);
			startMP.play();
		}).start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void stopSound() {
		if(startMP != null) {
			startMP.stop();
		}
	}
	
	public void startTransitionSound() {
		try { new Thread(() -> {
			transitionMP = new MediaPlayer(TRANSITION_SOUND);
			transitionMP.setCycleCount(1);
			transitionMP.play();
		}).start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static MenuComponent getInstance() {
		return instance;
	}
	
	public Pane getBackgroundPane() {
		return backgroundPane;
	}
}
