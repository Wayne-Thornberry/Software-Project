package game.challanges;

import javafx.scene.media.AudioClip;

import javax.swing.*;
import java.awt.*;

public class ChallengeKeypad extends Challenge{

    private JLabel lRedLight;
    private JLabel lInputDisplay;
    private JLabel lGreenLight;
    private String lInputText;

    private JButton bKeyOne;
    private JButton bKeyTwo;
    private JButton bKeyThree;
    private JButton bKeyFour;
    private JButton bKeyFive;
    private JButton bKeySix;
    private JButton bKeySeven;
    private JButton bKeyEight;
    private JButton bKeyNine;
    private JButton bKeyZero;
    private JButton bKeyClear;
    private JButton bKeyEnter;

    private AudioClip aInteractSound;

    public ChallengeKeypad(String sticker){
        super(0,sticker, 2);

        this.setLayout(new GridLayout(5,3));
        this.setBorder(BorderFactory.createEtchedBorder());

        lInputText = "";

        lRedLight = new JLabel(new ImageIcon("redbutton.png"));
        lInputDisplay = new JLabel("", SwingConstants.CENTER);
        lGreenLight = new JLabel(new ImageIcon("greenbutton.png"));

        lInputDisplay.setFont(new Font("Arial", 1, 28));

        bKeyOne = new JButton("1");
        bKeyTwo = new JButton("2");
        bKeyThree = new JButton("3");
        bKeyFour = new JButton("4");
        bKeyFive = new JButton("5");
        bKeySix = new JButton("6");
        bKeySeven = new JButton("7");
        bKeyEight = new JButton("8");
        bKeyNine = new JButton("9");
        bKeyZero = new JButton("0");

        bKeyClear = new JButton("Clear");
        bKeyEnter = new JButton("Enter");

        aInteractSound = new AudioClip("file:Audio/Interaction.wav");

        add(lRedLight);
        add(lInputDisplay);
        add(lGreenLight);
        add(bKeyOne);
        add(bKeyTwo);
        add(bKeyThree);
        add(bKeyFour);
        add(bKeyFive);
        add(bKeySix);
        add(bKeySeven);
        add(bKeyEight);
        add(bKeyNine);
        add(bKeyClear);
        add(bKeyZero);
        add(bKeyEnter);

        // Create Any Events

        bKeyOne.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyOne.getText());
            }
            aInteractSound.play();
        });

        bKeyTwo.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyTwo.getText());
            }
            aInteractSound.play();
        });

        bKeyThree.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyThree.getText());
            }
            aInteractSound.play();
        });

        bKeyFour.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyFour.getText());
            }
            aInteractSound.play();
        });

        bKeyFive.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyFive.getText());
            }
            aInteractSound.play();
        });

        bKeySix.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeySix.getText());
            }
            aInteractSound.play();
        });

        bKeySeven.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeySeven.getText());
            }
            aInteractSound.play();
        });

        bKeyEight.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyEight.getText());
            }
            aInteractSound.play();
        });

        bKeyNine.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyNine.getText());
            }
            aInteractSound.play();
        });

        bKeyZero.addActionListener(e->{
            if(getKeyInputLength() != 4 && getiState() == 0) {
                setlInputText(bKeyZero.getText());
            }
            aInteractSound.play();
        });

        bKeyClear.addActionListener(e->{
            aInteractSound.play();
            lInputText = "";
            lInputDisplay.setText("");
        });

        bKeyEnter.addActionListener(e->{
            aInteractSound.play();
            isCorrect();
        });
    }

    private int getKeyInputLength(){
        return lInputText.length();
    }

    private void setlInputText(String sInput){
        lInputText = lInputText + sInput;
        lInputDisplay.setText("<html><div style='color: red;'>" + lInputText + "</div></html>");
    }

    private void isCorrect(){
        if(lInputText.equals("2018")) {
            setiState(1);
            System.out.println("Passed");
        }else {
            setiState(2);
            System.out.println("Failed");
        }
        lInputText = "";
        setlInputText("");
    }
}
