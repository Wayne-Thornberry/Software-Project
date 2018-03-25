import gamelogic.Player;
import java.sql.*;

public class Database {

    private Connection cConnect;

    public Database(){
        try {
            cConnect = DriverManager.getConnection("jdbc:sqlite:Database.sqlite");
            System.out.println("Connection Successful");
        }catch(SQLException e) {
            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
    }

    public void addUser(Player pPly){

    }
}
