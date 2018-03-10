package gui;
import gui.scenes.EndScene;
import gui.scenes.GameScene;
import gui.scenes.MainScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIController extends JFrame{

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
        mItemGameScene = new JMenuItem("Load Game Scene");
        mItemEndScene  = new JMenuItem("Load End Scene");

        cLayout = new CardLayout();

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

        // Events

        mItemMainScene.addActionListener(e -> {
            setScene("0");
        });

        mItemGameScene.addActionListener(e -> {
            setScene("1");
        });

        mItemEndScene.addActionListener(e -> {
            setScene("2");
        });

        pMainScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent evt) {
                System.out.println("Main Scene Out Of View");
            }
            @Override
            public void componentShown(ComponentEvent evt) {
                System.out.println("Main Scene In View");
            }
        });

        pGameScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent evt) {
                System.out.println("Game Scene Out Of View");
            }
            @Override
            public void componentShown(ComponentEvent evt) {
                System.out.println("Game Scene In View");
            }
        });

        pEndScene.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent evt) {
                System.out.println("End Scene Out Of View");
            }
            @Override
            public void componentShown(ComponentEvent evt) {
                System.out.println("End Scene In View");
            }
        });

        this.setSize(1280,720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
