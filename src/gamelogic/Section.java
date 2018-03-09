package gamelogic;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Section extends JPanel {
    int r = ThreadLocalRandom.current().nextInt(1, 255 + 1);
    int g = ThreadLocalRandom.current().nextInt(1, 255 + 1);
    int b = ThreadLocalRandom.current().nextInt(1, 255 + 1);
    public Section(){
        this.setPreferredSize(this.getPreferredSize());
        this.setBackground(new Color(r,g,b));
    }
}
