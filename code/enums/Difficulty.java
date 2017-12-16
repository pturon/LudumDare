package code.enums;

public enum Difficulty {
	EASY(3),
	NORMAL(2),
	HARD(1);

	private int hearts;

	Difficulty(int hearts) {
		this.hearts = hearts;
	}

	/**
	 * Returns the number of hearts the player has left at the beginning of the game.
	 */
	public int getHearts() {
		return hearts;
	}

	/**
	 * Returns the difficulty that is selected when the layer rotates to the right
	 * through the difficulties in the main menu.
	 */
	public Difficulty next() {
		switch(this) {
		case EASY:
			return NORMAL;
		case NORMAL:
			return HARD;
		case HARD:
			return EASY;
		default:
			return NORMAL;
		}
	}

	/**
	 * Returns the difficulty that is selected when the layer rotates to the left
	 * through the difficulties in the main menu.
	 */
	public Difficulty previous() {
		switch(this) {
		case EASY:
			return HARD;
		case NORMAL:
			return EASY;
		case HARD:
			return NORMAL;
		default:
			return NORMAL;
		}
	}
}
