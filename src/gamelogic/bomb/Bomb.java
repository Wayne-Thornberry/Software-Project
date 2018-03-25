package gamelogic.bomb;

import gamelogic.challanges.*;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    private JPanel pInfoSpace;
    private JPanel pSectionSpace;

    public BombSticker bSticker;
    public BombTimer bTimer;
    public BombLives bLives;

    private WireChallenge cOne;
    private WireChallenge cTwo;
    private EvenOddChallenge cThree;
    private KeypadChallenge cFour;
    private WireChallenge cFive;
    private WireChallenge cSix;

    private int iChallengesCompleted;
    private int iChallengesFailed;

    private static GridBagConstraints gbContraints;


    public Bomb() {
        this.setLayout(new GridBagLayout());
        gbContraints = new GridBagConstraints();

        pInfoSpace = new JPanel(new GridLayout(0,3));
        pSectionSpace = new JPanel(new GridLayout(2,3));
        this.setBorder(BorderFactory.createEtchedBorder());


        bSticker = new BombSticker();
        bTimer = new BombTimer();
        bLives = new BombLives();

        this.setPreferredSize(this.getPreferredSize());
        pInfoSpace.setPreferredSize(pInfoSpace.getPreferredSize());
        pSectionSpace.setPreferredSize(pSectionSpace.getPreferredSize());

        cOne = new WireChallenge();
        cTwo = new WireChallenge();
        cThree = new EvenOddChallenge();
        cFour = new KeypadChallenge();
        cFive = new WireChallenge();
        cSix = new WireChallenge();

        iChallengesCompleted = 0;
        iChallengesFailed = 0;

        // Default Var
        gbContraints.fill = 1;
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        gbContraints.gridwidth = 1;
        gbContraints.gridheight = 1;

        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        this.add(pInfoSpace, gbContraints);

        gbContraints.gridx = 0;
        gbContraints.gridy = 1;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        this.add(pSectionSpace, gbContraints);

        pInfoSpace.add(bSticker);
        pInfoSpace.add(bTimer);
        pInfoSpace.add(bLives);

        Timer tUpdate = new Timer(100, e-> {
            checkSections();
        });
        tUpdate.start();

        //Sections
        pSectionSpace.add(cOne);
        pSectionSpace.add(cTwo);
        pSectionSpace.add(cThree);
        pSectionSpace.add(cFour);
        pSectionSpace.add(cFive);
        pSectionSpace.add(cSix);
    }

    public void checkSections(){
        switch (cOne.getState()){
            case 1 : setChallengeState(true); break;
            case 2 : setChallengeState(false); break;
        }

        switch (cTwo.getState()){
            case 1 : setChallengeState(true); break;
            case 2 : setChallengeState(false); break;
        }

        switch (cThree.getState()){
            case 1 : setChallengeState(true); break;
            case 2 : setChallengeState(false); break;
        }

        switch (cFour.getState()){
            case 1 : setChallengeState(true); break;
            case 2 : setChallengeState(false); break;
        }

        switch (cFive.getState()){
            case 1 : setChallengeState(true); break;
            case 2 : setChallengeState(false); break;
        }

        switch (cSix.getState()){
            case 1 : setChallengeState(true); break;
            case 2 : setChallengeState(false); break;
        }
    }

    public void resetBomb(){

        bTimer.resetTimer();
        bSticker.resetSticker();
        bLives.resetLives();

        iChallengesFailed = 0;
        iChallengesCompleted = 0;

        cOne.resetChallenge();
        cTwo.resetChallenge();
        cThree.resetChallenge();
        cFour.resetChallenge();
        cFive.resetChallenge();
        cSix.resetChallenge();
    }


    private void setChallengeSticker(){
        cOne.setStickerNo(bSticker.getStickerNo());
        cTwo.setStickerNo(bSticker.getStickerNo());
        cThree.setStickerNo(bSticker.getStickerNo());
        cFour.setStickerNo(bSticker.getStickerNo());
        cFive.setStickerNo(bSticker.getStickerNo());
        cSix.setStickerNo(bSticker.getStickerNo());
    }

    public void pauseBomb(){
        bTimer.tTimer.stop();
    }

    public void resumeBomb(){
        bTimer.tTimer.start();
    }

    private void setChallengeState(boolean bState){
        if(bState) {
            iChallengesCompleted++;
        }else{
            iChallengesFailed++;
            bLives.decreaseLives();
            bTimer.decreaseTimer();
        }
    }

    public boolean getBombState(){
        //System.out.println(iChallengesFailed + iChallengesCompleted);
        return (iChallengesFailed + iChallengesCompleted == 6 || bLives.getLives() <= 0 || bTimer.getTimer() <=0);
    }

    public int getiChallengesCompleted() {
        return iChallengesCompleted;
    }

    public int getiChallengesFailed() {
        return iChallengesFailed;
    }
}
