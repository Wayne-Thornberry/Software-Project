package ui.scenes;

import javax.swing.*;
import java.awt.*;

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

    public JButton bOptionsLives;
    public JButton bOptionsSticker;
    public JButton bOptionsTime;
    public JButton bOptionsRes;
    public JButton bLeaderboard;

    public JTextField tOptionsLives;
    public JTextField tOptionsTime;
    public JTextField tOptionsSticker;
    public JComboBox cResolutionBox;

    public JButton bUser;
    public String[] sResolutions = {"1024x576", "1280x720" ,"1920x1080"};

    private boolean isOptionsVisible;

    public SceneTitle(){

        this.setLayout(new GridLayout(0,2,15,0));
        this.setBorder(BorderFactory.createEmptyBorder(40,110,40,110));

        pLeftSpace = new JPanel(new BorderLayout());
        pLeftSpace.setOpaque(false);

        pRightSpace = new JPanel();


        pTitleSpace = new JPanel();
        pTitleSpace.setOpaque(false);

        pButtonSpace = new JPanel(new GridLayout(4,0, 0,5));
        pButtonSpace.setOpaque(false);

        pBDeadSpace = new JPanel(new GridLayout(0,2));
        pBDeadSpace.setOpaque(false);

        lTitle = new JLabel("<html><div style='text-align:center; color: white;'>BOMB DEFUSE <br> EXPERT</div></html>", SwingConstants.CENTER);
        lTitle.setFont(new Font("Arial",1,64));
        lTitle.setOpaque(false);

        bStartGame = new JButton("Start Game");
        bStartGame.setBackground(new Color(0x007B11));
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

        bLeaderboard = new JButton("View Leaderboard");
        bLeaderboard.setFocusable(false);
        bLeaderboard.setFont(new Font("Arial",1,32));
        bLeaderboard.setBackground(new Color(0xFF8600));
        bLeaderboard.setForeground(Color.WHITE);
        bLeaderboard.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        bQuitGame = new JButton("Quit Game");
        bQuitGame.setBackground(new Color(0xFF0000));
        bQuitGame.setFocusable(false);
        bQuitGame.setFont(new Font("Arial",1,32));
        bQuitGame.setForeground(Color.WHITE);
        bQuitGame.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        tUsername = new JTextField("Username");
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

        pButtonSpace.add(bStartGame);
        pButtonSpace.add(bOptions);
        pButtonSpace.add(bLeaderboard);
        pButtonSpace.add(bQuitGame);

        this.setOptionsVisible(false);

        pRightSpace.setLayout(new GridLayout(4,2,5,5));
        pRightSpace.setBackground(Color.WHITE);

        bOptionsLives = new JButton("Change Lives");
        bOptionsSticker = new JButton("Change Sticker");
        bOptionsTime = new JButton("Change Time");
        bOptionsRes = new JButton("Change Resolution");

        tOptionsLives = new JTextField("Lives");
        tOptionsLives.setHorizontalAlignment(SwingConstants.CENTER);
        tOptionsLives.setBorder(null);
        tOptionsLives.setFont(new Font("Arial",1,24));

        tOptionsSticker = new JTextField("Sticker");
        tOptionsSticker.setHorizontalAlignment(SwingConstants.CENTER);
        tOptionsSticker.setBorder(null);
        tOptionsSticker.setFont(new Font("Arial",1,24));

        tOptionsTime = new JTextField("Seconds");
        tOptionsTime.setHorizontalAlignment(SwingConstants.CENTER);
        tOptionsTime.setBorder(null);
        tOptionsTime.setFont(new Font("Arial",1,24));

        cResolutionBox = new JComboBox(sResolutions);
        cResolutionBox.setBorder(null);
        cResolutionBox.setFont(new Font("Arial",1,24));

        bOptionsLives.setFont(new Font("Arial",1,18));
        bOptionsSticker.setFont(new Font("Arial",1,18));
        bOptionsTime.setFont(new Font("Arial",1,18));
        bOptionsRes.setFont(new Font("Arial",1,18));

        bOptionsLives.setBackground(new Color(0x0078DE));
        bOptionsLives.setFocusable(false);
        bOptionsLives.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        bOptionsLives.setForeground(Color.WHITE);

        bOptionsSticker.setBackground(new Color(0x0078DE));
        bOptionsSticker.setFocusable(false);
        bOptionsSticker.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        bOptionsSticker.setForeground(Color.WHITE);

        bOptionsTime.setBackground(new Color(0x0078DE));
        bOptionsTime.setFocusable(false);
        bOptionsTime.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        bOptionsTime.setForeground(Color.WHITE);

        bOptionsRes.setBackground(new Color(0x0078DE));
        bOptionsRes.setFocusable(false);
        bOptionsRes.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        bOptionsRes.setForeground(Color.WHITE);

        pRightSpace.add(tOptionsLives);
        pRightSpace.add(bOptionsLives);

        pRightSpace.add(tOptionsSticker);
        pRightSpace.add(bOptionsSticker);

        pRightSpace.add(tOptionsTime);
        pRightSpace.add(bOptionsTime);

        pRightSpace.add(cResolutionBox);
        pRightSpace.add(bOptionsRes);

        this.add(pLeftSpace);
        this.add(pRightSpace);

        pLeftSpace.add(pTitleSpace, BorderLayout.NORTH);
        pLeftSpace.add(pButtonSpace, BorderLayout.CENTER);
        pLeftSpace.add(pBDeadSpace, BorderLayout.SOUTH);

        pTitleSpace.add(lTitle);

        pBDeadSpace.add(tUsername);
        pBDeadSpace.add(bUser);
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
