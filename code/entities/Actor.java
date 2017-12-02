package code.entities;

import java.awt.image.BufferedImage;

public abstract class Actor {
	protected int x;
	protected int y;

	public abstract BufferedImage getImage();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract void step();
}
