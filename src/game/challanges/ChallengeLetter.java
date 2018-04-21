
package game.challanges;
import javafx.scene.media.AudioClip;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class ChallengeLetter extends Challenge implements ActionListener {

    private AudioClip aInteractSound;
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";//random characters that loop will pick from
    private int StringSize = 5;//amount of random char

    private String sRandom;
    private JLabel lString;
    private JTextField tInput;

    private JButton bSubmit;
    private JButton bReset;

    public ChallengeLetter(String sticker) {
        super(0,sticker,3);

        sRandom = RandomStringToBeGenerated();
        lString = new JLabel(sRandom);
        tInput = new JTextField();

        aInteractSound = new AudioClip("file:audio/Interaction.wav");
        aInteractSound.setVolume(0.05);

        bSubmit = new JButton("Submit");
        bSubmit.addActionListener(this);
        bSubmit.setActionCommand("Submit");

        bReset = new JButton("Reset");
        bReset.addActionListener(this);
        bReset.setActionCommand("Reset");

        this.setLayout(new GridLayout(2,2));
        this.add(lString);
        this.add(tInput);
        this.add(bReset);
        this.add(bSubmit);
    }

    //generates random string
    public  String RandomStringToBeGenerated(){

        StringBuffer rand = new StringBuffer();
        for(int i=0; i<StringSize; i++){
            int number = getRandom();
            char ch = characters.charAt(number);
            rand.append(ch);
        }

        return rand.toString();

    }

    private int getRandom() {
        int randomInt = 0;
        Random Generator = new Random();
        randomInt = Generator.nextInt(characters.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Submit")){
            if (tInput.getText().equals(sRandom)) {
                setiState(1);
            }else{
                setiState(2);
            }
        }else{
            tInput.setText("");
        }
    }
}
