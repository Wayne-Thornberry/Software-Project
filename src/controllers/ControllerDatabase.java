package controllers;

import gamelogic.Player;
import java.sql.*;

public class ControllerDatabase {

    private Connection cConnect;
    private Player pUser;

    public ControllerDatabase(Player user){
        pUser = user;
        System.out.println("Controller Database Running...");
        try {
            cConnect = DriverManager.getConnection("jdbc:sqlite:Database/Database.sqlite");
            System.out.println("Connection Successful...");
        }catch(SQLException e) {
            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
    }

    public void addUser(Player pPly){

    }
}
