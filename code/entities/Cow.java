package code.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import code.views.Game;

public class Cow extends Actor {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	private Game game;

	public Cow(int x, int y, Game game) {
		super(x, y);
		this.game = game;
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

	/**
	 * Returns true if the cow was able to move left.
	 */
	private boolean moveLeft() {
		x--;
		//check hitboxes
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor instanceof Cow && actor.getHitbox().intersects(getHitbox())) {
				x++;
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if the cow was able to move right.
	 */
	private boolean moveRight() {
		x++;
		//check hitboxes
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor instanceof Cow && actor.getHitbox().intersects(getHitbox())) {
				x--;
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if the cow was able to move up.
	 */
	private boolean moveUp() {
		y--;
		//check hitboxes
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor instanceof Cow && actor.getHitbox().intersects(getHitbox())) {
				y++;
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if the cow was able to move down.
	 */
	private boolean moveDown() {
		y++;
		//check hitboxes
		List<Actor> actors = game.getActors();
		for(Actor actor : actors) {
			if(actor != this && actor instanceof Cow && actor.getHitbox().intersects(getHitbox())) {
				y--;
				return false;
			}
		}
		return true;
	}
}
