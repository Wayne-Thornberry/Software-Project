/**
 * The main application that controls most if not all the events in the program, besides
 * declaring and creating a structure. This houses nothing of real importance
 *
 * @author Wayne Thornberry B00100288
 * @version 2.0
 * @since 27/03/2018
 */

import controllers.*;
import game.Player;
import game.Progress;
import ui.components.Display;

public class Application{

    private static Display dUI;
    private static Player pUser;

    private static ControllerGame cGame;
    private static ControllerAction cAction;
    private static ControllerUI cUI;
    private static ControllerInput cInput;
    private static ControllerDatabase cDatabase;


    public static void main(String ARGS[]){ // Main Controller

        dUI = new Display(); // Main display
        pUser = new Player(null, 0,0,0,0,0); // Creates a new saved player that updates throughout the game

        cDatabase = new ControllerDatabase(pUser); // Controls the database, login, stats etc
        cGame = new ControllerGame(dUI, pUser, cDatabase); // Controls the game information, what challenge gets displayed. play info etc..
        cUI = new ControllerUI(cGame, dUI, pUser); // Controls the display of the game, including the JFrame and panels that get displayed
        cAction = new ControllerAction(dUI, cUI, cGame, pUser); // Controls All Events for buttons within the game
        cInput = new ControllerInput(dUI, cUI, cGame, pUser); // Controls all inputs received by the keyboard

        System.out.println("Application Running...");
    }
}
