package game.challanges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeWire extends JPanel implements ActionListener {

    private String sSticker;
    private JButton[] bWires;
    private JButton[] bWireO;

    private int numWires[];

    public ChallengeWire(String sticker){
        sSticker = sticker;
        numWires = new int[5];

        this.setLayout(new GridLayout(5,0));

        generateProblem();
        System.out.println((numWires[0] + " " + numWires[1]  + " " + numWires[2] + " " + numWires[3] + " " + numWires[4]));
    }


    private void generateProblem(){
        bWires = new JButton[5];
        for (int i = 0; i < bWires.length; i++) {
            switch (sSticker.charAt(i)){
                case '0' : setWire("wire_red",i);break;
                case '1' : setWire("wire_green",i);break;
                case '2' : setWire("wire_blue",i);break;
                case '3' : setWire("wire_white",i);break;
                case '4' : setWire("wire_black",i);break;
                case '5' : setWire("wire_red",i);break;
                case '6' : setWire("wire_green",i);break;
                case '7' : setWire("wire_blue",i);break;
                case '8' : setWire("wire_white",i);break;
                case '9' : setWire("wire_black",i);break;
            }
        }
    }

    private void setWire(String name, int i) {
        bWires[i] = new JButton();
        bWires[i].setIcon(new ImageIcon("Graphics/" + name + ".png"));
        bWires[i].setName(name);
        bWires[i].setActionCommand(String.valueOf(i));
        bWires[i].addActionListener(this);
        bWires[i].setBorder(null);
        bWires[i].setBackground(Color.WHITE);
        bWires[i].setOpaque(false);
        this.add(bWires[i]);
    }

    private void generateSolution(int i) {
        if (i == 0){

        }else{

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        cutWire(Integer.parseInt(e.getActionCommand()));
    }

    private void cutWire(int i) {
        System.out.println(bWires[i].getName());
        bWires[i].setIcon(new ImageIcon("Graphics/" + bWires[i].getName() + "_cut.png"));
        System.out.println("test");
    }
}
