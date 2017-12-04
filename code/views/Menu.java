package code.views;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import code.MainFrame;
import code.Textures;

public class Menu extends View {
    private String[] buttons = {"play", "difficulty", "exit"};
    private int currentFrame = 0;
    private int steps = 0;
    private int selection = 0;
    private int difficulty = 1;
    private int mousePressedOn = 0;

    public Menu(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public BufferedImage getImage(boolean debugging) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        graphics.drawImage(Textures.Menu.getBackground(), 0, 0, null);
        
        graphics.drawImage(Textures.Menu.getTitle(currentFrame%4), 176, 0, null);
        graphics.drawImage(Textures.Menu.getMilkman(), 476, 256, null);

        graphics.drawImage(Textures.Menu.getButton(), 32, 288, null);
        graphics.drawImage(Textures.Menu.getPlayFont(), 32, 288, null);
        graphics.drawImage(Textures.Menu.getButton(), 32, 384, null);
        graphics.drawImage(Textures.Menu.getDifficultyFont(difficulty), 32, 384, null);
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
                if (buttons[selection].equals("difficulty")) {
                    difficulty = (difficulty + 2) % 3;
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (buttons[selection].equals("difficulty")) {
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
                switch (buttons[selection]) {
                    case "play":
                        Cutscene cutscene = new Cutscene(difficulty);
                        MainFrame.getInstance().setCurrentView(cutscene);
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
        if (mouseEvent.getX() > 32 && mouseEvent.getX() < 444) {
            if (mouseEvent.getY() > 288 && mouseEvent.getY() < 352) {
                selection = 0;
            } else if (mouseEvent.getY() > 384 && mouseEvent.getY() < 448) {
                selection = 1;
            } else if (mouseEvent.getY() > 480 && mouseEvent.getY() < 544) {
                selection = 2;
            }
        }
    }

    @Override
    public void onMousePressed(MouseEvent mouseEvent) {
    	System.out.println(mouseEvent.getX() + " : " + mouseEvent.getY());
        if (mouseEvent.getX() > 32 && mouseEvent.getX() < 444) {
            if (mouseEvent.getY() > 288 && mouseEvent.getY() < 352) {
                mousePressedOn = 1;
            } else if (mouseEvent.getY() > 384 && mouseEvent.getY() < 448) {
                mousePressedOn = 2;
            } else if (mouseEvent.getY() > 480 && mouseEvent.getY() < 544) {
                mousePressedOn = 3;
            }
        }
        if (mouseEvent.getX() >= 306 && mouseEvent.getX() <= 342 && mouseEvent.getY() >= 30 && mouseEvent.getY() <= 132) {
            mousePressedOn = 4;
        } else if (mouseEvent.getX() >= 310 && mouseEvent.getX() <= 432 && mouseEvent.getY() >= 0 && mouseEvent.getY() <= 34) {
            mousePressedOn = 4;
        } else if (mouseEvent.getX() >= 480 && mouseEvent.getX() <= 558 && mouseEvent.getY() >= 142 && mouseEvent.getY() <= 256) {
            mousePressedOn = 5;
        }
    }

    @Override
    public void onMouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getX() > 32 && mouseEvent.getX() < 444) {
            if (mouseEvent.getY() > 288 && mouseEvent.getY() < 352 && mousePressedOn == 1) {
                mousePressedOn = 0;
                Cutscene cutscene = new Cutscene(difficulty);
                MainFrame.getInstance().setCurrentView(cutscene);
            } else if (mouseEvent.getY() > 384 && mouseEvent.getY() < 448 && mousePressedOn == 2) {
                mousePressedOn = 0;
                difficulty = (difficulty + 1) % 3;
            } else if (mouseEvent.getY() > 480 && mouseEvent.getY() < 544 && mousePressedOn == 3) {
                mousePressedOn = 0;
                System.exit(0);
            }
        }
        if (mouseEvent.getX() >= 306 && mouseEvent.getX() <= 342 && mouseEvent.getY() >= 30 && mouseEvent.getY() <= 132 && mousePressedOn == 4) {
        	if(steps == 0){
				steps++;
			}
        } else if (mouseEvent.getX() >= 310 && mouseEvent.getX() <= 432 && mouseEvent.getY() >= 0 && mouseEvent.getY() <= 34 && mousePressedOn == 4) {
        	if(steps == 0){
				steps++;
			}
        } else if (mouseEvent.getX() >= 480 && mouseEvent.getX() <= 558 && mouseEvent.getY() >= 142 && mouseEvent.getY() <= 256 && mousePressedOn == 5) {
            //Only sound in the game, could also be excluded
            File file = new File("src/sound/cow.wav");
            try {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }

    }

}