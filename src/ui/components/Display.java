/**
 * Display runs any necessary JFrames and JPanels to create the whole structure of the gUI, Including buttons, panels, labels ETC
 * THE MAIN GAME DOES NOT GENERATE HERE STOP LOOKING WAYNE!!!
 *
 * @author Wayne Thornberry B00100288
 * @version 2.0
 * @since 27/03/2018
 */
package ui.components;

import ui.components.DebugBar;
import ui.scenes.SceneTitle;
import ui.scenes.SceneGame;
import ui.scenes.SceneEnd;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    public DebugBar dMenuBar;

    public SceneTitle sTitle;
    public SceneGame sGame;
    public SceneEnd sEnd;

    public CardLayout cLayout;
    public JPanel pBase;

    private String sScene;

    public Display(){
        super("Game");

        dMenuBar = new DebugBar();
        cLayout = new CardLayout();
        pBase = new JPanel(cLayout);

        sTitle = new SceneTitle();
        sGame = new SceneGame();
        sEnd = new SceneEnd();

        pBase.add(sTitle, "0");
        pBase.add(sGame, "1");
        pBase.add(sEnd, "2");

        setDebug(false);
        setScene("0");

        this.add(pBase);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.requestFocus();
        this.setJMenuBar(dMenuBar);
        this.setSize(1280,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setScene(String scene){
        cLayout.show(pBase, scene);
        sScene = scene;
    }

    public String getScene(){
        return sScene;
    }

    public void setDebug(boolean visible){
        dMenuBar.setVisible(visible);
    }

    public void setIsFullscreen(boolean fullscreen){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        this.dispose();
        this.setUndecorated(fullscreen);
        this.setVisible(true);
    }
}
