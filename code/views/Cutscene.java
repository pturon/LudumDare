package code.views;

import code.AudioManager;
import code.MainFrame;
import code.Textures;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Cutscene extends View {
    private int currentFrame = 0;
    private int steps = 0;
    private int difficulty;

    public Cutscene(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public BufferedImage getImage(boolean debugging) {

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        switch (currentFrame){
            case 0:
                graphics.drawImage(Textures.CutSceneTextures.getFactoryOverview(),0,0,null);
                break;
            case 1:
                graphics.drawImage(Textures.CutSceneTextures.getFactoryOverview(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getExplosion_0(),0,0,null);
                AudioManager.playExplosionSound();
                break;
            case 2:
                graphics.drawImage(Textures.CutSceneTextures.getFactoryOverview(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getExplosion_1(),0,0,null);
                break;
            case 3:
                graphics.drawImage(Textures.CutSceneTextures.getFactoryOverview(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getExplosion_2(),0,0,null);
                break;
            case 4:
                graphics.drawImage(Textures.CutSceneTextures.getFactoryOverview(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getExplosion_3(),0,0,null);
                break;
            case 5:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_0(),0,0,null);
                break;
            case 6:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_1(),0,0,null);
                break;
            case 7:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_2(),0,0,null);
                break;
            case 8:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_3(),0,0,null);
                break;
            case 9:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_4(),0,0,null);
                break;
            case 10:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_5(),0,0,null);
                break;
            case 11:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_6(),0,0,null);
                break;
            case 12:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_7(),0,0,null);
                break;
            case 13:
                graphics.drawImage(Textures.CutSceneTextures.getDestroyedLab(),0,0,null);
                graphics.drawImage(Textures.CutSceneTextures.getChemical_8(),0,0,null);
                break;
            case 14:
            	MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
                break;
        }

        return image;
    }

    @Override
    public void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_SPACE:
                MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
                break;
            case KeyEvent.VK_ENTER:
            	MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
                break;
            case KeyEvent.VK_ESCAPE:
            	MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
                break;
        }
    }

    @Override
    public void onKeyReleased(KeyEvent keyEvent) {

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
    public void onMouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void onMousePressed(MouseEvent mouseEvent) {
    	MainFrame.getInstance().setCurrentView(new Overworld(difficulty));
    }

    @Override
    public void onMouseReleased(MouseEvent mouseEvent) {

    }
}
