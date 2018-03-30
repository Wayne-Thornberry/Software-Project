package ui.components.bomb;

import javax.swing.*;
import java.awt.*;

public class BombSticker extends JPanel {

    private JLabel lSticker;
    private String sStickerNo;

    public BombSticker(){
        sStickerNo = String.format("%06d",((int)(Math.random() * 999999)));
        lSticker = new JLabel(sStickerNo);
        lSticker.setFont(new Font("Arial",0,70));

        this.setBackground(Color.BLACK);
        lSticker.setForeground(Color.WHITE);

        this.add(lSticker);
    }

    public void resetSticker(){
        sStickerNo = String.format("%06d",((int)(Math.random() * 999999)));
        lSticker.setText(sStickerNo);
    }

    public void setStickerNo(String stickerNo){
        sStickerNo = stickerNo;
        lSticker.setText(sStickerNo);
    }

    public String getStickerNo(){
        return sStickerNo;
    }
}
