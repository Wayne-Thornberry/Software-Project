package gui.scenes;

import javax.swing.*;
import java.awt.*;

public class MainScene extends JPanel {

    private static JPanel pLeftSpace;
    private static JPanel pMiddleSpace;
    private static JPanel pRightSpace;

    private static JPanel pTDeadSpace;
    private static JPanel pTitleSpace;
    private static JPanel pMDeadSpace;
    private static JPanel pButtonSpace;
    private static JPanel pBDeadSpace;

    private static JLabel lTitle;

    private static JButton bStartGame;
    private static JButton bOptions;
    private static JButton bQuitGame;

    private static GridBagConstraints gbContraints;

    public MainScene(){

        this.setLayout(new GridBagLayout());
        pLeftSpace = new JPanel();
        pMiddleSpace = new JPanel(new GridBagLayout());
        pRightSpace = new JPanel();

        pTDeadSpace = new JPanel();
        pTitleSpace = new JPanel();
        pMDeadSpace = new JPanel();
        pButtonSpace = new JPanel(new GridLayout(3,0));
        pBDeadSpace = new JPanel();

        lTitle = new JLabel();

        bStartGame = new JButton("Start Game");
        bOptions = new JButton("Options");
        bQuitGame = new JButton("Quit Game");

        gbContraints = new GridBagConstraints();

        lTitle.setIcon(new ImageIcon(""));

        this.setBackground(Color.RED);

        pLeftSpace.setBackground(Color.RED);
        pMiddleSpace.setBackground(Color.GREEN);
        pRightSpace.setBackground(Color.BLUE);

        pLeftSpace.setPreferredSize(pLeftSpace.getPreferredSize());
        pMiddleSpace.setPreferredSize(pMiddleSpace.getPreferredSize());
        pRightSpace.setPreferredSize(pRightSpace.getPreferredSize());

        // Default Var

        gbContraints.fill = 1;
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        gbContraints.gridwidth = 1;
        gbContraints.gridheight = 1;

        // End

        // Sections
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.4;
        gbContraints.weighty = 0.4;
        this.add(pLeftSpace, gbContraints);
        gbContraints.gridx = 1;
        gbContraints.gridy = 0;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        this.add(pMiddleSpace, gbContraints);
        gbContraints.gridx = 2;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.4;
        gbContraints.weighty = 0.4;
        this.add(pRightSpace, gbContraints);

        // Middle Challenge
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        pMiddleSpace.add(pTDeadSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 1;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        pMiddleSpace.add(pTitleSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 2;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        pMiddleSpace.add(pMDeadSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 3;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        pMiddleSpace.add(pButtonSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 4;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        pMiddleSpace.add(pBDeadSpace, gbContraints);

        pTDeadSpace.setBackground(Color.ORANGE);
        pTitleSpace.setBackground(Color.YELLOW);
        pMDeadSpace.setBackground(Color.PINK);
        pButtonSpace.setBackground(Color.MAGENTA);
        pBDeadSpace.setBackground(Color.GRAY);

        pTitleSpace.add(lTitle);

        pButtonSpace.add(bStartGame);
        pButtonSpace.add(bOptions);
        pButtonSpace.add(bQuitGame);
    }
}
