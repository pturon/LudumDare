package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Textures;
import code.views.Scene;

public class Cow extends Actor {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;
	private int direction = UP;

	private static final int MAX_TURNS_PER_SECOND = 2;
	private int turningCooldown = 0;

	public Cow(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	@Override
	public BufferedImage getImage() {
		return Textures.Sprites.Cow.getWalking(direction);
	}

	@Override
	public int getWidth() {
		if(direction == LEFT || direction == RIGHT) {
			return 64;
		} else {
			return 32;
		}
	}

	@Override
	public int getHeight() {
		if(direction == UP || direction == DOWN) {
			return 64;
		} else {
			return 32;
		}
	}

	@Override
	public void step() {
		super.step();

		//only move every other step
		if(stepCounter % 2 != 0) {
			return;
		}

		int targetX = scene.getMilkman().getX();
		int targetY = scene.getMilkman().getY();

		if(turningCooldown <= 0) {
			turn(targetX, targetY);
		} else {
			turningCooldown --;
		}

		move(targetX, targetY);
	}

	private void turn(int targetX, int targetY) {
		int distanceX = targetX - x;
		int distanceY = targetY - y;
		int previousDirection = direction;

		if(Math.abs(distanceX) > Math.abs(distanceY)) {
			if(!scene.isPixelSolid(x - 32, y) && !scene.isPixelSolid(x + 31, y)) {
				if(targetX < x) {
					direction = LEFT;
				} else {
					direction = RIGHT;
				}
			}
		} else {
			if(!scene.isPixelSolid(x, y - 32) && !scene.isPixelSolid(x, y + 31)) {
				if(targetY < y) {
					direction = UP;
				} else {
					direction = DOWN;
				}
			}
		}

		if(direction != previousDirection) {
			turningCooldown = (int)((1.0 / MAX_TURNS_PER_SECOND) * Clock.getStepsPerSecond());
		}
	}

	private void move(int targetX, int targetY) {
		switch(direction) {
		case UP:
			if(!moveUp()) {
				if(targetX < x) {
					moveLeft();
				} else {
					moveRight();
				}
			}
			break;
		case DOWN:
			if(!moveDown()) {
				if(targetX < x) {
					moveLeft();
				} else {
					moveRight();
				}
			}
			break;
		case LEFT:
			if(!moveLeft()) {
				if(targetY < y) {
					moveUp();
				} else {
					moveDown();
				}
			}
			break;
		case RIGHT:
			if(!moveRight()) {
				if(targetY < y) {
					moveUp();
				} else {
					moveDown();
				}
			}
			break;
		default:
			break;
		}
	}
}
