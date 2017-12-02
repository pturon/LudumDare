package code.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import code.views.Game;

public class Cow extends Actor {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	public Cow(int x, int y, Game game) {
		super(x, y, game);
	}

	@Override
	public BufferedImage getImage() {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillOval(0, 0, WIDTH, HEIGHT);
		return image;
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
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

		if(Math.abs(distanceX) < Math.abs(distanceY)) {
			moveVertically(targetX, targetY);
		} else {
			moveHorizontally(targetX, targetY);
		}
	}

	private void moveHorizontally(int targetX, int targetY) {
		if(targetX < x) {
			if(!moveLeft()) {
				if(targetY < y) {
					moveUp();
				} else {
					moveDown();
				}
			}
		} else {
			if(!moveRight()) {
				if(targetY < y) {
					moveUp();
				} else {
					moveDown();
				}
			}
		}
	}

	private void moveVertically(int targetX, int targetY) {
		if(targetY < y) {
			if(!moveUp()) {
				if(targetX < x) {
					moveLeft();
				} else {
					moveRight();
				}
			}
		} else {
			if(!moveDown()) {
				if(targetX < x) {
					moveLeft();
				} else {
					moveRight();
				}
			}
		}
	}
}
