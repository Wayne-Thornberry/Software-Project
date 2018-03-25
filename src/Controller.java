import gamelogic.Player;
import gui.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller extends JFrame{

    private static JPanel pBase;
    private static Database dBase;

    public static MainScene pMainScene;
    public static GameScene pGameScene;
    public static EndScene pEndScene;

    private static JMenuBar mBar;
    private static JMenu mMenu;

    private static JMenu mMenuMain;
    private static JMenuItem mItemSwitchMainScene;
    private static JMenuItem mItemOptionsScene;

    private static JMenu mMenuGame;
    private static JMenuItem mItemSwitchGameScene;
    private static JMenuItem mItemReloadGameScene;

    private static JMenu mMenuEnd;
    private static JMenuItem mItemSwitchEndScene;
    private static JMenuItem mItemLeaderboardScene;

    private static CardLayout cLayout;

    private boolean bMainVisible;
    private boolean bGameVisible;
    private boolean bEndVisible;

    private static String sScene;

    private Timer tTimer;
    private Player pPlayer;

    public Controller(){
        super("Game");
        pBase = new JPanel();
        dBase = new Database();

        pMainScene = new MainScene();
        pGameScene = new GameScene();
        pEndScene = new EndScene();

        mBar = new JMenuBar();
        mMenu = new JMenu("Debug");

        mMenuMain = new JMenu("Main Menu Scene");
        mItemSwitchMainScene = new JMenuItem("Switch To Main Menu Scene");
        mItemOptionsScene = new JMenuItem("Load Options Scene");

        mMenuGame = new JMenu("Game Scene");
        mItemSwitchGameScene = new JMenuItem("Switch To Game Scene");
        mItemReloadGameScene = new JMenuItem("Load Game Scene");

        mMenuEnd  = new JMenu("End Scene");
        mItemSwitchEndScene  = new JMenuItem("Switch To End Scene");
        mItemLeaderboardScene  = new JMenuItem("Load Leaderboard Scene");

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

        mMenu.add(mMenuMain);
        mMenuMain.add(mItemSwitchMainScene);
        mMenuMain.add(mItemOptionsScene);

        mMenu.add(mMenuGame);
        mMenuGame.add(mItemSwitchGameScene);
        mMenuGame.add(mItemReloadGameScene);

        mMenu.add(mMenuEnd);
        mMenuEnd.add(mItemSwitchEndScene);
        mMenuEnd.add(mItemLeaderboardScene);

        pBase.add(pMainScene, "0");
        pBase.add(pGameScene, "1");
        pBase.add(pEndScene, "2");

        // Events

        // Main Menu Items
        mItemSwitchMainScene.addActionListener(e -> {
            pMainScene.setScene("0");
            setScene("0");
        });

        mItemOptionsScene.addActionListener(e -> {
            pMainScene.setScene("1");
        });

        // Game Items
        mItemSwitchGameScene.addActionListener(e -> {
            setScene("1");
        });

        mItemReloadGameScene.addActionListener(e -> {
            pGameScene.resetGame();
        });

        // End Screen Items
        mItemSwitchEndScene.addActionListener(e -> {
            setScene("2");
        });

        mItemLeaderboardScene.addActionListener(e -> {
            pEndScene.setScene("2");
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

        tTimer = new Timer(100, e->{
            if(pGameScene.pBombSpace.getBombState()){
                pPlayer.setiCompleted(pGameScene.pBombSpace.getiChallengesCompleted());
                pPlayer.setiFailed(pGameScene.pBombSpace.getiChallengesFailed());
                pPlayer.setiLives(pGameScene.pBombSpace.bLives.getLives());
                //pPlayer.setiScore(pGameScene.pBombSpace.bLives.getLives());
                pPlayer.setiSeconds(pGameScene.pBombSpace.bTimer.getTimer());
                pPlayer.setsName("Test");
                dBase.addUser(pPlayer);
                System.out.println("Player Info: " + pPlayer.getsName() + " " + pPlayer.getiFailed() + " " + pPlayer.getiCompleted() + " " + pPlayer.getiLives() + " " + pPlayer.getiSeconds());
                setScene("2");
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_T){
                    System.out.println("Tab Pressed");
                    mBar.setVisible(!mBar.isVisible());
                }

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
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setScene(String scene){
        sScene = scene;
        cLayout.show(pBase, sScene);
    }
}
