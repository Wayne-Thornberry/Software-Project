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

        this.setLayout(new GridLayout(0,2));
        this.setBorder(BorderFactory.createEmptyBorder(40,110,40,110));

        pLeftSpace = new JPanel(new BorderLayout());
        pRightSpace = new JPanel();

        pTitleSpace = new JPanel();
        pButtonSpace = new JPanel(new GridLayout(3,0));
        pBDeadSpace = new JPanel(new GridLayout(0,2));

        lTitle = new JLabel("TITLE");
        tUsername = new JTextField("Player");

        bStartGame = new JButton("Start Game");
        bOptions = new JButton("Options");
        bQuitGame = new JButton("Quit Game");

        bUser = new JButton("Select User");

        this.setBackground(Color.RED);

        pLeftSpace.setBackground(Color.GREEN);
        pRightSpace.setBackground(Color.ORANGE);

        pTitleSpace.setBackground(Color.RED);
        pButtonSpace.setBackground(Color.GREEN);
        pBDeadSpace.setBackground(Color.BLUE);

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
        g.drawImage(new ImageIcon("Graphics/backgroundimage.jpg").getImage(),0,0, 1920 , 1080, null);
    }
}
