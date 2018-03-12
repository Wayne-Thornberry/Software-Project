package gamelogic.bomb;

import javax.swing.*;
import java.awt.*;

public class BombSticker extends JPanel {

    private JLabel lSticker;

    private int iStickerNo;

    public BombSticker(){
        iStickerNo = (int)(Math.random() * 999999);
        lSticker = new JLabel(Integer.toString(iStickerNo));
        lSticker.setFont(new Font("Arial",0,72));

        this.add(lSticker);
        this.setPreferredSize(this.getPreferredSize());
        this.setBackground(Color.WHITE);
    }

    public void resetSticker(){
        iStickerNo = (int)(Math.random() * 999999);
        lSticker.setText(Integer.toString(iStickerNo));
    }
}
