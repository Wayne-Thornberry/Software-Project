package ui.components.bomb;

import javax.swing.*;
import java.awt.*;

public class BombTimer extends JPanel {

    private JLabel lTimer;
    private int iTime;

    public BombTimer(){
        iTime = 300;
        lTimer = new JLabel((iTime / 60) + ":" + String.format("%02d", iTime % 60));
        lTimer.setFont(new Font("Arial",0,70));

        this.setBackground(Color.BLACK);
        lTimer.setForeground(Color.WHITE);

        this.add(lTimer);
    }

    public void resetTimer(){
        iTime = 300;
        lTimer.setText(Integer.toString(iTime / 60)  + ":" +  String.format("%02d", iTime % 60));
    }

    public void setTimer(int time){
        iTime = time;
        lTimer.setText(Integer.toString(iTime / 60)  + ":" +  String.format("%02d", iTime % 60));
    }

    public int getTimer(){
        return iTime;
    }
}
