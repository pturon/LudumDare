package code.entities;

import java.awt.image.BufferedImage;

import code.Clock;
import code.Textures;
import code.views.Overworld;
import code.views.Scene;

public class Milkman extends Actor {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	private static boolean isLeftPressed = false;
	private static boolean isRightPressed = false;
	private static boolean isUpPressed = false;
	private static boolean isDownPressed = false;

	public static final boolean HORIZONTAL = true;
	public static final boolean VERTICAL = !HORIZONTAL;

	private int direction = RIGHT;
	private static boolean dominantDirection = HORIZONTAL;
	private int frame = 0;

	private long stepsSinceLastMove = 0;//needed for the "press R to restart"-hint

	private int pickupFrame = -1;
	private int placeFrame = -1;
	private static int emptyBottles = 0;
	private static int filledBottles = 0;
	private static int bottlesPlaced = 0;

	private static int hearts;

	public Milkman(int x, int y, Scene scene) {
		super(x, y, scene);
	}

	public boolean canPickupBottles() {
		return (emptyBottles + filledBottles) < 8 && pickupFrame == -1 && placeFrame == -1;
	}

	public boolean canPlaceBottles() {
		return filledBottles > 0 && pickupFrame == -1 && placeFrame == -1;
	}

	public void damage() {
		if(hearts > 0) {
			hearts--;
		}
	}

	public void fillBottles() {
		filledBottles += emptyBottles;
		emptyBottles = 0;
	}

	public int getEmptyBottles() {
		return emptyBottles;
	}

	public int getFilledBottles() {
		return filledBottles;
	}

	public int getBottlesPlaced() {
		return bottlesPlaced;
	}

	@Override
	public BufferedImage getImage() {
		if(pickupFrame > -1) {
				return Textures.Sprites.Milkman.getPickupAnimation(direction, pickupFrame, emptyBottles);
		}
		if(placeFrame > -1) {
			return Textures.Sprites.Milkman.getPickupAnimation(direction, 4 - placeFrame, emptyBottles);
		}
		return Textures.Sprites.Milkman.getWalkCycle(direction, frame, (emptyBottles + filledBottles));
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	public void pickupBottle() {
		pickupFrame++;
	}

	public void placeBottle() {
		placeFrame++;
		bottlesPlaced++;
	}

	public float getSecondsSinceLastMove() {
		return (float)stepsSinceLastMove / Clock.getStepsPerSecond();
	}

	public static void reset() {
		isLeftPressed = false;
		isRightPressed = false;
		isUpPressed = false;
		isDownPressed = false;

		emptyBottles = 0;
		filledBottles = 0;
		bottlesPlaced = 0;
	}

	public static void setLeftPressed(boolean isPressed) {
		isLeftPressed = isPressed;
		dominantDirection = HORIZONTAL;
	}

	public static void setRightPressed(boolean isPressed) {
		isRightPressed = isPressed;
		dominantDirection = HORIZONTAL;
	}

	public static void setUpPressed(boolean isPressed) {
		isUpPressed = isPressed;
		dominantDirection = VERTICAL;
	}

	public static void setDownPressed(boolean isPressed) {
		isDownPressed = isPressed;
		dominantDirection = VERTICAL;
	}

	@Override
	public void step()  {
		stepsSinceLastMove++;

		if(hearts <= 0) {
			((Overworld)scene).triggerDeath();
			return;
		}

		super.step();

		if(pickupFrame > 3) {
			pickupFrame = -1;
			emptyBottles++;
		}
		if(pickupFrame > -1) {
			if(stepCounter % (0.125 * Clock.getStepsPerSecond()) == 0) {
				pickupFrame++;
				if(pickupFrame == 2 && scene instanceof Overworld) {
					((Overworld)scene).removeBottleAt(x, y);
				}
			}
			return;
		}

		if(placeFrame > 3) {
			placeFrame = -1;
			filledBottles--;
		}
		if(placeFrame > -1) {
			if(stepCounter % (0.125 * Clock.getStepsPerSecond()) == 0) {
				placeFrame++;
				if(placeFrame == 1 && scene instanceof Overworld) {
					((Overworld)scene).placeBottleAt(x, y);
				}
			}
			return;
		}

		boolean isMoving = (isLeftPressed != isRightPressed) || (isUpPressed != isDownPressed);

		if(dominantDirection == HORIZONTAL) {
			if(isLeftPressed && !isRightPressed) {
				direction = LEFT;
				if(moveLeft()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isLeftPressed && isRightPressed) {
				direction = RIGHT;
				if(moveRight()) {
					stepsSinceLastMove = 0;
				}
			} else if(isUpPressed && !isDownPressed) {
				direction = UP;
				if(moveUp()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isUpPressed && isDownPressed) {
				direction = DOWN;
				if(moveDown()) {
					stepsSinceLastMove = 0;
				}
			}
		} else {
			if(isUpPressed && !isDownPressed) {
				direction = UP;
				if(moveUp()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isUpPressed && isDownPressed) {
				direction = DOWN;
				if(moveDown()) {
					stepsSinceLastMove = 0;
				}
			} else if(isLeftPressed && !isRightPressed) {
				direction = LEFT;
				if(moveLeft()) {
					stepsSinceLastMove = 0;
				}
			} else if(!isLeftPressed && isRightPressed) {
				direction = RIGHT;
				if(moveRight()) {
					stepsSinceLastMove = 0;
				}
			}
		}

		if(!isMoving) {
			frame = 1;
		} else if(stepCounter % 10 == 0) {
			frame = (frame + 1) % 4;
		}
	}

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}
}
