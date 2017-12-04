package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Pathfinding;
import code.Textures;
import code.views.Scene;

public class IntelligentCow extends Cow {
	private Pathfinding pahtfinding;

	private int hitCooldown = 0;
	private int frame = 0;

	public IntelligentCow(int x, int y, Scene scene, Pathfinding pathfinding) {
		super(x, y, scene);
		this.pahtfinding = pathfinding;
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
		direction = Pathfinding.getDirection(x / 32, y / 32);
	}
}
