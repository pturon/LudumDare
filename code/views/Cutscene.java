package code.views;

import code.MainFrame;
import code.Textures;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Cutscene extends View {

    private MainFrame mainFrame;

    private int currentFrame = 0;
    private int steps = 0;
    private int difficulty;

    public Cutscene(MainFrame mainFrame, int difficulty) {
        this.mainFrame = mainFrame;
        this.difficulty = difficulty;
    }

    @Override
    public BufferedImage getImage(boolean debugging) {

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        graphics.drawImage(Textures.CutSceneTextures.getFactoryOverview(), 0, 0, null);

        switch (currentFrame) {
            case 0:
                break;
            case 1:
                graphics.drawImage(Textures.CutSceneTextures.getExplosion_0(), 0, 0, null);
                break;
            case 2:
                graphics.drawImage(Textures.CutSceneTextures.getExpolsion_1(), 0, 0, null);
                break;
            case 3:
                graphics.drawImage(Textures.CutSceneTextures.getExplosion_2(), 0, 0, null);
                break;
            case 4:
                mainFrame.setCurrentView(new Overworld(difficulty));
                break;
        }

        return image;
    }

    @Override
    public void onKeyPressed(KeyEvent keyEvent) {

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
        if (steps == 75 && currentFrame > 0) {
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

    }

    @Override
    public void onMouseReleased(MouseEvent mouseEvent) {

    }
}
