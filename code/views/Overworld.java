package code.views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import code.Material;
import code.Textures;
import code.Tilemap;
import code.entities.Actor;
import code.entities.Cow;
import code.entities.Milkman;

public class Overworld extends Scene {
	private int difficulty;

	protected Tilemap items;

	private boolean showInstructions = true;

	private static final Color DEBUGGING_GREEN = new Color(0, 255, 0, 128);
	private static final Color DEBUGGING_RED = new Color(255, 0, 0, 128);

	public Overworld(int difficulty) {
		super("img/overworld/overworld_tilemap.txt", Overworld.class);

		items = new Tilemap("img/overworld/overworld_tilemap_milkbottles.txt", Overworld.class);
		milkman = new Milkman(64, 64, this);
		synchronized(actors) {
			actors.add(milkman);
			for(int i = 0; i < 8; i++) {
				actors.add(new Cow((int)(Math.random() * 800), (int)(Math.random() * 600), this));
			}
		}
		this.difficulty = difficulty;
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

		graphics.setColor(Color.WHITE);
		graphics.drawString("Bottles: " + milkman.getBottles(), 10, 20);

		return image;
	}

	public void removeBottleAt(int x, int y) {
		items.setMaterial(x / 32, y / 32, Material.CARDBOARD_BOX);
	}

	@Override
	public void step() {
		super.step();

		//pick up bottle
		int tileX = milkman.getX() / 32;
		int tileY = milkman.getY() / 32;
		if(items.getMaterial(tileX, tileY) == Material.EMPTY_BOTTLE && milkman.canPickupBottles()) {
			milkman.pickupBottle();
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
