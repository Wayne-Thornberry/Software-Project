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

    public Challenge cOne;
    public Challenge cTwo;
    public Challenge cThree;
    public Challenge cFour;
    public Challenge cFive;
    public Challenge cSix;

    public Bomb(Player pUser) {

        System.out.println("Bomb Generating...");
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, false));

        pInfo = new JPanel();
        pInfo.setBackground(Color.GRAY);

        pChallenges = new JPanel();
        pChallenges.setBackground(Color.GRAY);
        pChallenges.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));

        pInfo.setLayout(new GridLayout(0,3, 5,5));
        pChallenges.setLayout(new GridLayout(2,3,5,5));

        bSticker = new BombSticker(pUser.getiSticker());
        bTimer = new BombTimer(pUser.getiSeconds());
        bLives = new BombLives(pUser.getiLives());

        cOne = new ChallengeWire(bSticker.getStickerNo());
        cTwo = new ChallengeKeypad(bSticker.getStickerNo());
        cThree = new ChallengeEvenOdd(bSticker.getStickerNo());
        cFour = new ChallengePicture(bSticker.getStickerNo());
        cFive = new ChallengeLetter(bSticker.getStickerNo());
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

        cOne.getiState();
    }
}
