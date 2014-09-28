package charactercleaner;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Brick implements BrickEntity{

	public static final int BRICK_WIDTH = 48;
	public static final int BRICK_HEIGHT = 48;
	private float x;
	private float y;
	private Image image;
	
	public Brick(float x, float y) throws SlickException {
	    this.x = x;
	    this.y = y;
	    image = new Image("C:\\Users/Eiqueson/workspace/CharacterCleaner/object/BrickD.png");
	  }
	
	public void render() {
		image.draw(x - BRICK_WIDTH/2, y - BRICK_HEIGHT/2);
		
	}

	@Override
	public void update() {
		
		
	}

}
