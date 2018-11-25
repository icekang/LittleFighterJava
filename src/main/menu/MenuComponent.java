package main.menu;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import main.Main;

public class MenuComponent {
	private Pane backgroundPane;
	
	public static MenuComponent instance = new MenuComponent();
	
	public MenuComponent() {
		backgroundPane = new Pane();
		
		Canvas screen = new Canvas(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		GraphicsContext gc = screen.getGraphicsContext2D();
		
		Image imageBackground = new Image("images/MenuBackground.png");
		gc.drawImage(imageBackground, 0, 0);
		
		Image imageLogo = new Image("images/GameLogo.png");
		gc.drawImage(imageLogo, Main.SCREEN_WIDTH / 2 - imageLogo.getWidth() / 2, 10);
		
		//gc.clearRect(Main.SCREEN_WIDTH / 2, Main.SCREEN_HEIGHT / 2 * 4, 450, 100);
		
		gc.setFont(Font.font("Minecraft", 40));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("Main Menu", Main.SCREEN_WIDTH / 2, imageLogo.getHeight() * 8 / 7);
		
		gc.setFont(Font.font("Minecraft", 30));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("VSMode", Main.SCREEN_WIDTH / 2, imageLogo.getHeight() * 9 / 7);
		
		gc.setFont(Font.font("Minecraft", 30));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("Controls", Main.SCREEN_WIDTH / 2, imageLogo.getHeight() * 10 / 7);
		
		gc.setFont(Font.font("Minecraft", 30));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("Exit", Main.SCREEN_WIDTH / 2, imageLogo.getHeight() * 11 / 7);
		
		backgroundPane.getChildren().addAll(screen);
	}
	
	public static MenuComponent getInstance() {
		return instance;
	}
	
	public Pane getBackgroundPane() {
		return backgroundPane;
	}
}
