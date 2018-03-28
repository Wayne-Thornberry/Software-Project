package controllers;

import gamelogic.Player;
import ui.Bomb;
import ui.Display;

import javax.swing.*;

public class ControllerLogic {

    private Display dUI;
    private Bomb bBomb;
    private Timer tUpdate;
    private Player pUser;

    public ControllerLogic(Display ui, Player user) {
        System.out.println("Controller Logic Running...");
        System.out.println(">Setting Variable");
        try {
            dUI = ui;
            pUser = user;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(">Unknown Error Has Occurred");
        }
        System.out.println(">Attempting to create the Bomb");
        try {
            createBomb();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(">Unknown Error Has Occurred");
        }
        // create a new thread to manage update checks
    }

    public void createBomb(){
        bBomb = new Bomb();
        dUI.sGame.add(bBomb);
    }

    public void resetBomb(){
        if (bBomb != null) {
            bBomb.bTimer.resetTimer();
            bBomb.bSticker.resetSticker();
            bBomb.bLives.resetLives();
            //bBomb.resetChallenges();
        }
    }

    public void updatePlayer(){
        pUser.setsName("Wayno717");
        pUser.setiSeconds(200);
        pUser.setiScore(1795);
        pUser.setiLives(2);
        pUser.setiFailed(2);
        pUser.setiPassed(4);
    }
}
