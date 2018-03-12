package gamelogic.bomb;

import javax.swing.*;
import java.awt.*;

public class BombLives extends JPanel {

    private static JLabel lLives;

    private static int iLives;

    public BombLives(){

        iLives = 3;
        lLives = new JLabel(Integer.toString(iLives));
        lLives.setFont(new Font("Arial",0,72));

        this.add(lLives);
        this.setPreferredSize(this.getPreferredSize());
        this.setBackground(Color.RED);
    }
}
