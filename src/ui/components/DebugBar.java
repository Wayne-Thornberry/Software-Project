package ui.components;

import javax.swing.*;

public class DebugBar extends JMenuBar {

    private JMenu mScene;
    private JMenu mDebug;
    private JMenu mHelp;

    public JMenuItem mSceneTitle;
    public JMenuItem mSceneGame;
    public JMenuItem mSceneEnd;

    public JMenuItem mDebugLoadBomb;
    public JMenuItem mDebugResetBomb;
    public JMenuItem mDebugLoadLeaderboard;

    public JMenuItem mHelpWireChallenge;
    public JMenuItem mHelpEvenOddChallenge;
    public JMenuItem mHelpKeypadChallenge;
    public JMenuItem mHelpPictureChallenge;
    public JMenuItem mHelpLetterChallenge;

    public DebugBar(){

        mScene = new JMenu("Scenes");
        mDebug = new JMenu("Debug");
        mHelp = new JMenu("Help");

        mSceneTitle = new JMenuItem("Title Scene");
        mSceneGame = new JMenuItem("Game Scene");
        mSceneEnd = new JMenuItem("End Scene");

        mDebugLoadBomb = new JMenuItem("Load Bomb");
        mDebugResetBomb = new JMenuItem("Reset Bomb");
        mDebugLoadLeaderboard = new JMenuItem("Load Leaderboard");

        mHelpWireChallenge  = new JMenuItem("Wire Challenge");
        mHelpEvenOddChallenge  = new JMenuItem("Even Odd Challenge");
        mHelpKeypadChallenge  = new JMenuItem("Keypad Challenge");
        mHelpPictureChallenge  = new JMenuItem("Picture Challenge");
        mHelpLetterChallenge  = new JMenuItem("Letter Challenge");

        this.add(mScene);
        this.add(mDebug);
        this.add(mHelp);

        mScene.add(mSceneTitle);
        mScene.add(mSceneGame);
        mScene.add(mSceneEnd);

        mDebug.add(mDebugLoadBomb);
        mDebug.add(mDebugResetBomb);
        mDebug.add(mDebugLoadLeaderboard);

        mHelp.add(mHelpWireChallenge);
        mHelp.add(mHelpEvenOddChallenge);
        mHelp.add(mHelpKeypadChallenge);
        mHelp.add(mHelpPictureChallenge);
        mHelp.add(mHelpLetterChallenge);
    }
}
