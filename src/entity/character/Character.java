package entity.character;
import javafx.scene.image.Image;

public class Character {
	
	private String name;
	private Image image;
	
	public Character(String name, String url) {
		this.image = new Image("images/"+url);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Image getImage() {
		return image;
	}
	
}
