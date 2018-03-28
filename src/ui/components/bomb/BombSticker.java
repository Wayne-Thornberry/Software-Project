package ui.components.bomb;

import javax.swing.*;
import java.awt.*;

public class BombSticker extends JPanel {

    private JLabel lSticker;
    private int iStickerNo;

    public BombSticker(){
        iStickerNo = (int)(Math.random() * 999999);
        lSticker = new JLabel(Integer.toString(iStickerNo));
        lSticker.setFont(new Font("Arial",0,70));

        this.setBackground(Color.BLACK);
        lSticker.setForeground(Color.WHITE);

        this.add(lSticker);
    }

    public void resetSticker(){
        iStickerNo = (int)(Math.random() * 999999);
        lSticker.setText(Integer.toString(iStickerNo));
    }

    public void setStickerNo(int stickerNo){
        iStickerNo = stickerNo;
        lSticker.setText(Integer.toString(iStickerNo));
    }

    public int getStickerNo(){
        return iStickerNo;
    }
}
