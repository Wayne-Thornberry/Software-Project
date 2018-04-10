package ui.components.bomb;

import javax.swing.*;
import java.awt.*;

public class BombLives extends JPanel {

    private JLabel lLives;
    private int iLives;

    public BombLives(int lives){
        iLives = lives;
        lLives = new JLabel(Integer.toString(lives));
        lLives.setFont(new Font("Arial",0,48));
        this.add(lLives);
    }

    public void setLives(int lives){
        iLives = lives;
        lLives.setText(Integer.toString(iLives));
        lLives.setFont(new Font("Arial",0,48));
    }

    public int getLives(){
        return iLives;
    }
}
