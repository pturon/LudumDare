package code.views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import code.Tilemap;
import code.entities.Actor;
import code.entities.Cow;
import code.entities.Milkman;

public class Game extends View {
	private Milkman milkman;
	private List<Actor> actors = new ArrayList<>();
	private Tilemap tilemap = new Tilemap();

	public Game() {
		milkman = new Milkman(400, 300);
		synchronized(actors) {
			actors.add(milkman);
			for(int i = 0; i < 5; i++) {
				actors.add(new Cow((int)(Math.random() * 800), (int)(Math.random() * 600), this));
			}
		}
	}

	@Override
	public BufferedImage getImage(boolean debugging) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		
		graphics.setColor(new Color(64, 128, 64));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);

		for(int y = 0; y < tilemap.getHeight(); y++) {
			for(int x = 0; x < tilemap.getWidth(); x++) {
				graphics.drawImage(tilemap.getMaterial(x, y).getImage(), 32 * x, 32 * y, null);
			}
		}

		synchronized(actors) {
			for(Actor actor : actors) {
				drawActor(graphics, actor, debugging);
			}
		}

		return image;
	}

	private void drawActor(Graphics2D graphics, Actor actor, boolean debugging) {
		graphics.drawImage(actor.getImage(), actor.getX() - actor.getWidth() / 2, actor.getY() - actor.getHeight() / 2, null);
		if(debugging) {
			graphics.setColor(Color.RED);
			graphics.draw(actor.getHitbox());
			graphics.drawLine(actor.getX() - 5, actor.getY(), actor.getX() + 5, actor.getY());
			graphics.drawLine(actor.getX(), actor.getY() - 5, actor.getX(), actor.getY() + 5);
		}
	}

	public List<Actor> getActors() {
		return actors;
	}

	public Milkman getMilkman() {
		return milkman;
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			milkman.setLeftPressed(true);
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			milkman.setRightPressed(true);
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			milkman.setUpPressed(true);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			milkman.setDownPressed(true);
			break;
		default:
			break;
		}
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			milkman.setLeftPressed(false);
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			milkman.setRightPressed(false);
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			milkman.setUpPressed(false);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			milkman.setDownPressed(false);
			break;
		default:
			break;
		}
	}

	public void step() {
		synchronized(actors) {
			for(Actor actor : actors) {
				actor.step();
			}
		}
	}
}
