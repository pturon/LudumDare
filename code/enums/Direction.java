package code.enums;

/**
 * Represents one of the four directions that are possible in a tile-based world or no direction at all.
 */
public enum Direction {
	STANDING(-1),
	UP(0),
	DOWN(1),
	RIGHT(2),
	LEFT(3);

	private int spriteRow;

	Direction(int spriteRow) {
		this.spriteRow = spriteRow;
	}

	/**
	 * Returns the row in which the sprites for this direction can be found in the Sprite-sheets.
	 */
	public int getSpriteRow() {
		return spriteRow;
	}
}