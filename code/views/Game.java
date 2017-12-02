package code.views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import code.entities.Milkman;

public class Game extends View {
	private Milkman milkman = new Milkman(400, 300);

	@Override
	public BufferedImage getImage() {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		
		graphics.setColor(new Color(64, 128, 64));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);

		graphics.drawImage(milkman.getImage(), milkman.getX(), milkman.getY(), null);

		return image;
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
		milkman.step();
	}
}
