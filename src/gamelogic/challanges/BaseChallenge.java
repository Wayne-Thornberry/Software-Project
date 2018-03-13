package gamelogic.challanges;

import javax.swing.*;

public class BaseChallenge extends JPanel{

    private int iChallengeState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed 3 - Checked Either Failed/Passed

    public BaseChallenge(){
        iChallengeState = 0;
        // Define Any Vars
        // Create Any Events
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
