package gamelogic.challanges;



import gamelogic.bomb.BombSticker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvenOddChallenge extends JPanel implements ActionListener{

    private int iChallengeState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed 3 - Checked Either Failed/Passed
    private JButton bRedButton,bGreenButton;
    public EvenOddChallenge(){
        iChallengeState = 0;
        // Define Any Vars
        // Create Any Events


        bRedButton = new JButton("", new ImageIcon("redbutton.png"));
        bRedButton.setOpaque(false);
        bRedButton.setContentAreaFilled(false);
        bRedButton.setBorderPainted(false);

        bGreenButton = new JButton("", new ImageIcon("greenbutton.png"));
        bGreenButton.setOpaque(false);
        bGreenButton.setContentAreaFilled(false);
        bGreenButton.setBorderPainted(false);

        bRedButton.addActionListener(e->{
                    System.out.println("RED BUTTON PRESSED");
                    if(true )
                    {

                    }
                });

        bGreenButton.addActionListener(e->{
            System.out.println("GREEN BUTTON PRESSED");
        });






        this.setLayout(new GridLayout(0,2));
        this.add(bRedButton);
        this.add(bGreenButton);

    }

    private boolean isCorrect(){
        // Return if your pattern or task is correct
        return true;
    }

    public int getState(){
        //Return the state of challenge
        return iChallengeState;
    }

    public void resetChallenge(){  // Reset the object to its default states allowing to start again, must have this

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
