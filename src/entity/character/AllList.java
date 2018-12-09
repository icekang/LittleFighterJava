package entity.character;

import main.Main;
import main.charac.PlayCard;
import main.charac.PlayCardBot;
import java.util.*;
import main.arena.*;

public class AllList {
	public static Character[] charList=new Character[]{
			new Character("Knight","knight.png"),
			new Character("Jan","jan.png"),
			new Character("Monk","monk.png"),
			new Character("Sorcerer","sorcerer.png"),
			new Character("Woody","woody.png")};
	public static Players[] playerList = new Players[6];
	public static String[] teamcol = new String[] {
			"DC143C",
			"6B8E23",
			"48D1CC",
			"9400D3",
			"A0522D",
			"696969"
		};
	public static PlayCard[] playCardList = new PlayCard[6];
	public static TreeSet kList = new TreeSet();
	public static ArrayList al,hm,acc,skill;
	
	public static void initAC() {
		al=new ArrayList();
		hm=new ArrayList();
		acc=new ArrayList();
		skill=new ArrayList();
		int g=0;
		for(int i=0;i<6;i++) {
			if(playerList[i].isActive())
			{	
				al.add(i);
				hm.add(new HMbar(playerList[i],g));
				acc.add(new ArenaChar(playerList[i]));
				g+=1;
			}
		}
	}
	
	public static void initPlayers() {
		for(int i=0;i<6;i++) {
			if(i<2)
				playerList[i] = new Players(String.format("Player %d", i+1),i,i);
			else
				playerList[i] = new Players(String.format("Bot %d",i-1),i,i);
		}
	}
	
	public static void initPlayCard() {
		initPlayers();
		for(int i=0;i<6;i++) {
			int width = 253, height = 339, playerMargin = width + 35;
			double botRatio = 1.48;
			if(i<2)
				playCardList[i] = new PlayCard(playerList[i],Main.SCREEN_WIDTH / 2 - (playerMargin - width) / 2 - width + playerMargin*i,Main.SCREEN_HEIGHT / 20, width, height);
			else
				playCardList[i] = new PlayCardBot(playerList[i],Main.SCREEN_WIDTH / 2 - ((width / botRatio) + 15) * 3 / 2 - width / botRatio / 2+ ((width / botRatio) + 15)*(i-2),Main.SCREEN_HEIGHT * 12 / 20, width / botRatio, height / botRatio);
		}
	}
	
	public static int hasWinner() {
		TreeSet<Integer> tList = new TreeSet<>();
		for(int i=0;i<6;i++)
			if(playerList[i].isActive()&&playerList[i].getStatus()!=5)
				tList.add(playerList[i].getTeam());
		if(tList.size()>1)
			return 0;
		if(tList.size()==0)
			return 1;
		return 2;
	}
	
	public static ArrayList<Players> checkWinner() {
		ArrayList<Players> x =new ArrayList<>();
		TreeSet<Integer> tList = new TreeSet<>();
		for(int i=0;i<6;i++)
			if(playerList[i].isActive()&&playerList[i].getStatus()!=5)
				tList.add(playerList[i].getTeam());
		if(tList.size()>1||tList.size()==0)
			return x;
		int gg=tList.iterator().next();
		for(int i=0;i<6;i++)
			if(playerList[i].getTeam()==gg)
				x.add(playerList[i]);
		return x;
	}
}
