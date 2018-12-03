package main.charac;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import entity.character.players;
import entity.character.allList;
import javafx.scene.image.ImageView;

public class playCard extends Pane {
	players player;
	private Button Cname;
	private Button Team;
	private ImageView iv;
	public playCard(players p,double posx,double posy,double width,double height) {
		super();
		player=p;
		this.setLayoutX(posx);
		this.setLayoutY(posy);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		Cname = new Button(allList.charList[p.getCindex()].getName());
		Cname.setLayoutY(0);
		Cname.setPrefWidth(width);
		Cname.setStyle("-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		Team = new Button(String.format("Team %d", p.getTeam()));
		Team.setLayoutY(height-25);
		Team.setPrefWidth(width);
		Team.setStyle("-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;");
		
		iv=new ImageView();
		iv.setFitHeight(height - 50);
		iv.setFitWidth(width);
		iv.setLayoutY(25);
		
		this.getChildren().addAll(Cname,Team,iv);
	}
	
	public void handleKey(KeyCode x) {
		player.handleKey(x);
	}
	
	public void update()
	{
		if(player.isActive())
			iv.setImage(allList.charList[player.getCindex()].getImage());
		else
			iv.setImage(new Image("images/not.jpg"));
		Cname.setText(allList.charList[player.getCindex()].getName());
		Team.setText(String.format("Team %d", player.getTeam()));
	}
}
