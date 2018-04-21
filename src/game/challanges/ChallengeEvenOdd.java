package game.challanges;

import javafx.scene.media.AudioClip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeEvenOdd extends Challenge implements ActionListener {
    private AudioClip aInteractSound;
    private JButton bRedButton,bGreenButton;

    public ChallengeEvenOdd(String sticker){
        super(0,sticker, 3);
        aInteractSound = new AudioClip("file:Audio/Interaction.wav");

        bRedButton = new JButton("", new ImageIcon("graphics/redbutton.png"));
        bRedButton.setOpaque(false);
        bRedButton.setContentAreaFilled(false);
        bRedButton.setFocusable(false);
        bRedButton.setBorder(BorderFactory.createEmptyBorder());

        bGreenButton = new JButton("", new ImageIcon("graphics/greenbutton.png"));
        bGreenButton.setOpaque(false);
        bGreenButton.setContentAreaFilled(false);
        bGreenButton.setFocusable(false);
        bGreenButton.setBorder(BorderFactory.createEmptyBorder());

        bRedButton.addActionListener(this);
        bRedButton.setActionCommand("button_red");
        bGreenButton.addActionListener(this);
        bGreenButton.setActionCommand("button_green");

        this.setLayout(new GridLayout(0,2));
        this.add(bRedButton);
        this.add(bGreenButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aInteractSound.play();
        if(Integer.parseInt(getiStickerNo()) % 2 == 0){
            if(e.getActionCommand() == "button_green"){
                System.out.println("Button green pressed and the number was even so correct");
                setiState(1);
            }else{
                System.out.println("Button red pressed but the number was even so incorrect");
                setiState(2);
            }
        }else{
            if(e.getActionCommand() == "button_red"){
                System.out.println("Button red pressed and the number was odd so correct");
                setiState(1);
            }else{
                System.out.println("Button green pressed but the number was odd so incorrect");
                setiState(2);
            }
        }
        bGreenButton.removeActionListener(this);
        bRedButton.removeActionListener(this);
    }
}
