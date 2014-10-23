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
		if (CharacterCleanerMain.isStarted == false)
		{
			y += 0;
		}
		else
		{
			y += speed;
		}
		
	}
	
	public boolean isCharPressed() {
	    if (imgname == 'A')
	    	{return CharacterCleanerMain.isAPress;}
	    else if (imgname == 'B')
	    	{return CharacterCleanerMain.isBPress;}
	    else if (imgname == 'C')
	    	{return CharacterCleanerMain.isCPress;}
	    else if (imgname == 'D')
	    	{return CharacterCleanerMain.isDPress;}
	    else if (imgname == 'E')
	    	{return CharacterCleanerMain.isEPress;}
	    else if (imgname == 'F')
	    	{return CharacterCleanerMain.isFPress;}
	    else if (imgname == 'G')
	    	{return CharacterCleanerMain.isGPress;}
	    else if (imgname == 'H')
	    	{return CharacterCleanerMain.isHPress;}
	    else if (imgname == 'I')
	    	{return CharacterCleanerMain.isIPress;}
	    else if (imgname == 'J')
    		{return CharacterCleanerMain.isJPress;}
	    else if (imgname == 'K')
    		{return CharacterCleanerMain.isKPress;}
  	 	else if (imgname == 'L')
  	 		{return CharacterCleanerMain.isLPress;}
  	 	else if (imgname == 'M')
  	 		{return CharacterCleanerMain.isMPress;}
  	 	else if (imgname == 'N')
	 		{return CharacterCleanerMain.isNPress;}
  	 	else if (imgname == 'O')
  	 		{return CharacterCleanerMain.isOPress;}
  	 	else if (imgname == 'P')
  	 		{return CharacterCleanerMain.isPPress;}
  	 	else if (imgname == 'Q')
  	 		{return CharacterCleanerMain.isQPress;}
  	 	else if (imgname == 'R')
  	 		{return CharacterCleanerMain.isRPress;}
  	 	else if (imgname == 'S')
  	 		{return CharacterCleanerMain.isSPress;}
  	 	else if (imgname == 'T')
  	 		{return CharacterCleanerMain.isTPress;}
  	 	else if (imgname == 'U')
  	 		{return CharacterCleanerMain.isUPress;}
  	 	else if (imgname == 'V')
  	 		{return CharacterCleanerMain.isVPress;}
  	 	else if (imgname == 'W')
	 		{return CharacterCleanerMain.isWPress;}
  	 	else if (imgname == 'X')
	 		{return CharacterCleanerMain.isXPress;}
  	 	else if (imgname == 'Y')
	 		{return CharacterCleanerMain.isYPress;}
	    else
	    	{return CharacterCleanerMain.isZPress;}
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
