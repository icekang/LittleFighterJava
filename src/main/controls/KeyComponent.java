package main.controls;

import entity.control.Control;
import main.SceneManager;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.Cursor;

public class KeyComponent extends Pane {
	private Button Keyname;
	private Button Keyvalue;
	private int player;
	private int key_number;
	
	public KeyComponent(int player,int key_number,double width,double height,double posx,double posy,String lab) {
		super();
		this.player=player-1;
		this.key_number=key_number;
		this.setLayoutX(posx);
		this.setLayoutY(posy);
		this.setPrefHeight(height);
		this.setPrefWidth(width);
		Keyname = new Button(lab);
		Keyname.setLayoutX(0);Keyname.setLayoutY(0);Keyname.setMinWidth(0.5*width);Keyname.setPrefWidth(0.5*width);Keyname.setMaxWidth(0.5*width);Keyname.setMinHeight(height);Keyname.setPrefHeight(height);Keyname.setMaxHeight(height);
		Keyname.setStyle("-fx-background-color : #3A0808;-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;-fx-text-fill: white;");
		Keyvalue = new Button();
		Keyvalue.setLayoutX(0.5*width);Keyvalue.setLayoutY(0);Keyvalue.setPrefWidth(0.5*width);Keyvalue.setMinWidth(0.5*width);Keyvalue.setMaxWidth(0.5*width);Keyvalue.setPrefHeight(height);Keyvalue.setMinHeight(height);Keyvalue.setMaxHeight(height);
		Keyvalue.setStyle("-fx-background-color : #3A0808;-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;-fx-text-fill: white;");
		this.getChildren().addAll(Keyname,Keyvalue);
		
		this.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> 
			{
				Keyvalue.setStyle("-fx-background-color : #881818;-fx-focus-color: transparent;-fx-background-radius: 0;-fx-background-insets: 0;-fx-text-fill: white;");
				Control.SETTING_PLAYER=this.player;
				Control.SETTING_KEY=this.key_number;
			}
		);
		
		this.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> 
		    {
			    SceneManager.getControlScene().setCursor(Cursor.HAND);
		    }
	    );
		
		this.addEventFilter(MouseEvent.MOUSE_EXITED, event -> 
	        {
		        SceneManager.getControlScene().setCursor(Cursor.DEFAULT);
	        }
		);
		
		this.addEventFilter(KeyEvent.KEY_PRESSED, event -> 
		{
			for(int i=0;i<2;i++)
				for(int i2=0;i2<8;i2++)
					if(Control.allkey[i][i2]==event.getCode()&&(i!=this.player||i2!=this.key_number))
						return;
			if(Control.SETTING_PLAYER==this.player&&Control.SETTING_KEY==this.key_number)
			{
				Control.allkey[this.player][this.key_number]=event.getCode();
				Control.SETTING_PLAYER=-1;
				Control.SETTING_KEY=-1;
			}
		}
	);
	}
	
	public int GetPlayer() {
		return player;
	}
	
	public int GetKey() {
		return key_number;
	}
	
	public void update() {
		if(Control.SETTING_PLAYER==this.player&&Control.SETTING_KEY==this.key_number)
			Keyvalue.setStyle("-fx-background-color : #881818; -fx-text-fill: white;");
		else
			Keyvalue.setStyle("-fx-background-color : #FFFFFF");
		this.Keyvalue.setText(Control.allkey[this.player][this.key_number].toString());
	}
}
