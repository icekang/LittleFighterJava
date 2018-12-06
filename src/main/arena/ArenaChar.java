package main.arena;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import entity.character.*;

public class ArenaChar extends Pane {
	
	private players pp;
	private ImageView iv;
	private Button name;
	
	public ArenaChar(players p) {
		super();
		pp=p;
		
		iv=new ImageView();
		iv.setFitHeight(85);
		iv.setFitWidth(85);
		iv.setImage(allList.charList[pp.getCindex()].getImage());
		
		name=new Button(p.getName());
		name.setPrefWidth(40);name.setPrefHeight(10);
		name.setLayoutX(23);name.setLayoutY(85);
		name.setStyle("-fx-font-size: 5pt;-fx-text-fill: #"+allList.teamcol[p.getTeam()]+";");
		
		this.getChildren().addAll(iv,name);
	}
	
	public void gameUpdate() {
		//if(pp.getStatus()==5)
		//	return;
		this.setLayoutX(pp.getPosx());
		this.setLayoutY(600-pp.getPosy()-pp.getPosz());
		if(pp.getJump()!=0)
			iv.setImage(allList.charList[pp.getCindex()].getJump());
		else if(pp.getStatus()==0)
			iv.setImage(allList.charList[pp.getCindex()].getStand());
		else if(pp.getStatus()==1)
			iv.setImage(allList.charList[pp.getCindex()].getBlock());
		else if(pp.getStatus()==2)
			iv.setImage(allList.charList[pp.getCindex()].getAttack());
		else if(pp.getStatus()==3)
			iv.setImage(allList.charList[pp.getCindex()].getSk1());
		else if(pp.getStatus()==4)
			iv.setImage(allList.charList[pp.getCindex()].getSk2());
		else if(pp.getStatus()==5)
			iv.setImage(allList.charList[pp.getCindex()].getDead());
		iv.setScaleX(pp.getTurn());
	}
}
