package gamelogic.challanges;

import javax.swing.*;
import java.awt.*;

public class Wire_Challenge extends JPanel {

    private static JButton bWireOne;
    private static JButton bWireTwo;
    private static JButton bWireThree;
    private static JButton bWireFour;
    private static JButton bWireFive;

    private static boolean bIsWireOneCut;
    private static boolean bIsWireTwoCut;
    private static boolean bIsWireThreeCut;
    private static boolean bIsWireFourCut;
    private static boolean bIsWireFiveCut;

    private static int iChallangeState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed

    private static int iButtonOrder[] = {
            2, // First Button Order 3st
            4, // Second Button Order 5nd
            1, // Third Button Order 2rd
            0, // Fourth Button Order 1th
            3  // Fifth Button Order 4th
    };

    private static int iSequence;

    public Wire_Challenge(){
        this.setBackground(Color.LIGHT_GRAY);

        bIsWireOneCut = false;
        bIsWireTwoCut = false;
        bIsWireThreeCut = false;
        bIsWireFourCut = false;
        bIsWireFiveCut = false;

        iChallangeState = 0;
        iSequence = 0;

        bWireOne = new JButton("One", new ImageIcon("wire_black.png"));
        bWireOne.setOpaque(false);
        bWireOne.setContentAreaFilled(false);
        bWireOne.setBorderPainted(false);

        bWireTwo = new JButton("Two", new ImageIcon("wire_white.png"));
        bWireTwo.setOpaque(false);
        bWireTwo.setContentAreaFilled(false);
        bWireTwo.setBorderPainted(false);

        bWireThree = new JButton("Three", new ImageIcon("wire_red.png"));
        bWireThree.setOpaque(false);
        bWireThree.setContentAreaFilled(false);
        bWireThree.setBorderPainted(false);

        bWireFour = new JButton("Four", new ImageIcon("wire_green.png"));
        bWireFour.setOpaque(false);
        bWireFour.setContentAreaFilled(false);
        bWireFour.setBorderPainted(false);

        bWireFive = new JButton("Five", new ImageIcon("wire_blue.png"));
        bWireFive.setOpaque(false);
        bWireFive.setContentAreaFilled(false);
        bWireFive.setBorderPainted(false);

        bWireOne.addActionListener(e->{
            if(!bIsWireOneCut && iChallangeState != 2) {
                bIsWireOneCut = true;
                System.out.println(bWireOne.getText() + " Is Cut " + bIsWireOneCut);
                bWireOne.setIcon(new ImageIcon("wire_black_cut.png"));
                if (isCorrct(bWireOne.getText())) {
                    iSequence++;
                    System.out.println("CORRECT");
                    System.out.println(iSequence);
                } else {
                    System.out.println("INCORRECT");
                    iChallangeState = 2; // Failed Challenge
                }
            }else {
                System.out.println("Wire has been cut already or the challenge has failed");
            }
        });

        bWireTwo.addActionListener(e->{
            if(!bIsWireTwoCut && iChallangeState != 2) {
                bIsWireTwoCut = true;
                System.out.println(bWireTwo.getText() + " Is Cut " + bIsWireTwoCut);
                bWireTwo.setIcon(new ImageIcon("wire_red_cut.png"));
                if (isCorrct(bWireOne.getText())) {
                    iSequence++;
                    System.out.println("CORRECT");
                    System.out.println(iSequence);
                } else {
                    System.out.println("INCORRECT");
                    iChallangeState = 2; // Failed Challenge
                }
            }else {
                System.out.println("Wire has been cut already or the challenge has failed");
            }
        });

        bWireThree.addActionListener(e->{
            if(!bIsWireThreeCut && iChallangeState != 2) {
                bIsWireThreeCut = true;
                System.out.println(bWireThree.getText() + " Is Cut " + bIsWireThreeCut);
                bWireThree.setIcon(new ImageIcon("wire_red_cut.png"));
                if (isCorrct(bWireThree.getText())) {
                    iSequence++;
                    System.out.println("CORRECT");
                    System.out.println(iSequence);
                } else {
                    System.out.println("INCORRECT");
                    iChallangeState = 2; // Failed Challenge
                }
            }else {
                System.out.println("Wire has been cut already or the challenge has failed");
            }
        });

        bWireFour.addActionListener(e->{
            if(!bIsWireFourCut && iChallangeState != 2) {
                bIsWireFourCut = true;
                System.out.println(bWireFour.getText() + " Is Cut " + bIsWireFourCut);
                bWireFour.setIcon(new ImageIcon("wire_green_cut.png"));
                if (isCorrct(bWireFour.getText())) {
                    iSequence++;
                    System.out.println("CORRECT");
                    System.out.println(iSequence);
                } else {
                    System.out.println("INCORRECT");
                    iChallangeState = 2; // Failed Challenge
                }
            }else {
                System.out.println("Wire has been cut already or the challenge has failed");
            }
        });

        bWireFive.addActionListener(e->{
            if(!bIsWireFiveCut && iChallangeState != 2) {
                bIsWireFiveCut = true;
                System.out.println(bWireFive.getText() + " Is Cut " + bIsWireFiveCut);
                bWireFive.setIcon(new ImageIcon("wire_blue_cut.png"));
                if (isCorrct(bWireFive.getText())) {
                    iSequence++;
                    System.out.println("CORRECT");
                    System.out.println(iSequence);
                } else {
                    System.out.println("INCORRECT");
                    iChallangeState = 2; // Failed Challenge
                }
            }else {
                System.out.println("Wire has been cut already or the challenge has failed");
            }
        });


        this.setLayout(new GridLayout(5,0));

        this.add(bWireOne);
        this.add(bWireTwo);
        this.add(bWireThree);
        this.add(bWireFour);
        this.add(bWireFive);
    }

    private static boolean isCorrct(String bText){
        switch (bText){
            case "One" : return iButtonOrder[0] == iSequence;
            case "Two" : return iButtonOrder[1] == iSequence;
            case "Three" : return iButtonOrder[2] == iSequence;
            case "Four" : return iButtonOrder[3] == iSequence;
            case "Five" : return iButtonOrder[4] == iSequence;
            default: return false ;
        }
    }

    public static void resetChallange(){
        bIsWireOneCut = false;
        bIsWireTwoCut = false;
        bIsWireThreeCut = false;
        bIsWireFourCut = false;
        bIsWireFiveCut = false;

        iChallangeState = 0;
        iSequence = 0;

        bWireOne.setIcon(new ImageIcon("wire_black.png"));
        bWireTwo.setIcon(new ImageIcon("wire_white.png"));
        bWireThree.setIcon(new ImageIcon("wire_red.png"));
        bWireFour.setIcon(new ImageIcon("wire_green.png"));
        bWireFive.setIcon(new ImageIcon("wire_blue.png"));
    }
}
