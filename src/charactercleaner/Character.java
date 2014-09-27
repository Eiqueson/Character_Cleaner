package charactercleaner;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Character implements Entity{
	
	public static final int CHARACTER_WIDTH = 48;
	public static final int CHARACTER_HEIGHT = 48;
	private float x;
	private float y;
	private Image image;
	private float speed;
	
	public Character(float x, float y, char imgname, float speed) throws SlickException {
		this.x = x;
		this.y = y;
		this.speed = speed;
		image = new Image("C:\\Users/Eiqueson/workspace/CharacterCleaner/object/"+imgname+".png");
	}

	public void render() {
		image.draw(x - CHARACTER_WIDTH/2, y - CHARACTER_HEIGHT/2);
		
	}

	public void update() {
		y += speed;
		
	}

}
