package controllers;

import game.Player;
import javafx.scene.media.AudioClip;
import ui.components.Bomb;
import ui.components.Display;
import ui.components.Leaderboard;

import javax.swing.*;
import java.awt.*;

public class ControllerGame {

    private ControllerDatabase cDatabase;

    private Display dUI;
    private Bomb bBomb;
    private Leaderboard lLeaderboard;
    private Player pUser;

    private Timer tUpdate;
    private Timer tTimer;

    private AudioClip aMusic;
    private AudioClip aTimer;
    private AudioClip aIndication;
    private AudioClip aExplosion;

    public ControllerGame(Display ui, Player user, ControllerDatabase database) {
        System.out.println("Controller Logic Running...");
        System.out.println(">Setting Variable");
        try {
            aMusic = new AudioClip("file:audio/main_menu_music.mp3");
            aTimer = new AudioClip("file:audio/timer_beep_sound.mp3");
            aExplosion = new AudioClip("file:audio/explosion_sound.mp3");
            aMusic.setVolume(0.1);
            aTimer.setVolume(0.02);
            aExplosion.setVolume(0.5);
            aMusic.play();
            dUI = ui;
            pUser = user;
            cDatabase = database;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(">Unknown Error Has Occurred");
        }
    }

    public void loadGame(boolean state){
            if (state) {
                System.out.println(">Attempting to create the Bomb");





                pUser.setiScore(0);

                try{
                    pUser.setiSeconds(Integer.parseInt(dUI.sTitle.optionsTime.getText()));
                }catch(Exception e)
                {
                    if(pUser.getiSeconds() == 0)
                    {
                        pUser.setiSeconds(300);
                    }
                }



                pUser.setiPassed(0);
                pUser.setiFailed(0);

                try
                {
                    pUser.setiLives(Integer.parseInt(dUI.sTitle.optionsLives.getText()));
                }catch(Exception e){
                        pUser.setiLives(3);

                }

                try
                {
                    pUser.setiSticker(Integer.parseInt(dUI.sTitle.optionsSeed.getText()));
                }catch(Exception e){
                    pUser.setiSticker((int)(Math.random() * 999999));

                }



                bBomb = new Bomb(pUser);
                dUI.sGame.add(bBomb, BorderLayout.CENTER);

                aMusic.stop();
                aMusic = new AudioClip("file:audio/game_music.mp3");
                aMusic.setVolume(0.05);
                aMusic.play();

                tUpdate = new Timer(100, e -> {
                    if(bBomb.cOne.getiState() == 1){
                        pUser.setiPassed(pUser.getiPassed() + 1);
                        pUser.setiScore(pUser.getiSeconds() * bBomb.cOne.getiDifficulty() * pUser.getiLives());
                        aIndication = new AudioClip("file:audio/correct_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cOne.setiState(3);
                    }else if(bBomb.cOne.getiState() == 2){
                        pUser.setiFailed(pUser.getiFailed() + 1);
                        pUser.setiLives(pUser.getiLives() - 1);
                        tTimer.setDelay(tTimer.getDelay() / 2);
                        aIndication = new AudioClip("file:audio/incorrect_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cOne.setiState(3);
                    }

                    if(bBomb.cTwo.getiState() == 1){
                        pUser.setiPassed(pUser.getiPassed() + 1);
                        pUser.setiScore(pUser.getiSeconds() * bBomb.cOne.getiDifficulty() * pUser.getiLives());
                        aIndication = new AudioClip("file:audio/correct_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cTwo.setiState(3);
                    }else if(bBomb.cTwo.getiState() == 2){
                        pUser.setiFailed(pUser.getiFailed() + 1);
                        pUser.setiLives(pUser.getiLives() - 1);
                        tTimer.setDelay(tTimer.getDelay() / 2);
                        aIndication = new AudioClip("file:audio/incorrect_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cTwo.setiState(3);
                    }

                    if(bBomb.cThree.getiState() == 1){
                        pUser.setiPassed(pUser.getiPassed() + 1);
                        pUser.setiScore(pUser.getiSeconds() * bBomb.cOne.getiDifficulty() * pUser.getiLives());
                        aIndication = new AudioClip("file:audio/correct_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cThree.setiState(3);
                    }else if(bBomb.cThree.getiState() == 2){
                        pUser.setiFailed(pUser.getiFailed() + 1);
                        pUser.setiLives(pUser.getiLives() - 1);
                        tTimer.setDelay(tTimer.getDelay() / 2);
                        aIndication = new AudioClip("file:audio/incorrect_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cThree.setiState(3);
                    }

                    if(bBomb.cFour.getiState() == 1){
                        pUser.setiPassed(pUser.getiPassed() + 1);
                        pUser.setiScore(pUser.getiSeconds() * bBomb.cOne.getiDifficulty() * pUser.getiLives());
                        aIndication = new AudioClip("file:audio/correct_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cFour.setiState(3);
                    }else if(bBomb.cFour.getiState() == 2){
                        pUser.setiFailed(pUser.getiFailed() + 1);
                        pUser.setiLives(pUser.getiLives() - 1);
                        tTimer.setDelay(tTimer.getDelay() / 2);
                        aIndication = new AudioClip("file:audio/incorrect_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cFour.setiState(3);
                    }

                    if(bBomb.cFive.getiState() == 1){
                        pUser.setiPassed(pUser.getiPassed() + 1);
                        pUser.setiScore(pUser.getiSeconds() * bBomb.cOne.getiDifficulty() * pUser.getiLives());
                        aIndication = new AudioClip("file:audio/correct_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        System.out.println("Completed");
                        bBomb.cFive.setiState(3);
                    }else if(bBomb.cFive.getiState() == 2){
                        pUser.setiFailed(pUser.getiFailed() + 1);
                        pUser.setiLives(pUser.getiLives() - 1);
                        tTimer.setDelay(tTimer.getDelay() / 2);
                        aIndication = new AudioClip("file:audio/incorrect_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cFive.setiState(3);
                    }

                    if(bBomb.cSix.getiState() == 1){
                        pUser.setiPassed(pUser.getiPassed() + 1);
                        pUser.setiScore(pUser.getiSeconds() * bBomb.cOne.getiDifficulty() * pUser.getiLives());
                        aIndication = new AudioClip("file:audio/correct_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        System.out.println("Completed");
                        bBomb.cSix.setiState(3);
                    }else if(bBomb.cSix.getiState() == 2){
                        pUser.setiFailed(pUser.getiFailed() + 1);
                        pUser.setiLives(pUser.getiLives() - 1);
                        tTimer.setDelay(tTimer.getDelay() / 2);
                        aIndication = new AudioClip("file:audio/incorrect_sound.mp3");
                        aIndication.setVolume(0.1);
                        aIndication.play();
                        bBomb.cSix.setiState(3);
                    }



                    bBomb.bLives.setLives(pUser.getiLives());


                    if (pUser.getiLives() <= 0 || pUser.getiPassed() + pUser.getiFailed() == 6) {
                        if(pUser.getiLives() <= 0) {
                            aExplosion.play();
                        }
                        dUI.setScene("2");
                    }
                });

                tTimer = new Timer(1000, e -> {
                    bBomb.bTimer.setTimer(bBomb.bTimer.getTimer() - 1);
                    pUser.setiSeconds(bBomb.bTimer.getTimer());
                    aTimer.play();
                    if (bBomb.bTimer.getTimer() <= 0) {
                        aExplosion.play();
                        dUI.setScene("2");
                    }
                });

                tUpdate.start();
                tTimer.start();
            } else {
                try {
                    dUI.sGame.remove(bBomb);
                    bBomb = null;
                    tUpdate.stop();
                    tUpdate = null;
                    tTimer.stop();
                    tTimer = null;

                    aMusic.stop();
                    aMusic = new AudioClip("file:audio/main_menu_music.mp3");
                    aMusic.setVolume(0.1);
                    aMusic.play();
                }catch(NullPointerException e){
                    System.out.println("Game does not exist cannot unload");
                }
            }

            dUI.sGame.repaint();
            dUI.sGame.revalidate();
    }

    public void loadLeaderboard(boolean state){
        if(lLeaderboard == null) {
            System.out.println(">Attempting to create the Leadeboard Display");
            lLeaderboard = new Leaderboard(pUser, cDatabase);
            dUI.sEnd.add(lLeaderboard, BorderLayout.CENTER);
        }else {
            dUI.sEnd.remove(lLeaderboard);
            lLeaderboard = null;
        }
        dUI.sGame.repaint();
        dUI.sGame.revalidate();
    }

    public void setSticker(){
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Current Sticker: " + bBomb.bSticker.getStickerNo(), "Set Sticker", 3));
            pUser.setiSticker(input);
            bBomb.bSticker.setStickerNo(input);
            loadGame(false);
            loadGame(true);
        }catch (NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }

    public void setUsername(){
        try {
            String input = JOptionPane.showInputDialog(null, "Current Username: " + pUser.getsName(), "Set Sticker", 3);
            pUser.setsName(input);
        }catch (NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }

    public void setTimer(){
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Current Time: " + bBomb.bTimer.getTimer(), "Set Lives", 3));
            bBomb.bTimer.setTimer(input);
        }catch (NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }

    public void setScore(){
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null,"Current Score: " + pUser.getiScore(),"Set Score",3));
            pUser.setiScore(input);
        }catch (NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }

    public void setPassed(){
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Current Passed: " + pUser.getiPassed(), "Set Passed", 3));
            pUser.setiPassed(input);
        }catch (NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }

    public void setFailed(){
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Current Failed: " + pUser.getiFailed(), "Set Failed", 3));
            pUser.setiFailed(input);
        }catch (NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }

    public void setLives(){
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Current Lives: " + pUser.getiLives(), "Set Lives", 3));
            pUser.setiLives(input);
            bBomb.bLives.setLives(pUser.getiLives());
        }catch (NumberFormatException e){
            System.out.println("Invalid Input");
        }
    }

    public void checkUser() {
        if(pUser.getsName() != null) {
            if (cDatabase.userExists(pUser.getsName())) {
                System.out.println("USER EXISTS!!! Updating user...");
                cDatabase.updateUser(pUser.getsName(), pUser.getiSeconds(), pUser.getiScore(), pUser.getiPassed(), pUser.getiFailed(), pUser.getiLives());
            } else {
                System.out.println("USER DOES NOT EXIST!!! Creating user...");
                cDatabase.addUser(pUser.getsName(), pUser.getiSticker(), pUser.getiSeconds(), pUser.getiScore(), pUser.getiPassed(), pUser.getiFailed(), pUser.getiLives());
            }
        }
    }
}
