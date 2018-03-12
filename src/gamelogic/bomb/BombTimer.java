package gamelogic.bomb;

import javax.swing.*;
import java.awt.*;

public class BombTimer extends JPanel {

    private JLabel lTimer;
    public Timer tTimer;

    // Primitives
    private int iTime;
    private int iDelay;

    public BombTimer(){
        lTimer = new JLabel();
        iTime = 1000;
        iDelay = 1000;
        System.out.println(this.getMinimumSize().height);
        lTimer.setFont(new Font("Arial",0,72));

        this.add(lTimer);
        this.setBackground(Color.BLUE);

        // Events

        tTimer = new Timer(iDelay, e-> {
            iTime--;
            lTimer.setText(Integer.toString(iTime / 60)  + ":" +  Integer.toString(iTime % 60));
        });

        tTimer.start();
    }

    public void decreaseTimer(){
        iDelay = iDelay / 2;
        tTimer.setDelay(iDelay);
    }

    public void resetTimer(){
        iTime = 1000;
        iDelay = 1000;
        tTimer.setDelay(iDelay);
        lTimer.setText(Integer.toString(iTime / 60)  + ":" +  Integer.toString(iTime % 60));
    }
}
