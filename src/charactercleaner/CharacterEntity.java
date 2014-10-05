package charactercleaner;

public interface CharacterEntity {
	void render();
	void update();
	boolean isDeletable();
	char getName();
	boolean isInWindow();
}
