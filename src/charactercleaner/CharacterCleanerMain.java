package charactercleaner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import charactercleaner.CharacterCleanerMain;

public class CharacterCleanerMain extends BasicGame {

	public static final int GAME_WIDTH = 480;
	public static final int GAME_HEIGHT = 640;
	//public static final float SPEED = (float) 2;
	public static final int BRICK_COUNT = 30;
	public static final int CHARACTER_COUNT = 30;
	
	private String CHARACTER_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int N = CHARACTER_LIST.length();
	private Brick[] bricks;
	private Character[] characters;
	private ArrayList<BrickEntity> entities1;
	private ArrayList<CharacterEntity> entities2;
	
	Random row = new Random();
	Random randomcharacter = new Random();
	Random speed = new Random();
	private int score = 0;
	static boolean isCharPress = false;
	
	public CharacterCleanerMain(String title) {
		super(title);
		entities1 = new ArrayList<BrickEntity>();
		entities2 = new ArrayList<CharacterEntity>();
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (BrickEntity entity1 : entities1)
		{
			entity1.render();
		}
		for (CharacterEntity entity2 : entities2)
		{
			entity2.render();
		}
		g.drawString("Score: " + score , 400, 0);
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		initBrickWall();
		initFallingCharacter();
	}

	private void initFallingCharacter() throws SlickException {
		characters = new Character[CHARACTER_COUNT];
		for (int j=0 ; j<CHARACTER_COUNT ; j++)
		{
			characters[j] = new Character((row.nextInt(10)*Character.CHARACTER_WIDTH)+Character.CHARACTER_WIDTH/2, 
						Character.CHARACTER_HEIGHT/2 - 100*j, CHARACTER_LIST.charAt(randomcharacter.nextInt(N)), speed.nextInt(4)+1);
			entities2.add(characters[j]);
		}
	}

	private void initBrickWall() throws SlickException {
		bricks = new Brick[BRICK_COUNT];
		for (int i=0 ; i<BRICK_COUNT ; i++)
		{
			if (i<BRICK_COUNT/3)
				{
					bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*i,GAME_HEIGHT-Brick.BRICK_HEIGHT/2);
					entities1.add(bricks[i]);
				}
			else if (i<BRICK_COUNT*2/3)
				{
					bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*(i-10),GAME_HEIGHT-Brick.BRICK_HEIGHT*3/2);
					entities1.add(bricks[i]);
				}
			else
				{
					bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*(i-20),GAME_HEIGHT-Brick.BRICK_HEIGHT*5/2);
					entities1.add(bricks[i]);
				}
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for (BrickEntity entity1 : entities1)
		{
			entity1.update();
		}
		for (CharacterEntity entity2 : entities2)
		{
			entity2.update();
		}
		
		Iterator<CharacterEntity> iterator = entities2.iterator();
	    while (iterator.hasNext()) {
	      CharacterEntity entity2 = iterator.next();
	      entity2.update();
	      if (entity2.isDeletable()) {
	        iterator.remove();
	        isCharPress = false;
	      }
	    }
		
	}
	
	@Override
	  public void keyPressed(int key, char c) {
	    if (key == Input.KEY_SPACE) {
	    	isCharPress = true;
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
