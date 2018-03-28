/**
 * Controller input is a smaller controller but cant play an important role if the user wishes to use the keyboard.
 * This class receives keyboard and mouse input and can run many methods in the UI or Logic Controller
 *
 * @author Wayne Thornberry B00100288
 * @version 1.0
 * @since 27/03/2018
 */

package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerInput implements KeyListener {

    private ControllerUI cUI;
    private ControllerLogic cLogic;

    public ControllerInput(ControllerUI ui, ControllerLogic logic){
        System.out.println("Controller Input Running...");
        cUI = ui;
        cLogic = logic;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(Character.toUpperCase(e.getKeyChar()) + " Pressed");
        switch (e.getKeyCode()){
            case KeyEvent.VK_T: cUI.toggleDebug(); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Released");
    }
}
