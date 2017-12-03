package code.views;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Cutscene extends View{

    @Override
    public BufferedImage getImage(boolean debugging) {

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB );



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
