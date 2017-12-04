package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Pathfinding;
import code.Textures;
import code.views.Scene;

public class IntelligentCow extends Cow {
	private int hitCooldown = 0;
	private int hittingFrame = -1;
	private int frame = 0;

	public IntelligentCow(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	@Override
	public BufferedImage getImage() {
		if(hittingFrame >= 0) {
			return Textures.Sprites.IntelligentCow.getHitting(direction, hittingFrame);
		}
		return Textures.Sprites.IntelligentCow.getWalking(direction, frame);
	}

	@Override
	public int getWidth() {
		return 32;
	}

	@Override
	public int getHeight() {
		return 32;
	}

	@Override
	public void step() {
		super.step();

		if(stepCounter % 10 == 0) {
			frame = (frame + 1) % 4;

			if(hittingFrame >= 3) {
				hittingFrame = -1;
			} else if(hittingFrame >= 0) {
				hittingFrame++;
			}
		}

		double distanceToMilkman = Math.sqrt(Math.pow(scene.getMilkman().getX() - x, 2) + Math.pow(scene.getMilkman().getY() - y, 2));

		if(hitCooldown > 0) {
			hitCooldown--;
		} else if(distanceToMilkman <= 32) {
			scene.getMilkman().damage();
			hittingFrame = 0;
			hitCooldown = 2 * Clock.getStepsPerSecond();
		}
	}

	protected void turn(int targetX, int targetY) {
		if(Pathfinding.isInitialized()) {
			//use pathfinding in hard-mode
			int nextDirection = Pathfinding.getDirection(x / 32, y / 32);
			if(nextDirection != Actor.NO_DIRECTION) {
				direction = nextDirection;
			}
		} else {
			//try to go straight in easy- and normal-mode
			int distanceX = targetX - x;
			int distanceY = targetY - y;
			int previousDirection = direction;

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

			if(direction != previousDirection) {
				turningCooldown = (int)((1.0 / MAX_TURNS_PER_SECOND) * Clock.getStepsPerSecond());
			}
		}
	}
}
