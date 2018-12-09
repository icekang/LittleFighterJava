package skills;

import entity.character.Players;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import main.Main;

public class FloatSkill extends Skill {

	private int range;
	private int velo;
	
	public FloatSkill(int team,int damage,int turn,int mana,Image body,Image hitPic,int posx,int posy,int posz,int rx,int ry,int rz,boolean blockable,int range,int velo,int effdu,Media startsound,Media endsound) {
		super(team,damage,turn,mana,body,hitPic,posx,posy,posz,rx,ry,rz,blockable,effdu,startsound,endsound);
		this.range=range;
		this.velo=velo;
		this.setPrefHeight(60);
		this.setPrefWidth(60);
		this.setLayoutX(posx-30);
		this.setLayoutY(600-posy-posz-30);
	}
	
	@Override
	public boolean checkhit(Players p) {
		if(posx<0||posx>main.Main.SCREEN_WIDTH||range==0)
			return true;
		if(p.getStatus()!=5&&team!=p.getTeam()&&posx-rx<=p.getPosx()+42&&p.getPosx()+42<=posx+rx&&posy-ry<=p.getPosy()-42&&p.getPosy()-42<=posy+ry&&posz-rz<=p.getPosz()&&p.getPosz()<=posz+rz) {
			if(blockable&&turn!=p.getTurn()&&p.getStatus()==1)
			{
				this.hit=true;
				return true;
			}
			else
			{
				p.takeDamage(damage);
				this.hit=true;
				return true;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public void update() {
		this.setScaleX(turn);
		if(this.dead&&this.tilldead>0)
			this.tilldead-=1;
		if(!this.dead) {
			posx+=turn*velo;
			range-=1;
		}
		this.setLayoutX(posx-30);
		this.setLayoutY(600-posy-posz-30);
	}

}
