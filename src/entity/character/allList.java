package entity.character;

import main.charac.playCard;
import main.charac.playCardBot;

public class allList {
	public static Character[] charList=new Character[]{
			new Character("Woody","woody.jpg"),
			new Character("Dennis","dennis.jpg"),
			new Character("Scotty","scotty.jpg"),
			new Character("Spock","spock.jpg"),
			new Character("Stickman","stickman.jpg")};
	public static players[] playerList = new players[6];
	public static playCard[] playCardList = new playCard[6];
	
	public static void initPlayers() {
		for(int i=0;i<6;i++) {
			if(i<2)
				playerList[i] = new players(String.format("Player %d", i+1),i);
			else
				playerList[i] = new players(String.format("Bot %d",i-1),i);
		}
	}
	
	public static void initPlayCard() {
		initPlayers();
		for(int i=0;i<6;i++) {
			if(i<2)
				playCardList[i] = new playCard(playerList[i],0+200*i,0,100,150);
			else
				playCardList[i] = new playCardBot(playerList[i],0+200*(i-2),200,100,170);
		}
	}
}
