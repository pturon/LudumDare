package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Textures;
import code.views.Overworld;
import code.views.Scene;

public class Milkman extends Actor {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	private static boolean isLeftPressed = false;
	private static boolean isRightPressed = false;
	private static boolean isUpPressed = false;
	private static boolean isDownPressed = false;

	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;

	public static final boolean HORIZONTAL = true;
	public static final boolean VERTICAL = !HORIZONTAL;

	private int direction = RIGHT;
	private static boolean dominantDirection = HORIZONTAL;
	private int frame = 0;

	private long stepsSinceLastMove = 0;//needed for the "press R to restart"-hint

	private int pickupFrame = -1;
	private static int bottles = 0;
	private static int bottlesPlaced = 0;

	public static final boolean EMPTY_BOTTLE = false;
	public static final boolean FILLED_BOTTLE = !EMPTY_BOTTLE;
	private static boolean bottleType = EMPTY_BOTTLE;

	private static int hearts;

	public Milkman(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	public boolean canPickupBottles() {
		return bottleType == EMPTY_BOTTLE && bottles < 8 && pickupFrame == -1;
	}

	public boolean canPlaceBottles() {
		return bottleType == FILLED_BOTTLE && bottles > 0 && pickupFrame == -1;
	}

	public void fillBottles() {
		bottleType = FILLED_BOTTLE;
	}

	public int getBottles() {
		return bottles;
	}

	public int getBottlesPlaced() {
		return bottlesPlaced;
	}

	public boolean getBottleType() {
		return bottleType;
	}

	@Override
	public BufferedImage getImage() {
		if(pickupFrame > -1) {
			if(bottleType == EMPTY_BOTTLE) {
				return Textures.Sprites.Milkman.getPickupAnimation(direction, pickupFrame, bottles);
			} else {
				return Textures.Sprites.Milkman.getPickupAnimation(direction, 4 - pickupFrame, bottles);
			}
		}
		return Textures.Sprites.Milkman.getWalkCycle(direction, frame, bottles);
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	public void pickupBottle() {
		pickupFrame++;
	}

	public void placeBottle() {
		pickupFrame++;
		bottlesPlaced++;
	}

	public float getSecondsSinceLastMove() {
		return (float)stepsSinceLastMove / Clock.getStepsPerSecond();
	}

	public static void reset() {
		isLeftPressed = false;
		isRightPressed = false;
		isUpPressed = false;
		isDownPressed = false;

		bottles = 0;
		bottlesPlaced = 0;
		bottleType = EMPTY_BOTTLE;
	}

	public static void setLeftPressed(boolean isPressed) {
		isLeftPressed = isPressed;
		dominantDirection = HORIZONTAL;
	}

	public static void setRightPressed(boolean isPressed) {
		isRightPressed = isPressed;
		dominantDirection = HORIZONTAL;
	}

	public static void setUpPressed(boolean isPressed) {
		isUpPressed = isPressed;
		dominantDirection = VERTICAL;
	}

	public static void setDownPressed(boolean isPressed) {
		isDownPressed = isPressed;
		dominantDirection = VERTICAL;
	}

	@Override
	public void step() {
		super.step();

		if(pickupFrame > 3) {
			pickupFrame = -1;
			if(bottleType == EMPTY_BOTTLE) {
				bottles++;
			} else {
				bottles--;
				if(bottles == 0) {
					bottleType = EMPTY_BOTTLE;
				}
			}
		}
		if(pickupFrame > -1) {
			if(stepCounter % (0.125 * Clock.getStepsPerSecond()) == 0) {
				pickupFrame++;
				if(pickupFrame == 2 && scene instanceof Overworld) {
					if(bottleType == EMPTY_BOTTLE) {
						((Overworld)scene).removeBottleAt(x, y);
					} else {
						((Overworld)scene).placeBottleAt(x, y);
					}
				}
			}
			return;
		}

		boolean isMoving = (isLeftPressed != isRightPressed) || (isUpPressed != isDownPressed);

		stepsSinceLastMove++;
		if(dominantDirection == HORIZONTAL) {
			if(isLeftPressed && !isRightPressed) {
				direction = LEFT;
				if(moveLeft()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isLeftPressed && isRightPressed) {
				direction = RIGHT;
				if(moveRight()) {
					stepsSinceLastMove = 0;
				}
			} else if(isUpPressed && !isDownPressed) {
				direction = UP;
				if(moveUp()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isUpPressed && isDownPressed) {
				direction = DOWN;
				if(moveDown()) {
					stepsSinceLastMove = 0;
				}
			}
		} else {
			if(isUpPressed && !isDownPressed) {
				direction = UP;
				if(moveUp()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isUpPressed && isDownPressed) {
				direction = DOWN;
				if(moveDown()) {
					stepsSinceLastMove = 0;
				}
			} else if(isLeftPressed && !isRightPressed) {
				direction = LEFT;
				if(moveLeft()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isLeftPressed && isRightPressed) {
				direction = RIGHT;
				if(moveRight()) {
					stepsSinceLastMove = 0;
				}
			}
		}

		if(!isMoving) {
			frame = 1;
		} else if(stepCounter % 10 == 0) {
			frame = (frame + 1) % 4;
		}
	}

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}
}
