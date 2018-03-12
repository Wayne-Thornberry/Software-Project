package gamelogic.bomb;

import gamelogic.*;
import gamelogic.challanges.*;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    private static JPanel pInfoSpace;
    private static JPanel pSectionSpace;

    private static BombSticker bSticker;
    private static BombTimer bTimer;
    private static BombLives bLives;

    private static Wire_Challenge cOne;
    private static Challenge cTwo;
    private static Challenge cThree;
    private static Challenge cFour;
    private static Challenge cFive;
    private static Challenge cSix;

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

        //Sections
        pSectionSpace.add(cOne);
        pSectionSpace.add(cTwo);
        pSectionSpace.add(cThree);
        pSectionSpace.add(cFour);
        pSectionSpace.add(cFive);
        pSectionSpace.add(cSix);
    }

    public static void resetChallanges(){
        cOne.resetChallange();
        cTwo.resetChallenge();
        cThree.resetChallenge();
        cFour.resetChallenge();
        cFive.resetChallenge();
        cSix.resetChallenge();
    }
}
