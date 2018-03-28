package ui.components.bomb;

import javax.swing.*;
import java.awt.*;

public class BombLives extends JPanel {

    private JLabel lLives;
    private int iLives;

    public BombLives(){
        iLives = 3;
        lLives = new JLabel();
        lLives.setFont(new Font("Arial",0,70));

        this.setBackground(Color.BLACK);
        lLives.setForeground(Color.WHITE);

        this.add(lLives);
    }

    public void resetLives(){
        iLives = 3;
        lLives.setText(Integer.toString(iLives));
    }

    public void setLives(int lives){
        iLives = lives;
        lLives.setText(Integer.toString(iLives));
    }

    public int getLives(){
        return iLives;
    }
}
