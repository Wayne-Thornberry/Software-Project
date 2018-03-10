import gamelogic.LogicController;
import gui.*;
import gamelogic.sections.SectionManager;

public class Application {

    private static GUIController gController;
    private static LogicController lController;

    public static void main(String ARGS[]){
        gController = new GUIController();
        lController = new LogicController();

        if(gController.getScene() == "1"){
            lController.startGame();
        }
    }
}
