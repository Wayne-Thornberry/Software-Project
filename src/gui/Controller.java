package gui;

import gamelogic.Player;
import gui.scenes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller extends JFrame{

    private static JPanel pBase;

    public static MainScene pMainScene;
    public static GameScene pGameScene;
    public static EndScene pEndScene;

    private static JMenuBar mBar;
    private static JMenu mMenu;

    private static JMenuItem mItemMainScene;

    private static JMenu mItemGameMenu;
    private static JMenuItem mItemSwitchGameScene;
    private static JMenuItem mItemReloadGameScene;

    private static JMenuItem mItemEndScene;

    private static CardLayout cLayout;

    private static boolean bMainVisible;
    private static boolean bGameVisible;
    private static boolean bEndVisible;

    private static String sScene;

    private Timer tTimer;
    private Player pPlayer;

    public Controller(){
        super("Game");
        pBase = new JPanel();

        pMainScene = new MainScene();
        pGameScene = new GameScene();
        pEndScene = new EndScene();

        mBar = new JMenuBar();
        mMenu = new JMenu("Debug");

        mItemMainScene = new JMenuItem("Load MainMenu Scene");

        mItemGameMenu = new JMenu("Game Scene");
        mItemSwitchGameScene = new JMenuItem("Switch To Scene");
        mItemReloadGameScene = new JMenuItem("Reload Scene");

        mItemEndScene  = new JMenuItem("Load End Scene");

        cLayout = new CardLayout();

        bMainVisible = true;
        bGameVisible = false;
        bEndVisible = false;

        pPlayer = new Player();

        // Properties

        pBase.setLayout(cLayout);

        this.add(pBase);
        this.setJMenuBar(mBar);

        mBar.add(mMenu);

        mMenu.add(mItemMainScene);

        mMenu.add(mItemGameMenu);
        mItemGameMenu.add(mItemSwitchGameScene);
        mItemGameMenu.add(mItemReloadGameScene);

        mMenu.add(mItemEndScene);

        pBase.add(pMainScene, "0");
        pBase.add(pGameScene, "1");
        pBase.add(pEndScene, "2");

        // Events

        mItemMainScene.addActionListener(e -> {
            setScene("0");
        });

        mItemSwitchGameScene.addActionListener(e -> {
            setScene("1");
        });

        mItemReloadGameScene.addActionListener(e -> {
            pGameScene.resetGame();
        });


        mItemEndScene.addActionListener(e -> {
            setScene("2");
        });

        pMainScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
                bMainVisible = true;
                pGameScene.pauseGame();
                tTimer.stop();
            }
            @Override
            public void componentHidden(ComponentEvent evt) { bMainVisible = false; }
        });

        pGameScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
                bGameVisible = true;
                pGameScene.resumeGame();
                tTimer.start();
            }
            @Override
            public void componentHidden(ComponentEvent evt) { bGameVisible = false; }
        });

        pEndScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
                bEndVisible = true;
                pGameScene.pauseGame();
                tTimer.stop();
            }
            @Override
            public void componentHidden(ComponentEvent evt) {
                bEndVisible = false;
            }
        });

        tTimer = new Timer(1000, e->{
            if(pGameScene.pBombSpace.getBombState()){
                setScene("2");
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE && sScene == "1"){
                    System.out.println("ESC pressed");
                    setScene("0");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        tTimer.start();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.requestFocus();
        this.setSize(1280,720);
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setScene(String scene){
        sScene = scene;
        cLayout.show(pBase, sScene);
    }
}
