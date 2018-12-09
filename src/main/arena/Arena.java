package main.arena;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import entity.character.*;
import javafx.application.Platform;
import javafx.geometry.VPos;
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
import main.Main;
import main.SceneManager;
import skills.*;
import main.interfaces.*;

public class Arena implements BackGroundMusic {
	
	private static final ClassLoader CLASS_LOADER = Arena.class.getClassLoader();
	
	public static Arena instance = new Arena();
	
	public static int arenaWidth = Main.SCREEN_WIDTH;
	public static int arenaHeight = 400;
	
	private Media START_SOUND;
	static MediaPlayer startMP;
	static MediaPlayer transitionMP;
	
	private Pane backgroundPane;
	private ImageView iv;
	
	private Canvas resultCanvas;
	private GraphicsContext gc;
	
	private boolean fighting;

	public void hh(KeyCode k) {
		AllList.kList.add(k);
		
	}
	
	public void ho(KeyCode k) {
		AllList.kList.remove(k);
	}
	
	public Arena() {
		
		try {
			START_SOUND = new Media(CLASS_LOADER.getResource("sounds/main.mp3").toURI().toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		backgroundPane = new Pane();
		iv = new ImageView();
		iv.setFitHeight(Main.SCREEN_HEIGHT);
		iv.setFitWidth(Main.SCREEN_WIDTH);
		iv.setImage(new Image(CLASS_LOADER.getResourceAsStream("images/arena2.png")));
		
		resultCanvas = new Canvas(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT / 2.5);
		
		fighting = true;
		
		Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                    	if(!fighting)
                    		return;
                    	for(int i=AllList.skill.size()-1;i>=0;i--)
                    	{
                    		if(!((Skill)AllList.skill.get(i)).isdead()) {
	                    		if(AllList.skill.get(i).getClass().equals(PointSkill.class))
	                    		{
	                    			for(int i2=0;i2<AllList.al.size();i2++)
	                    				((PointSkill)AllList.skill.get(i)).checkhit(AllList.playerList[(int)AllList.al.get(i2)]);
	                    			((PointSkill)AllList.skill.get(i)).sigDead();
	                    		}
	                    		else
	                    		{
	                    			for(int i2=0;i2<AllList.al.size();i2++)
	                    				if(((FloatSkill)AllList.skill.get(i)).checkhit(AllList.playerList[(int)AllList.al.get(i2)])) {
	                    					((FloatSkill)AllList.skill.get(i)).sigDead();
	                    				}
	                    		}
                    		}
                    		((Skill)AllList.skill.get(i)).update();
                    		if(((Skill)AllList.skill.get(i)).des())
                    		{
                    			Arena.getInstance().remChild((Node)AllList.skill.get(i));
                    			AllList.skill.remove(i);
                    		}
                    	}
                    	for(int i=0;i<AllList.al.size();i++)
                			AllList.playerList[(int)AllList.al.get(i)].handleCommand();
                    	for(int i=0;i<AllList.al.size();i++)
                    	{
                    		((HMbar)AllList.hm.get(i)).gameUpdate();
                    		((ArenaChar)AllList.acc.get(i)).gameUpdate();
                    		AllList.playerList[(int)AllList.al.get(i)].gameUpdate();
                    	}
                    	
                    	if(AllList.hasWinner()==1) {
                    		resultCanvas.setVisible(true);
                    		System.out.println("DRAW");
                    		resultCanvas.setLayoutX(0);
        					resultCanvas.setLayoutY(Main.SCREEN_HEIGHT / 2 - resultCanvas.getHeight() / 2);
        					gc = resultCanvas.getGraphicsContext2D();
        					gc.setFill(Color.GRAY);
        					gc.fillRect(0, 0, resultCanvas.getWidth(), resultCanvas.getHeight());
        					
        					gc.setFont(Font.font("Minecraft", 80));
        					gc.setTextAlign(TextAlignment.CENTER);
        					gc.setTextBaseline(VPos.BASELINE);
        					gc.setFill(Color.RED);
        					gc.fillText("DRAW" , resultCanvas.getWidth() / 2, resultCanvas.getHeight() / 2);
        					
        					backgroundPane.getChildren().clear();
        					backgroundPane.getChildren().add(iv);
        					backgroundPane.getChildren().add(resultCanvas);
        					fighting = false;
        					
        					Arena.getInstance().stopSound();
        					resultCanvas.setOnMouseClicked(event -> {
        						resultCanvas.setVisible(false);
        						backgroundPane.getChildren().clear();
            					SceneManager.setMenuScene();
        					});
        				}
        				else if(AllList.hasWinner()==2)
        				{
        					resultCanvas.setVisible(true);
        					//System.out.println("WINNER");
        					resultCanvas.setLayoutX(0);
        					resultCanvas.setLayoutY(Main.SCREEN_HEIGHT / 2 - resultCanvas.getHeight() / 2);
        					gc = resultCanvas.getGraphicsContext2D();
        					gc.setFill(Color.GRAY);
        					gc.fillRect(0, 0, resultCanvas.getWidth(), resultCanvas.getHeight());
        					
        					gc.setFont(Font.font("Minecraft", 80));
        					gc.setTextAlign(TextAlignment.CENTER);
        					gc.setTextBaseline(VPos.BASELINE);
        					gc.setFill(Color.RED);
        					gc.fillText("WINNER" , resultCanvas.getWidth() / 2, resultCanvas.getHeight() / 2);
        					
        					gc.setFont(Font.font("Minecraft", 50));
        					ArrayList<Players> AP=AllList.checkWinner();
        					for(int i=0;i<AP.size();i++)
        						gc.fillText(AP.get(i).getName() ,i*190+80+resultCanvas.getWidth()/2-(85*AP.size()), resultCanvas.getHeight() * 3 / 4);
        					
        					backgroundPane.getChildren().clear();
        					backgroundPane.getChildren().add(iv);
        					backgroundPane.getChildren().add(resultCanvas);
        					fighting = false;
        					
        					Arena.getInstance().stopSound();
        					resultCanvas.setOnMouseClicked(event -> {
        						resultCanvas.setVisible(false);
        						backgroundPane.getChildren().clear();
            					SceneManager.setMenuScene();
        					});
        					
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
		backgroundPane.getChildren().addAll(AllList.hm);
		backgroundPane.getChildren().addAll(AllList.acc);
		this.startSound();
		fighting=true;
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
