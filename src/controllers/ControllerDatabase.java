package controllers;

import game.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerDatabase {

    private Connection cConnect;
    private Player pUser;

    public ControllerDatabase(Player user){
        pUser = user;
        System.out.println("Controller Database Running...");
        try {
            cConnect = DriverManager.getConnection("jdbc:sqlite:db/Database.sqlite");
            System.out.println("Connection Successful...");
            createLeaderboard();
        }catch(SQLException e) {
            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
    }

    public void createLeaderboard(){
        String sql = "CREATE TABLE IF NOT EXISTS Leaderboard(" +
                "   lId INT PRIMARY KEY NOT NULL," +
                "   lName VARCHAR(28)," +
                "   lTime INT," +
                "   lScore INT," +
                "   lPassed INT," +
                "   lFailed INT," +
                "   lLives INT" +
                ");";
        try {
            cConnect.createStatement().execute(sql);
            System.out.println(">Successfully created database table 'LEADERBOARD'");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(">Unable to create database table 'LEADERBOARD'");
        }
    }

    public void addUser(String name, int time, int score, int passed, int failed, int lives) {
        String sql ="INSERT INTO Leaderboard(lId, lName, lTime, lScore, lPassed, lFailed, lLives) " +
                    "VALUES ((SELECT MAX(lId) + 1 FROM Leaderboard),'"+name+"','"+time+"','"+score+"','"+passed+"','"+failed+"','"+lives+"')";

        try {
            cConnect.createStatement().execute(sql);
            System.out.println(">Successfully added user '" + name + "'");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(">unable to add user '" + name + "'");
        }
    }

    public List<String[]> getPlayers(){
        String sql ="" +
                "SELECT * " +
                "FROM Leaderboard " +
                "ORDER BY lScore DESC";
        try {
            System.out.println("Retrieving players...");
            Statement st = cConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<String[]> table = new ArrayList<>();
            int nCol = rs.getMetaData().getColumnCount();
            while( rs.next()) {
                String[] row = new String[nCol];
                for( int iCol = 1; iCol <= nCol; iCol++ ){
                    Object obj = rs.getObject( iCol );
                    row[iCol-1] = (obj == null) ?null:obj.toString();
                }
                table.add( row );
            }
            return table;
        }catch (SQLException e){
            return null;
        }
    }

    public String[] getPlayer(int id) {
        String sql ="" +
                "SELECT * " +
                "FROM Leaderboard " +
                "WHERE lID = '"+ id + "'";
        try {
            System.out.println("Retrieving player");
            Statement st = cConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] player = {
                    rs.getString("lId"),
                    rs.getString("lName"),
                    rs.getString("lTime"),
                    rs.getString("lScore"),
                    rs.getString("lPassed"),
                    rs.getString("lFailed"),
                    rs.getString("lLives")
            };

            System.out.println(player);
            return player;
        }catch (SQLException e){
            System.out.println("Unable to retrieve player");
            return null;
        }
    }

    public boolean userExists(String user) {
        String sql ="" +
                "SELECT *" +
                "FROM Leaderboard " +
                "WHERE lName LIKE '" + user + "'";
        try {
            System.out.println("Retrieving player");
            Statement st = cConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        }catch (SQLException e){
            System.out.println("Unable to retrieve player");
            return false;
        }
    }

    public void updateUser(String name, int time, int score, int passed, int failed, int lives) {
        String sql ="UPDATE Leaderboard " +
                "SET lTime = '"+ time +"', lScore = '" + score + "', lPassed = '" + passed + "', lFailed = '"+failed+"', lLives = '" + lives + "'" +
                "WHERE lName LIKE '" + name  +"'";
        try {
            System.out.println("Updating Player");
            cConnect.createStatement().execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to update player");
        }
    }

    public void removeUser(int id) {
        String sql ="DELETE FROM Leaderboard " +
                "WHERE lId = '" + id  +"'";
        try {
            System.out.println("Removing Player");
            if(id !=0) {
                cConnect.createStatement().execute(sql);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to remove player");
        }
    }
}
