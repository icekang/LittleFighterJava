package skills;

import entity.character.Character;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class SkillDetail {
	
	private static final ClassLoader CLASS_LOADER = SkillDetail.class.getClassLoader();
	
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
		body = new Image(CLASS_LOADER.getResourceAsStream(folder+"1.png"));
		hit = new Image(CLASS_LOADER.getResourceAsStream(folder+"2.png")); 
		
		//System.out.println(sfolder+"2.wav");
		try {
			startsound = new Media(CLASS_LOADER.getResource(sfolder+"1.wav").toURI().toString());
			hitsound = new Media(CLASS_LOADER.getResource(sfolder+"2.wav").toURI().toString());
		}
		catch(Exception e) {
			System.out.println("FUCK");
		}
	}
}
