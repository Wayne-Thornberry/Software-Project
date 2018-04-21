package ui.components.bomb;

import javax.swing.*;
import java.awt.*;

public class BombSticker extends JPanel {

    private JLabel lSticker;
    private String sStickerNo;

    public BombSticker(int sticker){
        sStickerNo = String.format("%06d",(sticker));
        lSticker = new JLabel(sStickerNo);
        lSticker.setFont(new Font("Arial",0,48));

        this.setOpaque(false);
        this.add(lSticker);
    }

    public void setStickerNo(int sticker){
        sStickerNo = String.format("%06d",(sticker));
        lSticker.setText(sStickerNo);
        lSticker.setFont(new Font("Arial",0,48));
    }

    public String getStickerNo(){
        return sStickerNo;
    }
}
