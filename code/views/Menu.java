package code.views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import code.MainFrame;
import code.Textures;
import code.entities.Actor;

public class Menu extends View {
	private MainFrame mainFrame;
	private String[] buttons = {"play", "difficulty", "exit"};
	private int selection = 0;
	private int difficulty = 1;

	public Menu(int difficulty, MainFrame mainFrame) {
		this.difficulty = difficulty;
		this.mainFrame = mainFrame;
	}

	@Override
	public BufferedImage getImage(boolean debugging) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		
		graphics.drawImage(Textures.Menu.getBackground(), 0, 0, null);

		graphics.drawImage(Textures.Menu.getTitle(), 176, 0, null);
		graphics.drawImage(Textures.Menu.getMilkman(), 476, 256, null);		

		graphics.drawImage(Textures.Menu.getButton(), 32, 288, null);
		graphics.drawImage(Textures.Menu.getPlayFont(), 32, 288, null);
		graphics.drawImage(Textures.Menu.getButton(), 32, 384, null);
		graphics.drawImage(Textures.Menu.getDifficultyFont(difficulty), 32, 384, null);
		graphics.drawImage(Textures.Menu.getButton(), 32, 480, null);
		graphics.drawImage(Textures.Menu.getExitFont(), 32, 480, null);

		graphics.drawImage(Textures.Menu.getFrame(), 32, 288 + selection*96, null);

		return image;
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			if(buttons[selection].equals("difficulty")){
				difficulty = (difficulty + 2) % 3;
			}
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			if(buttons[selection].equals("difficulty")){
				difficulty = (difficulty + 1) % 3;
			}
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			selection = (selection - 1 + buttons.length) % buttons.length;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			selection = (selection + 1) % (buttons.length);
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
			switch(buttons[selection]){
			case "play":
				mainFrame.setCurrentView(new Game(difficulty));
				break;
			case "difficulty":
				difficulty = (difficulty + 1) % 3;
				break;
			case "exit":
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
	public void onKeyReleased(KeyEvent keyEvent) {
		
	}

	@Override
	public void step() {
		
	}

}
