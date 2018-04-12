package controllers;

import game.Player;
import ui.Bomb;
import ui.Display;
import ui.Leaderboard;
import ui.PanelStats;

import javax.swing.*;
import java.awt.*;

public class ControllerGame {

    private Display dUI;
    private Bomb bBomb;
    private Leaderboard lLeaderboard;
    private Player pUser;
    private PanelStats iPanel;

    public ControllerGame(Display ui, Player user) {
        System.out.println("Controller Logic Running...");
        System.out.println(">Setting Variable");
        try {
            dUI = ui;
            pUser = user;
            iPanel = new PanelStats();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(">Unknown Error Has Occurred");
        }
    }

    public void createGame(){
        System.out.println(">Attempting to create the Bomb");
        if(bBomb == null) {
            bBomb = new Bomb();
            dUI.sGame.add(bBomb, BorderLayout.CENTER);
        }else {
            dUI.sGame.remove(bBomb);
            bBomb = null;
            createGame();
        }
        dUI.sGame.repaint();
        dUI.sGame.revalidate();
    }

    public void createLeaderboard(){
        System.out.println(">Attempting to create the Leadeboard");
        if(lLeaderboard == null) {
            lLeaderboard = new Leaderboard();
            dUI.sEnd.add(lLeaderboard, BorderLayout.CENTER);
        }else {
            dUI.sEnd.remove(lLeaderboard);
            lLeaderboard = null;
            createLeaderboard();
        }
        dUI.sGame.repaint();
        dUI.sGame.revalidate();
    }

    public void setCustomSticker(){
        int input = Integer.parseInt(JOptionPane.showInputDialog(null,"Input Sticker Number","Sticker Number",3));
        bBomb.bSticker.setStickerNo(input);
        //bBomb.resetBomb();
    }
}
