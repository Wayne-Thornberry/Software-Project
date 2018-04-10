package ui.components;

import javax.swing.*;

public class DebugBar extends JMenuBar {

    private JMenu mScene;
    private JMenu mDebug;
    private JMenu mHelp;

    public JMenuItem mSceneTitle;
    public JMenuItem mSceneGame;
    public JMenuItem mSceneEnd;

    public JMenuItem mDebugCreateBomb;
    public JMenuItem mDebugLoadLeaderboard;
    public JMenuItem mDebugRefreshUI;
    public JMenuItem mDebugSetSticker;

    private JMenu mDebugResolution;

    public JMenuItem mDebugResolutionOne;
    public JMenuItem mDebugResolutionTwo;
    public JMenuItem mDebugResolutionThree;

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

        mDebugCreateBomb = new JMenuItem("Create Bomb");
        mDebugLoadLeaderboard = new JMenuItem("Load Leaderboard");
        mDebugRefreshUI = new JMenuItem("Refresh UI");
        mDebugSetSticker = new JMenuItem("Set Sticker Number");

        mDebugResolution = new JMenu("Resolution");

        mDebugResolutionOne = new JMenuItem("1024x576");
        mDebugResolutionTwo = new JMenuItem("1280x720");
        mDebugResolutionThree = new JMenuItem("1920x1080");

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

        mDebug.add(mDebugCreateBomb);
        mDebug.add(mDebugLoadLeaderboard);
        mDebug.add(mDebugRefreshUI);
        mDebug.add(mDebugSetSticker);

        mDebug.add(mDebugResolution);

        mDebugResolution.add(mDebugResolutionOne);
        mDebugResolution.add(mDebugResolutionTwo);
        mDebugResolution.add(mDebugResolutionThree);

        mHelp.add(mHelpWireChallenge);
        mHelp.add(mHelpEvenOddChallenge);
        mHelp.add(mHelpKeypadChallenge);
        mHelp.add(mHelpPictureChallenge);
        mHelp.add(mHelpLetterChallenge);
    }
}
