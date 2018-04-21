package game.challanges;

import javafx.scene.media.AudioClip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeKeypad extends Challenge implements ActionListener {

    private JButton[] bKeyButtons;
    private JPanel lRedLight;
    private JLabel lInputDisplay;
    private JPanel lGreenLight;
    private String lInputText;
    private String sAwnser;
    private AudioClip aInteractSound;

    public ChallengeKeypad(String sticker){
        super(0,sticker, 2);

        this.setLayout(new GridLayout(5,3, 2,2));

        String stickerArray[] = sticker.split("");
        sAwnser = stickerArray[5] + stickerArray[4] + stickerArray[3] + stickerArray[2];

        lInputText = "";
        lGreenLight = new JPanel();
        lGreenLight.setBackground(Color.GRAY);

        lRedLight = new JPanel();
        lRedLight.setBackground(Color.GRAY);

        bKeyButtons = new JButton[12];

        lInputDisplay = new JLabel("", SwingConstants.CENTER);
        lInputDisplay.setBackground(Color.WHITE);
        lInputDisplay.setFont(new Font("Arial", 1, 28));

        aInteractSound = new AudioClip("file:audio/Interaction.wav");
        aInteractSound.setVolume(0.05);


        add(lRedLight);
        add(lInputDisplay);
        add(lGreenLight);

        for(int i=0;i<12;i++){
            if(i == 9) {
                bKeyButtons[i] = new JButton("Clear");
                bKeyButtons[i].setActionCommand("Clear");
                bKeyButtons[i].setBackground(Color.RED);
                bKeyButtons[i].setForeground(Color.WHITE);
            }else if(i == 10){
                bKeyButtons[i] = new JButton("0");
                bKeyButtons[i].setActionCommand("0");
                bKeyButtons[i].setBackground(Color.LIGHT_GRAY);
            } else if (i == 11) {
                bKeyButtons[i] = new JButton("Enter");
                bKeyButtons[i].setActionCommand("Enter");
                bKeyButtons[i].setBackground(new Color(0x007B11));
                bKeyButtons[i].setForeground(Color.WHITE);
            } else {
                bKeyButtons[i] = new JButton(String.valueOf(i + 1));
                bKeyButtons[i].setActionCommand(String.valueOf(i + 1));
                bKeyButtons[i].setBackground(Color.LIGHT_GRAY);
            }
            bKeyButtons[i].setFont(new Font("Arial", 1, 28));
            bKeyButtons[i].setBorder(BorderFactory.createEmptyBorder());
            bKeyButtons[i].addActionListener(this);
            this.add(bKeyButtons[i]);
        }

    }

    private int getKeyInputLength(){
        return lInputText.length();
    }

    private void setlInputText(String sInput){
        lInputText = lInputText + sInput;
        lInputDisplay.setText("<html><div style='color: Black;'>" + lInputText + "</div></html>");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aInteractSound.play();
        if(e.getActionCommand() == "Clear"){
            lInputText = "";
            lInputDisplay.setText("");
        }else if(e.getActionCommand() == "Enter"){
            if(lInputText.equals(sAwnser)) {
                setiState(1);
                System.out.println("Passed");
                lGreenLight.setBackground(new Color(0x007B11));
                lRedLight.setBackground(Color.GRAY);
                bKeyButtons[11].removeActionListener(this);
            }else {
                setiState(2);
                System.out.println("Failed");
                lGreenLight.setBackground(Color.GRAY);
                lRedLight.setBackground(Color.RED);
            }
            lInputText = "";
            setlInputText("");
        }else {
            if(getKeyInputLength() < 4) {
                setlInputText(e.getActionCommand());
            }
        }
    }
}
