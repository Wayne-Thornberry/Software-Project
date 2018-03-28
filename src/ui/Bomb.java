package ui;

import gamelogic.challanges.*;
import ui.components.bomb.*;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    public BombSticker bSticker;
    public BombTimer bTimer;
    public BombLives bLives;

    private ChallengeLetter cTwo;
    private ChallengeEvenOdd cThree;
    private ChallengeWire cOne;
    private ChallengeKeypad cFour;
    private ChallengePicture cFive;
    private ChallengeWire cSix;

    public Bomb() {

        this.setLayout(new GridLayout(3,3));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        System.out.println("Bomb has been created");
        bSticker = new BombSticker();
        bTimer = new BombTimer();
        bLives = new BombLives();


        bSticker.setStickerNo((int) (Math.random() * 999999));
        bTimer.setTimer(300);
        bLives.setLives(3);

        cOne = new ChallengeWire(bSticker.getStickerNo());
        cTwo = new ChallengeLetter(bSticker.getStickerNo());
        cThree = new ChallengeEvenOdd(bSticker.getStickerNo());
        cFour = new ChallengeKeypad(bSticker.getStickerNo());
        cFive = new ChallengePicture(bSticker.getStickerNo());
        cSix = new ChallengeWire(bSticker.getStickerNo());

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

    public void resetChallenges(){
        cOne.resetChallenge(bSticker.getStickerNo());
        cTwo.resetChallenge(bSticker.getStickerNo());
        cThree.resetChallenge(bSticker.getStickerNo());
        cFour.resetChallenge(bSticker.getStickerNo());
        cFive.resetChallenge(bSticker.getStickerNo());
        cSix.resetChallenge(bSticker.getStickerNo());
    }

    public int getState(){
        cOne.getState();
        cTwo.getState();
        cThree.getState();
        cFour.getState();
        cFive.getState();
        cSix.getState();
        return 0;
    }
}
