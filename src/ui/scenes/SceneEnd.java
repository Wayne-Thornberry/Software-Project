package ui.scenes;

import javax.swing.*;
import java.awt.*;

public class SceneEnd extends JPanel {

    public SceneEnd(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(40,110,40,110));
        this.setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Graphics/end_scene_graphic.jpg").getImage(),0,0, this.getSize().width , this.getSize().height, null);
    }
}

