package gamelogic.bomb;

import javax.swing.*;
import java.awt.*;

public class BombTimer extends JPanel {

    private static JLabel lTimer;
    private static Timer tTimer;

    // Primitives
    private static int iTimer;

    public BombTimer(){
        lTimer = new JLabel();
        iTimer = 1000;
        System.out.println(this.getMinimumSize().height);
        lTimer.setFont(new Font("Arial",0,72));

        this.add(lTimer);
        this.setBackground(Color.BLUE);

        // Events

        tTimer = new Timer(1000, e-> {
            System.out.println("Test");
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
        lTimer.setText(Integer.toString(iTimer / 60)  + ":" +  Integer.toString(iTimer % 60));
    }
}
