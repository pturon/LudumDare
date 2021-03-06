package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Textures;
import code.views.Scene;

public class StandardCow extends Cow {
	public StandardCow(int x, int y, Scene scene) {
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

	protected void turn(int targetX, int targetY) {
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
}
