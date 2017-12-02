package code.entities;

public class Milkman extends Actor {
	private boolean isLeftPressed = false;
	private boolean isRightPressed = false;
	private boolean isUpPressed = false;
	private boolean isDownPressed = false;

	public Milkman(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setLeftPressed(boolean isPressed) {
		isLeftPressed = isPressed;
	}

	public void setRightPressed(boolean isPressed) {
		isRightPressed = isPressed;
	}

	public void setUpPressed(boolean isPressed) {
		isUpPressed = isPressed;
	}

	public void setDownPressed(boolean isPressed) {
		isDownPressed = isPressed;
	}

	public void step() {
		if(isLeftPressed && !isRightPressed) {
			x--;
		} else if(!isLeftPressed && isRightPressed) {
			x++;
		}
		if(isUpPressed && !isDownPressed) {
			y--;
		} else if(!isUpPressed && isDownPressed) {
			y++;
		}
	}
}
