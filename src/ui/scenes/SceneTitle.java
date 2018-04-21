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
        g.drawImage(new ImageIcon("Graphics/backgroundimage.jpg").getImage(),0,0, 1280 , 720, null);
    }
}
