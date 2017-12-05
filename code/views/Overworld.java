package code.views;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import code.AudioManager;
import code.Clock;
import code.MainFrame;
import code.Material;
import code.Pathfinding;
import code.Textures;
import code.Tilemap;
import code.entities.Actor;
import code.entities.IntelligentCow;
import code.entities.Milkman;
import code.entities.StandardCow;

public class Overworld extends Scene {
	protected Tilemap items;

	private boolean victory = false;
	private boolean gameover = false;
	private boolean showInstructions = true;
    private String[] buttons = {"again", "menu"};
    private int selection = 0;
    private int mousePressedOn = 0;
    private long stepsSinceGameEnd = 0;

	private static final Color DEBUGGING_GREEN = new Color(0, 255, 0, 128);
	private static final Color DEBUGGING_RED = new Color(255, 0, 0, 128);

	public Overworld(int difficulty) {
		super("img/overworld/overworld_tilemap.txt", Overworld.class, difficulty);
		this.difficulty = difficulty;
		items = new Tilemap("img/overworld/overworld_tilemap_milkbottles.txt", Overworld.class);

		milkman = new Milkman(64, 64, this);
		Milkman.reset();
		milkman.setHearts(3 - difficulty);
		synchronized(actors) {
			actors.add(milkman);
		}

		if(difficulty == 2) {
			//better pathfinding in hard-mode
			Pathfinding.setTargetActor(milkman);
			Pathfinding.setTilemap(terrain);
		} else {
			//reset pathfinding otherwise
			Pathfinding.setTargetActor(null);
			Pathfinding.setTilemap(null);
		}
	}

