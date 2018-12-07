package main.charac;

import entity.control.Control;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.menu.MenuComponent;
import main.menu.MenuHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import main.SceneManager;
import main.controls.ControlsComponent;
import main.controls.KeyComponent;
import entity.character.allList;
import entity.character.players;

public class CharComponent {
public static CharComponent instance = new CharComponent();
	
	private static final Media START_SOUND = new Media(ClassLoader.getSystemResource("sounds/Controls.mp3").toString());
	static MediaPlayer startMP = new MediaPlayer(START_SOUND);
	private static final Media TRANSITION_SOUND = new Media(ClassLoader.getSystemResource("sounds/transition.mp3").toString());
	static MediaPlayer transitionMP = new MediaPlayer(TRANSITION_SOUND);
	private Pane backgroundPane;
	
	private boolean active;
	
	public void newRound() {
		this.backgroundPane.getChildren().clear();
		drawBackground();
		this.backgroundPane.getChildren().addAll(allList.playCardList);
		this.active=true;
	}
	
	public void hh(KeyCode k) {
		for(int i=0;i<6;i++)
			allList.playCardList[i].handleKey(k);
	}
	
	public CharComponent() {
		backgroundPane = new Pane();
		drawBackground();
		Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                    	
                    	if(!active)
                    		return;
                    	for(int i=0;i<6;i++)
        					allList.playCardList[i].update();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                    }
                    Platform.runLater(updater);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
	}
	private void drawBackground() {
		Canvas screen = new Canvas(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		GraphicsContext gc = screen.getGraphicsContext2D();
		
		Image imageBackground = new Image(ClassLoader.getSystemResource("images/MenuBackground.png").toString());
		gc.drawImage(imageBackground, 0, 0);
		
		
		Canvas canvasBack = new Canvas(68, 68);
		canvasBack.setLayoutX(5);canvasBack.setLayoutY(5);
		gc = canvasBack.getGraphicsContext2D();
		Image imageBack = new Image(ClassLoader.getSystemResource("images/Back.png").toString());
		gc.drawImage(imageBack, 0, 0);
		
		canvasBack.setOnMouseEntered(event -> SceneManager.getCharScene().setCursor(Cursor.HAND));
		canvasBack.setOnMouseClicked(event -> {this.stopSound();this.startTransitionSound();SceneManager.setMenuScene();});
		canvasBack.setOnMouseExited(event -> SceneManager.getCharScene().setCursor(Cursor.DEFAULT));
		
		Canvas canvasFront = new Canvas(68, 68);
		canvasFront.setLayoutX(900);canvasFront.setLayoutY(5);
		gc = canvasFront.getGraphicsContext2D();
		//Image imageBack = new Image(ClassLoader.getSystemResource("images/Back.png").toString());
		gc.drawImage(imageBack, 0, 0,imageBack.getWidth(),imageBack.getHeight(),imageBack.getWidth(),0,-imageBack.getWidth(),imageBack.getHeight());
		
		canvasFront.setOnMouseEntered(event -> SceneManager.getCharScene().setCursor(Cursor.HAND));
		canvasFront.setOnMouseClicked(event -> 
			{
				if(allList.hasWinner()==0) {
					this.stopSound();
					this.startTransitionSound();
					SceneManager.setArena();
				}
				else
				{
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("RESELECT");
					alert.setHeaderText("Please verify your selection");
					alert.setContentText("Must consist of at least 2 players from 2 different team");
					alert.showAndWait();
				}
			});
		this.active=true;
		canvasFront.setOnMouseExited(event -> SceneManager.getCharScene().setCursor(Cursor.DEFAULT));
		
		backgroundPane.getChildren().addAll(screen, canvasBack,canvasFront);
	}
	public static CharComponent getInstance() {
		return instance;
	}
	
	public Pane getBackgroundPane() {
		return backgroundPane;
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
}
