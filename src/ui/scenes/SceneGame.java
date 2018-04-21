package ui.scenes;

import javax.swing.*;
import java.awt.*;

public class SceneGame extends JPanel {

    public SceneGame(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(40,110,40,110));
        this.setBackground(Color.GREEN);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Graphics/title_scene_graphic.jpg").getImage(),0,0, this.getSize().width , this.getSize().height, null);
    }

}
