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
    private Player pUser;

    private boolean isTitleVisible;
    private boolean isGameVisible;
    private boolean isEndVisible;
    private boolean isFullscreen;
    private boolean isDebugVisible;
    private boolean isUserLocked;

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

        dUI.sTitle.addComponentListener(this); // Scene = 0
        dUI.sGame.addComponentListener(this); // Scene = 1
        dUI.sEnd.addComponentListener(this); // Scene = 2
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
        dUI.setScene(scene);
    }

    private void setTitleVisible(boolean titleVisible) {
        isTitleVisible = titleVisible;
        if(isTitleVisible){
            dUI.sTitle.setOptionsVisible(false);
            System.out.println("Title Loaded");
        }else{
            // Do something when the scene unloads
            System.out.println("Title Unloaded");
        }
    }

    public boolean isTitleVisible() {
        return isTitleVisible;
    }

    private void setGameVisible(boolean gameVisible) {
        isGameVisible = gameVisible;
        if(isGameVisible){
            cGame.createGame();
            System.out.println("Game Loaded");
        }else{
            // Do something when the scene unloads
            System.out.println("Game Unloaded");
        }
    }

    public boolean isGameVisible() {
        return isGameVisible;
    }

    private void setEndVisible(boolean endVisible) {
        isEndVisible = endVisible;
        if(isEndVisible){
            cGame.createLeaderboard();
            System.out.println("End Loaded");
        }else{
            // Do something when the scene unloads
            System.out.println("End Unloaded");
        }
    }

    public boolean isEndVisible() {
        return isEndVisible;
    }

    public void helpChallengeInfo(String filename){
        try {
            String content = new Scanner(new File(filename + ".html")).useDelimiter("\\z").next();
            JLabel label = new JLabel(content);
            new JOptionPane().showMessageDialog(null,label);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Unhandled Exception");
        }
    }

    public void toggleDebug(){
        dUI.setDebug(!isDebugVisible);
        isDebugVisible = !isDebugVisible;
    }

    public void refreshUI() {
        System.out.println("Repainting...");
        dUI.repaint();
        dUI.revalidate();
        dUI.sEnd.repaint();
        dUI.sEnd.revalidate();
        dUI.sGame.repaint();
        dUI.sGame.revalidate();
        dUI.sTitle.repaint();
        dUI.sTitle.revalidate();
    }

    public void setResolution(int width, int height) {
        dUI.setSize(width, height);
    }

    public void toggleFullscreen() {
        dUI.setIsFullscreen(!isFullscreen);
        isFullscreen = !isFullscreen;
    }

    public void toggleUsernameLock() {
        dUI.sTitle.setUsernameLock(!isUserLocked);
        isUserLocked = !isUserLocked;
        if (isUserLocked) {
            pUser.setsName(dUI.sTitle.tUsername.getText());
            System.out.println(pUser.getsName());
        }
    }

    public void toggleOptionMenu() {
        dUI.sTitle.setOptionsVisible(!dUI.sTitle.getOptionsVisible());
    }

    public void exitApplication() {
        if(dUI.getScene() == "0") {
            int iExit = JOptionPane.showConfirmDialog(null, "Do you wish to exit the game?", "Exit Prompt", JOptionPane.YES_NO_OPTION);
            if (iExit == JOptionPane.YES_OPTION) {
                System.exit(1);
            }
        }else{
            int iExit = JOptionPane.showConfirmDialog(null, "Do you wish to exit the game? You will lose unsaved progress", "Exit Prompt", JOptionPane.YES_NO_OPTION);
            if (iExit == JOptionPane.YES_OPTION) {
                dUI.setScene("0");
            }
        }
    }
}
