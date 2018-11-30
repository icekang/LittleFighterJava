package main.controls;

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
import javafx.scene.input.MouseEvent;
import main.Main;
import main.menu.MenuComponent;
import java.util.ArrayList;
import main.SceneManager;

public class ControlsComponent {
	public static ControlsComponent instance = new ControlsComponent();
	
	private static final Media START_SOUND = new Media(ClassLoader.getSystemResource("sounds/Controls.mp3").toString());
	static MediaPlayer startMP = new MediaPlayer(START_SOUND);

	private Pane backgroundPane;
	private ArrayList<KeyComponent> list;
	private Button backButton;
	public ControlsComponent() {
		backgroundPane = new Pane();
		list = new ArrayList<KeyComponent>();
		list.add(new KeyComponent(1,Control.UP,500,50,0,0,"UP"));
		list.add(new KeyComponent(1,Control.DOWN,500,50,0,60,"DOWN"));
		list.add(new KeyComponent(1,Control.LEFT,500,50,0,120,"LEFT"));
		list.add(new KeyComponent(1,Control.RIGHT,500,50,0,180,"RIGHT"));
		list.add(new KeyComponent(1,Control.BLOCK,500,50,0,240,"BLOCK"));
		list.add(new KeyComponent(1,Control.JUMP,500,50,0,300,"JUMP"));
		list.add(new KeyComponent(1,Control.ATTACK,500,50,0,360,"ATTACK"));
		list.add(new KeyComponent(1,Control.ACTIVATE,500,50,0,420,"ACTIVATE"));
		
		list.add(new KeyComponent(2,Control.UP,500,50,510,0,"UP"));
		list.add(new KeyComponent(2,Control.DOWN,500,50,510,60,"DOWN"));
		list.add(new KeyComponent(2,Control.LEFT,500,50,510,120,"LEFT"));
		list.add(new KeyComponent(2,Control.RIGHT,500,50,510,180,"RIGHT"));
		list.add(new KeyComponent(2,Control.BLOCK,500,50,510,240,"BLOCK"));
		list.add(new KeyComponent(2,Control.JUMP,500,50,510,300,"JUMP"));
		list.add(new KeyComponent(2,Control.ATTACK,500,50,510,360,"ATTACK"));
		list.add(new KeyComponent(2,Control.ACTIVATE,500,50,510,420,"ACTIVATE"));
		
		backButton = new Button("Back to Menu");
		backButton.setLayoutX(460);
		backButton.setLayoutY(530);
		backButton.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                ControlsComponent.getInstance().stopSound();
                SceneManager.setMenuScene();
            }
        });
		
		backgroundPane.getChildren().addAll(list);
		backgroundPane.getChildren().add(backButton);
		
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
	
	public Pane getBackgroundPane() {
		return backgroundPane;
	}
	
	public void stopSound() {
		if(startMP != null) {
			startMP.stop();
		}
	}
}
