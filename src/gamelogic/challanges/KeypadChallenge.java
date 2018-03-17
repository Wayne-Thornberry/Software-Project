package gamelogic.challanges;

import javax.swing.*;
import java.awt.*;

public class KeypadChallenge extends JPanel{

    private int iChallengeState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed 3 - Checked Either Failed/Passed
    private int iStickerNo;
    public JPanel keypad;
    JTextField textfield = new JTextField(30);


    public KeypadChallenge(){
        iChallengeState = 0;
        iStickerNo = 0;
        textfield.setEditable(false);
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
        });
        Key2.addActionListener(e->{
            textfield.setText(textfield.getText() + "2");
        });
        Key3.addActionListener(e->{
            textfield.setText(textfield.getText() + "3");
        });
        Key4.addActionListener(e->{
            textfield.setText(textfield.getText() + "4");
        });
        Key5.addActionListener(e->{
            textfield.setText(textfield.getText() + "5");
        });
        Key6.addActionListener(e->{
            textfield.setText(textfield.getText() + "6");
        });
        Key7.addActionListener(e->{
            textfield.setText(textfield.getText() + "7");
        });
        Key8.addActionListener(e->{
            textfield.setText(textfield.getText() + "8");
        });
        Key9.addActionListener(e->{
            textfield.setText(textfield.getText() + "9");
        });

        Key0.addActionListener(e->{
            textfield.setText(textfield.getText() + "0");
        });

        KeyClear.addActionListener(e->{
            System.out.println("TEXT CLEARED");
            textfield.setText("");
        });

        KeyEnter.addActionListener(e->{
            System.out.println("TEXT ENTERED");
            if(textfield.getText().equals("2018"))
            {
                System.out.println("CORRECT");
                isCorrect();
            }
        });




    }

    public void setStickerNo(int iNumber){
        iStickerNo = iNumber;
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
