package code;

import java.awt.Point;
import java.util.LinkedList;

import code.entities.Actor;
import code.enums.Direction;

/**
 * This class coordinates the pathfinding.
 * Starting from the target each tile is associated with the direction a cow has to walk to reach the target.
 */
public class Pathfinding {
	private static Actor target;
	private static Tilemap tilemap;

	private static Direction[][] currentDirections; //used for getDirection()
	private static Direction[][] nextDirections; //used for calculation

	private Pathfinding() {
		//no instance allowed
	}

	static {
		startPathfinding();
	}

	public static boolean isInitialized() {
		return target != null && tilemap != null && currentDirections != null && nextDirections != null;
	}

	/**
	 * Sets the actor that will be the target.
	 * (At this moment it is of course the milkman.)
	 */
	public static void setTargetActor(Actor target) {
		Pathfinding.target = target;
	}

	/**
	 * Sets the tilemap that is taken into account when calculating the path to the target.
	 */
	public static void setTilemap(Tilemap tilemap) {
		if(tilemap == null) {
			currentDirections = null;
			return;
		}
		Pathfinding.tilemap = tilemap;
		Pathfinding.currentDirections = new Direction[tilemap.getWidth()][tilemap.getHeight()];
		for(int y = 0; y < tilemap.getHeight(); y++) {
			for(int x = 0; x < tilemap.getWidth(); x++) {
				currentDirections[x][y] = Direction.STANDING;
			}
		}
		Pathfinding.nextDirections = new Direction[tilemap.getWidth()][tilemap.getHeight()];
		for(int y = 0; y < tilemap.getHeight(); y++) {
			for(int x = 0; x < tilemap.getWidth(); x++) {
				nextDirections[x][y] = Direction.STANDING;
			}
		}
	}

	/**
	 * Returns the direction the cow has to walk in order to get to the target.
	 * @param tileX The current x-coordinate of the tile the cow is standing on.
	 * @param tileY The current y-coordinate of the tile the cow is standing on.
	 * @return The direction the cow has to walk in order to get to the target.
	 */
	public static Direction getDirection(int tileX, int tileY) {
		try {
			return currentDirections[tileX][tileY];
		} catch(Exception exception) {
			//not enough motivation to handle ArrayIndexOutOfBoundsExceptions properly.
			return Direction.STANDING;
		}
	}

	private static void startPathfinding() {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					calculateDirections();
					updateDirections();
					try {
						Thread.sleep(100);
					} catch(InterruptedException exception) {
						Thread.currentThread().interrupt();
					}
				}
			}

			/**
			 * Calculates the directions in the shadow-copy.
			 */
			private void calculateDirections() {
				if(!isInitialized()) {
					return;
				}

				//reset values
				for(int y = 0; y < tilemap.getHeight(); y++) {
					for(int x = 0; x < tilemap.getWidth(); x++) {
						nextDirections[x][y] = Direction.STANDING;
					}
				}

				//calculate new directions
				LinkedList<Point> queue = new LinkedList<>();
				queue.addLast(new Point(target.getX() / 32, target.getY() / 32));

				while(!queue.isEmpty()) {
					Point currentTile = queue.removeFirst();

					//check above
					try {
						if(tilemap.getMaterial(currentTile.x, currentTile.y - 1).isSolid()) {
							nextDirections[currentTile.x][currentTile.y - 1] = Direction.STANDING;
						} else if(nextDirections[currentTile.x][currentTile.y - 1] == Direction.STANDING) {
							nextDirections[currentTile.x][currentTile.y - 1] = Direction.DOWN;
							queue.addLast(new Point(currentTile.x, currentTile.y - 1));
						}
					} catch(ArrayIndexOutOfBoundsException exception) {
						//not enough motivation to handle this properly
					}

					//check right
					try {
						if(tilemap.getMaterial(currentTile.x + 1, currentTile.y).isSolid()) {
							nextDirections[currentTile.x + 1][currentTile.y] = Direction.STANDING;
						} else if(nextDirections[currentTile.x + 1][currentTile.y] == Direction.STANDING) {
							nextDirections[currentTile.x + 1][currentTile.y] = Direction.LEFT;
							queue.addLast(new Point(currentTile.x + 1, currentTile.y));
						}
					} catch(ArrayIndexOutOfBoundsException exception) {
						//not enough motivation to handle this properly
					}

					//check below
					try {
						if(tilemap.getMaterial(currentTile.x, currentTile.y + 1).isSolid()) {
							nextDirections[currentTile.x][currentTile.y + 1] = Direction.STANDING;
						} else if(nextDirections[currentTile.x][currentTile.y + 1] == Direction.STANDING) {
							nextDirections[currentTile.x][currentTile.y + 1] = Direction.UP;
							queue.addLast(new Point(currentTile.x, currentTile.y + 1));
						}
					} catch(ArrayIndexOutOfBoundsException exception) {
						//not enough motivation to handle this properly
					}

					//check left
					try {
						if(tilemap.getMaterial(currentTile.x - 1, currentTile.y).isSolid()) {
							nextDirections[currentTile.x - 1][currentTile.y] = Direction.STANDING;
						} else if(nextDirections[currentTile.x - 1][currentTile.y] == Direction.STANDING) {
							nextDirections[currentTile.x - 1][currentTile.y] = Direction.RIGHT;
							queue.addLast(new Point(currentTile.x - 1, currentTile.y));
						}
					} catch(ArrayIndexOutOfBoundsException exception) {
						//not enough motivation to handle this properly
					}
				}
			}

			/**
			 * Copys the calculated directions to the ones used to the outside.
			 */
			private void updateDirections() {
				if(tilemap != null && nextDirections != null) {
					for(int y = 0; y < tilemap.getHeight(); y++) {
						for(int x = 0; x < tilemap.getWidth(); x++) {
							currentDirections[x][y] = nextDirections[x][y];
						}
					}
				}
			}
		}.start();
	}
}
