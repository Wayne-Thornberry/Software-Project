package game.challanges;



import javafx.scene.media.AudioClip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeEvenOdd extends JPanel{
     int iStickerNo;
    private AudioClip aInteractSound;
    private int iChallengeState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed 3 - Checked Either Failed/Passed
    private JButton bRedButton,bGreenButton;

    public ChallengeEvenOdd(String iSticker){

        int iStickerNo = Integer.parseInt(iSticker);
        iChallengeState = 0;
        //String stickerNo = sticker;
        // Define Any Vars
        // Create Any Events
        this.setBorder(BorderFactory.createEtchedBorder());
        aInteractSound = new AudioClip("file:Audio/Interaction.wav");
        bRedButton = new JButton("", new ImageIcon("Graphics/redbutton.png"));
        bRedButton.setOpaque(false);
        bRedButton.setContentAreaFilled(false);
        bRedButton.setBorderPainted(false);

        bGreenButton = new JButton("", new ImageIcon("Graphics/greenbutton.png"));
        bGreenButton.setOpaque(false);
        bGreenButton.setContentAreaFilled(false);
        bGreenButton.setBorderPainted(false);

        bRedButton.addActionListener(e->{
                    System.out.println("RED BUTTON PRESSED: " + iStickerNo);
                     aInteractSound.play();
                    if((iStickerNo % 2 == 0))
                    {
                        System.out.println("STICKER IS EVEN");
                        System.out.println("CORRECT!");
                        setState(1);
                    }
                    else
                    {
                        System.out.println("FAILED!");
                        setState(2);
                    }
                });



        bGreenButton.addActionListener(e->{
            System.out.println("GREEN BUTTON PRESSED: "  + iStickerNo);
            aInteractSound.play();
            if((iStickerNo % 2 == 1))
            {
                System.out.println("STICKER IS ODD");
                System.out.println("CORRECT!");
                setState(1);
            }
            else
            {
                System.out.println("FAILED!");
                setState(2);
            }
        });






        this.setLayout(new GridLayout(0,2));
        this.add(bRedButton);
        this.add(bGreenButton);

    }

    private boolean isCorrect(){
        // Return if your pattern or task is correct
        return true;
    }

    public void resetChallenge(){  // Reset the object to its default states allowing to start again, must have this

    }

    public int getState(){
        return iChallengeState;
    }

    public void setState(int state) {
        iChallengeState = state;
    }
}
