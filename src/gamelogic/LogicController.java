package gamelogic;

import gamelogic.bomb.Bomb;

public class LogicController {
    private static Bomb bBomb;


    public LogicController(){
        bBomb = new Bomb();
    }

    public static void startGame(){
        System.out.println("Game Started");
        bBomb.bTimer.getTimer().start();
    }
}
