package charactercleaner;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Character implements Entity{
	
	public static final int CHARACTER_WIDTH = 48;
	public static final int CHARACTER_HEIGHT = 48;
	private String CHARACTER_LIST = "ABCDEFGHIJKLMNOPQRSTUV";
	private int N = CHARACTER_LIST.length();
	private float x;
	private float y;
	private Image image;
	
	Random randomcharacter = new Random();
	
	public Character(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		image = new Image("C:\\Users/Eiqueson/workspace/CharacterCleaner/object/"+(CHARACTER_LIST.charAt(randomcharacter.nextInt(N)))+".png");
	}

	public void render() {
		image.draw(x - CHARACTER_WIDTH/2, y - CHARACTER_HEIGHT/2);
		
	}

	public void update() {
		y += CharacterCleanerMain.SPEED;
		
	}

}
