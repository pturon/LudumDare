package code.views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import code.AudioManager;
import code.MainFrame;
import code.Material;
import code.Textures;
import code.entities.Actor;
import code.entities.Milkman;

public class MilkFactory extends Scene {
	private Overworld overworld;

	private static final Color DEBUGGING_GREEN = new Color(0, 255, 0, 128);
	private static final Color DEBUGGING_RED = new Color(255, 0, 0, 128);

	private int arrow_frame = 0;
	private int steps = 0;

	private boolean playedBottleSound = false;

	public MilkFactory(Overworld overworld, int difficulty) {
		super("img/milkfactory/milk_factory_tilemap.txt", MilkFactory.class, difficulty);

		this.overworld = overworld;
		this.difficulty = difficulty;

		milkman = new Milkman(464, 528, this);
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

		switch (arrow_frame){
			case 0:
				graphics.drawImage(Textures.ui.getArrow_0(),32*19,48,null);
				graphics.drawImage(Textures.ui.getArrow_0(),32*17,48,null);
				break;
			case 1:
				graphics.drawImage(Textures.ui.getArrow_1(),32*19,48,null);
				graphics.drawImage(Textures.ui.getArrow_1(),32*17,48,null);
				break;
			case 2:
				graphics.drawImage(Textures.ui.getArrow_2(),32*19,48,null);
				graphics.drawImage(Textures.ui.getArrow_2(),32*17,48,null);
				break;
			case 3:
				graphics.drawImage(Textures.ui.getArrow_3(),32*19,48,null);
				graphics.drawImage(Textures.ui.getArrow_3(),32*17,48,null);
				break;
		}

		drawHUD(graphics);

		return image;
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

	@Override
	public void step() {
		super.step();
		
		int tileX = milkman.getX() / 32;
		int tileY = milkman.getY() / 32;

		//fill bottles
		if(((tileX == 16 && tileY == 3) || (tileX == 17 && tileY == 4))) {
			if(!playedBottleSound && milkman.getEmptyBottles() > 0) {
				AudioManager.playBottleSound();
				playedBottleSound = true;
				//This is a very ugly workaround to prevent the AudioManager from
				//playing the sound infinitely while standing near the conveyor belt.
				//This works because each time the player visits the milkfactory a new instance is created.
			}
			milkman.fillBottles();
		}

		//change scene
		if(terrain.getMaterial(tileX, tileY) == Material.SCENE_CONNECTOR) {
			MainFrame.getInstance().setCurrentView(overworld);
		}

		if(steps == 20){
			if(arrow_frame==3){
				arrow_frame = 0;
			}
			else{
				arrow_frame++;
			}
			steps = 0;
		}
		steps ++;
	}
}
