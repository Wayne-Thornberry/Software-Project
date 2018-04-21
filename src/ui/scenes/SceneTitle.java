package ui.scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SceneTitle extends JPanel {

    private JPanel pRightSpace;
    private JPanel pLeftSpace;

    private JPanel pTitleSpace;
    private JPanel pButtonSpace;
    private JPanel pBDeadSpace;

    private JLabel lTitle;
    public JTextField tUsername;

    public JButton bStartGame;
    public JButton bOptions;
    public JButton bQuitGame;

    public JButton bUser;

    private String sScene;

    private boolean isOptionsVisible;

    public SceneTitle(){

        this.setLayout(new GridLayout(0,2,15,0));
        this.setBorder(BorderFactory.createEmptyBorder(40,110,40,110));

        pLeftSpace = new JPanel(new BorderLayout());
        pLeftSpace.setOpaque(false);

        pRightSpace = new JPanel();

        pTitleSpace = new JPanel();
        pTitleSpace.setOpaque(false);

        pButtonSpace = new JPanel(new GridLayout(3,0, 0,5));
        pButtonSpace.setOpaque(false);

        pBDeadSpace = new JPanel(new GridLayout(0,2));
        pBDeadSpace.setOpaque(false);

        lTitle = new JLabel("<html><div style='text-align:center; color: white;'>BOMB DEFUSE <br> EXPERT</div></html>", SwingConstants.CENTER);
        lTitle.setFont(new Font("Arial",1,64));
        lTitle.setOpaque(false);

        bStartGame = new JButton("Start Game");
        bStartGame.setBackground(new Color(0x0078DE));
        bStartGame.setFocusable(false);
        bStartGame.setFont(new Font("Arial",1,32));
        bStartGame.setForeground(Color.WHITE);
        bStartGame.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        bOptions = new JButton("Options");
        bOptions.setBackground(new Color(0x0078DE));
        bOptions.setFocusable(false);
        bOptions.setFont(new Font("Arial",1,32));
        bOptions.setForeground(Color.WHITE);
        bOptions.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        bQuitGame = new JButton("Quit Game");
        bQuitGame.setBackground(new Color(0x0078DE));
        bQuitGame.setFocusable(false);
        bQuitGame.setFont(new Font("Arial",1,32));
        bQuitGame.setForeground(Color.WHITE);
        bQuitGame.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        tUsername = new JTextField();
        tUsername.setHorizontalAlignment(JTextField.CENTER);
        tUsername.setFont(new Font("Arial",1,24));
        tUsername.setBorder(BorderFactory.createEmptyBorder());
        tUsername.setFocusable(true);

        bUser = new JButton("Select User");
        bUser.setFont(new Font("Arial",1,24));
        bUser.setFocusable(false);
        bUser.setBorder(BorderFactory.createEmptyBorder());
        bUser.setBackground(new Color(0x009A21));
        bUser.setForeground(Color.WHITE);

        this.setBackground(Color.RED);

        this.setOptionsVisible(false);


        //////////////////////Options Menu///////////////////
        JPanel optionsPanel = new JPanel();

        optionsPanel.setLayout(new GridLayout(5,3));

        JButton optionsButton1 = new JButton("Change Lives");
        JButton optionsButton2 = new JButton("Change Seed");
        JButton optionsButton3 = new JButton("Change Time");
        JButton optionsButton4 = new JButton("Change Res");
        JButton optionsButton5 = new JButton("Submit");
        JButton optionsButton6 = new JButton("Submit");
        JButton optionsLeaderboard = new JButton("Leaderboard");

        JLabel optionsLabel1 = new JLabel("Enter lives: ");
        JLabel optionsLabel2 = new JLabel("Enter seed: ");
        JLabel optionsLabel3 = new JLabel("Enter time: ");
        JLabel optionsLabel4 = new JLabel("Choose size: ");
        JLabel optionsLabel5 = new JLabel("Label");
        JLabel optionsLabel6 = new JLabel("Label");

        JTextField optionsLives = new JTextField();
        JTextField optionsSeed = new JTextField();
        JTextField optionsTime = new JTextField();
        String[] resolutions = {"1024x576", "1280x720" ,"1920x1080"};
        JComboBox optionsResolution = new JComboBox(resolutions);



        optionsPanel.add(optionsLabel1);
        optionsPanel.add(optionsLives);
        optionsPanel.add(optionsButton1);

        optionsPanel.add(optionsLabel2);
        optionsPanel.add(optionsSeed);
        optionsPanel.add(optionsButton2);

        optionsPanel.add(optionsLabel3);
        optionsPanel.add(optionsTime);
        optionsPanel.add(optionsButton3);

        optionsPanel.add(optionsLabel4);
        optionsPanel.add(optionsResolution);
        optionsPanel.add(optionsButton4);

        optionsPanel.add(new JLabel(""));
        optionsPanel.add(new JLabel(""));
        optionsPanel.add(optionsLeaderboard);

        optionsButton1.setFont(new Font("Arial",1,20));
        optionsLabel1.setFont(new Font("Arial",1,20));

        optionsButton2.setFont(new Font("Arial",1,20));
        optionsLabel2.setFont(new Font("Arial",1,20));
        optionsButton3.setFont(new Font("Arial",1,20));
        optionsLabel3.setFont(new Font("Arial",1,20));
        optionsResolution.setFont(new Font("Arial",1,20));
        optionsButton4.setFont(new Font("Arial",1,20));
        optionsLabel4.setFont(new Font("Arial",1,20));
        optionsButton4.setFont(new Font("Arial",1,20));
        optionsLabel4.setFont(new Font("Arial",1,20));
        optionsLeaderboard.setFont(new Font("Arial",1,20));

        optionsButton1.setBackground(new Color(0x0078DE));
        optionsButton1.setForeground(Color.WHITE);
        optionsButton2.setBackground(new Color(0x0078DE));
        optionsButton2.setForeground(Color.WHITE);
        optionsButton3.setBackground(new Color(0x0078DE));
        optionsButton3.setForeground(Color.WHITE);
        optionsButton4.setBackground(new Color(0x0078DE));
        optionsButton4.setForeground(Color.WHITE);
        optionsLeaderboard.setBackground(new Color(0x0078DE));
        optionsLeaderboard.setForeground(Color.WHITE);




        pRightSpace.add(optionsPanel);
        /////////////////////////////////////////////////////
        this.add(pLeftSpace);
        this.add(pRightSpace);

        pLeftSpace.add(pTitleSpace, BorderLayout.NORTH);
        pLeftSpace.add(pButtonSpace, BorderLayout.CENTER);
        pLeftSpace.add(pBDeadSpace, BorderLayout.SOUTH);

        pTitleSpace.add(lTitle);

        pBDeadSpace.add(tUsername);
        pBDeadSpace.add(bUser);

        pButtonSpace.add(bStartGame);
        pButtonSpace.add(bOptions);
        pButtonSpace.add(bQuitGame);
    }

    public void setOptionsVisible(boolean scene){
        pRightSpace.setVisible(scene);
        isOptionsVisible = scene;
    }

    public boolean getOptionsVisible(){
        return isOptionsVisible;
    }

    public void setUsernameLock(boolean lock) {
        tUsername.setEditable(!lock);
        if (lock) {
            bUser.setText("Edit User");
            tUsername.setFocusable(!lock);
        } else {
            bUser.setText("Select User");
            tUsername.setFocusable(!lock);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Graphics/title_scene_graphic.jpg").getImage(),0,0, this.getSize().width , this.getSize().height, null);
    }
}
