package code;

import java.awt.Point;
import java.util.LinkedList;

import code.entities.Actor;

public class Pathfinding {
	private static Actor target;
	private static Tilemap tilemap;

	private static int[][] directions;

	private Pathfinding() {
		//no instance allowed
	}

	static {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
					} catch(InterruptedException exception) {
						Thread.currentThread().interrupt();
					}
					recalculatePaths();
				}
			}
		}.start();
	}

	public static void setTargetActor(Actor target) {
		Pathfinding.target = target;
	}

	public static void setTilemap(Tilemap tilemap) {
		Pathfinding.tilemap = tilemap;
		Pathfinding.directions = new int[tilemap.getWidth()][tilemap.getHeight()];
		for(int y = 0; y < tilemap.getHeight(); y++) {
			for(int x = 0; x < tilemap.getWidth(); x++) {
				directions[x][y] = Actor.NO_DIRECTION;
			}
		}
	}

	public static int getDirection(int tileX, int tileY) {
		if(directions != null) {
			return directions[tileX][tileY];
		} else {
			return Actor.NO_DIRECTION;
		}
	}

	private static void recalculatePaths() {
		if(tilemap != null && directions != null) {
			//reset values
			for(int y = 0; y < tilemap.getHeight(); y++) {
				for(int x = 0; x < tilemap.getWidth(); x++) {
					directions[x][y] = Actor.NO_DIRECTION;
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
						directions[currentTile.x][currentTile.y - 1] = Actor.NO_DIRECTION;
					} else if(directions[currentTile.x][currentTile.y - 1] < 0) {
						directions[currentTile.x][currentTile.y - 1] = Actor.DOWN;
						queue.addLast(new Point(currentTile.x, currentTile.y - 1));
					}
				} catch(ArrayIndexOutOfBoundsException exception) {
					//not enough motivation to handle this properly
				}
	
				//check right
				try {
					if(tilemap.getMaterial(currentTile.x + 1, currentTile.y).isSolid()) {
						directions[currentTile.x + 1][currentTile.y] = Actor.NO_DIRECTION;
					} else if(directions[currentTile.x + 1][currentTile.y] < 0) {
						directions[currentTile.x + 1][currentTile.y] = Actor.LEFT;
						queue.addLast(new Point(currentTile.x + 1, currentTile.y));
					}
				} catch(ArrayIndexOutOfBoundsException exception) {
					//not enough motivation to handle this properly
				}
	
				//check below
				try {
					if(tilemap.getMaterial(currentTile.x, currentTile.y + 1).isSolid()) {
						directions[currentTile.x][currentTile.y + 1] = Actor.NO_DIRECTION;
					} else if(directions[currentTile.x][currentTile.y + 1] < 0) {
						directions[currentTile.x][currentTile.y + 1] = Actor.UP;
						queue.addLast(new Point(currentTile.x, currentTile.y + 1));
					}
				} catch(ArrayIndexOutOfBoundsException exception) {
					//not enough motivation to handle this properly
				}
	
				//check left
				try {
					if(tilemap.getMaterial(currentTile.x - 1, currentTile.y).isSolid()) {
						directions[currentTile.x - 1][currentTile.y] = Actor.NO_DIRECTION;
					} else if(directions[currentTile.x - 1][currentTile.y] < 0) {
						directions[currentTile.x - 1][currentTile.y] = Actor.RIGHT;
						queue.addLast(new Point(currentTile.x - 1, currentTile.y));
					}
				} catch(ArrayIndexOutOfBoundsException exception) {
					//not enough motivation to handle this properly
				}
			}
		}
	}
}
