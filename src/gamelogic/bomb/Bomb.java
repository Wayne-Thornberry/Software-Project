package gamelogic.bomb;

import gamelogic.Section;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    private static JPanel pInfoSpace;
    private static JPanel pSectionSpace;

    public static BombSticker bSticker;
    public static BombTimer bTimer;
    public static BombLives bLives;

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
        for(int x=0;x<=5;x++){
            pSectionSpace.add(new Section());
        }
    }
}
