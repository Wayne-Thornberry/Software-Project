package game.challanges;

import javafx.scene.media.AudioClip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeWire extends Challenge implements ActionListener {

    private JButton[] bWires;
    private String[] sWires;
    private int[] iWires;
    private AudioClip aInteractSound;

    public ChallengeWire(String sticker){
        super(0,sticker, 4);
        bWires = new JButton[getiStickerNo().length()];
        sWires = new String[getiStickerNo().length()];
        iWires = new int[3];
        this.setLayout(new GridLayout(bWires.length,0));
        aInteractSound = new AudioClip("file:audio/Interaction.wav");
        aInteractSound.setVolume(0.05);

        for (int i = 0; i < bWires.length; i++) {
            switch (getiStickerNo().charAt(i)){
                case '0' : setWire("wire_red",i);   iWires[0]++;break;
                case '1' : setWire("wire_green",i); iWires[1]++;break;
                case '2' : setWire("wire_blue",i);  iWires[2]++;break;
                case '3' : setWire("wire_red",i);   iWires[0]++;break;
                case '4' : setWire("wire_green",i); iWires[1]++;break;
                case '5' : setWire("wire_blue",i);  iWires[2]++;break;
                case '6' : setWire("wire_red",i);   iWires[0]++;break;
                case '7' : setWire("wire_green",i); iWires[1]++;break;
                case '8' : setWire("wire_blue",i);  iWires[2]++;break;
                case '9' : setWire("wire_red",i);   iWires[0]++;break;
            }
        }
    }

    private void setWire(String name, int i) {
        sWires[i] = name;
        bWires[i] = new JButton();
        bWires[i].setIcon(new ImageIcon("Graphics/" + name + ".png"));
        bWires[i].setName(name);
        bWires[i].setActionCommand(String.valueOf(i));
        bWires[i].addActionListener(this);
        bWires[i].setBorder(null);
        bWires[i].setFocusable(false);
        bWires[i].setBackground(Color.WHITE);
        bWires[i].setOpaque(false);
        this.add(bWires[i]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cutWire(Integer.parseInt(e.getActionCommand()));
    }

    private void cutWire(int i) {
        bWires[i].setIcon(new ImageIcon("Graphics/" + bWires[i].getName() + "_cut.png"));
        bWires[i].removeActionListener(this);
        System.out.println(bWires[i].getName());
        aInteractSound.play();
        switch (bWires[i].getName()){
            case "wire_red" : checkWire(iWires[0]--); break;
            case "wire_green" : checkWire(iWires[1]--);break;
            case "wire_blue" : checkWire(iWires[2]--);break;
        }
    }

    private void checkWire(int wireAmount) {
        for(int i = 0; i < iWires.length; i++ ){
            System.out.println(wireAmount + " " + iWires[i]);
            if(wireAmount < iWires[i]){
                setiState(2);
                System.out.println("Failed");
                // Failed because the amount of wires in that set is less than the other two wires
            }
        }

        if(iWires[0] + iWires[1] + iWires[2] == 0){
            setiState(1);
            System.out.println("No More Wires");
        }

    }
}
