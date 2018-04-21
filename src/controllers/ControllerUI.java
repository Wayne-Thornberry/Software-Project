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
import ui.components.Display;

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
            if(isUserLocked) {
                cGame.loadGame(true);
                System.out.println("Game Loaded");
            }else{
                JOptionPane.showMessageDialog(null, "Please Enter a Username below to record your progress!", "Information", JOptionPane.INFORMATION_MESSAGE);
                setScene("0");
            }
        }else{
            cGame.loadGame(false);
            System.out.println("Game Unloaded");
        }
    }

    public boolean isGameVisible() {
        return isGameVisible;
    }

    private void setEndVisible(boolean endVisible) {
        isEndVisible = endVisible;
        if(isEndVisible){
            cGame.checkUser();
            cGame.loadLeaderboard(true);
            System.out.println("End Loaded");
        }else{
            cGame.loadLeaderboard(false);
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

    public void toggleDebug(boolean b){
        dUI.setDebug(b);
        System.out.println(pUser.isAdmin());
        refreshUI();
    }

    public void refreshUI() {
        System.out.println("Repainting...");
        if(dUI.getScene() == "1") {
            cGame.loadGame(false);
            cGame.loadGame(true);
        }else if(dUI.getScene() == "2"){
            cGame.loadLeaderboard(false);
            cGame.loadLeaderboard(true);
        }
        dUI.revalidate();
        dUI.repaint();
    }

    public void setResolution(int width, int height) {
        dUI.setSize(width, height);
        dUI.sTitle.repaint();
        dUI.sGame.repaint();
        dUI.sEnd.repaint();
    }

    public void toggleFullscreen() {
        dUI.setIsFullscreen(!isFullscreen);
        isFullscreen = !isFullscreen;
    }

    public void toggleUsernameLock() {
        if(dUI.sTitle.tUsername.getText() != null && !dUI.sTitle.tUsername.getText().trim().isEmpty()) {
            dUI.sTitle.setUsernameLock(!isUserLocked);
            isUserLocked = !isUserLocked;
            if (isUserLocked) {
                pUser.setsName(dUI.sTitle.tUsername.getText());
                System.out.println(pUser.getsName());
            }
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

    public void loginPrompt() {
        if(!pUser.isAdmin()) {
            try {
                String pass = JOptionPane.showInputDialog(null, "Enter Admin Password: ", "Admin Login", JOptionPane.INFORMATION_MESSAGE);
                if (pass.equals("root") && !pUser.isAdmin()) {
                    pUser.setAdmin(true);
                    toggleDebug(pUser.isAdmin());
                }
            }catch (NullPointerException e){
                System.out.println("Null Detected");
            }
        }else{
            pUser.setAdmin(false);
            toggleDebug(pUser.isAdmin());
        }
    }
}
