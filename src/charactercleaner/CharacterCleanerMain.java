package charactercleaner;

import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import charactercleaner.CharacterCleanerMain;

public class CharacterCleanerMain extends BasicGame {

	public static final int GAME_WIDTH = 480;
	public static final int GAME_HEIGHT = 640;
	public static final float SPEED = (float) 2;
	private Brick[] bricks;
	private Character[] characters;
	private Character character;
	private ArrayList<Entity> entities;
	
	public CharacterCleanerMain(String title) {
		super(title);
		entities = new ArrayList<Entity>();
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (Entity entity : entities)
		{
			entity.render();
		}
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		bricks = new Brick[30];
		for (int i=0 ; i<30 ; i++)
		{
			if (i<10)
				{
					bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*i,GAME_HEIGHT-Brick.BRICK_HEIGHT/2);
					entities.add(bricks[i]);
				}
			else if (i<20)
				{
					bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*(i-10),GAME_HEIGHT-Brick.BRICK_HEIGHT*3/2);
					entities.add(bricks[i]);
				}
			else
				{
					bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*(i-20),GAME_HEIGHT-Brick.BRICK_HEIGHT*5/2);
					entities.add(bricks[i]);
				}
		}
		character = new Character(264, 24);
		entities.add(character);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for (Entity entity : entities)
		{
			entity.update();
		}
		
		
	}
	
	public static void main(String[] args) {
	    try {
	    CharacterCleanerMain game = new CharacterCleanerMain("Character Cleaner");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
