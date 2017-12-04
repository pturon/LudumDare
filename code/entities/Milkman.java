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

	private int pickupFrame = -1;
	private static int bottles = 0;

	public static final boolean EMPTY_BOTTLE = false;
	public static final boolean FILLED_BOTTLE = !EMPTY_BOTTLE;
	private static boolean bottleType = EMPTY_BOTTLE;

	public Milkman(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	public boolean canPickupBottles() {
		return bottles < 8 && pickupFrame == -1;
	}

	public void fillBottles() {
		bottleType = FILLED_BOTTLE;
	}

	public int getBottles() {
		return bottles;
	}

	public boolean getBottleType() {
		return bottleType;
	}

	@Override
	public BufferedImage getImage() {
		if(pickupFrame > -1) {
			return Textures.Sprites.Milkman.getPickupAnimation(direction, pickupFrame, bottles);
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
			bottles++;
		}
		if(pickupFrame > -1) {
			if(stepCounter % (0.125 * Clock.getStepsPerSecond()) == 0) {
				pickupFrame++;
				if(pickupFrame == 2 && scene instanceof Overworld) {
					((Overworld)scene).removeBottleAt(x, y);
				}
			}
			return;
		}

		boolean isMoving = (isLeftPressed != isRightPressed) || (isUpPressed != isDownPressed);

		if(dominantDirection == HORIZONTAL) {
			if(isLeftPressed && !isRightPressed) {
				direction = LEFT;
				moveLeft();
			} else if(!isLeftPressed && isRightPressed) {
				direction = RIGHT;
				moveRight();
			} else if(isUpPressed && !isDownPressed) {
				direction = UP;
				moveUp();
			} else if(!isUpPressed && isDownPressed) {
				direction = DOWN;
				moveDown();
			}
		} else {
			if(isUpPressed && !isDownPressed) {
				direction = UP;
				moveUp();
			} else if(!isUpPressed && isDownPressed) {
				direction = DOWN;
				moveDown();
			} else if(isLeftPressed && !isRightPressed) {
				direction = LEFT;
				moveLeft();
			} else if(!isLeftPressed && isRightPressed) {
				direction = RIGHT;
				moveRight();
			}
		}

		if(!isMoving) {
			frame = 1;
		} else if(stepCounter % 10 == 0) {
			frame = (frame + 1) % 4;
		}
	}
}
