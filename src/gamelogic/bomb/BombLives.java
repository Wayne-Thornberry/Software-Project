package gamelogic.bomb;

import javax.swing.*;
import java.awt.*;

public class BombLives extends JPanel {

    private JLabel lLives;

    private int iLives;

    public BombLives(){

        iLives = 3;
        lLives = new JLabel(Integer.toString(iLives));
        lLives.setFont(new Font("Arial",0,72));

        this.add(lLives);
        this.setPreferredSize(this.getPreferredSize());
        this.setBackground(Color.RED);
    }

    public int getLives(){
        return iLives;
    }

    public void decreaseLives(){
        if(iLives > 0) {
            iLives--;
            lLives.setText(Integer.toString(iLives));
        }
    }

    public void resetLives(){
        iLives = 3;
        lLives.setText(Integer.toString(iLives));
    }
}
