package code.entities;

import java.awt.image.BufferedImage;

import code.Textures;
import code.views.Game;

public class Cow extends Actor {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int RIGHT = 2;
	public static final int LEFT = 3;

	private int direction = UP;

	public Cow(int x, int y, Game game) {
		super(x, y, game);
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
		if(stepCounter % 2 != 0) {
			return;
		}

		int targetX = game.getMilkman().getX();
		int targetY = game.getMilkman().getY();

		int distanceX = targetX - x;
		int distanceY = targetY - y;

		if(Math.abs(distanceX) > Math.abs(distanceY)) {
			if(targetX < x) {
				direction = LEFT;
			} else {
				direction = RIGHT;
			}
		} else {
			if(targetY < y) {
				direction = UP;
			} else {
				direction = DOWN;
			}
		}

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
