package code.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Cow extends Actor {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	private Milkman milkman;

	public Cow(int x, int y, Milkman milkman) {
		super(x, y);
		this.milkman = milkman;
	}

	@Override
	public BufferedImage getImage() {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillOval(0, 0, WIDTH, HEIGHT);
		return image;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	@Override
	public void step() {
		super.step();
		if(stepCounter % 2 != 0) {
			return;
		}

		int targetX = milkman.getX();
		int targetY = milkman.getY();

		int distanceX = targetX - x;
		int distanceY = targetY - y;

		if(Math.abs(distanceX) < Math.abs(distanceY)) {
			if(targetY < y) {
				y--;
			} else {
				y++;
			}
			
		} else {
			if(targetX < x) {
				x--;
			} else {
				x++;
			}
		}
	}
}
