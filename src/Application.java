/**
 * The main application that controlls most if not all the events in the program, besides
 * declaring and creating a structure. This houses nothing of real importance
 *
 * @author Wayne Thornberry B00100288
 * @version 2.0
 * @since 27/03/2018
 */

import controllers.*;
import gamelogic.Player;
import ui.Display;

public class Application{

    private static Display dUI;
    private static Player pUser;

    private static ControllerLogic cLogic;
    private static ControllerAction cAction;
    private static ControllerUI cUI;
    private static ControllerInput cInput;
    private static ControllerDatabase cDatabase;

    public static void main(String ARGS[]){ // Main Controller

        dUI = new Display();
        pUser = new Player(null, 0,0,0,0,0);

        cDatabase = new ControllerDatabase(pUser); // Controls the database, login, stats etc
        cLogic = new ControllerLogic(dUI, pUser); // Controls the game information, what challenge gets displayed. play info etc..
        cUI = new ControllerUI(cLogic, dUI, pUser); // Controls the display of the game, including the JFrame and panels that get displayed
        cAction = new ControllerAction(cUI, cLogic); // Controls All Events for buttons within the game
        cInput = new ControllerInput(cUI, cLogic); // Controls all inputs received by the keyboard

        dUI.addKeyListener(cInput); // This User Interface needs to listen out for key inputs

        // Listen out for scene changes
        dUI.sTitle.addComponentListener(cUI); // Scene = 0
        dUI.sGame.addComponentListener(cUI); // Scene = 1
        dUI.sEnd.addComponentListener(cUI); // Scene = 2

        //Listen out for menu inputs
        dUI.dMenuBar.mSceneTitle.addActionListener(cAction); // Scene Title Button
        dUI.dMenuBar.mSceneEnd.addActionListener(cAction); // Scene Game Button
        dUI.dMenuBar.mSceneGame.addActionListener(cAction); // Scene End Button

        dUI.dMenuBar.mDebugLoadBomb.addActionListener(cAction); // Debug Load Bomb Button
        dUI.dMenuBar.mDebugResetBomb.addActionListener(cAction); // Debug Reset Bomb Button
        dUI.dMenuBar.mDebugLoadLeaderboard.addActionListener(cAction); // Debug Load Leaderboard Button

        dUI.dMenuBar.mHelpWireChallenge.addActionListener(cAction); // Help Wire Challenge Button
        dUI.dMenuBar.mHelpEvenOddChallenge.addActionListener(cAction); // Help Even Odd Challenge Button
        dUI.dMenuBar.mHelpKeypadChallenge.addActionListener(cAction); // Help Keypad Challenge Button
        dUI.dMenuBar.mHelpLetterChallenge.addActionListener(cAction); // Help Letter Challenge Button
        dUI.dMenuBar.mHelpPictureChallenge.addActionListener(cAction); // Help Picture Challenge Button

        System.out.println("Application Running...");
    }
}
