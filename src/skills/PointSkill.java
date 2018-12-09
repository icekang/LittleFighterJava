package skills;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import entity.character.*;

public class PointSkill extends Skill {
	
	public PointSkill(int team,int damage,int turn,int mana,Image body,Image hitPic,int posx,int posy,int posz,int rx,int ry,int rz,boolean blockable,int effdu,Media startsound,Media endsound) {
		super(team,damage,turn,mana,body,hitPic,posx,posy,posz,rx,ry,rz,blockable,effdu,startsound,endsound);
		this.setLayoutX(posx-30);
		this.setLayoutY(600-posy-posz-30);
		this.hit=true;
	}
	
	public boolean checkhit(Players p) {
		if(p.getStatus()!=5&&team!=p.getTeam()&&posx-rx<=p.getPosx()+42&&p.getPosx()+42<=posx+rx&&posy-ry<=p.getPosy()-42&&p.getPosy()-42<=posy+ry&&posz-rz<=p.getPosz()&&p.getPosz()<=posz+rz) {
			if(blockable&&turn!=p.getTurn()&&p.getStatus()==1)
				return false;
			else
			{
				p.takeDamage(damage);
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	public void update() {
		this.setScaleX(turn);
		if(this.dead&&this.tilldead>0)
			this.tilldead-=1;
	}
}
