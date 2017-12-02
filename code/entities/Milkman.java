package code.entities;

import java.awt.image.BufferedImage;

import code.Textures;

public class Milkman extends Actor {
	private boolean isLeftPressed = false;
	private boolean isRightPressed = false;
	private boolean isUpPressed = false;
	private boolean isDownPressed = false;

	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;

	private int direction = RIGHT;
	private int stepCounter = 0;
	private int frame = 0;

	public Milkman(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public BufferedImage getImage() {
		return Textures.Sprites.Milkman.getWalkCycle(direction, frame);
	}

	public void setLeftPressed(boolean isPressed) {
		isLeftPressed = isPressed;
	}

	public void setRightPressed(boolean isPressed) {
		isRightPressed = isPressed;
	}

	public void setUpPressed(boolean isPressed) {
		isUpPressed = isPressed;
	}

	public void setDownPressed(boolean isPressed) {
		isDownPressed = isPressed;
	}

	public void step() {
		if(isLeftPressed && !isRightPressed) {
			direction = LEFT;
			x--;
		} else if(!isLeftPressed && isRightPressed) {
			direction = RIGHT;
			x++;
		}
		if(isUpPressed && !isDownPressed) {
			direction = UP;
			y--;
		} else if(!isUpPressed && isDownPressed) {
			direction = DOWN;
			y++;
		}

		if((isLeftPressed || isRightPressed || isUpPressed || isDownPressed) && stepCounter % 10 == 0) {
			frame = (frame + 1) % 4;
		}
		stepCounter++;
	}
}
