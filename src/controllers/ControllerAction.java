/**
 * Controller action controls and main events to do with button preses and
 * launches relative methods in either logic of ControllerUI
 *
 * @author Wayne Thornberry B00100288
 * @version 1.0
 * @since 27/03/2018
 */

package controllers;

import game.Player;
import javafx.scene.media.AudioClip;
import ui.components.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAction implements ActionListener {

    private Player pUser;
    private Display dUI;
    private ControllerUI cUI;
    private ControllerGame cGame;

    private AudioClip aActionSound;

    public ControllerAction(Display ui, ControllerUI cui, ControllerGame game, Player user){
        System.out.println("Controller Action Running...");
        pUser = user;
        dUI = ui;
        cUI = cui;
        cGame = game;
        aActionSound = new AudioClip("file:audio/Interaction.wav");

        //Scene Title Events
        dUI.sTitle.bUser.addActionListener(this);
        dUI.sTitle.bStartGame.addActionListener(this);
        dUI.sTitle.bOptions.addActionListener(this);
        dUI.sTitle.bQuitGame.addActionListener(this);

        //Debug Menu Events
        dUI.dMenuBar.mSceneTitle.addActionListener(this); // Scene Title Button
        dUI.dMenuBar.mSceneEnd.addActionListener(this); // Scene Game Button
        dUI.dMenuBar.mSceneGame.addActionListener(this); // Scene End Button

        dUI.dMenuBar.mDebugCreateBomb.addActionListener(this); // Debug Load Bomb Button
        dUI.dMenuBar.mDebugCreateLeaderboard.addActionListener(this); // Debug Load Leaderboard Button
        dUI.dMenuBar.mDebugRefreshUI.addActionListener(this); // Debug Refresh UI

        dUI.dMenuBar.mDebugBombSetSticker.addActionListener(this); // Debug Set Sticker
        dUI.dMenuBar.mDebugBombSetTime.addActionListener(this); // Debug Set Time
        dUI.dMenuBar.mDebugBombSetLives.addActionListener(this); // Debug Set Lives

        dUI.dMenuBar.mDebugPlayerSetUserName.addActionListener(this); // Debug Set Username
        dUI.dMenuBar.mDebugPlayerSetScore.addActionListener(this); // Debug Set Score
        dUI.dMenuBar.mDebugPlayerSetPassed.addActionListener(this); // Debug Set Passed
        dUI.dMenuBar.mDebugPlayerSetFailed.addActionListener(this); // Debug Set Failed

        dUI.dMenuBar.mDebugResolutionOne.addActionListener(this); // Debug Set Resolution 800x600
        dUI.dMenuBar.mDebugResolutionTwo.addActionListener(this); // Debug Set Resolution 1280x720
        dUI.dMenuBar.mDebugResolutionThree.addActionListener(this); // Debug Set Resolution 1920x1080

        dUI.dMenuBar.mHelpWireChallenge.addActionListener(this); // Help Wire Challenge Button
        dUI.dMenuBar.mHelpEvenOddChallenge.addActionListener(this); // Help Even Odd Challenge Button
        dUI.dMenuBar.mHelpKeypadChallenge.addActionListener(this); // Help Keypad Challenge Button
        dUI.dMenuBar.mHelpLetterChallenge.addActionListener(this); // Help Letter Challenge Button
        dUI.dMenuBar.mHelpPictureChallenge.addActionListener(this); // Help Picture Challenge Button
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("BUTTON: " + e.getActionCommand() + " PRESSED"); // Find the Button Interacted With

        // DebugBar Commands
        switch (e.getActionCommand()){
            case "Title Scene" : cUI.setScene("0");break;
            case "Game Scene" : cUI.setScene("1"); break;
            case "End Scene" : cUI.setScene("2");break;

            case "Create Bomb" : cGame.loadGame(true); break;
            case "Create Leaderboard" : cGame.loadLeaderboard(true); break;
            case "Refresh UI" : cUI.refreshUI(); break;

            case "Set Sticker Number" : cGame.setSticker(); break;
            case "Set Timer" : cGame.setTimer(); break;
            case "Set Lives" : cGame.setLives(); break;

            case "Set Username" : cGame.setUsername(); break;
            case "Set Score" : cGame.setScore(); break;
            case "Set Passed" : cGame.setPassed(); break;
            case "Set Failed" : cGame.setFailed(); break;

            case "1024x576" : cUI.setResolution(1024,576);break;
            case "1280x720" : cUI.setResolution(1280,720);break;
            case "1920x1080" : cUI.setResolution(1920,1080);break;

            case "Wire Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            case "Keypad Challenge": cUI.helpChallengeInfo("KeypadChallenge"); break;
            case "Letter Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            case "Even Odd Challenge": cUI.helpChallengeInfo("EvenOddChallenge"); break;
            case "Picture Challenge": cUI.helpChallengeInfo("WireChallenge"); break;
            default: System.out.println("Unknown Debug Button");
        }

        // Main Menu Options

        switch (e.getActionCommand()){
            case "Start Game" : cUI.setScene("1"); break;
            case "Options" : cUI.toggleOptionMenu(); break;
            case "Quit Game" : cUI.exitApplication(); break;
            case "Select User" : cUI.toggleUsernameLock(); break;
            case "Edit User" : cUI.toggleUsernameLock(); break;
            default: System.out.println("Unknown Menu Button");
        }

        aActionSound.play();

    }
}
