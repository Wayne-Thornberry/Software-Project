package gamelogic.challanges;

import javax.swing.*;

public class ChallengeBase extends JPanel{

    private int iChallengeState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed 3 - Checked Either Failed/Passed
    private int iStickerNo;

    public ChallengeBase(){
        iChallengeState = 0;
        iStickerNo = 0;
        // Define Any Vars
        // Create Any Events
    }

    public void setStickerNo(int iNumber){
        iStickerNo = iNumber;
    }

    private boolean isCorrect(){
        // Return if your pattern or task is correct
        return true;
    }

    public int getState(){
        //Return the state of challenge
        return iChallengeState;
    }
}
