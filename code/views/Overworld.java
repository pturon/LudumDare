package code.views;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import code.MainFrame;
import code.Material;
import code.Textures;
import code.Tilemap;
import code.entities.Actor;
import code.entities.StandardCow;
import code.entities.IntelligentCow;
import code.entities.Milkman;

public class Overworld extends Scene {
	protected Tilemap items;

	private boolean showInstructions = true;

	private static final Color DEBUGGING_GREEN = new Color(0, 255, 0, 128);
	private static final Color DEBUGGING_RED = new Color(255, 0, 0, 128);

	public Overworld(int difficulty) {
		super("img/overworld/overworld_tilemap.txt", Overworld.class, difficulty);

		this.difficulty = difficulty;

		items = new Tilemap("img/overworld/overworld_tilemap_milkbottles.txt", Overworld.class);
		milkman = new Milkman(64, 64, this);
		switch (difficulty){
			case 0:
				milkman.setHearts(3);
				break;
			case 1:
				milkman.setHearts(2);
				break;
			case 2:
				milkman.setHearts(1);
				break;
		}
		synchronized(actors) {
			actors.add(milkman);
		}
	}

	@Override
	public BufferedImage getImage(boolean debugging) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		
		graphics.setColor(Color.MAGENTA);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);

		int mapOffsetX = milkman.getX() - (WIDTH / 2);
		if(mapOffsetX < 0) {
			mapOffsetX = 0;
		} else if(mapOffsetX > terrain.getWidth() * 32 - WIDTH) {
			mapOffsetX = terrain.getWidth() * 32 - WIDTH;
		}
		int mapOffsetY = milkman.getY() - (HEIGHT / 2);
		if(mapOffsetY < 0) {
			mapOffsetY = 0;
		} else if(mapOffsetY > terrain.getHeight() * 32 - HEIGHT) {
			mapOffsetY = terrain.getHeight() * 32 - HEIGHT;
		}

		for(int y = 0; y < terrain.getHeight(); y++) {
			for(int x = 0; x < terrain.getWidth(); x++) {
				graphics.drawImage(terrain.getMaterial(x, y).getImage(), 32 * x - mapOffsetX, 32 * y - mapOffsetY, null);
				graphics.drawImage(items.getMaterial(x, y).getImage(), 32 * x - mapOffsetX, 32 * y - mapOffsetY, null);
				if(debugging) {
					if(terrain.getMaterial(x, y).isSolid()) {
						graphics.setColor(DEBUGGING_RED);
					} else {
						graphics.setColor(DEBUGGING_GREEN);
					}
					graphics.fillRect(32 * x - mapOffsetX, 32 * y - mapOffsetY, 32, 32);
				}
			}
		}

		synchronized(actors) {
			for(Actor actor : actors) {
				int x = actor.getX() - actor.getWidth() / 2 - mapOffsetX;
				int y = actor.getY() - actor.getHeight() / 2 - mapOffsetY;
				graphics.drawImage(actor.getImage(), x, y, null);
				if(debugging) {
					graphics.setColor(Color.RED);
					graphics.drawRect(actor.getHitbox().x - mapOffsetX, actor.getHitbox().y - mapOffsetY, actor.getHitbox().width, actor.getHitbox().height);
					graphics.drawLine(actor.getX() - 5 - mapOffsetX, actor.getY() - mapOffsetY, actor.getX() + 5 - mapOffsetX, actor.getY() - mapOffsetY);
					graphics.drawLine(actor.getX() - mapOffsetX, actor.getY() - 5 - mapOffsetY, actor.getX() - mapOffsetX, actor.getY() + 5 - mapOffsetY);
				}
			}
		}

		if(showInstructions) {
			graphics.drawImage(Textures.HUD.getInstructions(), 0, 0, null);
		}

		if(!showInstructions){
			drawHUD(graphics);

			float secondsSinceLastMove = milkman.getSecondsSinceLastMove();
			if(secondsSinceLastMove > 3) {
				float opacity = (secondsSinceLastMove - 3);
				if(opacity > 1)opacity = 1.0f;
				graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
				graphics.drawImage(Textures.HUD.getRestart(), 0, 0, null);
			}
		}

		return image;
	}

	public void removeBottleAt(int x, int y) {
		items.setMaterial(x / 32, y / 32, Material.CARDBOARD_BOX);
		if(milkman.getBottles() + milkman.getBottlesPlaced() > 8) {
			spawnIntelligentCow();
		} else {
			spawnStandardCow();
		}
	}

	public void placeBottleAt(int x, int y) {
		items.setMaterial(x / 32, y / 32, Material.FILLED_BOTTLE);
	}

	/**
	 * Calculates a spawnpoint.
	 * First a position is randomly chosen outside of the viewport.
	 * Then it is rotated around the viewport until a valid spawn-position is found.
	 */
	private Point getSpawnPoint() {
		int perimeter = 2 * WIDTH + 2 * HEIGHT;
		int offset = new Random().nextInt(perimeter);

		int viewportCenterX = milkman.getX();
		if(viewportCenterX < (WIDTH / 2)) {
			viewportCenterX = (WIDTH / 2);
		} else if(viewportCenterX > terrain.getWidth() * 32 - (WIDTH / 2)) {
			viewportCenterX = terrain.getWidth() * 32 - (WIDTH / 2);
		}

		int viewportCenterY = milkman.getY();
		if(viewportCenterY < (HEIGHT / 2)) {
			viewportCenterY = (HEIGHT / 2);
		} else if(viewportCenterY > terrain.getHeight() * 32 - (HEIGHT / 2)) {
			viewportCenterY = terrain.getHeight() * 32 - (HEIGHT / 2);
		}

		for(int i = 0; i < perimeter; i++) {
			int tilePosition = (i + offset) % perimeter;

			int x;
			int y;

			if(tilePosition < WIDTH) {
				//north
				x = viewportCenterX - (WIDTH / 2) + tilePosition;
				y = viewportCenterY - (HEIGHT / 2) - 64;
			} else if(tilePosition < WIDTH + HEIGHT) {
				//east
				x = viewportCenterX + (WIDTH / 2) + 64;
				y = viewportCenterY - (HEIGHT / 2) + (tilePosition - WIDTH);
			} else if(tilePosition < 2 * WIDTH + HEIGHT) {
				//south
				x = viewportCenterX - (WIDTH / 2) + (tilePosition - WIDTH - HEIGHT);
				y = viewportCenterY + (HEIGHT / 2) + 64;
			} else {
				//west
				x = viewportCenterX - (WIDTH / 2) - 64;
				y = viewportCenterY - (HEIGHT / 2) + (tilePosition - WIDTH - HEIGHT - WIDTH);
			}

			if(!terrain.getMaterialAt(x, y).isSolid()) {
				return new Point(x, y);
			}
		}
		//Return null if no valid spawn-point has been found.
		//(Very unlikely. If this was possible, the player would not be able to leave the screen.)
		return null;
	}

	/**
	 * Spawns a standard cow.
	 */
	private void spawnStandardCow() {
		Point spawnpoint = getSpawnPoint();
		if(spawnpoint != null) {
			synchronized(actors) {
				actors.add(new StandardCow(spawnpoint.x, spawnpoint.y, this));
			}
		}
	}

	/**
	 * Spawns an intelligent cow.
	 */
	private void spawnIntelligentCow() {
		Point spawnpoint = getSpawnPoint();
		if(spawnpoint != null) {
			synchronized(actors) {
				actors.add(new IntelligentCow(spawnpoint.x, spawnpoint.y, this));
			}
		}
	}

	@Override
	public void step() {
		super.step();

		int tileX = milkman.getX() / 32;
		int tileY = milkman.getY() / 32;

		//pick up bottle
		if(items.getMaterial(tileX, tileY) == Material.EMPTY_BOTTLE && milkman.canPickupBottles()) {
			milkman.pickupBottle();
		}

		//place bottle
		if(items.getMaterial(tileX, tileY) == Material.CARDBOARD_BOX && milkman.canPlaceBottles()) {
			milkman.placeBottle();
		}

		//change scene
		if(terrain.getMaterial(tileX, tileY) == Material.SCENE_CONNECTOR) {
			MainFrame.getInstance().setCurrentView(new MilkFactory(this, difficulty));
			if(milkman.getX() < 0) {
				milkman.setX(16);
			}
			if(milkman.getY() < 0) {
				milkman.setY(16);
			}
			if(milkman.getX() > 32 * terrain.getWidth() - 32) {
				milkman.setX(32 * terrain.getWidth() - 48);
			}
			if(milkman.getY() > 32 * terrain.getHeight() - 32) {
				milkman.setY(32 * terrain.getHeight() - 48);
			}
		}
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		super.onKeyPressed(keyEvent);
		showInstructions = false;
	}

	@Override
	public void onMouseMoved(MouseEvent mouseEvent) {
		//not used at the moment
	}

	@Override
	public void onMousePressed(MouseEvent mouseEvent) {
		//not used at the moment
	}

	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {
		//not used at the moment
	}

}
