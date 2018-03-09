package gamelogic;

import javax.swing.*;
import java.awt.*;

public class Timer extends JPanel {

    private static JLabel lTitle;

    public Timer(){

        lTitle = new JLabel();
        lTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(lTitle);
        this.setBackground(Color.BLUE);
    }
}
