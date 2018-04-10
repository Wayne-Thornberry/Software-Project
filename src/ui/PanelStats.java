package ui;

import javax.swing.*;
import java.awt.*;

public class PanelStats extends JPanel {

    private JLabel lInfo;

    public PanelStats(){
        lInfo = new JLabel("test");
        this.setBackground(Color.BLACK);
        lInfo.setOpaque(false);
        lInfo.setForeground(Color.WHITE);
        this.add(lInfo);
    }
}
