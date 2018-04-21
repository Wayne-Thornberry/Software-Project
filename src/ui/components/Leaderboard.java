package ui.components;

import controllers.ControllerDatabase;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Leaderboard extends JPanel implements ActionListener {

    private JPanel pRow;
    private Player pUser;
    private ControllerDatabase cDatabase;

    public Leaderboard(Player user, ControllerDatabase data){

        this.setLayout(new GridLayout(15,0));
        this.setOpaque(false);
        pUser = user;
        cDatabase = data;

        pRow = new JPanel(new GridLayout(0,8));
        pRow.setBackground(Color.GRAY);

        String sHeadings[] = {"Id","Username","Sticker","Time","Score","Passed","Failed","Lives","Delete"};

        for (int i = 0; i<sHeadings.length;i++) {
            if (i < sHeadings.length - 1) {
                JButton bHeadings = new JButton(sHeadings[i] + " | DESC");
                bHeadings.setForeground(Color.WHITE);
                bHeadings.setBorder(BorderFactory.createEmptyBorder());
                bHeadings.setBackground(Color.GRAY);
                bHeadings.setFocusable(false);
                bHeadings.setHorizontalAlignment(SwingConstants.CENTER);
                bHeadings.setFont(new Font("Arial", 1, 12));
                pRow.add(bHeadings);
            }else{
                if(pUser.isAdmin()){
                    pRow.setLayout(new GridLayout(0,9));
                    JButton bHeadings = new JButton(sHeadings[i] + " | DESC");
                    bHeadings.setForeground(Color.WHITE);
                    bHeadings.setBorder(BorderFactory.createEmptyBorder());
                    bHeadings.setBackground(Color.GRAY);
                    bHeadings.setFocusable(false);
                    bHeadings.setHorizontalAlignment(SwingConstants.CENTER);
                    bHeadings.setFont(new Font("Arial", 1, 12));
                    pRow.add(bHeadings);
                }
            }
        }

        this.add(pRow);

        System.out.println(">Attempting to populate Leadeboard...");
        List<String[]> table = cDatabase.getPlayers();

        int nextID = 0;
        for( String[] row: table ){
            pRow = new JPanel(new GridLayout(0, 8));
            int columnCount = 0;
            JButton bDelete = new JButton();
            bDelete.setFocusable(false);
            pRow.add(new JLabel(Integer.toString(nextID++), SwingConstants.CENTER));
            for (String s : row) {
                 if(columnCount == 0) {
                     bDelete.setActionCommand(s);
                 }
                pRow.setBackground(Color.LIGHT_GRAY);
                pRow.add(new JLabel(s, SwingConstants.CENTER));
                columnCount++;
            }
            if (pUser.isAdmin()) {
                pRow.setLayout(new GridLayout(0, 9));
                bDelete.addActionListener(this);
                bDelete.setBackground(Color.RED);
                bDelete.setText("DELETE");
                bDelete.setFocusable(false);
                bDelete.setBorder(BorderFactory.createEmptyBorder());
                bDelete.setForeground(Color.WHITE);
                bDelete.setFont(new Font("Arial",1,12));
                pRow.add(bDelete);
            }
            this.add(pRow);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cDatabase.removeUser(e.getActionCommand());
        this.revalidate();
        this.repaint();
    }
}