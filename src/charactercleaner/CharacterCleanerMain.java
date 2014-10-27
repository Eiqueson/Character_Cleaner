package charactercleaner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import charactercleaner.CharacterCleanerMain;

public class CharacterCleanerMain extends CheckCollision {

	public static final int GAME_WIDTH = 480;
	public static final int GAME_HEIGHT = 640;
	public static final int BRICK_COUNT = 3;
	public static final int ROW = 10;
	public static final int CHARACTER_COUNT = 500;
	
	private String CHARACTER_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int N = CHARACTER_LIST.length();
	private Brick[] bricks;
	private Character[] characters;
	private char[] getChar;
	private ArrayList<BrickEntity>[] entities1 = new ArrayList[ROW];
	private ArrayList<CharacterEntity> entities2;
	static boolean isStarted;
	
	Random row = new Random();
	Random randomcharacter = new Random();
	Random speed = new Random();
	private int score = 0;
	float time = 60;
	int count = 6;
	
	static boolean isAPress = false;
	static boolean isBPress = false;
	static boolean isCPress = false;
	static boolean isDPress = false;
	static boolean isEPress = false;
	static boolean isFPress = false;
	static boolean isGPress = false;
	static boolean isHPress = false;
	static boolean isIPress = false;
	static boolean isJPress = false;
	static boolean isKPress = false;
	static boolean isLPress = false;
	static boolean isMPress = false;
	static boolean isNPress = false;
	static boolean isOPress = false;
	static boolean isPPress = false;
	static boolean isQPress = false;
	static boolean isRPress = false;
	static boolean isSPress = false;
	static boolean isTPress = false;
	static boolean isUPress = false;
	static boolean isVPress = false;
	static boolean isWPress = false;
	static boolean isXPress = false;
	static boolean isYPress = false;
	static boolean isZPress = false;
	
	public CharacterCleanerMain(String title) {
		super(title);
		for (int i=0 ; i<ROW ; i++)
		{
			entities1[i] = new ArrayList<BrickEntity>();
		}
		entities2 = new ArrayList<CharacterEntity>();
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for (int i=0 ; i<ROW ; i++)
		{
			for (BrickEntity entity1 : entities1[i])
			{
				entity1.render();
			}
		}
		for (CharacterEntity entity2 : entities2)
		{
			entity2.render();
		}
		g.drawString("Score: " + score , 400, 0);
		if (isStarted == false)
		{
			g.drawString("Game Over", GAME_WIDTH/2 - 40, GAME_HEIGHT/3);
		}
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		isStarted = true;
		initBrickWall();
		initFallingCharacter();
	}

	private void initFallingCharacter() throws SlickException {
		getChar = new char[CHARACTER_COUNT];
		for (int i=0 ; i<CHARACTER_COUNT ; i++)
		{
			getChar[i] = CHARACTER_LIST.charAt(randomcharacter.nextInt(N));
		}
		characters = new Character[CHARACTER_COUNT];
		for (int j=0 ; j<CHARACTER_COUNT ; j++)
		{
			characters[j] = new Character((row.nextInt(10)*Character.CHARACTER_WIDTH)+Character.CHARACTER_WIDTH/2, 
			Character.CHARACTER_HEIGHT/2 - 240*j, getChar[j], speed.nextInt(2)+1);
			entities2.add(characters[j]);
		}
	}

	private void initBrickWall() throws SlickException {
		for (int j=0 ; j<ROW ; j++)
		{
			bricks = new Brick[BRICK_COUNT]; 
			for (int i=0 ; i<BRICK_COUNT ; i++)
			{
				if (i<BRICK_COUNT/3)
					{
						bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*j,GAME_HEIGHT-Brick.BRICK_HEIGHT*5/2);
							entities1[j].add(bricks[i]);
					}
				else if (i<BRICK_COUNT*2/3)
					{
						bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*j,GAME_HEIGHT-Brick.BRICK_HEIGHT*3/2);
							entities1[j].add(bricks[i]);
					}
				else
					{
						bricks[i] = new Brick(Brick.BRICK_WIDTH/2+Brick.BRICK_WIDTH*j,GAME_HEIGHT-Brick.BRICK_HEIGHT/2);
							entities1[j].add(bricks[i]);
					}
			}
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for (int i=0 ; i<ROW ; i++)
		{
			for (BrickEntity entity1 : entities1[i])
			{
				entity1.update();
			}
		}
		
		for (CharacterEntity entity2 : entities2)
		{
			entity2.update();
		}
		
