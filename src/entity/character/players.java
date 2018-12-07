package entity.character;

import entity.control.Control;
import skills.*;
import javafx.scene.input.KeyCode;
import main.arena.Arena;
import javafx.scene.image.*;

import java.util.*;
public class players {
	private String name;
	private int cindex;
	private int team;
	private int pNum;
	private int jump=0;
	private boolean active;
	private int hp,mp,posx,posy,posz,bcd,turn,status,timeout;
	
	public players(String name,int pNum,int team) {
		Random ran = new Random();
		this.name=name;
		this.pNum=pNum;
		this.active=false;
		this.cindex=0;
		this.team=team;
		this.hp=500;
		this.mp=100;
		this.posx=ran.nextInt(950);
		this.posy=82 + ran.nextInt(318);
		this.posz=0;
		this.bcd=0;
		this.turn=1;
		this.jump=0;
		this.status=0; //0=normal 1=blocked 2=attack 3=skill1 4=skill2 5=dead
		this.timeout=0;
	}
	
	public void takeDamage(int dmg) {
		this.hp-=dmg;
		if(this.hp<=0)
		{
			this.hp=0;
			this.status=5;
			this.timeout=-1;
		}
	}
	
	public void toggleActive() {
		this.active = !this.active;
	}
	
	public void changeChar(int way) {
		cindex+=way;
		if(cindex<0)
			cindex+=allList.charList.length;
		cindex%=allList.charList.length;
	}
	
	public void changeTeam(int way) {
		team+=way;
		if(team<0)
			team=0;
		if(team>5)
			team=5;
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
	
	public void move(int way,int wayy) {
		posx+=way;
		if(posx>905)
			posx=905;
		if(posx<0)
			posx=0;
		posy+=wayy;
		if(posy>400)
			posy=400;
		if(posy<82)
			posy=82;
	}
	
	private int botMove() {
		if(pNum<=1)
			return -1;
		Random ran = new Random();
		int x=ran.nextInt(100);
		if(x<4)
			return 1;
		if(x<8)
			return 2;
		if(x<12)
			return 3;
		if(x<16)
			return 4;
		if(x<20)
			return 5;
		if(x<40)
			return 6;
		if(x<60)
			return 7;
		if(x<80)
			return 8;
		return 9;
	}
	
	public void handleCommand() {
		if(this.status!=0)
			return;
		int y = this.botMove();
		if((allList.kList.contains(Control.allkey[pNum][Control.ACTIVATE])&&allList.kList.contains(Control.allkey[pNum][Control.JUMP])||y==1)&&this.jump==0) {
			SkillDetail sd = allList.charList[this.getCindex()].getSKILL2();
			if(this.mp>=sd.mana) {
				this.mp-=sd.mana;
				PointSkill x = new PointSkill(team,sd.damage,turn,sd.mana,sd.body,sd.hit,posx+42+sd.range*turn,posy-42,posz,sd.rx,sd.ry,sd.rz,sd.blockable,sd.effdu,sd.startsound,sd.hitsound);
				allList.skill.add(x);
				Arena.getInstance().addChild(x);
				this.status=4;
				this.timeout=10;
				return;
			}
		}
		if((allList.kList.contains(Control.allkey[pNum][Control.ACTIVATE])&&allList.kList.contains(Control.allkey[pNum][Control.ATTACK])||y==2)&&this.jump==0) {
			SkillDetail sd = allList.charList[this.getCindex()].getSKILL1();
			if(this.mp>=sd.mana) {
				this.mp-=sd.mana;
				FloatSkill x = new FloatSkill(team,sd.damage,turn,sd.mana,sd.body,sd.hit,posx+42,posy-42,posz,sd.rx,sd.ry,sd.rz,sd.blockable,sd.range,sd.velo,sd.effdu,sd.startsound,sd.hitsound);
				allList.skill.add(x);
				Arena.getInstance().addChild(x);
				this.status=3;
				this.timeout=10;
				return;
			}
		}
		if((allList.kList.contains(Control.allkey[pNum][Control.ATTACK])||y==3)&&this.jump==0) {
			SkillDetail sd = allList.charList[this.getCindex()].getATK();
			PointSkill x = new PointSkill(team,sd.damage,turn,sd.mana,sd.body,sd.hit,posx+42+sd.range*turn,posy-42,posz,sd.rx,sd.ry,sd.rz,sd.blockable,sd.effdu,sd.startsound,sd.hitsound);
			allList.skill.add(x);
			Arena.getInstance().addChild(x);
			this.status=2;
			this.timeout=10;
			return;
		}
		if((allList.kList.contains(Control.allkey[pNum][Control.BLOCK])||y==4)&&this.jump==0&&this.bcd==0) {
			this.status=1;
			this.timeout=10;
			this.bcd=30;
		}
		if(allList.kList.contains(Control.allkey[pNum][Control.RIGHT])||y==6) {
			this.turn=1;
			this.move(10,0);
		}
		if(allList.kList.contains(Control.allkey[pNum][Control.LEFT])||y==7) {
			this.turn=-1;
			this.move(-10,0);
		}
		if(allList.kList.contains(Control.allkey[pNum][Control.UP])||y==8) {
			this.move(0,10);
		}
		if(allList.kList.contains(Control.allkey[pNum][Control.DOWN])||y==9) {
			this.move(0,-10);
		}
		if((allList.kList.contains(Control.allkey[pNum][Control.JUMP])||y==5)&&this.jump==0) {
			this.jump=1;
		}
	}
	
	public int getJump() {
		return jump;
	}

	public int getStatus() {
		return status;
	}

	public int getTimeout() {
		return timeout;
	}

	public void gameUpdate() {
		if(this.status==5)
			return;
		if(this.mp<100)
			this.mp+=1;
		if(jump==-1)
		{
			this.posz-=20;
			if(this.posz<=0)
			{
				this.posz=0;
				this.jump=0;
			}
		}
		if(jump==1)
		{
			this.posz+=20;
			if(this.posz>=100)
			{
				this.posz=50;
				this.jump=-1;
			}
		}
		if(this.status!=0)
		{
			this.timeout--;
			if(this.timeout==0)
				this.status=0;
		}
		if(this.bcd>0)
			this.bcd-=1;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}

	public int getPosz() {
		return posz;
	}

	public int getTurn() {
		return turn;
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
