package code.entities;

import java.awt.image.BufferedImage;

public abstract class Actor {
	protected int x;
	protected int y;
	protected long stepCounter = 0;

	protected Actor(int x, int y) {
		this.x = x;
		this.y = y;
	}

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

	public abstract int getWidth();

	public abstract int getHeight();

	public void step() {
		stepCounter++;
	}
}
