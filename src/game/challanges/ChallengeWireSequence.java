package game.challanges;

import ui.Bomb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeWireSequence extends JPanel implements ActionListener{


    private Bomb bBomb;

    private JButton bWireOne;
    private JButton bWireTwo;
    private JButton bWireThree;
    private JButton bWireFour;
    private JButton bWireFive;
    private JButton bWireSix;
    private JButton[] bWires;

    private String sSticker;

    private int iState;
    private int iBlackWires;

    public ChallengeWireSequence(Bomb bomb, String sticker){
        bBomb = bomb;
        sSticker = sticker;

        this.setLayout(new GridLayout(6,0));

        bWireOne = new JButton();
        bWireTwo = new JButton();
        bWireThree = new JButton();
        bWireFour = new JButton();
        bWireFive = new JButton();
        bWireSix = new JButton();

        bWires = new JButton[6];
        bWires[0] = bWireOne;
        bWires[1] = bWireTwo;
        bWires[2] = bWireThree;
        bWires[3] = bWireFour;
        bWires[4] = bWireFive;
        bWires[5] = bWireSix;

        this.add(bWireOne);
        this.add(bWireTwo);
        this.add(bWireThree);
        this.add(bWireFour);
        this.add(bWireFive);
        this.add(bWireSix);

        // Events

        bWireOne.addActionListener(this::actionPerformed);
        bWireTwo.addActionListener(this::actionPerformed);
        bWireThree.addActionListener(this::actionPerformed);
        bWireFour.addActionListener(this::actionPerformed);
        bWireFive.addActionListener(this::actionPerformed);
        bWireSix.addActionListener(this::actionPerformed);

        generatePattern();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

    }

    public int getState() {
        return iState;
    }

    public void setState(int state) {
        iState = state;
    }

    private void generatePattern(){
        for(int i=0;i<=sSticker.length()-1;i++) {
            System.out.println(sSticker.charAt(i));
            switch (sSticker.charAt(i)){
                case '0' : setButtonInfo(bWires[i],"Red","wire_red") ;break;
                case '1' : setButtonInfo(bWires[i],"Green","wire_green");break;
                case '2' : setButtonInfo(bWires[i],"Blue","wire_blue");break;
                case '3' : setButtonInfo(bWires[i],"White","wire_white");break;
                case '4' : setButtonInfo(bWires[i],"Black","wire_black");break;
                case '5' : setButtonInfo(bWires[i],"Red","wire_red");break;
                case '6' : setButtonInfo(bWires[i],"Green","wire_green");break;
                case '7' : setButtonInfo(bWires[i],"Blue","wire_blue");break;
                case '8' : setButtonInfo(bWires[i],"White","wire_white");break;
                case '9' : setButtonInfo(bWires[i],"Black","wire_black");break;
            }
        }
    }

    private void setButtonInfo(JButton button, String name, String image){
        button.setText(name);
        button.setIcon(new ImageIcon("Graphics/" + image + ".png"));
    }

    public void resetChallenge(String sticker){
        sSticker = sticker;
        generatePattern();
    }
}
