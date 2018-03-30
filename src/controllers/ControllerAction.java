/**
 * Controller action controls and main events to do with button preses and
 * launches relative methods in either logic of ControllerUI
 *
 * @author Wayne Thornberry B00100288
 * @version 1.0
 * @since 27/03/2018
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAction implements ActionListener {

    private ControllerUI cUI;
    private ControllerGame cGame;

    public ControllerAction(ControllerUI ui, ControllerGame game){
        System.out.println("Controller Action Running...");
        cUI = ui;
        cGame = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("BUTTON: " + e.getActionCommand() + " PRESSED"); // Find the Button Interacted With

        switch (e.getActionCommand()){
            case "Title Scene" : cUI.setScene("0");break;
            case "Game Scene" : cUI.setScene("1"); break;
            case "End Scene" : cUI.setScene("2");break;
            case "Reset Bomb" : cGame.resetController(); break;
            case "Wire Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            case "Keypad Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            case "Letter Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            case "OddEven Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            case "Picture Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            default: System.out.println("Unknown Button");
        }
    }
}
