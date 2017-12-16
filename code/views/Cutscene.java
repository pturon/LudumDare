package code.views;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import code.AudioManager;
import code.MainFrame;
import code.Textures;
import code.enums.Difficulty;

public class Cutscene extends View {
    private int currentFrame = 0;
    private int steps = 0;
    private Difficulty difficulty;

    public Cutscene(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public BufferedImage getImage(boolean debugging) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        if(currentFrame == 0) {
            graphics.drawImage(Textures.Cutscene.getFactoryOverview(), 0, 0, null);
        } else if(currentFrame < 5) {
        	if(currentFrame == 1) {
        		AudioManager.playExplosionSound();
        	}
            graphics.drawImage(Textures.Cutscene.getFactoryOverview(), 0, 0, null);
            graphics.drawImage(Textures.Cutscene.getExplosion(currentFrame - 1), 0, 0, null);
        } else if(currentFrame < 14) {
            graphics.drawImage(Textures.Cutscene.getDestroyedLab(), 0, 0, null);
            graphics.drawImage(Textures.Cutscene.getChemicals(currentFrame - 5), 0, 0, null);
        } else {
        	MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
        }

        return image;
    }

    @Override
    public void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_SPACE:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_ESCAPE:
            	MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
                break;
            default:
            	break;
        }
    }

    @Override
    public void step() {
        if (steps == 256 && currentFrame == 0) {
            currentFrame++;
            steps = 0;
        }
        if (steps == 10 && currentFrame > 0 && currentFrame < 5) {
            steps = 0;
            currentFrame++;
        }
        if (steps == 40 && currentFrame > 4 && currentFrame < 13) {
            steps = 0;
            currentFrame++;
        }
        if (steps == 128 && currentFrame >  12) {
            steps = 0;
            currentFrame++;
        }
        steps++;

    }

    @Override
    public void onMousePressed(MouseEvent mouseEvent) {
    	MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
    }
}
