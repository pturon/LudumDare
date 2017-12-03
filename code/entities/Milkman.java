package code.entities;

import java.awt.image.BufferedImage;

import code.Textures;
import code.views.Game;

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
	private int bottles = 0;

	public Milkman(int x, int y, Game game) {
		super(x, y, game);
	}

	public boolean canPickupBottles() {
		return bottles < 8;
	}

	public int getBottles() {
		return bottles;
	}

	@Override
	public BufferedImage getImage() {
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
		bottles++;
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
