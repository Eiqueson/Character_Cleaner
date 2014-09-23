package charactercleaner;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import charactercleaner.CharacterCleanerMain;

public class CharacterCleanerMain extends BasicGame {

	public static final int GAME_WIDTH = 480;
	public static final int GAME_HEIGHT = 640;
	private Brick[] bricks;
	
	public CharacterCleanerMain(String title) {
		super(title);

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (Brick brick : bricks)
		{
			brick.render();
		}
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		bricks = new Brick[30];
		for (int i=0 ; i<30 ; i++)
		{
			if (i<10)
				bricks[i] = new Brick(24+48*i,GAME_HEIGHT-24);
			else if (i<20)
				bricks[i] = new Brick(24+48*(i-10),GAME_HEIGHT-72);
			else
				bricks[i] = new Brick(24+48*(i-20),GAME_HEIGHT-120);
		}
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		
	}
	
	public static void main(String[] args) {
	    try {
	    CharacterCleanerMain game = new CharacterCleanerMain("Main");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
