package code.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import code.views.Scene;

public abstract class Actor {
	protected int x;
	protected int y;
	protected Scene scene;
	protected long stepCounter = 0;

	protected Actor(int x, int y, Scene scene) {
		this.x = x;
		this.y = y;
		this.scene = scene;
	}

	public Rectangle getHitbox() {
		return new Rectangle(x - getWidth() / 2, y - getHeight() / 2, getWidth(), getHeight());
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

	/**
	 * Returns true if the actor was able to move left.
	 */
	protected boolean moveLeft() {
		x--;
		//check hitboxes
		List<Actor> actors = scene.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox()) && actor.x < x) {
				x++;
				return false;
			}
		}

		//check terrain
		if(scene.isPixelSolid(x - (getWidth() / 2), y)) {
			x++;
			return false;
		}

		//funnel
		if(scene.isPixelSolid(x - (getWidth() / 2), y - (getHeight()) / 2)) {
			y++;
		} else if(scene.isPixelSolid(x - (getWidth() / 2), y + (getHeight() / 2) - 1)) {
			y--;
		}

		return true;
	}

	/**
	 * Returns true if the actor was able to move right.
	 */
	protected boolean moveRight() {
		x++;
		//check hitboxes
		List<Actor> actors = scene.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox()) && actor.x > x) {
				x--;
				return false;
			}
		}

		//check terrain
		if(scene.isPixelSolid(x + (getWidth() / 2), y)) {
			x--;
			return false;
		}

		//funnel
		if(scene.isPixelSolid(x + (getWidth() / 2) - 1, y - (getHeight()) / 2)) {
			y++;
		} else if(scene.isPixelSolid(x + (getWidth() / 2) - 1, y + (getHeight() / 2) - 1)) {
			y--;
		}

		return true;
	}

	/**
	 * Returns true if the actor was able to move up.
	 */
	protected boolean moveUp() {
		y--;
		//check hitboxes
		List<Actor> actors = scene.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox()) && actor.y < y) {
				y++;
				return false;
			}
		}

		//check terrain
		if(scene.isPixelSolid(x, y - (getHeight() / 2))) {
			y++;
			return false;
		}

		//funnel
		if(scene.isPixelSolid(x - (getWidth() / 2), y - (getHeight()) / 2)) {
			x++;
		} else if(scene.isPixelSolid(x + (getWidth() / 2) - 1, y - (getHeight()) / 2)) {
			x--;
		}

		return true;
	}

	/**
	 * Returns true if the actor was able to move down.
	 */
	protected boolean moveDown() {
		y++;
		//check hitboxes
		List<Actor> actors = scene.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox()) && actor.y > y) {
				y--;
				return false;
			}
		}

		//check terrain
		if(scene.isPixelSolid(x, y + (getHeight() / 2))) {
			y--;
			return false;
		}

		//funnel
		if(scene.isPixelSolid(x - (getWidth() / 2), y + (getHeight()) / 2)) {
			x++;
		} else if(scene.isPixelSolid(x + (getWidth() / 2) - 1, y + (getHeight() / 2) - 1)) {
			x--;
		}

		return true;
	}
}
