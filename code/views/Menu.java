package code.views;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import code.AudioManager;
import code.MainFrame;
import code.Textures;
import code.enums.Difficulty;

public class Menu extends View {
	private Rectangle smokeHitbox = new Rectangle(310, 0, 122, 34);
	private Rectangle chimneyHitbox = new Rectangle(306, 30, 36, 102);
	private Rectangle mooHitbox = new Rectangle(480, 142, 78, 114);
	private Rectangle playHitbox = new Rectangle(32, 287, 411, 64);
	private Rectangle difficultyHitbox = new Rectangle(32, 384, 411, 64);
	private Rectangle exitHitbox = new Rectangle(32, 480, 411, 64);

	private static final int PLAY = 0;
	private static final int DIFFICULTY = 1;
	private static final int EXIT = 2;
    private int selection = PLAY;

    private int currentFrame = 0;
    private int steps = 0;
    private Difficulty selectedDifficulty = Difficulty.NORMAL;

    public Menu(Difficulty difficulty) {
        this.selectedDifficulty = difficulty;
    }

    @Override
    public BufferedImage getImage(boolean debugging) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        graphics.drawImage(Textures.Menu.getBackground(), 0, 0, null);
        
        graphics.drawImage(Textures.Menu.getTitle(currentFrame % 4), 176, 0, null);
        graphics.drawImage(Textures.Menu.getMilkman(), 476, 256, null);

        graphics.drawImage(Textures.Menu.getButton(), 32, 288, null);
        graphics.drawImage(Textures.Menu.getPlayFont(), 32, 288, null);
        graphics.drawImage(Textures.Menu.getButton(), 32, 384, null);
        graphics.drawImage(Textures.Menu.getDifficultyFont(selectedDifficulty), 32, 384, null);
        graphics.drawImage(Textures.Menu.getButton(), 32, 480, null);
        graphics.drawImage(Textures.Menu.getExitFont(), 32, 480, null);

        graphics.drawImage(Textures.Menu.getFrame(), 32, 288 + selection * 96, null);

        return image;
    }

    @Override
    public void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (selection == DIFFICULTY) {
                    selectedDifficulty = selectedDifficulty.previous();
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (selection == DIFFICULTY) {
                    selectedDifficulty = selectedDifficulty.next();
                }
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                selection = (selection + 2) % 3;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                selection = (selection + 1) % 3;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_SPACE:
                switch (selection) {
                    case PLAY:
                        MainFrame.getInstance().setCurrentView(new Cutscene(selectedDifficulty));
                        break;
                    case DIFFICULTY:
                        selectedDifficulty = selectedDifficulty.next();
                        break;
                    case EXIT:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void step() {
    	if (!(steps == 0 && currentFrame == 0)) {	
    		if (steps == 16 && currentFrame < 16){
                steps = 0;
                currentFrame++;  			
    		} 
    		if (currentFrame == 16){
    			steps = -1;
    			currentFrame = 0;
    		}
    		steps++;
        }
    }

    @Override
    public void onMouseMoved(MouseEvent mouseEvent) {
    	if(playHitbox.contains(mouseEvent.getPoint())) {
    		selection = PLAY;
    	} else if(difficultyHitbox.contains(mouseEvent.getPoint())) {
    		selection = DIFFICULTY;
    	} else if(exitHitbox.contains(mouseEvent.getPoint())) {
    		selection = EXIT;
    	}
    }

    @Override
    public void onMousePressed(MouseEvent mouseEvent) {
    	if(playHitbox.contains(mouseEvent.getPoint())) {
            MainFrame.getInstance().setCurrentView(new Cutscene(selectedDifficulty));
    	} else if(difficultyHitbox.contains(mouseEvent.getPoint())) {
            selectedDifficulty = selectedDifficulty.next();
    	} else if(exitHitbox.contains(mouseEvent.getPoint())) {
            System.exit(0);
        } else if (chimneyHitbox.contains(mouseEvent.getPoint()) || smokeHitbox.contains(mouseEvent.getPoint())) {
        	if(steps == 0){
				steps++;
			}
        } else if (mooHitbox.contains(mouseEvent.getPoint())) {
           AudioManager.playCowSound();
        }
    }
}