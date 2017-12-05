package code.views;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import code.Clock;
import code.MainFrame;
import code.Textures;
import code.Tilemap;
import code.entities.Actor;
import code.entities.Milkman;

public abstract class Scene extends View {
    protected Milkman milkman;
    protected List<Actor> actors = new ArrayList<>();
    protected Tilemap terrain;
    protected int difficulty;

    private String[] buttons = {"resume", "menu"};
    private boolean pause;
    private int selection = 0;
    private int mousePressedOn = 0;

    public Scene(String pathToTerrainMap, Class<? extends Scene> parentClass, int difficulty) {
        terrain = new Tilemap(pathToTerrainMap, parentClass);
        this.difficulty = difficulty;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public Milkman getMilkman() {
        return milkman;
    }

    public boolean isPixelSolid(int pixelX, int pixelY) {
        return terrain.getMaterialAt(pixelX, pixelY).isSolid();
    }

    @Override
    public void onKeyPressed(KeyEvent keyEvent) {
    	if(pause){
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
                    case "resume":
                        pause = false;
                        Clock.unpause();
                        break;
                    case "menu":
                        MainFrame.getInstance().setCurrentView(new Menu(difficulty));
                        Clock.unpause();
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    	} else {
    		switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                Milkman.setLeftPressed(true);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                Milkman.setRightPressed(true);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                Milkman.setUpPressed(true);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                Milkman.setDownPressed(true);
                break;
            default:
                break;
    		}
    	}
        
    }

    @Override
    public void onKeyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                Milkman.setLeftPressed(false);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                Milkman.setRightPressed(false);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                Milkman.setUpPressed(false);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                Milkman.setDownPressed(false);
                break;
            case KeyEvent.VK_R:
                Milkman.reset();
                MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
                break;
            case KeyEvent.VK_ESCAPE:
                pause = true;
                break;
            default:
                break;
        }
    }

    public void step() {
        //copy list to avoid concurrent-modification-exception
        Actor[] threadSafeActors = actors.toArray(new Actor[0]);
        for (Actor actor : threadSafeActors) {
            actor.step();
        }
    }

    public void drawHUD(Graphics2D graphics) {
        graphics.drawImage(Textures.ui.getUiBackground(), 0, 0, null);

        int emptyBottles = milkman.getEmptyBottles();
        int filledBottles = milkman.getFilledBottles();
        int hearts = milkman.getHearts();
        char[] score = Integer.toString(milkman.getBottlesPlaced()).toCharArray();

        for (int i = 0; i < (emptyBottles + filledBottles); i++) {
            if (i < emptyBottles) {
                graphics.drawImage(Textures.ui.getEmptyBottle(), 780 - (13 * i), 2, null);
            } else {
                graphics.drawImage(Textures.ui.getFull_bottle(), 780 - (13 * i), 2, null);
            }
        }

        for (int i = hearts; i > 0; i--){
            graphics.drawImage(Textures.ui.getHeart(),670-(17*i),2,null);
        }

        for(int i = 0; i < score.length; i++){
            switch (score[i]){
                case '0':
                    graphics.drawImage(Textures.ui.getNumber_0(),75+(10*i),5,null);
                    break;
                case '1':
                    graphics.drawImage(Textures.ui.getNumber_1(),75+(7*i),5,null);
                    break;
                case '2':
                    graphics.drawImage(Textures.ui.getNumber_2(),75+(10*i),5,null);
                    break;
                case '3':
                    graphics.drawImage(Textures.ui.getNumber_3(),75+(10*i),5,null);
                    break;
                case '4':
                    graphics.drawImage(Textures.ui.getNumber_4(),75+(10*i),5,null);
                    break;
                case '5':
                    graphics.drawImage(Textures.ui.getNumber_5(),75+(10*i),5,null);
                    break;
                case '6':
                    graphics.drawImage(Textures.ui.getNumber_6(),75+(10*i),5,null);
                    break;
                case '7':
                    graphics.drawImage(Textures.ui.getNumber_7(),75+(10*i),5,null);
                    break;
                case '8':
                    graphics.drawImage(Textures.ui.getNumber_8(),75+(10*i),5,null);
                    break;
                case '9':
                    graphics.drawImage(Textures.ui.getNumber_9(),75+(10*i),5,null);
                    break;
            }
        }
        
        if(pause){

        	graphics.drawImage(Textures.HUD.getPause(), 0, 0, null);
        	graphics.drawImage(Textures.Menu.getButton(), 194, 352, null);
			graphics.drawImage(Textures.Menu.getButton(), 194, 448, null);
	        graphics.drawImage(Textures.Menu.getResumeFont(), 194, 352, null);
	        graphics.drawImage(Textures.Menu.getMenuFont(), 194, 448, null);
			graphics.drawImage(Textures.Menu.getFrame(), 194, 352 + selection * 96, null);
			Clock.pause();
        }
    }
    
    @Override
	public void onMouseMoved(MouseEvent mouseEvent) {
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
		if(pause){
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
		if(pause){
			if (mouseEvent.getX() > 194 && mouseEvent.getX() < 606) {
	            if (mouseEvent.getY() > 352 && mouseEvent.getY() < 416 && mousePressedOn == 1) {
	            	mousePressedOn = 0;
                    pause = false;
                    Clock.unpause();
	            } else if (mouseEvent.getY() > 448 && mouseEvent.getY() < 512 && mousePressedOn == 2) {
	            	mousePressedOn = 0;
	            	MainFrame.getInstance().setCurrentView(new Menu(difficulty));
                    Clock.unpause();
	            }
	        }
		}
		
	}
    
}