	@Override
	public BufferedImage getImage(boolean debugging) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		BufferedImage overlayImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		BufferedImage baseImage;
		if(gameover){
			baseImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_BYTE_GRAY);
		} else{
			baseImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);			
		}
		
		Graphics2D baseGraphics = baseImage.createGraphics();
		Graphics2D overlayGraphics = overlayImage.createGraphics();	
		Graphics2D graphics = image.createGraphics();	
		
		baseGraphics.setColor(Color.MAGENTA);
		baseGraphics.fillRect(0, 0, WIDTH, HEIGHT);

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
				int tilePositionOnScreenX = 32 * x - mapOffsetX;
				int tilePositionOnScreenY = 32 * y - mapOffsetY;

				baseGraphics.drawImage(terrain.getMaterial(x, y).getImage(), tilePositionOnScreenX, tilePositionOnScreenY, null);
				baseGraphics.drawImage(items.getMaterial(x, y).getImage(), tilePositionOnScreenX, tilePositionOnScreenY, null);
				if(debugging) {
					if(terrain.getMaterial(x, y).isSolid()) {
						baseGraphics.setColor(DEBUGGING_RED);
					} else {
						baseGraphics.setColor(DEBUGGING_GREEN);
					}
					baseGraphics.fillRect(tilePositionOnScreenX, tilePositionOnScreenY, 32, 32);
					baseGraphics.setColor(Color.BLUE);
					if(Pathfinding.isInitialized()) {
						switch(Pathfinding.getDirection(x, y)) {
						case Actor.LEFT:
							baseGraphics.drawLine(tilePositionOnScreenX + 8, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 8);
							baseGraphics.drawLine(tilePositionOnScreenX + 8, tilePositionOnScreenY + 16, tilePositionOnScreenX + 24, tilePositionOnScreenY + 16);
							baseGraphics.drawLine(tilePositionOnScreenX + 8, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 24);
							break;
						case Actor.RIGHT:
							baseGraphics.drawLine(tilePositionOnScreenX + 24, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 8);
							baseGraphics.drawLine(tilePositionOnScreenX + 8, tilePositionOnScreenY + 16, tilePositionOnScreenX + 24, tilePositionOnScreenY + 16);
							baseGraphics.drawLine(tilePositionOnScreenX + 24, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 24);
							break;
						case Actor.UP:
							baseGraphics.drawLine(tilePositionOnScreenX + 8, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 8);
							baseGraphics.drawLine(tilePositionOnScreenX + 16, tilePositionOnScreenY + 24, tilePositionOnScreenX + 16, tilePositionOnScreenY + 8);
							baseGraphics.drawLine(tilePositionOnScreenX + 24, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 8);
							break;
						case Actor.DOWN:
							baseGraphics.drawLine(tilePositionOnScreenX + 8, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 24);
							baseGraphics.drawLine(tilePositionOnScreenX + 16, tilePositionOnScreenY + 8, tilePositionOnScreenX + 16, tilePositionOnScreenY + 24);
							baseGraphics.drawLine(tilePositionOnScreenX + 24, tilePositionOnScreenY + 16, tilePositionOnScreenX + 16, tilePositionOnScreenY + 24);
							break;
						}
					}
				}
			}
		}

		synchronized(actors) {
			for(Actor actor : actors) {
				int x = actor.getX() - actor.getWidth() / 2 - mapOffsetX;
				int y = actor.getY() - actor.getHeight() / 2 - mapOffsetY;
				baseGraphics.drawImage(actor.getImage(), x, y, null);
				if(debugging) {
					baseGraphics.setColor(Color.RED);
					baseGraphics.drawRect(actor.getHitbox().x - mapOffsetX, actor.getHitbox().y - mapOffsetY, actor.getHitbox().width, actor.getHitbox().height);
					baseGraphics.drawLine(actor.getX() - 5 - mapOffsetX, actor.getY() - mapOffsetY, actor.getX() + 5 - mapOffsetX, actor.getY() - mapOffsetY);
					baseGraphics.drawLine(actor.getX() - mapOffsetX, actor.getY() - 5 - mapOffsetY, actor.getX() - mapOffsetX, actor.getY() + 5 - mapOffsetY);
				}
			}
		}

		if(showInstructions) {
			baseGraphics.drawImage(Textures.HUD.getInstructions(), 0, 0, null);
		}
		
		if(!showInstructions){
			float secondsSinceLastMove = milkman.getSecondsSinceLastMove();
			if(gameover){
				float opacity = (float)stepsSinceGameEnd/Clock.getStepsPerSecond();				
				if(opacity > 1)opacity = 1.0f;
				overlayGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

				overlayGraphics.drawImage(Textures.HUD.getGameover(), 0, 0, null);
				overlayGraphics.drawImage(Textures.Menu.getButton(), 194, 352, null);
				overlayGraphics.drawImage(Textures.Menu.getButton(), 194, 448, null);
				overlayGraphics.drawImage(Textures.Menu.getAgainFont(), 194, 352, null);
				overlayGraphics.drawImage(Textures.Menu.getMenuFont(), 194, 448, null);
				overlayGraphics.drawImage(Textures.Menu.getFrame(), 194, 352 + selection * 96, null);
			} else if(victory){
				float opacity = (float)stepsSinceGameEnd/Clock.getStepsPerSecond();
				if(opacity > 1)opacity = 1.0f;
				overlayGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

				overlayGraphics.drawImage(Textures.HUD.getVictory(), 0, 0, null);
				if(opacity >= 1){
					Clock.pause();
				}
			} else if(secondsSinceLastMove > 3) {
				float opacity = (secondsSinceLastMove - 3);
				if(opacity > 1)opacity = 1.0f;
				baseGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
				
				baseGraphics.drawImage(Textures.HUD.getRestart(), 0, 0, null);
			}
			drawHUD(baseGraphics);
		}		
		
		graphics.drawImage(baseImage, 0, 0, null);
		graphics.drawImage(overlayImage, 0, 0, null);
		
		return image;
	}

	public void removeBottleAt(int x, int y) {
		AudioManager.playBottleSound();
		items.setMaterial(x / 32, y / 32, Material.CARDBOARD_BOX);
		if(difficulty != 0 && milkman.getEmptyBottles() + milkman.getFilledBottles() + milkman.getBottlesPlaced() > 8) {
			spawnIntelligentCow();
		} else {
			spawnStandardCow();
		}
	}

	public void placeBottleAt(int x, int y) {
		AudioManager.playBottleSound();
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
		if(gameover | victory){
			stepsSinceGameEnd++;
			super.disablePause();
		} else {
			//not needed at the moment, because after the game ended it can't resume
			stepsSinceGameEnd = 0;
			super.enablePause();
		}
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
		if(gameover){
			switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                selection = (selection - 1 + buttons.length) % buttons.length;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                selection = (selection + 1) % (buttons.length);
                break;
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_SPACE:
                switch (buttons[selection]) {
                    case "again":
                        Milkman.reset();
                        MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
                        break;
                    case "menu":
                        MainFrame.getInstance().setCurrentView(new Menu(difficulty));
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
			}
		}
		
	}

	@Override
	public void onMouseMoved(MouseEvent mouseEvent) {
		super.onMouseMoved(mouseEvent);
		if (mouseEvent.getX() > 194 && mouseEvent.getX() < 606) {
            if (mouseEvent.getY() > 352 && mouseEvent.getY() < 416) {
                selection = 0;
            } else if (mouseEvent.getY() > 448 && mouseEvent.getY() < 512) {
                selection = 1;
            }
        }
	}

	@Override
	public void onMousePressed(MouseEvent mouseEvent) {
		super.onMousePressed(mouseEvent);
		showInstructions = false;
		if(gameover){
			if (mouseEvent.getX() > 194 && mouseEvent.getX() < 606) {
	            if (mouseEvent.getY() > 352 && mouseEvent.getY() < 416) {
	            	mousePressedOn = 1;
	            } else if (mouseEvent.getY() > 448 && mouseEvent.getY() < 512) {
	            	mousePressedOn = 2;
	            }
	        }
		}
		
	}

	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {
		super.onMouseReleased(mouseEvent);
		if(gameover){
			if (mouseEvent.getX() > 194 && mouseEvent.getX() < 606) {
	            if (mouseEvent.getY() > 352 && mouseEvent.getY() < 416 && mousePressedOn == 1) {
	            	mousePressedOn = 0;
	            	Milkman.reset();
	                MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
	            } else if (mouseEvent.getY() > 448 && mouseEvent.getY() < 512 && mousePressedOn == 2) {
	            	mousePressedOn = 0;
	            	MainFrame.getInstance().setCurrentView(new Menu(difficulty));
	            }
	        }
		}
		
	}
	
	public void triggerDeath(){
		this.gameover = true;
	}
	
	public void checkVictory(int bottlesPlaced){
		if(bottlesPlaced >= items.getBottleCount()){
			victory = true;
		}
	}

}
