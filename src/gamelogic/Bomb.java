package gamelogic;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JPanel{

    private static JPanel pInfoSpace;
    private static JPanel pSectionSpace;

    private static Font lTimerFont;
    private static Font lStickerFont;

    private static GridBagConstraints gbContraints;


    public Bomb() {
        this.setLayout(new GridBagLayout());
        gbContraints = new GridBagConstraints();

        pInfoSpace = new JPanel(new GridLayout(0,3));
        lTimerFont = new Font("Serif", Font.PLAIN, 64);
        lStickerFont = new Font("Serif", Font.PLAIN, 64);

        pSectionSpace = new JPanel(new GridLayout(2,3));

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

        pInfoSpace.add(new Sticker());
        pInfoSpace.add(new Timer());
        pInfoSpace.add(new Lives());

        //Sections
        for(int x=0;x<=5;x++){
            pSectionSpace.add(new Section());
        }

        //createSticker();
        //createTimer();
        //createLives();
    }

    public static void createSticker(){
        //JLabel lSticker = new JLabel("352159");
        //lSticker.setBackground(Color.WHITE);
        //lSticker.setFont(lStickerFont);
        //pStickerSpace.add(lSticker);
    }

    public static void createTimer(){
        //JLabel lTimer = new JLabel("33:33");
        //lTimer.setBackground(Color.WHITE);
        //lTimer.setFont(lTimerFont);
        //pTimerSpace.add(lTimer);
    }

    public static void createLives(){
        //JLabel lLiveOne = new JLabel();
        //JLabel lLiveTwo = new JLabel();
        //JLabel lLiveThree = new JLabel();

        //lLiveOne.setHorizontalAlignment(0);
        //lLiveTwo.setHorizontalAlignment(0);
        //lLiveThree.setHorizontalAlignment(0);

        //lLiveOne.setIcon(new ImageIcon("light_on.png"));
        //lLiveTwo.setIcon(new ImageIcon("light_off.png"));
        //lLiveThree.setIcon(new ImageIcon("light_off.png"));

        //pLivesSpace.add(lLiveOne);
        //pLivesSpace.add(lLiveTwo);
        //pLivesSpace.add(lLiveThree);
    }
}
