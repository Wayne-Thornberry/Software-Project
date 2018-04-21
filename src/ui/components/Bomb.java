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
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));

        pInfo = new JPanel();
        pInfo.setBackground(Color.LIGHT_GRAY);

        pChallenges = new JPanel();

        pInfo.setLayout(new GridLayout(0,3));
        pChallenges.setLayout(new GridLayout(2,3));

        bSticker = new BombSticker(pUser.getiSticker());
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

        cOne.getiState();
    }
}
