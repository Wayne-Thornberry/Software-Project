package game;

public class Player {

    private String sName;
    private int iScore;
    private int iSeconds;
    private int iLives;
    private int iFailed;
    private int iPassed;

    private boolean isDebug;

    public Player(String name, int score, int seconds, int lives, int failed, int passed){
        sName = name;
        iScore = score;
        iSeconds = seconds;
        iLives = lives;
        iFailed = failed;
        iPassed = passed;
    }

    public String getsName(){
        return sName;
    }

    public void setsName(String sName){
        this.sName = sName;
    }

    public int getiScore(){
        return iScore;
    }

    public void setiScore(int iScore){
        this.iScore = iScore;
    }

    public int getiSeconds(){
        return iSeconds;
    }

    public void setiSeconds(int iSeconds){
        this.iSeconds = iSeconds;
    }

    public int getiLives(){
        return iLives;
    }

    public void setiLives(int iLives){
        this.iLives = iLives;
    }

    public int getiFailed(){
        return iFailed;
    }

    public void setiFailed(int iFailed){
        this.iFailed = iFailed;
    }

    public int getiPassed(){
        return iPassed;
    }

    public void setiPassed(int iPassed){
        this.iPassed = iPassed;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }
}
