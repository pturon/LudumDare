package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Textures;
import code.views.Scene;

public class IntelligentCow extends Cow {
	private int hitCooldown = 0;
	private int frame = 0;

	public IntelligentCow(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	@Override
	public BufferedImage getImage() {
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

		double distanceToMilkman = Math.sqrt(Math.pow(scene.getMilkman().getX() - x, 2) + Math.pow(scene.getMilkman().getY() - y, 2));

		if(hitCooldown > 0) {
			hitCooldown--;
		} else if(distanceToMilkman <= 32) {
			scene.getMilkman().damage();
			hitCooldown = (int)(0.5 * Clock.getStepsPerSecond());
		}

		if(stepCounter % 10 == 0) {
			frame = (frame + 1) % 4;
		}
	}

	protected void turn(int targetX, int targetY) {
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
