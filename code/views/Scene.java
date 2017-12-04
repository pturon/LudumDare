package code.views;

import code.MainFrame;
import code.Textures;
import code.Tilemap;
import code.entities.Actor;
import code.entities.Milkman;

import javax.xml.soap.Text;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene extends View {
    protected Milkman milkman;
    protected List<Actor> actors = new ArrayList<>();
    protected Tilemap terrain;
    protected int difficulty;

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
                MainFrame.getInstance().setCurrentView(new Menu(difficulty));
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

        int bottles = milkman.getBottles();
        boolean type = milkman.getBottleType();
        int hearts = milkman.getHearts();
        char[] score = Integer.toString(milkman.getBottlesPlaced()).toCharArray();

        for (int i = 0; i < bottles; i++) {
            if (!type) {
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
                    graphics.drawImage(Textures.ui.getNumber_0(),75+(20*i),5,null);
                    break;
                case '1':
                    graphics.drawImage(Textures.ui.getNumber_1(),75+(20*i),5,null);
                    break;
                case '2':
                    graphics.drawImage(Textures.ui.getNumber_2(),75+(20*i),5,null);
                    break;
                case '3':
                    graphics.drawImage(Textures.ui.getNumber_3(),75+(20*i),5,null);
                    break;
                case '4':
                    graphics.drawImage(Textures.ui.getNumber_4(),75+(20*i),5,null);
                    break;
                case '5':
                    graphics.drawImage(Textures.ui.getNumber_5(),75+(20*i),5,null);
                    break;
                case '6':
                    graphics.drawImage(Textures.ui.getNumber_6(),75+(20*i),5,null);
                    break;
                case '7':
                    graphics.drawImage(Textures.ui.getNumber_7(),75+(20*i),5,null);
                    break;
                case '8':
                    graphics.drawImage(Textures.ui.getNumber_8(),75+(20*i),5,null);
                    break;
                case '9':
                    graphics.drawImage(Textures.ui.getNumber_9(),75+(20*i),5,null);
                    break;
            }
        }

    }
}
