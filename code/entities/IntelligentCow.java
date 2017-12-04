package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Textures;
import code.views.Scene;

public class IntelligentCow extends Cow {
	private int hitCooldown = 0;

	public IntelligentCow(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	@Override
	public BufferedImage getImage() {
		return Textures.Sprites.IntelligentCow.getWalking(direction);
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

		if(hitCooldown > 0) {
			hitCooldown--;
		} else if(Math.abs(scene.getMilkman().getX() - x) < 48
			   && Math.abs(scene.getMilkman().getY() - y) < 48) {
			scene.getMilkman().damage();
			hitCooldown = (int)(0.5 * Clock.getStepsPerSecond());
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
