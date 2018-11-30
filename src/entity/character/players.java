package entity.character;

import entity.control.Control;
import javafx.scene.input.KeyCode;

public class players {
	private String name;
	private int cindex;
	//private character charact;
	private int team;
	private int pNum;
	private boolean active;
	
	public players(String name,int pNum) {
		this.name=name;
		this.pNum=pNum;
		this.active=false;
		this.cindex=0;
		this.team=0;
	}
	
	public void toggleActive() {
		this.active = !this.active;
	}
	
	public void changeChar(int way) {
		cindex+=way;
		if(cindex<0)
			cindex+=characterList.charName.length;
		cindex%=characterList.charName.length;
	}
	
	public void changeTeam(int way) {
		team+=way;
		if(team<0)
			team=0;
	}
	
	public void handleKey(KeyCode x) {
		if(pNum>1)
			return;
		if(x.equals(Control.allkey[pNum][Control.ACTIVATE])) {
			this.toggleActive();
			return;
		}
		if(x.equals(Control.allkey[pNum][Control.LEFT])) {
			this.changeChar(-1);
			return;
		}
		if(x.equals(Control.allkey[pNum][Control.RIGHT])) {
			this.changeChar(1);
			return;
		}
		if(x.equals(Control.allkey[pNum][Control.DOWN])) {
			this.changeTeam(-1);
			return;
		}
		if(x.equals(Control.allkey[pNum][Control.UP])) {
			this.changeTeam(1);
			return;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCindex() {
		return cindex;
	}

	public void setCindex(int cindex) {
		this.cindex = cindex;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