		checkCharacterPress();
		checkCollision();
		checkGameOver();
	}

	protected void checkCollision() {
		Iterator<CharacterEntity> characters = entities2.iterator();
		while (characters.hasNext())
		{
			CharacterEntity character = characters.next();
			character.update();
			if ((entities1[0].isEmpty() == false) && (entities1[0].get(0).YPosition() - character.YPosition() < 24) && (entities1[0].get(0).XPosition() == character.XPosition()))
			{
				entities1[0].remove(0);
				characters.remove();
			}
			if ((entities1[1].isEmpty() == false) && (entities1[1].get(0).YPosition() - character.YPosition() < 24) && (entities1[1].get(0).XPosition() == character.XPosition()))
			{
				entities1[1].remove(0);
				characters.remove();
			}
			if ((entities1[2].isEmpty() == false) && (entities1[2].get(0).YPosition() - character.YPosition() < 24) && (entities1[2].get(0).XPosition() == character.XPosition()))
			{
				entities1[2].remove(0);
				characters.remove();
			}
			if ((entities1[3].isEmpty() == false) && (entities1[3].get(0).YPosition() - character.YPosition() < 24) && (entities1[3].get(0).XPosition() == character.XPosition()))
			{
				entities1[3].remove(0);
				characters.remove();
			}
			if ((entities1[4].isEmpty() == false) && (entities1[4].get(0).YPosition() - character.YPosition() < 24) && (entities1[4].get(0).XPosition() == character.XPosition()))
			{
				entities1[4].remove(0);
				characters.remove();
			}
			if ((entities1[5].isEmpty() == false) && (entities1[5].get(0).YPosition() - character.YPosition() < 24) && (entities1[5].get(0).XPosition() == character.XPosition()))
			{
				entities1[5].remove(0);
				characters.remove();
			}
			if ((entities1[6].isEmpty() == false) && (entities1[6].get(0).YPosition() - character.YPosition() < 24) && (entities1[6].get(0).XPosition() == character.XPosition()))
			{
				entities1[6].remove(0);
				characters.remove();
			}
			if ((entities1[7].isEmpty() == false) && (entities1[7].get(0).YPosition() - character.YPosition() < 24) && (entities1[7].get(0).XPosition() == character.XPosition()))
			{
				entities1[7].remove(0);
				characters.remove();
			}
			if ((entities1[8].isEmpty() == false) && (entities1[8].get(0).YPosition() - character.YPosition() < 24) && (entities1[8].get(0).XPosition() == character.XPosition()))
			{
				entities1[8].remove(0);
				characters.remove();
			}
			if ((entities1[9].isEmpty() == false) && (entities1[9].get(0).YPosition() - character.YPosition() < 24) && (entities1[9].get(0).XPosition() == character.XPosition()))
			{
				entities1[9].remove(0);
				characters.remove();
			}
		}
	}

	protected void checkGameOver() {
		Iterator<CharacterEntity> characters = entities2.iterator();
		while (characters.hasNext())
		{
			CharacterEntity character = characters.next();
			if (isStarted == true)
				{
					character.update();
				}
			if (character.YPosition() > GAME_HEIGHT)
				{
					isStarted = false;
					characters.remove();
				}
		}
	}

	private void checkCharacterPress() {
		Iterator<CharacterEntity> characters = entities2.iterator();
	    while (characters.hasNext())
	    {
	    	CharacterEntity entity2 = characters.next();
	    	entity2.update();
	    	if (entity2.isDeletable() && (entity2.getName() == 'A') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isAPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'B') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isBPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'C') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isCPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'D') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isDPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'E') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isEPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'F') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isFPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'G') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isGPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'H') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isHPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'I') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isIPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'J') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isJPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'K') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isKPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'L') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isLPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'M') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isMPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'N') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isNPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'O') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isOPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'P') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isPPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'Q') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isQPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'R') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isRPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'S') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isSPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'T') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isTPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'U') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isUPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'V') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isVPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'W') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isWPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'X') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isXPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'Y') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isYPress = false;
	    		score++;
	    	}
	    	if (entity2.isDeletable() && (entity2.getName() == 'Z') && (entity2.isInWindow()))
	    	{
	    		characters.remove();
	    		isZPress = false;
	    		score++;
	    	}
	    }
	}
	
	@Override
	  public void keyPressed(int key, char c) {
	    if (isStarted == true)
	    {
	    	if (key == Input.KEY_A) {
	    		isAPress = true;
	    	}
	    	if (key == Input.KEY_B) {
	    		isBPress = true;
	    	}
	    	if (key == Input.KEY_C) {
	    		isCPress = true;
	    	}
	    	if (key == Input.KEY_D) {
	    		isDPress = true;
	    	}
	    	if (key == Input.KEY_E) {
	    		isEPress = true;
	    	}
	    	if (key == Input.KEY_F) {
	    		isFPress = true;
	    	}
	    	if (key == Input.KEY_G) {
	    		isGPress = true;
	    	}
	    	if (key == Input.KEY_H) {
	    		isHPress = true;
	    	}
	    	if (key == Input.KEY_I) {
	    		isIPress = true;
	    	}
	    	if (key == Input.KEY_J) {
	    		isJPress = true;
	    	}
	    	if (key == Input.KEY_K) {
	    		isKPress = true;
	    	}
	    	if (key == Input.KEY_L) {
	    		isLPress = true;
	    	}
	    	if (key == Input.KEY_M) {
	    		isMPress = true;
	    	}
	    	if (key == Input.KEY_N) {
	    		isNPress = true;
	    	}
	    	if (key == Input.KEY_O) {
	    		isOPress = true;
	    	}
	    	if (key == Input.KEY_P) {
	    		isPPress = true;
	    	}
	    	if (key == Input.KEY_Q) {
	    		isQPress = true;
	    	}
	    	if (key == Input.KEY_R) {
	    		isRPress = true;
	    	}
	    	if (key == Input.KEY_S) {
	    		isSPress = true;
	    	}
	    	if (key == Input.KEY_T) {
	    		isTPress = true;
	    	}
	    	if (key == Input.KEY_U) {
	    		isUPress = true;
	    	}
	    	if (key == Input.KEY_V) {
	    		isVPress = true;
	    	}
	    	if (key == Input.KEY_W) {
	    		isWPress = true;
	    	}
	    	if (key == Input.KEY_X) {
	    		isXPress = true;
	    	}
	    	if (key == Input.KEY_Y) {
	    		isYPress = true;
	    	}
	    	if (key == Input.KEY_Z) {
	    		isZPress = true;
	    	}
	    }
	    if (key == Input.KEY_SPACE) {
    		isStarted = true;
    		score = 0;
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
