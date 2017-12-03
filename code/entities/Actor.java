package code.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import code.views.Game;

public abstract class Actor {
	protected int x;
	protected int y;
	protected Game game;
	protected long stepCounter = 0;

	protected Actor(int x, int y, Game game) {
		this.x = x;
		this.y = y;
		this.game = game;
	}

	public Rectangle getHitbox() {
		return new Rectangle(x - getWidth() / 2, y - getHeight() / 2, getWidth(), getHeight());
	}

	public abstract BufferedImage getImage();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox())) {
				x++;
				return false;
			}
		}

		//check terrain
		if(game.isPixelSolid(x - (getWidth() / 2), y)) {
			x++;
			return false;
		}

		//funnel
		if(game.isPixelSolid(x - (getWidth() / 2), y - (getHeight()) / 2)) {
			y++;
		} else if(game.isPixelSolid(x - (getWidth() / 2), y + (getHeight() / 2) - 1)) {
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
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox())) {
				x--;
				return false;
			}
		}

		//check terrain
		if(game.isPixelSolid(x + (getWidth() / 2), y)) {
			x--;
			return false;
		}

		//funnel
		if(game.isPixelSolid(x + (getWidth() / 2) - 1, y - (getHeight()) / 2)) {
			y++;
		} else if(game.isPixelSolid(x + (getWidth() / 2) - 1, y + (getHeight() / 2) - 1)) {
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
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox())) {
				y++;
				return false;
			}
		}

		//check terrain
		if(game.isPixelSolid(x, y - (getHeight() / 2))) {
			y++;
			return false;
		}

		//funnel
		if(game.isPixelSolid(x - (getWidth() / 2), y - (getHeight()) / 2)) {
			x++;
		} else if(game.isPixelSolid(x + (getWidth() / 2) - 1, y - (getHeight()) / 2)) {
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
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor.getHitbox().intersects(getHitbox())) {
				y--;
				return false;
			}
		}

		//check terrain
		if(game.isPixelSolid(x, y + (getHeight() / 2))) {
			y--;
			return false;
		}

		//funnel
		if(game.isPixelSolid(x - (getWidth() / 2), y + (getHeight()) / 2)) {
			x++;
		} else if(game.isPixelSolid(x + (getWidth() / 2) - 1, y + (getHeight() / 2) - 1)) {
			x--;
		}

		return true;
	}
}
