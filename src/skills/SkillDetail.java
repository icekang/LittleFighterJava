package skills;

import javafx.scene.image.Image;

public class SkillDetail {
	
	public int damage,mana,rx,ry,rz,range,velo,effdu;
	
	public boolean blockable;
	
	public Image body,hit;
	
	public SkillDetail(int damage,int mana,int rx,int ry,int rz,int range,int velo,boolean blockable,String folder,int effdu) {
		this.damage=damage;
		this.mana=mana;
		this.rx=rx;
		this.ry=ry;
		this.rz=rz;
		this.range=range;
		this.velo=velo;
		this.blockable=blockable;
		this.effdu=effdu;
		body = new Image(folder+"1.png");
		hit = new Image(folder+"2.png"); 
	}
}
