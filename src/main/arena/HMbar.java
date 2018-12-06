package main.arena;

import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.ProgressBar;
import entity.character.*;

public class HMbar extends Pane {
	
	private players pp;
	private ProgressBar hp;
	private ProgressBar mp;
	private ImageView iv;
	private Button name;
	
	public HMbar(players p,int pos) {
		super();
		pp=p;
		
		name=new Button(p.getName());
		name.setPrefWidth(40);name.setPrefHeight(10);
		name.setLayoutX(7);name.setLayoutY(60);
		name.setStyle("-fx-font-size: 5pt");
		
		setLayoutY(10);setLayoutX(164*pos+4);
		setPrefHeight(80);
		setPrefWidth(160);
		setStyle("-fx-background-color: #"+allList.teamcol[p.getTeam()]+";");
		hp=new ProgressBar();
		hp.setProgress(0.5);
		//hp.setStyle("-fx-box-border: goldenrod;");
		hp.setPrefWidth(95);hp.setPrefHeight(10);
		hp.setLayoutX(60);hp.setLayoutY(15);
		
		mp=new ProgressBar();
		mp.setProgress(0.6);
		//mp.setStyle("-fx-box-border: goldenrod;");
		mp.setPrefWidth(95);mp.setPrefHeight(10);
		mp.setLayoutX(60);mp.setLayoutY(45);
		
		iv=new ImageView();
		iv.setFitHeight(32);
		iv.setFitWidth(32);
		iv.setLayoutY(25);iv.setLayoutX(10);
		iv.setImage(allList.charList[pp.getCindex()].getImage());
		
		this.getChildren().addAll(hp,mp,iv,name);
	}
	
	public void gameUpdate() {
		hp.setProgress(pp.getHp()/500.0);
		mp.setProgress(pp.getMp()/100.0);
	}
	
}
