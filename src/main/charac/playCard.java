package main.charac;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import entity.character.players;
import entity.character.characterList;
public class playCard extends Pane {
	players player;
	private Button Cname;
	private Button Team;
	public playCard(players p,double posx,double posy,double width,double height) {
		super();
		player=p;
		this.setLayoutX(posx);
		this.setLayoutY(posy);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		Cname = new Button(characterList.charName[p.getCindex()]);
		Cname.setLayoutY(0);
		Team = new Button(String.format("Team %d", p.getTeam()));
		Team.setLayoutY(50);
		this.getChildren().addAll(Cname,Team);
	}
	
	public void handleKey(KeyCode x) {
		player.handleKey(x);
	}
	
	public void update()
	{
		if(player.isActive())
			this.setStyle("-fx-background-color : #FFFFFF;");
		else
			this.setStyle("-fx-background-color : #000000;");
		Cname.setText(characterList.charName[player.getCindex()]);
		Team.setText(String.format("Team %d", player.getTeam()));
	}
}
