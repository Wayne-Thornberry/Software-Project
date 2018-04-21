package game.challanges;

import javax.swing.*;

public abstract class Challenge extends JPanel{

    Challenge(){}

    private int iState; // Defines if the challenge has been completed, idle or failed - 0 Idle - 1 Completed - 2 Failed 3 - Checked Either Failed/Passed
    private int iDifficulty; // Can range from 1 to 5, 1 beings very easy 5 being very hard
    private String iStickerNo;

    public Challenge(int state, String sticker, int difficulty){
        iState = state;
        iStickerNo = sticker;
        iDifficulty = difficulty;
    }

    public String getiStickerNo() {
        return iStickerNo;
    }

    public void setiStickerNo(String iStickerNo) {
        this.iStickerNo = iStickerNo;
    }

    public int getiState() {
        return iState;
    }

    public void setiState(int iState) {
        this.iState = iState;
    }

    public int getiDifficulty() {
        return iDifficulty;
    }

    public void setiDifficulty(int iDifficulty) {
        this.iDifficulty = iDifficulty;
    }
}
