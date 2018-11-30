package main.menu;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import main.Main;
import main.SceneManager;

public class MenuComponent {
	public static MenuComponent instance = new MenuComponent();
	
	private static final Media START_SOUND = new Media(ClassLoader.getSystemResource("sounds/main.mp3").toString());
	static MediaPlayer startMP = new MediaPlayer(START_SOUND);
	private static final Media TRANSITION_SOUND = new Media(ClassLoader.getSystemResource("sounds/transition.mp3").toString());
	static MediaPlayer transitionMP = new MediaPlayer(TRANSITION_SOUND);
	
	private Pane backgroundPane;
	private Canvas canvasVSMode;
	private Canvas canvasControls;
	private Canvas canvasExit;
	
	public MenuComponent() {
		backgroundPane = new Pane();
		
		Canvas screen = new Canvas(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		GraphicsContext gc = screen.getGraphicsContext2D();
		
		Image imageBackground = new Image("images/MenuBackground.png");
		gc.drawImage(imageBackground, 0, 0);
		
		Image imageLogo = new Image("images/GameLogo.png");
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
		
		try { new Thread(() -> {
			startMP = new MediaPlayer(START_SOUND);
			startMP.setCycleCount(MediaPlayer.INDEFINITE);
			startMP.play();
		}).start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		backgroundPane.getChildren().addAll(screen, canvasVSMode, canvasControls, canvasExit);
	}
	
	public void stopSound() {
		if(startMP != null) {
			startMP.stop();
		}
	}
	
	public void startTransitionSound() {
		transitionMP.setCycleCount(1);
		transitionMP.play();
	}
	
	public static MenuComponent getInstance() {
		return instance;
	}
	
	public Pane getBackgroundPane() {
		return backgroundPane;
	}
}
