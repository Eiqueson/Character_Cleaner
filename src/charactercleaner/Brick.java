package charactercleaner;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Brick {

	private float x;
	  private float y;
	  private Image image;
	
	public Brick(float x, float y) throws SlickException {
	    this.x = x;
	    this.y = y;
	    image = new Image("C:\\Users/Eiqueson/workspace/CharacterCleaner/object/BrickD.png");
	  }
	
	public void render() {
		image.draw(x - 24, y - 24);
		
	}

}
