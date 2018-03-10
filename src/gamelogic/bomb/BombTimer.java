package gamelogic.bomb;

import javax.swing.*;
import java.awt.*;

public class BombTimer extends JPanel {

    private static JLabel lTitle;
    private static Timer tTimer;

    // Primitives
    private static int iTimer;

    public BombTimer(){
        lTitle = new JLabel();
        iTimer = 10;

        this.add(lTitle);
        this.setBackground(Color.BLUE);

        // Events

        tTimer = new Timer(1000, e-> {
            setTimer();
            updateTimerText();
        });
        tTimer.start();
    }

    public static void setTimer(){
        iTimer--;
    }

    public static Timer getTimer(){
        return tTimer;
    }

    private static void updateTimerText(){
        lTitle.setText(Integer.toString(iTimer / 60)  + ":" +  Integer.toString(iTimer % 60));
    }
}
