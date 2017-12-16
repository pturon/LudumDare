package code.views;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import code.MainFrame;

public abstract class View {
	public static final int WIDTH = MainFrame.WIDTH;
	public static final int HEIGHT = MainFrame.HEIGHT;

	public abstract BufferedImage getImage(boolean debugging);

	public void onKeyPressed(KeyEvent keyEvent) {
		//can be implemented in subclasses if needed
	}

	public void onKeyReleased(KeyEvent keyEvent) {
		//can be implemented in subclasses if needed
	}

	public abstract void step();

	public void onMouseMoved(MouseEvent mouseEvent) {
		//can be implemented in subclasses if needed
	}

	public void onMousePressed(MouseEvent mouseEvent) {
		//can be implemented in subclasses if needed
	}

	public void onMouseReleased(MouseEvent mouseEvent) {
		//can be implemented in subclasses if needed
	}
}
