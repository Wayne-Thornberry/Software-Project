package gamelogic.challanges;

import javafx.scene.media.AudioClip;

import javax.swing.*;
import java.awt.*;

public class KeypadChallenge extends JPanel{

    private int iChallengeState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed 3 - Checked Either Failed/Passed
    int iStickerNo;
    public JPanel keypad;
    JTextField textfield = new JTextField(30);
    private AudioClip aInteractSound;

    public KeypadChallenge(){
        iChallengeState = 0;
        //iStickerNo = 0;
        textfield.setEditable(false);
        aInteractSound = new AudioClip("file:Interaction.wav");

        this.setLayout(new GridLayout(5,3));
        //keypad.setLayout(new GridLayout(4,3));
        JButton Key1 = new JButton("1");
        JButton Key2 = new JButton("2");
        JButton Key3 = new JButton("3");
        JButton Key4 = new JButton("4");
        JButton Key5 = new JButton("5");
        JButton Key6 = new JButton("6");
        JButton Key7 = new JButton("7");
        JButton Key8 = new JButton("8");
        JButton Key9 = new JButton("9");
        JButton Key0 = new JButton("0");
        JButton KeyClear = new JButton("Clear");
        JButton KeyEnter = new JButton("Enter");
        add(textfield, BorderLayout.NORTH);
        add(new JButton());
        add(new JButton());
        add(Key1);
        add(Key2);
        add(Key3);
        add(Key4);
        add(Key5);
        add(Key6);
        add(Key7);
        add(Key8);
        add(Key9);
        add(KeyClear);
        add(Key0);
        add(KeyEnter);

        // Define Any Vars
        // Create Any Events

        Key1.addActionListener(e->{
            textfield.setText(textfield.getText() + "1");
            aInteractSound.play();
        });
        Key2.addActionListener(e->{
            textfield.setText(textfield.getText() + "2");
            aInteractSound.play();
        });
        Key3.addActionListener(e->{
            textfield.setText(textfield.getText() + "3");
            aInteractSound.play();
        });
        Key4.addActionListener(e->{
            textfield.setText(textfield.getText() + "4");
            aInteractSound.play();
        });
        Key5.addActionListener(e->{
            textfield.setText(textfield.getText() + "5");
            aInteractSound.play();
        });
        Key6.addActionListener(e->{
            textfield.setText(textfield.getText() + "6");
            aInteractSound.play();
        });
        Key7.addActionListener(e->{
            textfield.setText(textfield.getText() + "7");
            aInteractSound.play();
        });
        Key8.addActionListener(e->{
            textfield.setText(textfield.getText() + "8");
            aInteractSound.play();
        });
        Key9.addActionListener(e->{
            textfield.setText(textfield.getText() + "9");
            aInteractSound.play();
        });

        Key0.addActionListener(e->{
            textfield.setText(textfield.getText() + "0");
            aInteractSound.play();
        });

        KeyClear.addActionListener(e->{
            System.out.println("TEXT CLEARED");
            aInteractSound.play();
            textfield.setText("");
        });

        KeyEnter.addActionListener(e->{
            System.out.println("TEXT ENTERED");
            aInteractSound.play();
            if(textfield.getText().equals("2018"))
            {
                textfield.setText("CORRECT!");
                System.out.println("CORRECT");
                iChallengeState = 1;


            }
        });




    }

    public void setStickerNo(int iNumber){
        this.iStickerNo = iNumber;
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
}
