package main.arena;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import entity.character.allList;
import entity.control.Control;
import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import main.Main;
import main.SceneManager;
import main.charac.CharComponent;
import main.controls.ControlsComponent;
import main.controls.ControlsHandler;
import main.controls.KeyComponent;
import javafx.scene.image.ImageView;
import skills.*;

public class Arena {
	public static Arena instance = new Arena();
	
	public static int arenaWidth = Main.SCREEN_WIDTH;
	public static int arenaHeight = 400;
	
	private static final Media START_SOUND = new Media(ClassLoader.getSystemResource("sounds/Controls.mp3").toString());
	static MediaPlayer startMP = new MediaPlayer(START_SOUND);
	private static final Media TRANSITION_SOUND = new Media(ClassLoader.getSystemResource("sounds/transition.mp3").toString());
	static MediaPlayer transitionMP = new MediaPlayer(TRANSITION_SOUND);
	
	private Pane backgroundPane;
	private ImageView iv;

	public void hh(KeyCode k) {
		allList.kList.add(k);
		
	}
	
	public void ho(KeyCode k) {
		allList.kList.remove(k);
	}
	
	public Arena() {
		backgroundPane = new Pane();
		iv=new ImageView();
		iv.setFitHeight(Main.SCREEN_HEIGHT);
		iv.setFitWidth(Main.SCREEN_WIDTH);
		iv.setImage(new Image("images/arena.png"));
		
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
                    	for(int i=allList.skill.size()-1;i>=0;i--)
                    	{
                    		if(!((Skill)allList.skill.get(i)).isdead()) {
	                    		if(allList.skill.get(i).getClass().equals(PointSkill.class))
	                    		{
	                    			for(int i2=0;i2<allList.al.size();i2++)
	                    				((PointSkill)allList.skill.get(i)).checkhit(allList.playerList[(int)allList.al.get(i2)]);
	                    			((PointSkill)allList.skill.get(i)).sigDead();
	                    		}
	                    		else
	                    		{
	                    			for(int i2=0;i2<allList.al.size();i2++)
	                    				if(((FloatSkill)allList.skill.get(i)).checkhit(allList.playerList[(int)allList.al.get(i2)])) {
	                    					((FloatSkill)allList.skill.get(i)).sigDead();
	                    				}
	                    		}
                    		}
                    		((Skill)allList.skill.get(i)).update();
                    		if(((Skill)allList.skill.get(i)).des())
                    		{
                    			Arena.getInstance().remChild((Node)allList.skill.get(i));
                    			allList.skill.remove(i);
                    		}
                    	}
                    	for(int i=0;i<allList.al.size();i++)
                			allList.playerList[(int)allList.al.get(i)].handleCommand();
                    	for(int i=0;i<allList.al.size();i++)
                    	{
                    		((HMbar)allList.hm.get(i)).gameUpdate();
                    		((ArenaChar)allList.acc.get(i)).gameUpdate();
                    		allList.playerList[(int)allList.al.get(i)].gameUpdate();
                    	}
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
	
	public void newArena() {
		backgroundPane.getChildren().clear();
		backgroundPane.getChildren().add(iv);
		backgroundPane.getChildren().addAll(allList.hm);
		backgroundPane.getChildren().addAll(allList.acc);
	}
	
	public static Arena getInstance() {
		return instance;
	}
	
	public Pane getBackgroundPane() {
		return backgroundPane;
	}
	
	public void addChild(Node e) {
		backgroundPane.getChildren().add(e);
	}
	
	public void remChild(Node e) {
		backgroundPane.getChildren().remove(e);
	}
	
	public void stopSound() {
		if(startMP != null) {
			startMP.stop();
		}
	}
}
