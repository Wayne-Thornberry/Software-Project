package game;

import controllers.ControllerGame;
import controllers.ControllerUI;

public class Progress implements Runnable{

    private ControllerGame cGame;
    private ControllerUI cUI;
    private Player pUser;

    public Progress(ControllerGame game, ControllerUI ui, Player user){
        cGame = game;
        cUI = ui;
        pUser = user;
    }

    @Override
    public void run() {
        //while(true){
          //  cGame.getProgress();
        //}
    }
}
