package gui;

import gui.scenes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUIController extends JFrame{

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

    public GUIController(){
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

        bMainVisible = true;
        bGameVisible = false;
        bEndVisible = false;

        // Events

        mItemMainScene.addActionListener(e -> {
            setScene("0");
        });

        mItemSwitchGameScene.addActionListener(e -> {
            setScene("1");
        });

        mItemReloadGameScene.addActionListener(e -> {
            pGameScene.pBombSpace.resetBomb();
        });


        mItemEndScene.addActionListener(e -> {
            setScene("2");
        });

        pMainScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) { bMainVisible = true; }
            @Override
            public void componentHidden(ComponentEvent evt) { bMainVisible = false; }
        });

        pGameScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) { bGameVisible = true; }
            @Override
            public void componentHidden(ComponentEvent evt) { bGameVisible = false; }
        });

        pEndScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) { bEndVisible = true; }
            @Override
            public void componentHidden(ComponentEvent evt) {
                bEndVisible = false;
            }
        });

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

    public String getScene(){
        return sScene;
    }
}
