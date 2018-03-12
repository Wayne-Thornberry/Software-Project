package gamelogic.bomb;

import gamelogic.*;
import gamelogic.challanges.*;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    private JPanel pInfoSpace;
    private JPanel pSectionSpace;

    private BombSticker bSticker;
    private BombTimer bTimer;
    private BombLives bLives;

    private Wire_Challenge cOne;
    private Wire_Challenge cTwo;
    private Wire_Challenge cThree;
    private Wire_Challenge cFour;
    private Wire_Challenge cFive;
    private Wire_Challenge cSix;

    private int iChallengesCompleted;
    private int iChallengesFailed;

    private boolean bBombCompleted;

    private static GridBagConstraints gbContraints;


    public Bomb() {
        this.setLayout(new GridBagLayout());
        gbContraints = new GridBagConstraints();

        pInfoSpace = new JPanel(new GridLayout(0,3));
        pSectionSpace = new JPanel(new GridLayout(2,3));

        bSticker = new BombSticker();
        bTimer = new BombTimer();
        bLives = new BombLives();

        this.setPreferredSize(this.getPreferredSize());
        pInfoSpace.setPreferredSize(pInfoSpace.getPreferredSize());
        pSectionSpace.setPreferredSize(pSectionSpace.getPreferredSize());

        cOne = new Wire_Challenge();
        cTwo = new Wire_Challenge();
        cThree = new Wire_Challenge();
        cFour = new Wire_Challenge();
        cFive = new Wire_Challenge();
        cSix = new Wire_Challenge();

        iChallengesCompleted = 0;
        iChallengesFailed = 0;

        bBombCompleted = false;

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

    public void resetBomb(){

        bTimer.resetTimer();
        bSticker.resetSticker();
        bLives.resetLives();

        cOne.resetChallenge();
        cTwo.resetChallenge();
        cThree.resetChallenge();
        cFour.resetChallenge();
        cFive.resetChallenge();
        cSix.resetChallenge();
    }

    public void checkSections(){
        switch (cOne.getState()){
            case 1 : passedSection(); break;
            case 2 : failedSection(); break;
        }

        switch (cTwo.getState()){
            case 1 : passedSection(); break;
            case 2 : failedSection(); break;
        }

        switch (cThree.getState()){
            case 1 : passedSection(); break;
            case 2 : failedSection(); break;
        }

        switch (cFour.getState()){
            case 1 : passedSection(); break;
            case 2 : failedSection(); break;
        }

        switch (cFive.getState()){
            case 1 : passedSection(); break;
            case 2 : failedSection(); break;
        }

        switch (cSix.getState()){
            case 1 : passedSection(); break;
            case 2 : failedSection(); break;
        }
    }

    private void passedSection(){
        iChallengesCompleted++;
        checkProgress();
    }

    private void failedSection(){
        iChallengesFailed++;
        checkProgress();
    }

    private void checkProgress(){
        if(iChallengesFailed == 3 || iChallengesFailed + iChallengesCompleted == 6){
            bBombCompleted = true;
        }
    }
}
