package ui.components;

import game.Player;
import game.challanges.*;
import ui.components.bomb.*;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    private JPanel pInfo;
    public BombSticker bSticker;
    public BombTimer bTimer;
    public BombLives bLives;

    private JPanel pChallenges;
    private ChallengeWire cOne;
    private ChallengeWire cTwo;
    private ChallengeWire cThree;
    private ChallengeWire cFour;
    private ChallengeWire cFive;
    private ChallengeWire cSix;

    public Bomb(Player pUser) {

        System.out.println("Bomb Generating...");
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, false));

        pInfo = new JPanel();
        pChallenges = new JPanel();

        pInfo.setLayout(new GridLayout(0,3));
        pChallenges.setLayout(new GridLayout(2,3));

        bSticker = new BombSticker((int)(Math.random() * 999999));
        bTimer = new BombTimer(pUser.getiSeconds());
        bLives = new BombLives(pUser.getiLives());

        cOne = new ChallengeWire(bSticker.getStickerNo());
        cTwo = new ChallengeWire(bSticker.getStickerNo());
        cThree = new ChallengeWire(bSticker.getStickerNo());
        cFour = new ChallengeWire(bSticker.getStickerNo());
        cFive = new ChallengeWire(bSticker.getStickerNo());
        cSix = new ChallengeWire(bSticker.getStickerNo());

        pInfo.add(bSticker);
        pInfo.add(bTimer);
        pInfo.add(bLives);
        this.add(pInfo, BorderLayout.NORTH);

        pChallenges.add(cOne);
        pChallenges.add(cTwo);
        pChallenges.add(cThree);
        pChallenges.add(cFour);
        pChallenges.add(cFive);
        pChallenges.add(cSix);
        this.add(pChallenges, BorderLayout.CENTER);
    }

    /*public void resetBomb(){
        bSticker.setStickerNo((int)(Math.random() * 999999));
        bLives.setLives(3);
        bTimer.setTimer(300);

        cOne.resetChallenge(bSticker.getStickerNo());
        cTwo.resetChallenge(bSticker.getStickerNo());
        cThree.resetChallenge(bSticker.getStickerNo());
        cFour.resetChallenge(bSticker.getStickerNo());
        cFive.resetChallenge(bSticker.getStickerNo());
        cSix.resetChallenge(bSticker.getStickerNo());
    }*/
}
