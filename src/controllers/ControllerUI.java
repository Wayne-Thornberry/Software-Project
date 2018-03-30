/**
 * ControllerUI controls anything to do with the user interface, show/hide certin jpanels, do something when it switches scene or a label laods
 * This class mostly works in conjunction with Controller Action
 *
 * @author Wayne Thornberry B00100288
 * @version 1.0
 * @since 27/03/2018
 */

package controllers;

import game.Player;
import ui.Display;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ControllerUI extends ComponentAdapter {

    private Display dUI;
    private ControllerGame cGame;
    private String sScene;
    private Player pUser;

    private boolean isTitleVisible;
    private boolean isGameVisible;
    private boolean isEndVisible;

    public ControllerUI(ControllerGame game, Display ui, Player user){
        System.out.println("Controller UI Running...");
        System.out.println(">Setting Variable");
        try {
            cGame = game;
            dUI = ui;
            pUser = user;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(">Unknown Error Has Occurred");
        }
        System.out.println(">Setting Menus");
        try {
            setTitleVisible(true);
            setGameVisible(false);
            setEndVisible(false);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Unknown Error Has Occurred");
        }
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        super.componentHidden(e);
        System.out.println(e.getSource().getClass().getSimpleName() + " Visible: FALSE");
        switch (e.getSource().getClass().getSimpleName()){
            case "SceneTitle": setTitleVisible(false); break;
            case "SceneGame": setGameVisible(false); break;
            case "SceneEnd": setEndVisible(false); break;
        }
    }

    @Override
    public void componentShown(ComponentEvent e) {
        super.componentShown(e);
        System.out.println(e.getSource().getClass().getSimpleName() + " Visible: TRUE");
        switch (e.getSource().getClass().getSimpleName()){
            case "SceneTitle": setTitleVisible(true); break;
            case "SceneGame": setGameVisible(true); break;
            case "SceneEnd": setEndVisible(true); break;
        }
    }

    public void setScene(String scene){
        sScene = scene;
        dUI.cLayout.show(dUI.pBase,sScene);
    }

    public String getScene(){
        return sScene;
    }

    private void setTitleVisible(boolean titleVisible) {
        isTitleVisible = titleVisible;
        if(isTitleVisible){
            // Do somethign when the scene loads
            System.out.println("Title Loaded");
        }else{
            // Do soemthign when the scene unloads
            System.out.println("Title Unloaded");
        }
    }

    public boolean isTitleVisible() {
        return isTitleVisible;
    }

    private void setGameVisible(boolean gameVisible) {
        isGameVisible = gameVisible;
        if(isGameVisible){
            System.out.println("Game Loaded");
        }else{
            // Do soemthign when the scene unloads
            System.out.println("Game Unloaded");
        }
    }

    public boolean isGameVisible() {
        return isGameVisible;
    }

    private void setEndVisible(boolean endVisible) {
        isEndVisible = endVisible;
        if(isEndVisible){
            // Do somethign when the scene loads
            System.out.println("End Loaded");
        }else{
            // Do soemthign when the scene unloads
            System.out.println("End Unloaded");
        }
    }

    public boolean isEndVisible() {
        return isEndVisible;
    }

    public void helpChallengeInfo(String filename){
        try {
            String content = new Scanner(new File(filename + ".txt")).useDelimiter("\\z").next();
            JLabel label = new JLabel(content);
            new JOptionPane().showMessageDialog(null,label);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Unhandled Exception");
        }
    }

    public void toggleDebug(){
        dUI.dMenuBar.setVisible(!dUI.dMenuBar.isVisible());
    }

}
