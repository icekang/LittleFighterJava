package skills;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class SkillDetail {
	
	public int damage,mana,rx,ry,rz,range,velo,effdu;
	
	public boolean blockable;
	
	public Image body,hit;
	
	public Media startsound,hitsound;
	
	public SkillDetail(int damage,int mana,int rx,int ry,int rz,int range,int velo,boolean blockable,String folder,int effdu,String sfolder) {
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
		
		//System.out.println(sfolder+"2.wav");
		
		startsound = new Media(ClassLoader.getSystemResource(sfolder+"1.wav").toString());
		hitsound = new Media(ClassLoader.getSystemResource(sfolder+"2.wav").toString());
	}
}
