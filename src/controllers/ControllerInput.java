/**
 * Controller input is a smaller controller but cant play an important role if the user wishes to use the keyboard.
 * This class receives keyboard and mouse input and can run many methods in the UI or Logic Controller
 *
 * @author Wayne Thornberry B00100288
 * @version 1.0
 * @since 27/03/2018
 */

package controllers;

import game.Player;
import ui.components.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerInput implements KeyListener {

    private Player pUser;
    private Display dUI;
    private ControllerUI cUI;
    private ControllerGame cGame;

    public ControllerInput(Display ui, ControllerUI cui, ControllerGame game, Player user){
        System.out.println("Controller Input Running...");
        pUser = user;
        dUI = ui;
        cUI = cui;
        cGame = game;

        dUI.addKeyListener(this); // This User Interface needs to listen out for key inputs
        dUI.sTitle.tUsername.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + " " + Character.toUpperCase(e.getKeyChar()) + " Pressed");
        switch (e.getKeyCode()){
            case KeyEvent.VK_T: cUI.toggleDebug(); break;
            case KeyEvent.VK_F11: cUI.toggleFullscreen(); break;
            case KeyEvent.VK_R: cGame.loadLeaderboard(true); break;
            case KeyEvent.VK_ESCAPE: cUI.exitApplication(); break;
            case KeyEvent.VK_ENTER: cUI.toggleUsernameLock(); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Released");
    }
}
