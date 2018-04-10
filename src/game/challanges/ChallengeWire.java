package game.challanges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChallengeWire extends JPanel implements ActionListener {

    private String sSticker;
    private JButton[] bWires;

    public ChallengeWire(String sticker){
        sSticker = sticker;

        this.setLayout(new GridLayout(5,0));

        generateProblem();
        generateSolution();
    }


    private void generateProblem(){
        bWires = new JButton[5];
        for (int i = 0; i < bWires.length; i++) {
            switch (sSticker.charAt(i)){
                case '0' : setWire("wire_red"   ,i) ;break;
                case '1' : setWire("wire_green" ,i) ;break;
                case '2' : setWire("wire_blue"  ,i) ;break;
                case '3' : setWire("wire_white" ,i) ;break;
                case '4' : setWire("wire_black" ,i) ;break;
                case '5' : setWire("wire_red"   ,i) ;break;
                case '6' : setWire("wire_green" ,i) ;break;
                case '7' : setWire("wire_blue"  ,i) ;break;
                case '8' : setWire("wire_white" ,i) ;break;
                case '9' : setWire("wire_black" ,i) ;break;
            }
        }
    }

    private void setWire(String name, int i) {
        bWires[i] = new JButton();
        bWires[i].setIcon(new ImageIcon("Graphics/" + name + ".png"));
        bWires[i].setName(name);
        bWires[i].setActionCommand(String.valueOf(i));
        bWires[i].addActionListener(this);
        this.add(bWires[i]);
    }

    private void generateSolution() {

    }

    /*public void resetChallenge(String sticker){
        sSticker = sticker;
        for (int i = 0; i < bWires.length; i++) {
            this.remove(bWires[i]);
        }
        this.revalidate();
        this.repaint();
        generateProblem();
        generateSolution();
    }*/

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

    /*

        for (int i = 0; i < bWires.length; i++) {
            bWires[i] = new JButton();
            bWires[i].addActionListener(this);
            bWires[i].setActionCommand(String.valueOf(i));
            bWires[i].setFocusable(false);
            bWires[i].setBorder(null);
            bWires[i].setBackground(Color.WHITE);
            bWires[i].setOpaque(false);
            this.add(bWires[i]);
        }
     */
}
