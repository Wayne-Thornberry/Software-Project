package ui.scenes;

import ui.Bomb;

import javax.swing.*;
import java.awt.*;

public class SceneGame extends JPanel {

    private static BorderLayout bLayout;

    public SceneGame(){
        bLayout = new BorderLayout();
        bLayout.setHgap(50);
        bLayout.setVgap(50);
        this.setLayout(bLayout);
    }

}
