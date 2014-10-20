package charactercleaner;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Character implements CharacterEntity{
	
	public static final int CHARACTER_WIDTH = 48;
	public static final int CHARACTER_HEIGHT = 48;
	private float x;
	private float y;
	private Image image;
	private float speed;
	private char imgname;
	
	public Character(float x, float y, char imgname, float speed) throws SlickException {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.imgname = imgname;
		image = new Image("res/"+imgname+".png");
	}

	public void render() {
		image.draw(x - CHARACTER_WIDTH/2, y - CHARACTER_HEIGHT/2);
		
	}

	public void update() {
		y += speed;
		
	}
	
	public boolean isCharPressed() {
	    if (imgname == 'A')
	    	return CharacterCleanerMain.isAPress;
	    else if (imgname == 'B')
	    	return CharacterCleanerMain.isBPress;
	    else if (imgname == 'C')
	    	return CharacterCleanerMain.isCPress;
	    else if (imgname == 'D')
	    	return CharacterCleanerMain.isDPress;
	    else if (imgname == 'E')
	    	return CharacterCleanerMain.isEPress;
	    else if (imgname == 'F')
	    	return CharacterCleanerMain.isFPress;
	    else if (imgname == 'G')
	    	return CharacterCleanerMain.isGPress;
	    else if (imgname == 'H')
	    	return CharacterCleanerMain.isHPress;
	    else if (imgname == 'I')
	    	return CharacterCleanerMain.isIPress;
	    else
	    	return CharacterCleanerMain.isJPress;
	  }
	
	public char getName() {
		return imgname;
	}
	 
	public boolean isDeletable() {
	    return isCharPressed();
	}

	public boolean isInWindow() {
		return (y > 0 && y < CharacterCleanerMain.GAME_HEIGHT);
	}

	@Override
	public float YPosition() {
		return y;
	}

	@Override
	public float XPosition() {
		return x;
	}

}
