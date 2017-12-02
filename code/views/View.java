package code.views;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import code.MainFrame;

public abstract class View {
	public static final int WIDTH = MainFrame.WIDTH;
	public static final int HEIGHT = MainFrame.HEIGHT;

	public abstract BufferedImage getImage(boolean debugging);
	public abstract void onKeyPressed(KeyEvent keyEvent);
	public abstract void onKeyReleased(KeyEvent keyEvent);
	public abstract void step();
}
