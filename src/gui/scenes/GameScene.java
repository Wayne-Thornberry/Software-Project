package gui.scenes;

import gamelogic.bomb.*;

import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private static JPanel pLeftSpace;
    private static JPanel pTopSpace;
    public static Bomb pBombSpace;
    private static JPanel pRightSpace;
    private static JPanel pBottomSpace;

    private static GridBagConstraints gbContraints;

    public GameScene(){

        this.setLayout(new GridBagLayout());
        pLeftSpace = new JPanel();
        pTopSpace = new JPanel();
        pBombSpace = new Bomb();
        pRightSpace = new JPanel();
        pBottomSpace = new JPanel();

        gbContraints = new GridBagConstraints();

        this.setBackground(Color.GREEN);

        pLeftSpace.setBackground(Color.RED);
        pTopSpace.setBackground(Color.GREEN);
        pRightSpace.setBackground(Color.BLUE);
        pBottomSpace.setBackground(Color.WHITE);

        pLeftSpace.setPreferredSize(pLeftSpace.getPreferredSize());
        pTopSpace.setPreferredSize(pTopSpace.getPreferredSize());
        pRightSpace.setPreferredSize(pRightSpace.getPreferredSize());
        pBottomSpace.setPreferredSize(pBottomSpace.getPreferredSize());

        // Default Var

        gbContraints.fill = 1;
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        gbContraints.gridwidth = 1;
        gbContraints.gridheight = 1;

        // End

        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.1;
        gbContraints.weighty = 0.1;
        gbContraints.gridwidth = 3;
        this.add(pTopSpace, gbContraints);

        gbContraints.gridx = 0;
        gbContraints.gridy = 1;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        gbContraints.gridwidth = 1;
        this.add(pLeftSpace, gbContraints);

        gbContraints.gridx = 1;
        gbContraints.gridy = 1;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        gbContraints.gridwidth = 1;
        this.add(pBombSpace, gbContraints);

        gbContraints.gridx = 2;
        gbContraints.gridy = 1;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        gbContraints.gridwidth = 1;
        this.add(pRightSpace, gbContraints);

        gbContraints.gridx = 0;
        gbContraints.gridy = 2;
        gbContraints.weightx = 0.1;
        gbContraints.weighty = 0.1;
        gbContraints.gridwidth = 3;
        this.add(pBottomSpace, gbContraints);
    }

    public void resetGame(){
        pBombSpace.resetBomb();
    }

    public void resumeGame(){
        pBombSpace.resumeBomb();
    }

    public void pauseGame(){
        pBombSpace.pauseBomb();
    }

}
