package ui.scenes;

import javax.swing.*;
import java.awt.*;

public class SceneTitle extends JPanel {

    private JPanel pRightSpace;
    private JPanel pLeftSpace;

    private JPanel pTDeadSpace;
    private JPanel pTitleSpace;
    private JPanel pMDeadSpace;
    private JPanel pButtonSpace;
    private JPanel pBDeadSpace;

    private JLabel lTitle;

    private JButton bStartGame;
    private JButton bOptions;
    private JButton bQuitGame;

    private GridBagConstraints gbContraints;

    private String sScene;

    public SceneTitle(){

        this.setLayout(new GridLayout(0,2));

        pLeftSpace = new JPanel(new GridBagLayout());
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

        pLeftSpace.setBackground(Color.GREEN);
        pRightSpace.setBackground(Color.ORANGE);

        pLeftSpace.setPreferredSize(pLeftSpace.getPreferredSize());
        pRightSpace.setPreferredSize(pRightSpace.getPreferredSize());

        // Default Var

        gbContraints.fill = 1;
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        gbContraints.gridwidth = 1;
        gbContraints.gridheight = 1;

        this.add(pLeftSpace);
        this.add(pRightSpace);

        // Middle Challenge
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        pLeftSpace.add(pTDeadSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 1;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        pLeftSpace.add(pTitleSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 2;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        pLeftSpace.add(pMDeadSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 3;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        pLeftSpace.add(pButtonSpace, gbContraints);
        gbContraints.gridx = 0;
        gbContraints.gridy = 4;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        pLeftSpace.add(pBDeadSpace, gbContraints);

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

    public void setScene(String Scene){
        sScene = Scene;
        if(sScene == "0"){
            pLeftSpace.setVisible(true);
            pRightSpace.setVisible(false);
        }else{
            pLeftSpace.setVisible(false);
            pRightSpace.setVisible(true);
        }
    }
}
