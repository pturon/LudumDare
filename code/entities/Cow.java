package code.entities;

import code.views.Scene;

public abstract class Cow extends Actor {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;
	protected int direction = UP;

	protected static final int MAX_TURNS_PER_SECOND = 2;
	protected int turningCooldown = 0;

	protected Cow(int x, int y, Scene scene) {
		super(x, y, scene);
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

	protected abstract void turn(int targetX, int targetY);

	protected void move(int targetX, int targetY) {
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
