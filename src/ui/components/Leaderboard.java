package ui.components;

import controllers.ControllerDatabase;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Leaderboard extends JPanel {

    private JLabel pRow;

    public Leaderboard(Player pUser, ControllerDatabase cDatabase){

        this.setLayout(new GridLayout(15,0));

        pRow = new JLabel();
        pRow.setLayout(new GridLayout(0,7));
        pRow.add(new JButton("Id"));
        pRow.add(new JButton("Username"));
        pRow.add(new JButton("Time"));
        pRow.add(new JButton("Score"));
        pRow.add(new JButton("Passed"));
        pRow.add(new JButton("Failed"));
        pRow.add(new JButton("Lives"));


        if(pUser.isDebug()) {
            pRow.setLayout(new GridLayout(0,8));
            pRow.add(new JButton("Delete"));
        }

        this.add(pRow);

        System.out.println(">Attempting to populate Leadeboard...");
        List<String[]> table = cDatabase.getPlayers();

        for( String[] row: table ){
            pRow = new JLabel();
            pRow.setLayout(new GridLayout(0, 7));
            int columnCount = 0;
            JButton bDelete = new JButton();
            bDelete.setFocusable(false);
            for (String s : row) {
                pRow.add(new JLabel(s, SwingConstants.CENTER));
                if (columnCount == 0) {
                    bDelete.addActionListener(e -> {
                        cDatabase.removeUser(Integer.parseInt(s));
                        this.repaint();
                        this.revalidate();
                    });
                }
                columnCount++;
            }
            if (pUser.isDebug()) {
                pRow.setLayout(new GridLayout(0, 8));
                pRow.add(bDelete);
            }
            this.add(pRow);
        }
    }
}