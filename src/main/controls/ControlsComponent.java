package main.controls;

import entity.control.Control;
import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.menu.MenuComponent;
import java.util.ArrayList;
import main.SceneManager;

public class ControlsComponent {
	public static ControlsComponent instance = new ControlsComponent();
	
	private static final Media START_SOUND = new Media(ClassLoader.getSystemResource("sounds/Controls.mp3").toString());
	static MediaPlayer startMP = new MediaPlayer(START_SOUND);
	private static final Media TRANSITION_SOUND = new Media(ClassLoader.getSystemResource("sounds/transition.mp3").toString());
	static MediaPlayer transitionMP = new MediaPlayer(TRANSITION_SOUND);
	
	private Pane backgroundPane;
	
	private ArrayList<KeyComponent> list;
	private Button backButton;
	public ControlsComponent() {
		backgroundPane = new Pane();
		
		Canvas screen = new Canvas(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		GraphicsContext gc = screen.getGraphicsContext2D();
		
		Image imageBackground = new Image(ClassLoader.getSystemResource("images/MenuBackground.png").toString());
		gc.drawImage(imageBackground, 0, 0);
		
		Canvas canvasBack = new Canvas(68, 68);
		canvasBack.setLayoutX(5);canvasBack.setLayoutY(5);
		gc = canvasBack.getGraphicsContext2D();
		Image imageBack = new Image(ClassLoader.getSystemResource("images/Back.png").toString());
		gc.drawImage(imageBack, 0, 0);
		
		canvasBack.setOnMouseEntered(event -> SceneManager.getControlScene().setCursor(Cursor.HAND));
		canvasBack.setOnMouseClicked(event -> ControlsHandler.moveToMenuScene());
		canvasBack.setOnMouseExited(event -> SceneManager.getControlScene().setCursor(Cursor.DEFAULT));
		
		Canvas control;
		Canvas player1;
		Canvas player2;
		
		control = new Canvas(400, 132 / 3);
		control.setTranslateX(Main.SCREEN_WIDTH / 2 - control.getWidth() / 2);
		control.setTranslateY(Main.SCREEN_HEIGHT / 30);
		gc = control.getGraphicsContext2D();
		
		gc.setFont(Font.font("Minecraft", 40));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("CONTROLS", control.getWidth() / 2, control.getHeight()* 4 / 5);
		
		player1 = new Canvas(300, 132 / 3);
		player1.setTranslateX(10);
		player1.setTranslateY(Main.SCREEN_HEIGHT * 1.5 / 20);
		gc = player1.getGraphicsContext2D();
		
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("PLAYER 1", control.getWidth() / 2, control.getHeight()* 4 / 5);
		
		player2 = new Canvas(300, 132 / 3);
		player2.setTranslateX(Main.SCREEN_WIDTH - 10 - 1.5 * player2.getWidth());
		player2.setTranslateY(Main.SCREEN_HEIGHT * 1.5 / 20);
		gc = player2.getGraphicsContext2D();
		
		gc.setFont(Font.font("Minecraft", 20));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BASELINE);
		gc.setFill(Color.WHITE);
		gc.fillText("PLAYER 2", control.getWidth() / 2, control.getHeight()* 4 / 5);
		
		list = new ArrayList<KeyComponent>();
		double y = Main.SCREEN_HEIGHT * 3 / 20 + 10;
		double prefWidth = Main.SCREEN_WIDTH / 5;
		double keyX = 60;
		list.add(new KeyComponent(1,Control.UP,prefWidth,50,keyX,y,"UP")); y += 60;
		list.add(new KeyComponent(1,Control.DOWN,prefWidth,50,keyX,y,"DOWN")); y += 60;
		list.add(new KeyComponent(1,Control.LEFT,prefWidth,50,keyX,y,"LEFT")); y += 60;
		list.add(new KeyComponent(1,Control.RIGHT,prefWidth,50,keyX,y,"RIGHT")); y += 60;
		list.add(new KeyComponent(1,Control.BLOCK,prefWidth,50,keyX,y,"BLOCK")); y += 60;
		list.add(new KeyComponent(1,Control.JUMP,prefWidth,50,keyX,y,"JUMP")); y += 60;
		list.add(new KeyComponent(1,Control.ATTACK,prefWidth,50,keyX,y,"ATTACK")); y += 60;
		list.add(new KeyComponent(1,Control.ACTIVATE,prefWidth,50,keyX,y,"ACTIVATE"));
		y = Main.SCREEN_HEIGHT * 3 / 20 + 10;
		keyX += 520;
		list.add(new KeyComponent(2,Control.UP,prefWidth,50,keyX,y,"UP")); y += 60;
		list.add(new KeyComponent(2,Control.DOWN,prefWidth,50,keyX,y,"DOWN")); y += 60;
		list.add(new KeyComponent(2,Control.LEFT,prefWidth,50,keyX,y,"LEFT")); y += 60;
		list.add(new KeyComponent(2,Control.RIGHT,prefWidth,50,keyX,y,"RIGHT")); y += 60;
		list.add(new KeyComponent(2,Control.BLOCK,prefWidth,50,keyX,y,"BLOCK")); y += 60;
		list.add(new KeyComponent(2,Control.JUMP,prefWidth,50,keyX,y,"JUMP")); y += 60;
		list.add(new KeyComponent(2,Control.ATTACK,prefWidth,50,keyX,y,"ATTACK")); y += 60;
		list.add(new KeyComponent(2,Control.ACTIVATE,prefWidth,50,keyX,y,"ACTIVATE"));
		/*
		backButton = new Button("Back to Menu");
		backButton.setPrefWidth(300);
		backButton.setPrefHeight(50);
		backButton.setStyle("-fx-background-color : #FFFFFF;-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		backButton.setLayoutX(Main.SCREEN_WIDTH / 2 - 300 / 2);
		backButton.setLayoutY(y + 60);
		
		backButton.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	ControlsHandler.moveToMenuScene();
            }
        });
        */
		backgroundPane.getChildren().addAll(screen, canvasBack, control, player1, player2);
		backgroundPane.getChildren().addAll(list);
		//backgroundPane.getChildren().add(backButton);
		
		try { new Thread(() -> {
			startMP = new MediaPlayer(START_SOUND);
			startMP.setCycleCount(MediaPlayer.INDEFINITE);
			startMP.play();
		}).start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<list.size();i++)
                        	list.get(i).update();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                    Platform.runLater(updater);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
	}
	
	public static ControlsComponent getInstance() {
		return instance;
	}
	
	public void startTransitionSound() {
		transitionMP.setCycleCount(1);
		transitionMP.play();
	}
	
	public Pane getBackgroundPane() {
		return backgroundPane;
	}
	
	public void stopSound() {
		if(startMP != null) {
			startMP.stop();
		}
	}
}
