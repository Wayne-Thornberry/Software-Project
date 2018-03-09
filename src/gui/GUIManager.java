package gui;
import gui.scenes.EndScene;
import gui.scenes.GameScene;
import gui.scenes.MainScene;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class GUIManager extends JFrame{

    private static JPanel pBase;
    private static MainScene pMainScene;
    private static GameScene pGameScene;
    private static EndScene pEndScene;

    private static JMenuBar mBar;
    private static JMenu mMenu;
    private static JMenuItem mItemMainScene;
    private static JMenuItem mItemGameScene;
    private static JMenuItem mItemEndScene;

    private static CardLayout cLayout;
    private static GridBagConstraints gbContraints;

    private static Font fTitle = new Font("Ariel",Font.PLAIN,64);

    int r = ThreadLocalRandom.current().nextInt(1, 255 + 1);
    int g = ThreadLocalRandom.current().nextInt(1, 255 + 1);
    int b = ThreadLocalRandom.current().nextInt(1, 255 + 1);

    public GUIManager(){
        super("Game");
        pBase = new JPanel();

        pMainScene = new MainScene();
        pMainScene.setLayout(new GridBagLayout());

        pGameScene = new GameScene();
        pGameScene.setLayout(new GridBagLayout());

        pEndScene = new EndScene();
        pEndScene.setLayout(new GridBagLayout());

        mBar = new JMenuBar();
        mMenu = new JMenu("Debug");
        mItemMainScene = new JMenuItem("Load MainMenu Scene");
        mItemGameScene = new JMenuItem("Load Game Scene");
        mItemEndScene  = new JMenuItem("Load End Scene");

        cLayout = new CardLayout();
        gbContraints = new GridBagConstraints();

        // Default Var
        gbContraints.fill = 1;
        gbContraints.gridheight = 1;
        gbContraints.gridwidth = 1;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;

        pBase.setLayout(cLayout);

        this.add(pBase);
        this.setJMenuBar(mBar);

        mBar.add(mMenu);

        mMenu.add(mItemMainScene);
        mMenu.add(mItemGameScene);
        mMenu.add(mItemEndScene);

        pBase.add(pMainScene, "0");
        pBase.add(pGameScene, "1");
        pBase.add(pEndScene, "2");

        mItemMainScene.addActionListener(e -> {
            cLayout.show(pBase, "0");
        });

        mItemGameScene.addActionListener(e -> {
            cLayout.show(pBase, "1");
        });

        mItemEndScene.addActionListener(e -> {
            cLayout.show(pBase, "2");
        });

        this.setSize(1280,720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /*public static void drawMainScene(){
        JPanel pLeftSpace = new JPanel();
        JPanel pMiddleSpace = new JPanel(new GridBagLayout());
        JPanel pRightSpace = new JPanel();

        JPanel pTDeadSpace = new JPanel();
        JPanel pTitleSpace = new JPanel();
        JPanel pMDeadSpace = new JPanel();
        JPanel pButtonSpace = new JPanel(new GridLayout(3,0));
        JPanel pBDeadSpace = new JPanel();

        JLabel lTitle = new JLabel();

        JButton bStartGame = new JButton("Start Game");
        JButton bOptions = new JButton("Options");
        JButton bQuitGame = new JButton("Quit Game");

        lTitle.setIcon(new ImageIcon(""));

        pLeftSpace.setBackground(Color.RED);
        pMiddleSpace.setBackground(Color.GREEN);
        pRightSpace.setBackground(Color.BLUE);

        pLeftSpace.setPreferredSize(pLeftSpace.getPreferredSize());
        pMiddleSpace.setPreferredSize(pMiddleSpace.getPreferredSize());
        pRightSpace.setPreferredSize(pRightSpace.getPreferredSize());

        // Sections
        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.4;
        gbContraints.weighty = 0.4;
        pSceneMain.add(pLeftSpace, gbContraints);
        gbContraints.gridx = 1;
        gbContraints.gridy = 0;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        pSceneMain.add(pMiddleSpace, gbContraints);
        gbContraints.gridx = 2;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.4;
        gbContraints.weighty = 0.4;
        pSceneMain.add(pRightSpace, gbContraints);

        // Middle Section
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
        lTitle.setFont(fTitle);

        pButtonSpace.add(bStartGame);
        pButtonSpace.add(bOptions);
        pButtonSpace.add(bQuitGame);

    }

    public static void drawGameScene(){
        JPanel pLeftSpace = new JPanel();
        JPanel pTopSpace = new JPanel();
        JPanel pRightSpace = new JPanel();
        JPanel pBottomSpace = new JPanel();

        pLeftSpace.setBackground(Color.RED);
        pTopSpace.setBackground(Color.GREEN);
        pRightSpace.setBackground(Color.BLUE);
        pBottomSpace.setBackground(Color.WHITE);

        pLeftSpace.setPreferredSize(pLeftSpace.getPreferredSize());
        pTopSpace.setPreferredSize(pTopSpace.getPreferredSize());
        pRightSpace.setPreferredSize(pRightSpace.getPreferredSize());
        pBottomSpace.setPreferredSize(pBottomSpace.getPreferredSize());

        gbContraints.gridx = 0;
        gbContraints.gridy = 0;
        gbContraints.weightx = 0.1;
        gbContraints.weighty = 0.1;
        gbContraints.gridwidth = 3;
        pSceneGame.add(pTopSpace, gbContraints);

        gbContraints.gridx = 0;
        gbContraints.gridy = 1;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        gbContraints.gridwidth = 1;
        pSceneGame.add(pLeftSpace, gbContraints);

        gbContraints.gridx = 1;
        gbContraints.gridy = 1;
        gbContraints.weightx = 1;
        gbContraints.weighty = 1;
        gbContraints.gridwidth = 1;
        pSceneGame.add(new Bomb(), gbContraints);

        gbContraints.gridx = 2;
        gbContraints.gridy = 1;
        gbContraints.weightx = 0.2;
        gbContraints.weighty = 0.2;
        gbContraints.gridwidth = 1;
        pSceneGame.add(pRightSpace, gbContraints);

        gbContraints.gridx = 0;
        gbContraints.gridy = 2;
        gbContraints.weightx = 0.1;
        gbContraints.weighty = 0.1;
        gbContraints.gridwidth = 3;
        pSceneGame.add(pBottomSpace, gbContraints);

    }*/

    public static void drawEndScene(){

    }
}
