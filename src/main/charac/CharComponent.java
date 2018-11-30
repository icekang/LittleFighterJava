package main.charac;

import entity.control.Control;
import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.geometry.Pos;
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
import java.util.ArrayList;
import main.SceneManager;
import main.controls.ControlsComponent;
import main.controls.KeyComponent;
import entity.character.players;

public class CharComponent {
public static CharComponent instance = new CharComponent();
	
	private static final Media START_SOUND = new Media(ClassLoader.getSystemResource("sounds/Controls.mp3").toString());
	static MediaPlayer startMP = new MediaPlayer(START_SOUND);
	private playCard gg;
	private Pane backgroundPane;
	public CharComponent() {
		backgroundPane = new Pane();
		gg = new playCard(new players("ASD",0),0,0,100,100);
		
		backgroundPane.getChildren().add(gg);
		backgroundPane.addEventFilter(KeyEvent.KEY_PRESSED, event -> 
			{
				gg.handleKey(event.getCode());
			}
		);
		
		Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        gg.update();
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
		
		try { new Thread(() -> {
			startMP = new MediaPlayer(START_SOUND);
			startMP.setCycleCount(MediaPlayer.INDEFINITE);
			startMP.play();
		}).start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static CharComponent getInstance() {
		return instance;
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
