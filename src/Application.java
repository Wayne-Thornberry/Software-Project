import gamelogic.*;
import gui.*;

public class Application {

    private static GUIController gController;
    private static LogicController lController;

    public static void main(String ARGS[]){
        gController = new GUIController();
        lController = new LogicController();
    }
}
