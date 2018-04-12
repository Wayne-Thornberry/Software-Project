package ui;

import javax.swing.*;
import java.awt.*;

public class Leaderboard extends JPanel {

    private JLabel pUserNames;
    private JLabel pUserScore;
    private JLabel pUserTime;
    private JLabel pUserLives;
    private JLabel pUserCompleted;
    private JLabel pUserFailed;

    public Leaderboard(){

        this.setLayout(new GridLayout(15,6));

        pUserNames = new JLabel("Username");
        pUserScore = new JLabel("Score");
        pUserTime = new JLabel("Time");
        pUserLives =  new JLabel("Lives");
        pUserCompleted = new JLabel("Completed");
        pUserFailed = new JLabel("Failed");

        this.add(pUserNames);
        this.add(pUserScore);
        this.add(pUserTime);
        this.add(pUserLives);
        this.add(pUserCompleted);
        this.add(pUserFailed);

        for(int i=0; i<14; i++) {
            this.add(new JLabel("Wayno717"));
            this.add(new JLabel("3654"));
            this.add(new JLabel("3:30"));
            this.add(new JLabel("2"));
            this.add(new JLabel("5"));
            this.add(new JLabel("1"));
        }
    }
}
