package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Textures;
import code.views.Overworld;
import code.views.Scene;

public class Milkman extends Actor {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	private boolean isLeftPressed = false;
	private boolean isRightPressed = false;
	private boolean isUpPressed = false;
	private boolean isDownPressed = false;

	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;

	public static final boolean HORIZONTAL = true;
	public static final boolean VERTICAL = !HORIZONTAL;

	private int direction = RIGHT;
	private boolean dominantDirection = HORIZONTAL;
	private int frame = 0;

	private int pickupFrame = -1;
	private int bottles = 0;

	public Milkman(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	public boolean canPickupBottles() {
		return bottles < 8 && pickupFrame == -1;
	}

	public int getBottles() {
		return bottles;
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

	public void setLeftPressed(boolean isPressed) {
		isLeftPressed = isPressed;
		dominantDirection = HORIZONTAL;
	}

	public void setRightPressed(boolean isPressed) {
		isRightPressed = isPressed;
		dominantDirection = HORIZONTAL;
	}

	public void setUpPressed(boolean isPressed) {
		isUpPressed = isPressed;
		dominantDirection = VERTICAL;
	}

	public void setDownPressed(boolean isPressed) {
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
