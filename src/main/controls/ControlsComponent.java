package main.controls;

import entity.control.Control;
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
import main.menu.MenuComponent;

public class ControlsComponent {
	public static ControlsComponent instance = new ControlsComponent();
	
	private static final Media START_SOUND = new Media(ClassLoader.getSystemResource("sounds/Controls.mp3").toString());
	static MediaPlayer startMP = new MediaPlayer(START_SOUND);

	private Pane backgroundPane;
	
	private Canvas moveUpPlayer1;
	private Canvas moveDownPlayer1;
	private Canvas moveLeftPlayer1;
	private Canvas moveRightPlayer1;
	private Canvas attackPlayer1;
	private Canvas jumpPlayer1;
	
	private Canvas moveUpPlayer2;
	private Canvas moveDownPlayer2;
	private Canvas moveLeftPlayer2;
	private Canvas moveRightPlayer2;
	private Canvas attackPlayer2;
	private Canvas jumpPlayer2;
	public ControlsComponent() {
		backgroundPane = new Pane();
		
		Canvas screen = new Canvas(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		GraphicsContext gc = screen.getGraphicsContext2D();
		
		Image imageBackground = new Image("images/MenuBackground.png");
		gc.drawImage(imageBackground, 0, 0);
		
		moveUpPlayer1 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		moveDownPlayer1 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		moveLeftPlayer1 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		moveRightPlayer1 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		attackPlayer1 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		jumpPlayer1 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		
		gc = moveUpPlayer1.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveUpPlayer1.toString() , moveUpPlayer1.getWidth() / 2, moveUpPlayer1.getHeight() * 4 / 5);
		
		gc = moveDownPlayer1.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveDownPlayer1.toString() , moveDownPlayer1.getWidth() / 2, moveDownPlayer1.getHeight() * 4 / 5);
		
		gc = moveLeftPlayer1.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveLeftPlayer1.toString() , moveLeftPlayer1.getWidth() / 2, moveLeftPlayer1.getHeight() * 4 / 5);
		
		gc = moveRightPlayer2.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveRightPlayer2.toString() , moveRightPlayer2.getWidth() / 2, moveRightPlayer2.getHeight() * 4 / 5);
		
		gc = attackPlayer1.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.attackPlayer1.toString() , attackPlayer1.getWidth() / 2, attackPlayer1.getHeight() * 4 / 5);
		
		gc = jumpPlayer1.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.jumpPlayer1.toString() , jumpPlayer1.getWidth() / 2, jumpPlayer1.getHeight() * 4 / 5);
		
		moveUpPlayer2 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		moveDownPlayer2 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		moveLeftPlayer2 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		moveRightPlayer2 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		attackPlayer2 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		jumpPlayer2 = new Canvas(Main.SCREEN_WIDTH / 4, Main.SCREEN_HEIGHT / 10);
		
		gc = moveUpPlayer2.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveUpPlayer2.toString() , moveUpPlayer2.getWidth() / 2, moveUpPlayer2.getHeight() * 4 / 5);
		
		gc = moveDownPlayer2.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveDownPlayer2.toString() , moveDownPlayer2.getWidth() / 2, moveDownPlayer2.getHeight() * 4 / 5);
		
		gc = moveLeftPlayer2.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveLeftPlayer2.toString() , moveLeftPlayer2.getWidth() / 2, moveLeftPlayer2.getHeight() * 4 / 5);
		
		gc = moveRightPlayer2.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.moveRightPlayer2.toString() , moveRightPlayer2.getWidth() / 2, moveRightPlayer2.getHeight() * 4 / 5);
		
		gc = attackPlayer2.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.attackPlayer2.toString() , attackPlayer2.getWidth() / 2, attackPlayer2.getHeight() * 4 / 5);
		
		gc = jumpPlayer2.getGraphicsContext2D();
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText(Control.jumpPlayer2.toString() , jumpPlayer2.getWidth() / 2, jumpPlayer2.getHeight() * 4 / 5);
		try { new Thread(() -> {
			startMP = new MediaPlayer(START_SOUND);
			startMP.setCycleCount(MediaPlayer.INDEFINITE);
			startMP.play();
		}).start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ControlsComponent getInstance() {
		return instance;
	}
}
