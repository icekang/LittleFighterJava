package entity.character;
import javafx.scene.image.Image;
import skills.SkillDetail;

public class Character {
	
	private String name;
	private Image image,jump,block,attack,s1,s2,dead,stand;
	private SkillDetail atk,skill1,skill2;
	
	public Character(String name, String url) {
		this.image = new Image("thumbs/"+url);
		this.stand= new Image("stand/"+url);
		this.jump = new Image("jump/"+url);
		this.block = new Image("block/"+url);
		this.attack = new Image("attack/"+url);
		this.s1 = new Image("sk1/"+url);
		this.s2 = new Image("sk2/"+url);
		this.dead = new Image("dead/"+url);
		this.name = name;
		
		if(name.equals("Jan")) {
			atk=new SkillDetail(30,0,25,40,10,35,0,true,"skills/janhit",3,"effect/janhit");
			skill1=new SkillDetail(100,30,10,40,10,40,10,false,"skills/star",3,"effect/jancast");
			skill2=new SkillDetail(200,60,50,50,50,200,0,false,"skills/exp1",10,"effect/janbomb");
		}
		if(name.equals("Knight")) {
			atk=new SkillDetail(30,0,25,40,10,35,0,true,"skills/knighthit",3,"effect/knighthit");
			skill1=new SkillDetail(100,30,10,40,10,40,10,false,"skills/pur",3,"effect/knightcast");
			skill2=new SkillDetail(200,60,50,50,50,200,0,false,"skills/exp2",10,"effect/knightbomb");
		}
		if(name.equals("Monk")) {
			atk=new SkillDetail(30,0,25,40,10,35,0,true,"skills/monkhit",3,"effect/monkhit");
			skill1=new SkillDetail(100,30,10,40,10,40,10,false,"skills/spark",3,"effect/monkcast");
			skill2=new SkillDetail(200,60,50,50,50,200,0,false,"skills/exp3",10,"effect/monkbomb");
		}
		if(name.equals("Sorcerer")) {
			atk=new SkillDetail(30,0,25,40,10,35,0,true,"skills/sorcererhit",3,"effect/sorcererhit");
			skill1=new SkillDetail(100,30,10,40,10,40,10,false,"skills/ball",3,"effect/sorcerercast");
			skill2=new SkillDetail(200,60,50,50,50,200,0,false,"skills/exp4",10,"effect/sorcererbomb");
		}
		if(name.equals("Woody")) {
			atk=new SkillDetail(30,0,25,40,10,35,0,true,"skills/woodyhit",3,"effect/woodyhit");
			skill1=new SkillDetail(100,30,10,40,10,40,10,false,"skills/redp",3,"effect/woodycast");
			skill2=new SkillDetail(200,60,50,50,50,200,0,false,"skills/exp5",10,"effect/woodybomb");
		}
	}
	
	public SkillDetail getATK() {
		return atk;
	}
	
	public SkillDetail getSKILL1() {
		return skill1;
	}
	
	public SkillDetail getSKILL2() {
		return skill2;
	}

	public Image getJump() {
		return jump;
	}

	public String getName() {
		return name;
	}

	public Image getImage() {
		return image;
	}
	
	public Image getBlock() {
		return block;
	}
	
	public Image getAttack() {
		return attack;
	}
	
	public Image getSk1() {
		return s1;
	}
	
	public Image getSk2() {
		return s2;
	}
	
	public Image getDead() {
		return dead;
	}
	
	public Image getStand() {
		return stand;
	}
	
}
