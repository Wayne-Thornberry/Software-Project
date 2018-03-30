package ui;

import game.challanges.*;
import ui.components.bomb.*;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    public BombSticker bSticker;
    public BombTimer bTimer;
    public BombLives bLives;

    private ChallengeWireSequence cTwo;
    private ChallengeWireSequence cThree;
    private ChallengeWireSequence cOne;
    private ChallengeWireSequence cFour;
    private ChallengeWireSequence cFive;
    private ChallengeWireSequence cSix;

    private int iCCompleted;
    private int iCFailed;

    private int iState;

    public Bomb() {

        this.setLayout(new GridLayout(3,3));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        System.out.println("Bomb has been created");
        bSticker = new BombSticker();
        bTimer = new BombTimer(300);
        bLives = new BombLives(3);

        cOne = new ChallengeWireSequence(this, bSticker.getStickerNo());
        cTwo = new ChallengeWireSequence(this, bSticker.getStickerNo());
        cThree = new ChallengeWireSequence(this, bSticker.getStickerNo());
        cFour = new ChallengeWireSequence(this, bSticker.getStickerNo());
        cFive = new ChallengeWireSequence(this, bSticker.getStickerNo());
        cSix = new ChallengeWireSequence(this, bSticker.getStickerNo());

        iCCompleted = 0;
        iCFailed = 0;
        iState = 0;

        this.add(bSticker);
        this.add(bTimer);
        this.add(bLives);

        this.add(cOne);
        this.add(cTwo);
        this.add(cThree);
        this.add(cFour);
        this.add(cFive);
        this.add(cSix);
    }

    public void resetBomb(){
        bSticker.resetSticker();
        bLives.resetLives();
        bTimer.resetTimer();

        cOne.resetChallenge(bSticker.getStickerNo());
        cTwo.resetChallenge(bSticker.getStickerNo());
        cThree.resetChallenge(bSticker.getStickerNo());
        cFour.resetChallenge(bSticker.getStickerNo());
        cFive.resetChallenge(bSticker.getStickerNo());
        cSix.resetChallenge(bSticker.getStickerNo());
    }

    public void updateProgress() {
        if(cOne.getState() == 1){
            setCompleted(getCompleted()+1);
            cOne.setState(3);
        }else if(cOne.getState() == 2){
            setFailed(getFailed()+1);
            cOne.setState(3);
        }

        if(cTwo.getState() == 1){
            setCompleted(getCompleted()+1);
            cTwo.setState(3);
        }else if(cTwo.getState() == 2){
            setFailed(getFailed()+1);
            cTwo.setState(3);
        }

        if(cThree.getState() == 1){
            setCompleted(getCompleted()+1);
            cThree.setState(3);
        }else if(cThree.getState() == 2){
            setFailed(getFailed()+1);
            cThree.setState(3);
        }

        if(cFour.getState() == 1){
            setCompleted(getCompleted()+1);
            cFour.setState(3);
        }else if(cFour.getState() == 2){
            setFailed(getFailed()+1);
            cFour.setState(3);
        }

        if(cFive.getState() == 1){
            setCompleted(getCompleted()+1);
            cFive.setState(3);
        }else if(cFive.getState() == 2){
            setFailed(getFailed()+1);
            cFive.setState(3);
        }

        if(cSix.getState() == 1){
            setCompleted(getCompleted()+1);
            cSix.setState(3);
        }else if(cSix.getState() == 2){
            setFailed(getFailed()+1);///
            cSix.setState(3);
        }

        System.out.println(getCompleted() + " " + getFailed());
    }

    private void setState(int state){
        iState = state;
    }

    public int getState(){
        return iState;
    }

    public int getCompleted() {
        return iCCompleted;
    }

    private void setCompleted(int completed) {
        iCCompleted = completed;
        System.out.println(getCompleted());
    }

    public int getFailed() {
        return iCFailed;
    }

    private void setFailed(int failed) {
        iCFailed = failed;
        System.out.println(getFailed());
    }
}
