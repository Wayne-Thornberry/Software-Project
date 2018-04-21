package ui.components.bomb;

import javax.swing.*;
import java.awt.*;

public class BombTimer extends JPanel {

    private JLabel lTimer;
    private int iTime;

    public BombTimer(int seconds){
        iTime = seconds;
        lTimer = new JLabel((iTime / 60) + ":" + String.format("%02d", iTime % 60));
        lTimer.setFont(new Font("Arial",0,48));

        this.setOpaque(false);
        this.add(lTimer);
    }

    public void setTimer(int time){
        iTime = time;
        lTimer.setText(Integer.toString(iTime / 60)  + ":" +  String.format("%02d", iTime % 60));
        lTimer.setFont(new Font("Arial",0,48));
    }

    public int getTimer(){
        return iTime;
    }
}
